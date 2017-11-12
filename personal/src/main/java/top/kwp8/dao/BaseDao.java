package top.kwp8.dao;

import java.util.List;

public interface BaseDao<T> {

	void save(String sql,Object...objects);
	
	void update(String sql,Object...objects);
	
	void delete(String sql,Integer id);
	
	T select(String sql,Integer id,Class<T> cla);
	
	List<T> selectList(String sql,Class<T> cla);
	
	List<T> selectListByName(String sql,Class<T> cla,String name);

	List<T> selectListByPage(String sql, Class<T> cla, Object...objects);
	
	Long selCount(String sql,Object...objects);
}
