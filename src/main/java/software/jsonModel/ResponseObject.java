package software.jsonModel;

import software.model.UserComments;
import software.model.UserInfo;
import software.model.UserPosts;
import java.util.List;

public class ResponseObject {
  private String msg;
  private String errMsg;
  private int msgType;
  private List<IndexObject> objects;
  private List<UserPosts> userPosts;
  private List<UserComments> comments;
  private UserInfo userInfo;

  public ResponseObject() {}

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

  public String getMsg() {
    return msg;
  }

  public List<UserComments> getComments() {
    return comments;
  }

  public void setComments(List<UserComments> comments) {
    this.comments = comments;
  }


  public int getMsgType() {
    return msgType;
  }


  public void setMsgType(int msgType) {
    this.msgType = msgType;
  }


  public void setMsg(String msg) {
    this.msg = msg;
  }

  public List<IndexObject> getObjects() {
    return objects;
  }

  public void setObjects(List<IndexObject> objects) {
    this.objects = objects;
  }
}
