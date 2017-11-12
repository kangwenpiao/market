package top.kwp8.controller.mobile;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import top.kwp8.entity.Goods;
import top.kwp8.entity.view.GoodsView;
import top.kwp8.service.GoodsService;
import top.kwp8.utils.Grid;
import top.kwp8.utils.JsonResult;
import top.kwp8.utils.OutPrint;
import top.kwp8.utils.Utils;

@RequestMapping("/mobile")
@Controller
public class MobileGoodsController {

	@Autowired
	private GoodsService goodsService;
	@RequestMapping("/selgoods.do")
	public void selGoods(Integer goodsid,HttpServletRequest request,HttpServletResponse response){
		if(goodsid == null){
			OutPrint.returnResultFail(response, "商品goodsid没传");
			return;
		}
		Goods goods = goodsService.select(goodsid);
		String img = goods.getImg();
		String imgurl = Utils.getImgpath(request,img);
		goods.setImg(imgurl);
		OutPrint.outResultRes(response, goods, JsonResult.success, "查询成功");
	}
	@RequestMapping("/listgoods.do")
	public void ListGoods(String name,HttpServletRequest request,HttpServletResponse response){
		List<Goods> listgoods = goodsService.selectListByName(name);
		List<GoodsView> list = new ArrayList<>();
		for (Goods goods : listgoods) {
			GoodsView g = new GoodsView();
			BeanUtils.copyProperties(goods, g,new String[]{"img"});
			String img = goods.getImg();
			String imgurl = Utils.getImgpath(request,img);
			g.setImg(imgurl);
			list.add(g);
		}
		OutPrint.outResultRes(response, list, JsonResult.success, "查询成功");
	}
	@RequestMapping("/listgoodspage.do")
	public void ListGoodsPage(Grid grid,HttpServletRequest request,HttpServletResponse response){
		List<Goods> listgoods = goodsService.selectList(grid);
		List<GoodsView> list = new ArrayList<>();
		for (Goods goods : listgoods) {
			GoodsView g = new GoodsView();
			BeanUtils.copyProperties(goods, g,new String[]{"img"});
			String img = goods.getImg();
			String imgurl = Utils.getImgpath(request,img);
			g.setImg(imgurl);
			list.add(g);
		}
		OutPrint.outResultRes(response, list, JsonResult.success, "查询成功");
	}
}
