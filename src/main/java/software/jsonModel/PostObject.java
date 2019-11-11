package software.jsonModel;

public class PostObject {
  private String token;
  private String postTitle;
  private String postData;
  private int postId;
  private int motherPostId;

  public PostObject() {}

  public PostObject(String token, String postTitle, String postData) {
    this.token = token;
    this.postTitle = postTitle;
    this.postData = postData;
  }

  public PostObject(String token, String postTitle, String postData, int postId, int motherPostId) {
    this.token = token;
    this.postTitle = postTitle;
    this.postData = postData;
    this.postId = postId;
    this.motherPostId = motherPostId;
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

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
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
}
