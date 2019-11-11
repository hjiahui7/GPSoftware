package software.model;

import java.util.Date;

public class UserInfo {
  private String eMail;

  private Integer id;

  private String firstName;

  private String lastName;

  private String pSignature;

  private String passwd;

  private String nickName;

  private Date createTime;

  public UserInfo() {}

  public UserInfo(
      String eMail,
      String firstName,
      String lastName,
      String passwd,
      String nickName,
      Date createTime) {
    this.eMail = eMail;
    this.firstName = firstName;
    this.lastName = lastName;
    this.passwd = passwd;
    this.nickName = nickName;
    this.createTime = createTime;
  }

  public String geteMail() {
    return eMail;
  }

  public void seteMail(String eMail) {
    this.eMail = eMail == null ? null : eMail.trim();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public void setLastName(String lastName) {
    this.lastName = lastName == null ? null : lastName.trim();
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
}
