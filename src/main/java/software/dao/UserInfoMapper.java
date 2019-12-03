package software.dao;

import org.apache.ibatis.annotations.Param;
import software.model.UserInfo;

public interface UserInfoMapper {
  int deleteByPrimaryKey(Integer uid);

  int insert(UserInfo record);

  int insertSelective(UserInfo record);

  UserInfo selectByPrimaryKey(Integer uid);

  int updateByPrimaryKeySelective(UserInfo record);

  int updateByPrimaryKey(UserInfo record);

  UserInfo selectUserInfoByEmail(@Param("email") String email);

  UserInfo selectUserInfoByEmailAndPasswd(
      @Param("email") String email, @Param("passwd") String passwd);
}
