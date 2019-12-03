package software.jsonModel;

import java.util.Date;

public class IndexObject {
  private int uid;
  private int pid;
  private String postTitle;
  private String postData;
  private Date createTime;
  private String nickName;
  private int commentCount;
  private int level;

  public IndexObject() {}

  public IndexObject(int pid, String postTitle, String postData, Date createTime, String nickName) {
    this.pid = pid;
    this.postTitle = postTitle;
    this.postData = postData;
    this.createTime = createTime;
    this.nickName = nickName;
  }

  public int getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(int commentCount) {
    this.commentCount = commentCount;
  }

  public int getPid() {
    return pid;
  }

  public void setPid(int pid) {
    this.pid = pid;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public String getPostTitle() {
    return postTitle;
  }

  public void setPostTitle(String postTitle) {
    this.postTitle = postTitle;
  }

  public String getPostData() {
    return postData;
  }

  public void setPostData(String postData) {
    this.postData = postData;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getNickName() {
    return nickName;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
}
