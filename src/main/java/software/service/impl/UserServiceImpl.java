package software.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.dao.UserCommentsMapper;
import software.dao.UserInfoMapper;
import software.dao.UserPostsMapper;
import software.jsonModel.ResponseObject;
import software.model.UserComments;
import software.model.UserInfo;
import software.model.UserPosts;
import software.service.UserService;
import software.service.util.SessionCtr;
import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
  @Resource private UserInfoMapper userInfoMapper;
  @Resource private UserPostsMapper userPostsMapper;
  @Resource private UserCommentsMapper userCommentsMapper;
  private static SessionCtr sessionCtr = SessionCtr.getInstance();

  @Override
  public boolean register(
      String firstName, String lastName, String eMail, String passwd, String nickName) {
    UserInfo dup = userInfoMapper.selectUserInfoByEmail(eMail);
    if (dup == null) {
      String salt = sessionCtr.getSalt();
      String psSalt = sessionCtr.getMd5(passwd, salt);
      UserInfo userInfo =
          new UserInfo(
              firstName,
              lastName,
              eMail,
              psSalt,
              salt,
              nickName,
              new Date(System.currentTimeMillis()));
      int check = userInfoMapper.insertSelective(userInfo);
      if (check > 0) {
        return true;
      }
    }
    return false;
  }
  // sessionCtr.getMd5(psSalt, salt)
  @Override
  public UserInfo login(String email, String passwd) {
    UserInfo exist = userInfoMapper.selectUserInfoByEmail(email);
    if (exist != null) {
      boolean succ = sessionCtr.checkLogin(exist, passwd);
      if (succ) {
        Date curDate = new Date(System.currentTimeMillis());
        exist.setAccessTime(curDate);
        userInfoMapper.updateByPrimaryKeySelective(exist);
        String token = sessionCtr.getMd5(exist.getPasswd(), exist.getPasswdSalt());
        UserInfo userInfo = new UserInfo();
        userInfo.setToken(token);
        userInfo.setNickName(exist.getNickName());
        userInfo.setUid(exist.getUid());
        return userInfo;
      }
    }
    return null;
  }

  /**
   * 如果是在最外层post，那么前端会给一个motherpost为-1，你将会返还postId
   * 如果是在内存post，那么前端会给你一个motherpost为之前你给前端的postId，你会返还一个postId 要注意的是这个postid是惟一的，他们用的是一个表
   *
   * @param token
   * @param title
   * @param content
   * @param motherPostId
   * @return
   */
  @Override
  @Transactional
  public int postTopic(String token, String title, String content, int uid, int motherPostId) {
    UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid);
    int result = sessionCtr.checkToken(userInfo, token);
    if (result != SessionCtr.success) {
      return result;
    }
    if (content.length() > 0) {
      Date curDate = new Date(System.currentTimeMillis());
      if (motherPostId == -1) {
        UserPosts newPost =
            new UserPosts(
                userInfo.getUid(),
                userInfo.getNickName(),
                title,
                content,
                curDate,
                0,
                motherPostId,
                1);
        userPostsMapper.insertSelective(newPost);
      } else {
        UserPosts motherPost = userPostsMapper.selectUserPostByPostId(motherPostId);
        UserPosts innerPost =
            new UserPosts(
                userInfo.getUid(),
                userInfo.getNickName(),
                title,
                content,
                curDate,
                0,
                motherPostId,
                motherPost.getLevel() + 1);
        motherPost.setLevel(motherPost.getLevel() + 1);
        userPostsMapper.updateByPrimaryKey(motherPost);
        userPostsMapper.insertSelective(innerPost);
      }
    }
    return result;
  }

  /**
   * 删除所有有这个mother id的数据和他本身
   *
   * @param postId
   * @return
   */
  @Override
  @Transactional
  public int deletePost(int postId, int mid, String token, int uid) {
    UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid);
    int result = sessionCtr.checkToken(userInfo, token);
    if (result != SessionCtr.success) {
      return result;
    }
    if (mid == -1) {
      int r1 = this.userPostsMapper.deleteByPostId(postId);
      int r2 = this.userCommentsMapper.deleteByMotherId(postId);
      return SessionCtr.success;
    } else {
      int r1 = this.userPostsMapper.deleteByPrimaryKey(postId);
      int r2 = this.userCommentsMapper.deleteCommentByPid(postId);
      return SessionCtr.success;
    }
  }

  @Override
  public int postComment(String token, String Content, int uid1, int uid2, int pid, int mid) {
    UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid1);
    int result = sessionCtr.checkToken(userInfo, token);
    if (result != SessionCtr.success) {
      return result;
    }
    UserInfo u1 = userInfoMapper.selectByPrimaryKey(uid1);
    UserInfo u2 = null;
    UserComments userComments;
    if (uid2 != -1) {
      u2 = userInfoMapper.selectByPrimaryKey(uid2);
    }
    UserPosts p1 = userPostsMapper.selectByPrimaryKey(pid);
    p1.setCommentCount(p1.getCommentCount() + 1);
    userPostsMapper.updateByPrimaryKeySelective(p1);
    ResponseObject object = new ResponseObject();
    if (u2 == null) {
      userComments =
          new UserComments(
              pid,
              mid,
              Content,
              new Date(System.currentTimeMillis()),
              u1.getNickName(),
              "",
              uid1,
              uid2);
    } else {
      userComments =
          new UserComments(
              pid,
              mid,
              Content,
              new Date(System.currentTimeMillis()),
              u1.getNickName(),
              u2.getNickName(),
              uid1,
              uid2);
    }
    int ef = userCommentsMapper.insertSelective(userComments);
    return 1;
  }

  @Override
  public int deleteCommentByCid(String token, int cid, int uid, int pid) {
    UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid);
    int result = sessionCtr.checkToken(userInfo, token);
    if (result != SessionCtr.success) {
      return result;
    }
    UserPosts posts = userPostsMapper.selectByPrimaryKey(pid);
    posts.setCommentCount(posts.getCommentCount() - 1);
    userPostsMapper.updateByPrimaryKeySelective(posts);
    userCommentsMapper.deleteByPrimaryKey(cid);
    return SessionCtr.success;
  }
}
