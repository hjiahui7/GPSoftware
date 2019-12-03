package software.model;

import java.util.Date;

public class UserComments {
  private Integer cid;

  private Integer pid;

  private Integer mid;

  private String comment;

  private Date createTime;

  private String userNickFrom;

  private String userNickTo;

  private Integer uidFrom;

  private Integer uidTo;

  private String token;

  public UserComments() {}

  public UserComments(
      Integer pid,
      Integer mid,
      String comment,
      Date createTime,
      String userNickFrom,
      String userNickTo,
      Integer uidFrom,
      Integer uidTo) {
    this.pid = pid;
    this.mid = mid;
    this.comment = comment;
    this.createTime = createTime;
    this.userNickFrom = userNickFrom;
    this.userNickTo = userNickTo;
    this.uidFrom = uidFrom;
    this.uidTo = uidTo;
  }

  public Integer getCid() {
    return cid;
  }

  public void setCid(Integer cid) {
    this.cid = cid;
  }

  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment == null ? null : comment.trim();
  }

  public Integer getMid() {
    return mid;
  }

  public void setMid(Integer mid) {
    this.mid = mid;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getUserNickFrom() {
    return userNickFrom;
  }

  public void setUserNickFrom(String userNickFrom) {
    this.userNickFrom = userNickFrom == null ? null : userNickFrom.trim();
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getUserNickTo() {
    return userNickTo;
  }

  public void setUserNickTo(String userNickTo) {
    this.userNickTo = userNickTo == null ? null : userNickTo.trim();
  }

  public Integer getUidFrom() {
    return uidFrom;
  }

  public void setUidFrom(Integer uidFrom) {
    this.uidFrom = uidFrom;
  }

  public Integer getUidTo() {
    return uidTo;
  }

  public void setUidTo(Integer uidTo) {
    this.uidTo = uidTo;
  }
}
