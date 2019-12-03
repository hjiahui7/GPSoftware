package software.service;

import software.jsonModel.ResponseObject;
import software.model.UserComments;
import software.model.UserInfo;
import software.model.UserPosts;

import java.util.List;

public interface UserProfileService {

  UserInfo getUserProfile(int uid, String token);

  boolean updatePS(int uid, String token, String ps);

  List<UserPosts> getUserPostsByUserId(int uid);

  public List<UserPosts> getUserReplyByUserId(int userId);

  List<UserComments> getCommentByUserId(int userId);
}
