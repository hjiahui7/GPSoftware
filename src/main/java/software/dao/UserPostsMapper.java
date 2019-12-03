package software.dao;

import org.apache.ibatis.annotations.Param;
import software.jsonModel.IndexObject;
import software.model.UserPosts;

import java.util.Date;
import java.util.List;

public interface UserPostsMapper {
  int deleteByPrimaryKey(Integer pid);

  int insert(UserPosts record);

  int insertSelective(UserPosts record);

  UserPosts selectByPrimaryKey(Integer pid);

  int updateByPrimaryKeySelective(UserPosts record);

  int updateByPrimaryKey(UserPosts record);

  List<IndexObject> selectAllUserPosts();

  List<IndexObject> selectAllPostsByTime(Date time);

  UserPosts selectUserPostByPostId(@Param("pid") int pid);

  List<UserPosts> selectAllUserPostByMotherId(@Param("motherPostId") int motherPostId);

  List<UserPosts> selectUserPostByUserId(@Param("uid") int uid);

  List<UserPosts> selectUserReplyByUserId(@Param("uid") int uid);

  int deleteByPostId(int pid);

  int deleteByMotherPostId(int motherPostId);

  List<UserPosts> selectOtherPostByUserId(@Param("uid") int uid);
}
