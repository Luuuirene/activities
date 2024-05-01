package com.activities_category.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.activities_item.model.ItemVO;

@Entity
@Table(name = "activity_category")
public class CategoryVO implements Serializable{
	private static final long serialVersionUID = 6263388433578802846L;

    @Id
    @Column(name = "activity_category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityCategoryId;

    @Column(name = "activity_category_name")
    @NotEmpty(message = "活動類別名稱：請勿空白")
    private String activityCategoryName;

    @Column(name = "activity_category_info")
    private String activityCategoryInfo;

    @OneToMany(mappedBy = "categoryVO" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("activityId")
    private Set<ItemVO> items;

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

    public Set<ItemVO> getItems() {
        return items;
    }

    public void setItems(Set<ItemVO> items) {
        this.items = items;
    }
}
