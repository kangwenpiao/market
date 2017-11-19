package top.kwp8.service;

import java.util.List;

import top.kwp8.entity.User;

public interface UserService {

	User selectUser(User user);
	
	void addUser(List<String> list);
	
}
