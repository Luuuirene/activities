package com.activities_photo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.activities_item.model.ItemVO;

@Entity
@Table(name = "activity_photo")
public class PhotoVO implements Serializable{

	
	private static final long serialVersionUID = 5741389575757322797L;
	
	@Id
	@Column(name = "activity_photo_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer activityPhotoId;
	
	@ManyToOne
	@JoinColumn(name = "activity_id",referencedColumnName = "activity_id")
	private ItemVO itemVO;
	
	@Column(name = "activity_photo", columnDefinition = "longblob")
	private byte[] activityPhoto;
	
	public PhotoVO() {
		
	}

	public Integer getActivityPhotoId() {
		return activityPhotoId;
	}

	public void setActivityPhotoId(Integer activityPhotoId) {
		this.activityPhotoId = activityPhotoId;
	}

	public ItemVO getItemVO() {
		return itemVO;
	}

	public void setItemVO(ItemVO itemVO) {
		this.itemVO = itemVO;
	}

	public byte[] getActivityPhoto() {
		return activityPhoto;
	}

	public void setActivityPhoto(byte[] activityPhoto) {
		this.activityPhoto = activityPhoto;
	}
	
	

}
