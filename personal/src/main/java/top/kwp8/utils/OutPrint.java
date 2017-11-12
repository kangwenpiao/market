package top.kwp8.utils;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class OutPrint {

	public static void outResultRes(HttpServletResponse response, Object object,Integer code,String message){
		response.setContentType("text/html;charset=utf-8");
		JsonResult jsonResult = new JsonResult(code, message, object);
		JSONObject jsonObject = JSONObject.fromObject(jsonResult);
		try {
			response.getWriter().print(jsonObject);//out.print();执行后  后面的程序也会执行
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void outResultResSuc(HttpServletResponse response, Object object,String message){
		response.setContentType("text/html;charset=utf-8");
		JsonResult jsonResult = new JsonResult(JsonResult.success, message, object);
		JSONObject jsonObject = JSONObject.fromObject(jsonResult);
		try {
			response.getWriter().print(jsonObject);//out.print();执行后  后面的程序也会执行
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void outResultResSucGrid(HttpServletResponse response, Object object){
		response.setContentType("text/html;charset=utf-8");
		JSONObject jsonObject = JSONObject.fromObject(object);
		try {
			response.getWriter().print(jsonObject);//out.print();执行后  后面的程序也会执行
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void returnResultSuccess(HttpServletResponse response,String message){
		response.setContentType("text/html;charset=utf-8");
		JsonResult jsonResult = new JsonResult(JsonResult.success, message);
		JSONObject jsonObject = JSONObject.fromObject(jsonResult);
		try {
			response.getWriter().print(jsonObject);//out.print();执行后  后面的程序也会执行
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void returnResultError(HttpServletResponse response,String message){
		response.setContentType("text/html;charset=utf-8");
		JsonResult jsonResult = new JsonResult(JsonResult.error, message);
		JSONObject jsonObject = JSONObject.fromObject(jsonResult);
		try {
			response.getWriter().print(jsonObject);//out.print();执行后  后面的程序也会执行
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void returnResultFail(HttpServletResponse response,String message){
		response.setContentType("text/html;charset=utf-8");
		JsonResult jsonResult = new JsonResult(JsonResult.fail, message);
		JSONObject jsonObject = JSONObject.fromObject(jsonResult);
		try {
			response.getWriter().print(jsonObject);//out.print();执行后  后面的程序也会执行
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String returnResult(Integer code,String message,Object object){
		JsonResult jsonResult = new JsonResult(code, message,object);
		JSONObject jsonObject = JSONObject.fromObject(jsonResult);
		return jsonObject.toString();
//			return new String(jsonObject.toString().getBytes("ISO-8859-1"),"UTF-8").toString();
	}
	public static String returnResult(Object object){
		JsonResult jsonResult = new JsonResult(object);
		JSONObject jsonObject = JSONObject.fromObject(jsonResult);
		return jsonObject.toString();
	}
	public static String returnJson(Object object){
		JSONObject jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
	}
}
