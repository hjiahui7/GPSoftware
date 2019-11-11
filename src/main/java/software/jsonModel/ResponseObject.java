package software.jsonModel;

import software.model.UserInfo;
import software.model.UserPosts;

import java.util.List;

public class ResponseObject {
  int userId;
  String msg;
  String token;
  String nickName;
  String errMsg;
  List<IndexObject> objects;
  List<UserPosts> userPosts;
  UserInfo userInfo;
  private int postId;
  private int motherPostId;

  public ResponseObject() {}

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public ResponseObject(int postId, int motherPostId) {
    this.postId = postId;
    this.motherPostId = motherPostId;
  }

  public List<UserPosts> getUserPosts() {
    return userPosts;
  }

  public void setUserPosts(List<UserPosts> userPosts) {
    this.userPosts = userPosts;
  }

  public UserInfo getUserInfo() {
    return userInfo;
  }

  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

  public String getErrMsg() {
    return errMsg;
  }

  public void setErrMsg(String errMsg) {
    this.errMsg = errMsg;
  }

  public int getPostId() {
    return postId;
  }

  public void setPostId(int postId) {
    this.postId = postId;
  }

  public int getMotherPostId() {
    return motherPostId;
  }

  public void setMotherPostId(int motherPostId) {
    this.motherPostId = motherPostId;
  }

  @Override
  public String toString() {
    return "ResponseObject{"
        + "msg='"
        + msg
        + '\''
        + ", token='"
        + token
        + '\''
        + ", nickName='"
        + nickName
        + '\''
        + '}';
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public List<IndexObject> getObjects() {
    return objects;
  }

  public void setObjects(List<IndexObject> objects) {
    this.objects = objects;
  }
}
