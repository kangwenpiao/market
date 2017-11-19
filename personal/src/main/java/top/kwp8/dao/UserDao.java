package top.kwp8.dao;

import java.util.List;

import top.kwp8.entity.User;

public interface UserDao{

	User select(String sql,User user);
	
	void addUser(String sql ,List<String> list);
}
