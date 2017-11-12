package top.kwp8.entity;

public class Goods {
//	private static final int com_status = 0; 
//	private static final int hot_status = 1; 
//	private static final int empty_status = 2;
	private Integer id;
	private String goodsName;
//	private Double price;
	private String price;
	private String produceAddress;
	private Double marketprice;
	private Integer salecount;
	private String img;
	private String content;
	private Integer status;
	private Integer reserveCount;
	private Long createtime;
	private String specifications;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
//	public Double getPrice() {
//		return price;
//	}
//	public void setPrice(Double price) {
//		this.price = price;
//	}
	
	public String getProduceAddress() {
		return produceAddress;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setProduceAddress(String produceAddress) {
		this.produceAddress = produceAddress;
	}
	public Double getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(Double marketprice) {
		this.marketprice = marketprice;
	}
	public Integer getSalecount() {
		return salecount;
	}
	public void setSalecount(Integer salecount) {
		this.salecount = salecount;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getReserveCount() {
		return reserveCount;
	}
	public void setReserveCount(Integer reserveCount) {
		this.reserveCount = reserveCount;
	}
	public Long getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	
}
