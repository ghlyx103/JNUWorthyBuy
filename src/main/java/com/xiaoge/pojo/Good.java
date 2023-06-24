package com.xiaoge.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Good implements Comparator<Good>{
    // 主键
    @Id
    private String goods_id;

	private int wx_id;
    @JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private String goods_name;//商品名字
	private String goods_content;//描述
	private String img;//图片ID???byte[]
	private double price;//价格
    private String shop;//购买渠道
    private int status = 0;//审核状态
    
    public Good() {}
    
    public Good(int wx_id, Date date, String goods_name, String goods_content, 
    		String img, double price, String shop) 
    {
    	this.wx_id = wx_id;
    	this.date = date;
    	this.goods_name = goods_name;
    	this.goods_content = goods_content;
    	this.img = img;
    	this.price = price;
    	this.shop = shop;
    	status = 0;
    }
    //get&set function
    public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

    public int getWx_id() {
		return wx_id;
	}

    public void setWx_id(int wx_id) {
		this.wx_id = wx_id;
	}
	
    public Date getDate() {
		return date;
	}

    public void setDate(Date date) {
		this.date = date;
	}

    public String getGoods_name() {
		return goods_name;
	}

    public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

    public String getGoods_content() {
		return goods_content;
	}

    public void setGoods_content(String goods_content) {
		this.goods_content = goods_content;
	}

    public String getImg() {
		return img;
	}

    public void setImg(String img) {
		this.img = img;
	}

    public double getPrice() {
		return price;
	}

    public void setPrice(double price) {
		this.price = price;
	}

    public String getShop() {
		return shop;
	}

    public void setShop(String shop) {
		this.shop = shop;
	}

    public int getStatus() {
		return status;
	}

    public void setStatus(int status) {
		this.status = status;
	}
    //数据对象转化成字符串，为JSON文件做准备
    @Override
    public String toString() {
        return "product{" +
        		"wx_id='" + wx_id + '\'' +
                ",date='" + date + '\'' +
                ", name=" + goods_name +
                ", content='" + goods_content + '\'' +
                ", img=" + img +
                ", price=" + price + 
                ", shop='" + shop + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
	
	public List<Good> sortPrice(List<Good> products) 
	{
		Collections.sort(products, new Comparator<Good>() {

			@Override
			public int compare(Good o1, Good o2) {
				// TODO Auto-generated method stub
				if(o1.getPrice() == o2.getPrice())
					return 0;
				else if(o1.getPrice() > o2.getPrice())
					return 1;
				else
					return -1;
			}
			
		});
		return products;
	}
	
	
	public List<Good> sortTime(List<Good> products) 
	{
		Collections.sort(products, new Comparator<Good>() {

			@Override
			public int compare(Good o1, Good o2) {
				// TODO Auto-generated method stub
				if(o1.getDate().before(o2.getDate()))
					return 1;
				else 
					return -1;
			}
		
		});
		return products;
	}

	@Override
	public int compare(Good o1, Good o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setName(String s) {
	}
}
