package software.jsonModel;

import java.util.Date;

public class IndexObject {
  private int id;
  private String postTitle;
  private String postData;
  private Date createTime;
  private String nickName;
  private int commentCount;


  public IndexObject() {
  }


  public IndexObject(int id, String postTitle, String postData, Date createTime, String nickName) {
    this.id = id;
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
}
