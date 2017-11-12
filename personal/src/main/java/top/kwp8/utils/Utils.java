package top.kwp8.utils;

import java.io.File;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

public class Utils {

	public static String mappingPath(HttpServletRequest request){
		if(request == null){
			return "";
		}
		String url=request.getScheme()+"://"+ request.getServerName() + ":"+request.getLocalPort() + request.getContextPath() +File.separator+"mapping"+File.separator;
		return url;
	}
	public static String path(HttpServletRequest request){
		if(request == null){
			return "";
		}
		String url=request.getScheme()+"://"+ request.getServerName() + ":"+request.getLocalPort() + request.getContextPath() +"/";
		return url;
	}
	public static String getImgpath(HttpServletRequest request,String imgName){
		if(request == null){
			return "";
		}
		String url= Utils.path(request) + "goodsimg/"+imgName;
		return url;
	}
	public static String getDateString(Long time){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(time != null){
			return sdf.format(time);
		}
		return "";
	}
}
