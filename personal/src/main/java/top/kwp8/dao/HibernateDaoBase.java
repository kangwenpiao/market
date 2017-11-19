package top.kwp8.dao;

import java.util.List;


public interface HibernateDaoBase<T> {

	void save(T t);
	
	void delete(T t);
	
	T get(Class<T> cla,Integer id);
	
	void update(T t);
	
	List<T> list(String sql);
	
	List<T> pagelist(String sql,Integer pageNo,Integer pageSize,Object...objects);
	
	Long getCount(String sql,Object...objects);

}
