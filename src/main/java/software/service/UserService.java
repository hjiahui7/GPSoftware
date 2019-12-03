package software.service;

import software.jsonModel.ResponseObject;
import software.model.UserInfo;
import software.model.UserPosts;

import java.util.List;

public interface UserService {
  boolean register(String firstName, String lastName, String eMail, String passwd, String nickName);

  UserInfo login(String email, String passwd);

  int postTopic(String token, String title, String Content, int uid, int motherPostId);

  int deletePost(int postId, int mid, String token, int uid);

  int postComment(String token, String Content, int uid1, int uid2, int pid, int mid);

  int deleteCommentByCid(String token, int cid, int uid, int pid);
}
