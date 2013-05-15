package edu.SMtool.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Post")
public class Post implements Serializable{

	private static final long serialVersionUID = -1804408044639078030L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPost")
	private int id;

	@Column(name = "ddate")
	private Date date;
	
	@Column (name = "ccontent")
	private String content;
	
	@Column(name = "link")
	private String link;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCampaign")
	private Campaign idCampaign;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	

	public Campaign getIdCampaign() {
		return idCampaign;
	}
	public void setIdCampaign(Campaign idCampaign) {
		this.idCampaign = idCampaign;
	}
	
	

}
