package software.model;

import java.util.Date;
import java.util.List;

public class UserPosts {
  private Integer pid;

  private Integer uid;

  private String nickName;

  private String postTitle;

  private String postData;

  private Date createTime;

  private Date dealTime;

  private Integer commentCount;

  private Integer motherPostId;

  private Integer level;

  private List<UserComments> userComments;
  private String token;

  public UserPosts() {}

  public UserPosts(
      Integer uid,
      String nickName,
      String postTitle,
      String postData,
      Date createTime,
      Integer commentCount,
      Integer motherPostId) {
    this.uid = uid;
    this.nickName = nickName;
    this.postTitle = postTitle;
    this.postData = postData;
    this.createTime = createTime;
    this.commentCount = commentCount;
    this.motherPostId = motherPostId;
  }

  public UserPosts(
      Integer uid,
      String nickName,
      String postTitle,
      String postData,
      Date createTime,
      Integer commentCount,
      Integer motherPostId,
      Integer level) {
    this.uid = uid;
    this.nickName = nickName;
    this.postTitle = postTitle;
    this.postData = postData;
    this.createTime = createTime;
    this.commentCount = commentCount;
    this.motherPostId = motherPostId;
    this.level = level;
  }

  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public Integer getUid() {
    return uid;
  }

  public Date getDealTime() {
    return dealTime;
  }

  public void setDealTime(Date dealTime) {
    this.dealTime = dealTime;
  }

  public List<UserComments> getUserComments() {
    return userComments;
  }

  public void setUserComments(List<UserComments> userComments) {
    this.userComments = userComments;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
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
    this.nickName = nickName == null ? null : nickName.trim();
  }

  public String getPostTitle() {
    return postTitle;
  }

  public void setPostTitle(String postTitle) {
    this.postTitle = postTitle == null ? null : postTitle.trim();
  }

  public String getPostData() {
    return postData;
  }

  public void setPostData(String postData) {
    this.postData = postData == null ? null : postData.trim();
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Integer getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(Integer commentCount) {
    this.commentCount = commentCount;
  }

  public Integer getMotherPostId() {
    return motherPostId;
  }

  public void setMotherPostId(Integer motherPostId) {
    this.motherPostId = motherPostId;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }
}
