package software.service.impl;

import org.springframework.stereotype.Service;
import software.dao.UserInfoMapper;
import software.dao.UserPostsMapper;
import software.model.UserInfo;
import software.model.UserPosts;
import software.service.UserProfileService;
import software.service.util.SessionCtr;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserProfileServiceImpl implements UserProfileService {

  @Resource private UserInfoMapper userInfoMapper;
  @Resource private UserPostsMapper userPostsMapper;
  private ConcurrentHashMap<String, String> sessionMap = SessionCtr.getSessionMap();

  @Override
  public UserInfo getUserProfile(String token) {
    String email = null;
    if ((email = sessionMap.get(token)) == null) {
      return null;
    }
    UserInfo userInfo = userInfoMapper.selectUserInfoByEmail(email);
    return userInfo;
  }

  @Override
  public boolean updatePS(String token, String ps) {
    String email = null;
    if ((email = sessionMap.get(token)) == null) {
      return false;
    }
    UserInfo userInfo = new UserInfo();
    userInfo.seteMail(email);
    userInfo.setpSignature(ps);
    userInfoMapper.updateByPrimaryKeySelective(userInfo);
    return true;
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
  public List<UserPosts> getOtherPostsByUserId(int userId) {
    List<UserPosts> usersPosts = userPostsMapper.selectOtherPostByUserId(userId);
    return usersPosts;
  }
}
