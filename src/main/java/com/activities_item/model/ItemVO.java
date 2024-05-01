package com.activities_item.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import com.activities_category.model.CategoryVO;
import com.activities_photo.model.PhotoVO;
import com.activities_session.model.SessionVO;


@Entity
@Table(name = "activity_item")
public class ItemVO implements Serializable {

    private static final long serialVersionUID = 3719173549196281407L;

    @Id
    @Column(name = "activity_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityId;
    
//    @ManyToOne
//    @JoinColumn(name = "activity_category_id", referencedColumnName = "activity_category_id")
//    private CategoryVO_ForIt categoryVO_ForIt;
    
    @ManyToOne
    @JoinColumn(name = "activity_category_id", referencedColumnName = "activity_category_id")
    private CategoryVO categoryVO;

    @Column(name = "activity_name")
    @NotEmpty(message = "活動名稱：請勿空白")
    private String activityName;

    @Column(name = "activity_description")
    private String activityDescription;

    @Column(name = "activity_info")
    private String activityInfo;

    @Column(name = "activity_price")
    @NotNull(message = "活動價格：請勿空白")
    @DecimalMin(value = "1", message = "只能填寫數字，且不能有小數點")
    private Integer activityPrice;

    @Column(name = "activity_state")
    private Boolean activityState;

    @OneToMany(mappedBy = "itemVO", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("activitySessionId")
    private Set<SessionVO> sessionVOs;
    
    @OneToMany(mappedBy = "itemVO" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("activityPhotoId")
    private Set<PhotoVO> photoVOs;


    public ItemVO(){

    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    

//    public CategoryVO_ForIt getCategoryVO_ForIt() {
//		return categoryVO_ForIt;
//	}
//
//	public void setCategoryVO_ForIt(CategoryVO_ForIt categoryVO_ForIt) {
//		this.categoryVO_ForIt = categoryVO_ForIt;
//	}
	
	public CategoryVO getCategoryVO() {
		return categoryVO;
	}
	
	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
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

	

	public Set<SessionVO> getSessionVOs() {
		return sessionVOs;
	}

	public void setSessionVOs(Set<SessionVO> sessionVOs) {
		this.sessionVOs = sessionVOs;
	}

	public Set<PhotoVO> getPhotoVOs() {
		return photoVOs;
	}

	public void setPhotoVOs(Set<PhotoVO> photoVOs) {
		this.photoVOs = photoVOs;
	}
	
    
    
}


