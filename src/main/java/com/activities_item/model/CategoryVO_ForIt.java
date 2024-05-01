package com.activities_item.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "activity_category")
public class CategoryVO_ForIt implements Serializable{
	 

	private static final long serialVersionUID = 5814217779090330217L;

	@Id
    @Column(name = "activity_category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityCategoryId;

    @Column(name = "activity_category_name")
    @NotEmpty(message = "活動類別名稱：請勿空白")
    private String activityCategoryName;

    @Column(name = "activity_category_info")
    private String activityCategoryInfo;

//    @OneToMany(mappedBy = "categoryVO_ForIt" , cascade = CascadeType.ALL)
//    @OrderBy("activityId")
//    private Set<ItemVO> items;

    public Integer getActivityCategoryId() {
        return activityCategoryId;
    }

    public void setActivityCategoryId(Integer activityCategoryId) {
        this.activityCategoryId = activityCategoryId;
    }

    public String getActivityCategoryName() {
        return activityCategoryName;
    }

    public void setActivityCategoryName(String activityCategoryName) {
        this.activityCategoryName = activityCategoryName;
    }

    public String getActivityCategoryInfo() {
        return activityCategoryInfo;
    }

    public void setActivityCategoryInfo(String activityCategoryInfo) {
        this.activityCategoryInfo = activityCategoryInfo;
    }

//    public Set<ItemVO> getItems() {
//        return items;
//    }
//
//    public void setItems(Set<ItemVO> items) {
//        this.items = items;
//    }
}
