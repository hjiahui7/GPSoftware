package software.model;

import java.util.Date;

public class UserPosts {
  private Integer id;

  private Integer userId;

  private String nickName;

  private String postTitle;

  private String postData;

  private Date createTime;

  private Integer commentCount;

  private Integer motherPostId;

  private Integer level;


  public UserPosts() {
  }


  public UserPosts(
      Integer userId,
      String nickName,
      String postTitle,
      String postData,
      Date createTime,
      Integer commentCount,
      Integer motherPostId) {
    this.userId = userId;
    this.nickName = nickName;
    this.postTitle = postTitle;
    this.postData = postData;
    this.createTime = createTime;
    this.commentCount = commentCount;
    this.motherPostId = motherPostId;
  }

  public UserPosts(
      Integer userId,
      String nickName,
      String postTitle,
      String postData,
      Date createTime,
      Integer commentCount,
      Integer motherPostId,
      Integer level) {
    this.userId = userId;
    this.nickName = nickName;
    this.postTitle = postTitle;
    this.postData = postData;
    this.createTime = createTime;
    this.commentCount = commentCount;
    this.motherPostId = motherPostId;
    this.level = level;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
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
