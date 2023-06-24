package com.xiaoge.pojo;

import java.util.Date;

public class Comment {

	private String goods_name;
	private int comment_id;
	private Date comment_date;
	private String comment;
	
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "Comment [goods_name=" + goods_name + ", comment_id=" + comment_id + ", comment_date=" + comment_date
				+ ", comment=" + comment + "]";
	}

    public void setCommentId(String number) {
    }

	public void setContent(String greatProduct) {
	}
}
