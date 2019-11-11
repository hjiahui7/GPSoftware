package software.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import software.dao.UserInfoMapper;
import software.dao.UserPostsMapper;
import software.jsonModel.ResponseObject;
import software.model.UserInfo;
import software.model.UserPosts;
import software.service.UserService;
import software.service.util.SessionCtr;
import software.service.util.Sha256;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl implements UserService {
  @Resource private UserInfoMapper userInfoMapper;
  @Resource private UserPostsMapper userPostsMapper;
  private AtomicInteger atomicInteger = new AtomicInteger(0);
  private static ConcurrentHashMap<String, String> sessionMap = SessionCtr.getSessionMap();

  @Override
  public boolean register(
      String firstName, String lastName, String eMail, String passwd, String nickName) {
    UserInfo dup = userInfoMapper.selectUserInfoByEmail(eMail);
    // 要改成check nickname
    System.out.println("register " + dup);

    if (dup == null) {
      UserInfo userInfo =
          new UserInfo(
              eMail, firstName, lastName, passwd, nickName, new Date(System.currentTimeMillis()));
      atomicInteger.incrementAndGet();
      int check = userInfoMapper.insertSelective(userInfo);
      if (check > 0) {
        return true;
      }
    }
    return false;
  }

  @Override
  public ResponseObject login(String email, String passwd) {
    UserInfo exist = userInfoMapper.selectUserInfoByEmailAndPasswd(email, passwd);
    if (exist != null) {
      ResponseObject object = new ResponseObject();
      Date curDate = new Date(System.currentTimeMillis());
      String sessionid = Sha256.getSHA256(email + passwd + curDate.toString());
      sessionMap.putIfAbsent(sessionid, email);
      object.setNickName(exist.getNickName());
      object.setToken(sessionid);
      object.setUserId(exist.getId());
      return object;
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
  public ResponseObject postTopic(String token, String title, String content, int motherPostId) {
    String email = null;
    int resPostId = -1;
    if ((email = sessionMap.get(token)) == null) {
      return null;
    }
    ResponseObject result = new ResponseObject();
    if (content.length() > 0) {
      Date curDate = new Date(System.currentTimeMillis());
      UserInfo userInfo = userInfoMapper.selectUserInfoByEmail(email);
      if (motherPostId == -1) {
        UserPosts newPost =
            new UserPosts(
                userInfo.getId(),
                userInfo.getNickName(),
                title,
                content,
                curDate,
                1,
                motherPostId,
                1);
        userPostsMapper.insertSelective(newPost);
        resPostId = newPost.getId();
        result.setPostId(resPostId);
        result.setUserId(userInfo.getId());
      } else {
        UserPosts motherPost = userPostsMapper.selectUserPostByPostId(motherPostId);
        UserPosts innerPost =
            new UserPosts(
                userInfo.getId(),
                userInfo.getNickName(),
                title,
                content,
                curDate,
                0,
                motherPostId,
                motherPost.getCommentCount());
        motherPost.setCommentCount(motherPost.getCommentCount() + 1);
        userPostsMapper.updateByPrimaryKeySelective(motherPost);
        userPostsMapper.insertSelective(innerPost);
        resPostId = innerPost.getId();
        result.setPostId(resPostId);
        result.setUserId(resPostId);
      }
      if (resPostId >= 0) {
        return result;
      }
    }
    return null;
  }

  /**
   * 删除所有有这个mother id的数据和他本身
   *
   * @param postId
   * @return
   */
  @Override
  @Transactional
  public boolean deletePost(int postId) {
    int r1 = this.userPostsMapper.deleteByPostId(postId);
    return r1 >= 1;
  }

  /**
   * 得到当前post下所有post
   *
   * @param postId
   * @return
   */
  @Override
  @Transactional
  public List<UserPosts> getPostsById(int postId) {
    List<UserPosts> result = null;
    result = userPostsMapper.selectAllUserPostByMotherId(postId);
    return result;
  }
}
