package software.model;

import java.util.Date;

public class UserInfo {
  private Integer uid;

  private String firstName;

  private String lastName;

  private String eMail;

  private String pSignature;

  private String passwd;

  private String passwdSalt;

  private String nickName;

  private Date createTime;

  private Date accessTime;

  private String token;

  public UserInfo() {}

  public UserInfo(
      String firstName,
      String lastName,
      String eMail,
      String passwd,
      String passwdSalt,
      String nickName,
      Date createTime) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.eMail = eMail;
    this.passwd = passwd;
    this.passwdSalt = passwdSalt;
    this.nickName = nickName;
    this.createTime = createTime;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName == null ? null : firstName.trim();
  }

  public String getLastName() {
    return lastName;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName == null ? null : lastName.trim();
  }

  public String geteMail() {
    return eMail;
  }

  public void seteMail(String eMail) {
    this.eMail = eMail == null ? null : eMail.trim();
  }

  public String getpSignature() {
    return pSignature;
  }

  public void setpSignature(String pSignature) {
    this.pSignature = pSignature == null ? null : pSignature.trim();
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd == null ? null : passwd.trim();
  }

  public String getPasswdSalt() {
    return passwdSalt;
  }

  public void setPasswdSalt(String passwdSalt) {
    this.passwdSalt = passwdSalt == null ? null : passwdSalt.trim();
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName == null ? null : nickName.trim();
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getAccessTime() {
    return accessTime;
  }

  public void setAccessTime(Date accessTime) {
    this.accessTime = accessTime;
  }
}
