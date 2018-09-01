package com.demo.dao;

import com.demo.models.User;


public interface UserMapper {
	// 查询一个用户
	public User selectById(Integer id);

	// 添加用户
	public int insertUser(User user);
	// 添加用户
	public int insertUser2(User user);	

	// 修改用户
	public int updateUser(User user);

	// 删除用户
	public int deleteUser(Integer id);
}
