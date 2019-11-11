package software.service;

import software.model.UserInfo;
import software.model.UserPosts;

import java.util.List;

public interface UserProfileService {

  UserInfo getUserProfile(String token);

  boolean updatePS(String token, String ps);

  List<UserPosts> getUserPostsByUserId(int uid);

  List<UserPosts> getOtherPostsByUserId(int userId);
}
