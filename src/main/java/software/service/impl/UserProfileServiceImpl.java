package software.service.impl;

import org.springframework.stereotype.Service;
import software.dao.UserCommentsMapper;
import software.dao.UserInfoMapper;
import software.dao.UserPostsMapper;
import software.jsonModel.ResponseObject;
import software.model.UserComments;
import software.model.UserInfo;
import software.model.UserPosts;
import software.service.UserProfileService;
import software.service.util.SessionCtr;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

  @Resource private UserInfoMapper userInfoMapper;
  @Resource private UserPostsMapper userPostsMapper;
  @Resource private UserCommentsMapper userCommentsMapper;

  private SessionCtr sessionCtr = SessionCtr.getInstance();

  @Override
  public UserInfo getUserProfile(int uid, String token) {
    UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid);
    int result = sessionCtr.checkToken(userInfo, token);
    if (result != SessionCtr.success) {
      return userInfo;
    }
    userInfo.setPasswd("");
    userInfo.setPasswdSalt("");
    return userInfo;
  }

  @Override
  public boolean updatePS(int uid, String token, String ps) {
    UserInfo userInfo = userInfoMapper.selectByPrimaryKey(uid);
    int result = sessionCtr.checkToken(userInfo, token);
    if (result != SessionCtr.success) {
      return false;
    }
    userInfo.setpSignature(ps);
    userInfoMapper.updateByPrimaryKey(userInfo);
    return false;
  }

  /**
   * 得到当前user的post
   *
   * @param userId
   * @return
   */
  @Override
  public List<UserPosts> getUserPostsByUserId(int userId) {
    List<UserPosts> usersPosts = userPostsMapper.selectUserPostByUserId(userId);
    return usersPosts;
  }

  /**
   * 得到当前user的post
   *
   * @param userId
   * @return
   */
  @Override
  public List<UserPosts> getUserReplyByUserId(int userId) {
    List<UserPosts> usersPosts = userPostsMapper.selectUserReplyByUserId(userId);
    return usersPosts;
  }

  /**
   * 得到当前user的post
   *
   * @param userId
   * @return
   */
  @Override
  public List<UserComments> getCommentByUserId(int userId) {
    List<UserComments> userComments = userCommentsMapper.selectAllCommentsByUid(userId);
    return userComments;
  }
}
