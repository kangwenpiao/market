package top.kwp8.service;

import java.util.List;

import top.kwp8.entity.Goods;
import top.kwp8.utils.Grid;

public interface GoodsService {

	void save(Goods goods);
	
	void update(Goods goods);
	
	void delete(Integer id);
	
	Goods select(Integer id);
	
	List<Goods> selectList();
	
	List<Goods> selectListByName(String name);
	
	List<Goods> selectListPage(Grid grid);
	
	List<Goods> selectList(Grid grid);
	
	Long selCount(String name);
}
