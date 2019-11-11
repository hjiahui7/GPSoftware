package software.service;

import software.jsonModel.ResponseObject;
import software.model.UserPosts;

import java.util.List;

public interface UserService {
  boolean register(String firstName, String lastName, String eMail, String passwd, String nickName);

  ResponseObject login(String email, String passwd);

  ResponseObject postTopic(String token, String title, String Content, int motherPostId);

  boolean deletePost(int postId);

  List<UserPosts> getPostsById(int postId);
}
