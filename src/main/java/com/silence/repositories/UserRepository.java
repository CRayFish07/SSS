package com.silence.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.silence.enties.User;

@Repository("userDao")
public interface UserRepository extends JpaRepository<User, Integer>{

	@Modifying
	@Query("update User u set u.name = :name,u.birthday = :birthday,u.telephone = :telephone where u.id = :id")
	public void update(@Param("name") String name,@Param("birthday") Date birthday,
			@Param("telephone") String telephone,@Param("id") Integer id);

	//根据不同的年龄段统计用户的数量,nativeQuery=true表示使用本地查詢，也就是JDBC查詢
	@Query(value="select count(*),left(birthday,4) from users group by left(birthday,4)",nativeQuery=true)
	public List<Object[]> findByAgeCount();
	
	//根据用户的电话号码判断是否存在
	@Query("from User u where u.telephone = :telephone")
	public User exist(@Param("telephone") String telephone);
	
}