package top.kwp8.dao;

import java.util.Map;

import top.kwp8.entity.Admin;

public interface AdminDao {

	Admin selectByName(String sql,Map<String,String> paramMap);
	
}
