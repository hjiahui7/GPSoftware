package software.service.util;

import org.apache.logging.log4j.util.PropertiesUtil;
import software.dao.UserInfoMapper;
import software.dao.UserPostsMapper;
import software.jsonModel.ResponseObject;
import software.model.UserInfo;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

public class SessionCtr {

  public static final int success = 1;
  public static final int timeOut = 2;
  public static final int tokenFailed = 3;
  final Random r = new SecureRandom();

  private static class SessionMaker {
    private static SessionCtr instance = new SessionCtr();
  }

  public static SessionCtr getInstance() {
    return SessionMaker.instance;
  }

  /**
   * 1 success 2 timeout 3 token failed
   *
   * @param token
   * @return
   */
  public int checkToken(UserInfo userInfo, String token) {
    String md5S = getMd5(userInfo.getPasswd(), userInfo.getPasswdSalt());
    if (token.equals(md5S)) {
      long curT = System.currentTimeMillis();
      long r = curT - userInfo.getAccessTime().getTime();
      if (r > 2000 * 3600) {
        return timeOut;
      } else {
        return success;
      }
    }
    return tokenFailed;
  }

  public boolean checkLogin(UserInfo userInfo, String pass) {
    if (userInfo.getPasswd().equals(getMd5(pass, userInfo.getPasswdSalt()))) {
      return true;
    }
    return false;
  }

  public String getMd5(String pass, String salt) {
    return md5(pass + salt);
  }

  public String getSalt() {
    byte[] salt = new byte[32];
    r.nextBytes(salt);
    return salt.toString();
  }

  public static String md5(String input) {
    String md5 = null;
    if (null == input) return null;
    try {
      MessageDigest digest = MessageDigest.getInstance("MD5");
      digest.update(input.getBytes(), 0, input.length());
      md5 = new BigInteger(1, digest.digest()).toString(16);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return md5;
  }
}
