package top.kwp8.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.kwp8.dao.AdminDao;
import top.kwp8.entity.Admin;
import top.kwp8.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	@Override
	public Admin selectByName(String name) {
		String sql = "select * from admin where name = :name";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("name", name);
		return adminDao.selectByName(sql, paramMap);
	}

}
