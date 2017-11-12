package top.kwp8.utils;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class WXUtils {

	public static final String appId = "wx354ef86dfbf6a296";
	public static final String AppSecret = "04035c1d5b51950e904c16b1ce66af68";
	private static final String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + WXUtils.appId + "&secret=" + WXUtils.AppSecret;
	private static final String get_user_url = "";
	public static String access_token = "";
	public static Long time = 0L;

	public static String getToken() {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		System.out.println("Executing request " + httpget.getURI());
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpget);
			System.out.println("----------------------------------------");
			System.out.println(response.getStatusLine());
			org.apache.http.HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity);
			if (entity != null) {
				time = System.currentTimeMillis() / 1000;
				JSONObject jsonObject = JSONObject.fromObject(content);
				access_token = (String) jsonObject.get("access_token");
				System.out.println(access_token);
			} 
			httpget.abort();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return access_token;
	}
	
	public static String getAccessToken(){
		Long nowdate = System.currentTimeMillis()/1000;
		if(nowdate >= time){
			return WXUtils.getToken();
		}
		return access_token;
	}

	public static void main(String[] args) {
		getToken();
	}
	
	public static void getUserInfo(){
		
	}
}
