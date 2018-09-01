package com.demo.dao;

import com.demo.models.User;


public interface UserMapper {
	// ��ѯһ���û�
	public User selectById(Integer id);

	// ����û�
	public int insertUser(User user);
	// ����û�
	public int insertUser2(User user);	

	// �޸��û�
	public int updateUser(User user);

	// ɾ���û�
	public int deleteUser(Integer id);
}
