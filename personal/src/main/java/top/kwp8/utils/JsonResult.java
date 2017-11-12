package top.kwp8.utils;

public class JsonResult {

	

	public static final int success = 0; //0看得到
//	public static final Integer success = 0; //0看不到
	public static final int fail = 1;
	public static final int error = 2;
//	public static final Integer error = 1;
	private Integer code; 
	private String message;
	private Object obj;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public JsonResult(Integer code, String message, Object obj) {
		super();
		this.code = code;
		this.message = message;
		this.obj = obj;
	}
	
	public JsonResult(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public JsonResult(Object obj) {
		super();
		this.obj = obj;
	}
}
