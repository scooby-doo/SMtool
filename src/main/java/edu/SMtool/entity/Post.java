package edu.SMtool.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = "Post")
public class Post {
	
	private int id;
	private Date date;
	private String content;
	private String link;
	private Campaign idCampaign;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPost")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column (name = "content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name = "link")
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "idCampaign")
	public Campaign getIdCampaign() {
		return idCampaign;
	}
	public void setIdCampaign(Campaign idCampaign) {
		this.idCampaign = idCampaign;
	}
	
	

}
