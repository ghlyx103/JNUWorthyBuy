package com.xiaoge.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    // 主键
    @Id
    private int wx_id;
	private String user_name;
	private String phonr;
	private String picture;
	private boolean uesr_publish = true;
	private boolean uesr_comment = true;
	
	public int getWx_id() {
		return wx_id;
	}
	public void setWx_id(int wx_id) {
		this.wx_id = wx_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPhonr() {
		return phonr;
	}
	public void setPhonr(String phonr) {
		this.phonr = phonr;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public boolean isUesr_publish() {
		return uesr_publish;
	}
	public void setUesr_publish(boolean uesr_publish) {
		this.uesr_publish = uesr_publish;
	}
	public boolean isUesr_comment() {
		return uesr_comment;
	}
	public void setUesr_comment(boolean uesr_comment) {
		this.uesr_comment = uesr_comment;
	}
	
	@Override
	public String toString() {
		return "User [wx_id=" + wx_id + ", user_name=" + user_name + ", phonr=" + phonr + ", picture=" + picture
				+ ", uesr_publish=" + uesr_publish + ", uesr_comment=" + uesr_comment + "]";
	}

	public void setName(String johnDoe) {
	}
}

