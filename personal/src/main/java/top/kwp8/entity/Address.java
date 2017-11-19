package top.kwp8.entity;

public class Address {
	private final static Integer DEFAULT = 1; 
	private Integer id;
	private Integer userid;
	private Integer isshow;
	private Integer regionsid;
	private String detailaddress;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getIsshow() {
		return isshow;
	}
	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}
	public Integer getRegionsid() {
		return regionsid;
	}
	public void setRegionsid(Integer regionsid) {
		this.regionsid = regionsid;
	}
	public String getDetailaddress() {
		return detailaddress;
	}
	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}
	
}
