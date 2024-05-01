package com.activities_photo.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OrderBy;
//import javax.persistence.Table;

import com.activities_item.model.CategoryVO_ForIt;


//@Entity
//@Table(name = "activity_item")
public class ItemVO_ForPh implements Serializable{


	private static final long serialVersionUID = -1673628885997440549L;

	@Id
    @Column(name = "activity_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityId;
    
//    @ManyToOne
//    @JoinColumn(name = "activity_category_id", referencedColumnName = "activity_category_id")
    private CategoryVO_ForIt categoryVO_ForIt;
	

    @Column(name = "activity_name")
    private String activityName;

    @Column(name = "activity_description")
    private String activityDescription;

    @Column(name = "activity_info")
    private String activityInfo;

    @Column(name = "activity_price")
    private Integer activityPrice;

    @Column(name = "activity_state")
    private Boolean activityState;

//    @OneToMany(mappedBy = "itemVO_ForPh", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @OrderBy("activityPhotoId")
    private Set<PhotoVO> photoVOs;


    public ItemVO_ForPh(){

    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    

    public CategoryVO_ForIt getCategoryVO_ForIt() {
		return categoryVO_ForIt;
	}

	public void setCategoryVO_ForIt(CategoryVO_ForIt categoryVO_ForIt) {
		this.categoryVO_ForIt = categoryVO_ForIt;
	}


	public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public String getActivityInfo() {
        return activityInfo;
    }

    public void setActivityInfo(String activityInfo) {
        this.activityInfo = activityInfo;
    }

    public Integer getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(Integer activityPrice) {
        this.activityPrice = activityPrice;
    }

    public Boolean getActivityState() {
        return activityState;
    }

    public void setActivityState(Boolean activityState) {
        this.activityState = activityState;
    }

	public Set<PhotoVO> getPhotoVOs() {
		return photoVOs;
	}

	public void setPhotoVOs(Set<PhotoVO> photoVOs) {
		this.photoVOs = photoVOs;
	}

	
    

}
