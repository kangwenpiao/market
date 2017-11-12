package top.kwp8.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.kwp8.dao.GoodsDao;
import top.kwp8.entity.Goods;
import top.kwp8.service.GoodsService;
import top.kwp8.utils.Grid;
@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public void save(Goods goods) {
		String sql = "insert goods(goodsName,price,produceAddress,marketprice,salecount,img,content,status,reserveCount,createtime,specifications) value(?,?,?,?,?,?,?,?,?,?,?)";
		goodsDao.save(sql,goods.getGoodsName(),goods.getPrice(),goods.getProduceAddress(),goods.getMarketprice(),goods.getSalecount(),goods.getImg(),goods.getContent(),goods.getStatus(),goods.getReserveCount(),goods.getCreatetime(),goods.getSpecifications());
	}

	@Override
	public void update(Goods goods) {
		String sql = "";
		if(StringUtils.isBlank(goods.getImg())){
			sql = "update goods set goodsName = ?,price = ?,produceAddress = ?,marketprice = ?,salecount = ?,content = ?,status = ?,reserveCount =? where id = ?";
			System.out.println(sql);
			goodsDao.update(sql,goods.getGoodsName(),goods.getPrice(),goods.getProduceAddress(),goods.getMarketprice(),goods.getSalecount(),goods.getContent(),goods.getStatus(),goods.getReserveCount(),goods.getId());
		}else{
			sql = "update goods set goodsName = ?,price = ?,produceAddress = ?,marketprice = ?,salecount = ?,img = ?,content = ?,status = ?,reserveCount =? where id = ?";
			System.out.println(sql);
			goodsDao.update(sql,goods.getGoodsName(),goods.getPrice(),goods.getProduceAddress(),goods.getMarketprice(),goods.getSalecount(),goods.getImg(),goods.getContent(),goods.getStatus(),goods.getReserveCount(),goods.getId());
		}
	}

	@Override
	public void delete(Integer id) {
		String sql  = "delete from goods where id = ?";
		goodsDao.delete(sql, id);
	}

	@Override
	public Goods select(Integer id) {
		String sql = "select * from goods where id = ?";
		return goodsDao.select(sql, id,Goods.class);
	}

	@Override
	public List<Goods> selectList() {
		String sql = "select * from goods";
		return goodsDao.selectList(sql, Goods.class);
	}
	@Override
	public List<Goods> selectListByName(String name) {
		String sql = "";
		if(StringUtils.isBlank(name)){
			 sql = "select * from goods";
			 return goodsDao.selectList(sql, Goods.class);
		}else{
			 sql = "select * from goods where goodsName like ?";
			 System.out.println(sql);
			 return goodsDao.selectListByName(sql, Goods.class,'%'+name+'%');
		}
	}
	@Override
	public List<Goods> selectListPage(Grid grid) {
		String sql = "";
		Integer start = (grid.getPage()-1) * grid.getRows();
		if(StringUtils.isBlank(grid.getName())){
			 sql = "select * from goods order by "+grid.getSort()+" "+grid.getOrder().toUpperCase()+" limit ?,?";
			 System.out.println(sql);
			 return goodsDao.selectListByPage(sql, Goods.class,start,grid.getRows());
		}else{
			 sql = "select * from goods where goodsName like ? order by "+grid.getSort()+" "+grid.getOrder().toUpperCase()+" limit ?,?";
			 System.out.println(sql);
			 return goodsDao.selectListByPage(sql, Goods.class,'%'+grid.getName()+'%',start,grid.getRows());
		}
	}
	@Override
	public List<Goods> selectList(Grid grid) {
		String sql = "";
		Integer start = (grid.getPage()-1) * grid.getRows();
		if(StringUtils.isBlank(grid.getName())){
			 sql = "select * from goods order by salecount desc limit ?,?";
			 System.out.println(sql);
			 return goodsDao.selectListByPage(sql, Goods.class,start,grid.getRows());
		}else{
			 sql = "select * from goods where goodsName like ? order by salecount desc limit ?,?";
			 System.out.println(sql);
			 return goodsDao.selectListByPage(sql, Goods.class,'%'+grid.getName()+'%',start,grid.getRows());
		}
	}
	@Override
	public Long selCount(String name) {
		String sql = "";
		if(StringUtils.isBlank(name)){
			sql ="select count(*) from goods";
			return goodsDao.selCount(sql);
		}else{
			 sql ="select count(*) from goods where goodsName like ?";
			 return goodsDao.selCount(sql,'%'+name+'%');
		}
	}
}
