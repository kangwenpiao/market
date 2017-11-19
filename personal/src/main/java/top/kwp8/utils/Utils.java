package top.kwp8.utils;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class Utils {
	/**
	 * 项目目录
	 * @param request
	 * @return
	 */
	public static String path(HttpServletRequest request){
		if(request == null){
			return "";
		}
		String url=request.getScheme()+"://"+ request.getServerName() + ":"+request.getLocalPort() + request.getContextPath() +"/";
		return url;
	}
	/**
	 * 图片路径
	 * @param request
	 * @param imgName
	 * @return
	 */
	public static String getImgpath(HttpServletRequest request,String imgName){
		if(request == null){
			return "";
		}
		String url= Utils.path(request) + "goodsimg/"+imgName;
		return url;
	}
	/**
	 * 时间格式化
	 * 对long格式化为yyyy-MM-dd HH:mm:ss
	 * @param time
	 * @return
	 */
	public static String getDateString(Long time){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(time != null){
			return sdf.format(time);
		}
		return "";
	}
	/**
	 * 只能判断是否是11位的手机号
	 * @param mobile
	 * @return
	 */
	public static boolean checkMobile(String mobile){
		if(StringUtils.isBlank(mobile)){
			return false;
		}
		String regex = "^\\d{11}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobile);
		return m.matches();
	}
	
}
