package top.kwp8.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import top.kwp8.entity.Goods;
import top.kwp8.service.GoodsService;
import top.kwp8.utils.Grid;
import top.kwp8.utils.OutPrint;
import top.kwp8.utils.Page;
import top.kwp8.utils.Utils;

@RequestMapping("/admin")
@Controller
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	@RequestMapping("/savegoods.do")
	public String saveGoods(@RequestParam(value="file",required = true) MultipartFile file,Goods goods,HttpServletRequest request,HttpServletResponse response){
//		String path = request.getServletContext().getRealPath("/") + "WEB-INF/page/img/";
		String path = request.getServletContext().getRealPath("/");
		File filePath = new File(path);
		String realPath = filePath.getParent() + File.separator + "goodsimg";
//		String path = Utils.mappingPath(request);
		if(file.isEmpty()){
//			throw new RuntimeException("file 文件为空,记得传图片~");
			request.setAttribute("message", "保存商品失败，记得传商品图片！");
			return "goodsreturn";
		}
		String fileName = file.getOriginalFilename();//文件名
		String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		fileName = new Date().getTime()+"_goods" + ext;
		File copy = new File(realPath,fileName);
		System.out.println(copy.getAbsolutePath());
		try {
			if(!copy.exists()){
				copy.mkdirs();
			}
			file.transferTo(copy);
			goods.setImg(fileName);
			goods.setCreatetime(System.currentTimeMillis());
			goodsService.save(goods);
			request.setAttribute("message", "保存商品成功！");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "goodsreturn";
//		OutPrint.returnResultSuccess(response, "增加成功");
	}
	@RequestMapping("/editgoods.do")
	public String editGoods(Goods goods,@RequestParam(value="file",required = false) MultipartFile file,HttpServletRequest request,HttpServletResponse response){
		try {
			if(!file.isEmpty()){
//				String path = request.getServletContext().getRealPath("/") + "WEB-INF/page/img/";
				String path = request.getServletContext().getRealPath("/");
				File filePath = new File(path);
				String realPath = filePath.getParent() + File.separator + "goodsimg";
				String fileName = file.getOriginalFilename();//文件名
				String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());
				fileName = new Date().getTime()+"_goods" + ext;
				File copy = new File(realPath, fileName);
				file.transferTo(copy);
				goods.setImg(fileName);
			}
			goodsService.update(goods);
			request.setAttribute("message", "编辑商品成功！");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		OutPrint.returnResultSuccess(response, "编辑成功");
		return "goodsreturn";
	}
	@RequestMapping("/goodslist.do")
	public void goodsListPage(Grid grid,HttpServletRequest request,HttpServletResponse response){
		List<Goods> list = goodsService.selectListPage(grid);
		for (Goods goods : list) {
			String img = goods.getImg();
			String imgurl = Utils.getImgpath(request,img);
			goods.setImg(imgurl);
		}
		Long total = goodsService.selCount(grid.getName());
		Page<Goods> pagelist = new Page<>(total, list);
		OutPrint.outResultResSucGrid(response, pagelist);
	}
	@RequestMapping("/addgoodspage.do")
	public String addGoodsPage(){
		return "goods";
	}
	@RequestMapping("/addgoods.do")
	public String addGoods(){
		return "addgoods";
	}
	@RequestMapping("/listgoodspage.do")
	public String listGoodsPage(){
		return "goodslist";
	}
	@RequestMapping("/editgoodspage.do")
	public String editgoodspage(HttpServletRequest request,HttpServletResponse response,Integer goodsid){
		if(goodsid == null){
			throw new RuntimeException("商品id没传");
		}
		Goods goods = goodsService.select(goodsid);
		if(goods == null){
			throw new RuntimeException("商品不存在");
		}
		String img = goods.getImg();
		String imgurl = Utils.getImgpath(request,img);
		goods.setImg(imgurl);
		request.setAttribute("goods", goods);
		return "editgoods2";
	}
	@RequestMapping("/deletegoods.do")
	public void deletegoods(Integer goodsid,HttpServletResponse response){
		if(goodsid == null){
			throw new RuntimeException("商品id没传");
		}
		goodsService.delete(goodsid);
		OutPrint.returnResultSuccess(response, "删除成功");
	}
	@RequestMapping("/upload.do")
	public void upload(@RequestParam(value="imgFile",required = true)MultipartFile file,HttpServletRequest request,HttpServletResponse response){
		if(!file.isEmpty()){
//			String path = request.getServletContext().getRealPath("/") + "WEB-INF/page/img/";
			String path = request.getServletContext().getRealPath("/");
			File filePath = new File(path);
			String realPath = filePath.getParent() + File.separator + "goodsimg";
			String fileName = file.getOriginalFilename();//文件名
			String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			fileName = new Date().getTime() + ext;
			File copy = new File(realPath, fileName);
			try {
				file.transferTo(copy);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String url = Utils.getImgpath(request, fileName);
			JSONObject obj = new JSONObject();
			obj.put("error", 0);
			obj.put("url", url);
			OutPrint.outResultResSucGrid(response, obj);
		}else{
			OutPrint.returnResultFail(response, "file 为空");
		}
	}
}
