package top.kwp8.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  用ThreadLocal来存储request,session,response 以便实现Session any where 
 *  request any where response any where
 */
public class ThreadContextHolder  {
	protected static final Logger logger = LoggerFactory.getLogger(ThreadContextHolder.class);
	
	private static ThreadLocal<HttpServletRequest> HttpRequestThreadLocalHolder = new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpServletResponse> HttpResponseThreadLocalHolder = new ThreadLocal<HttpServletResponse>();
	private static ThreadLocal<HttpSession> HttpSessionThreadLocalHolder = new ThreadLocal<HttpSession>();
	
	
	public static void setHttpRequest(HttpServletRequest request){
		HttpRequestThreadLocalHolder.set(request);
	}
	
	public static HttpServletRequest getHttpRequest(){
		return  HttpRequestThreadLocalHolder.get();
	}
	
	public static void remove(){
		HttpRequestThreadLocalHolder.remove();
		HttpResponseThreadLocalHolder.remove();
	}
	
	public static void setHttpResponse(HttpServletResponse response){
		HttpResponseThreadLocalHolder.set(response);	
	}
	
	public static HttpServletResponse getHttpResponse(){
		
		return HttpResponseThreadLocalHolder.get();
	}

	public static HttpSession getHttpSession() {
		if(HttpSessionThreadLocalHolder.get() == null){
			HttpSessionThreadLocalHolder.set(HttpRequestThreadLocalHolder.get().getSession());
		}
		return HttpSessionThreadLocalHolder.get(); 
	}

	public static void setHttpSession(HttpSession session) {
		HttpSessionThreadLocalHolder.set(session);
	}
	
	
}
