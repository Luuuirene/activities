package com.activities_session.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.activities_item.model.ItemVO;
import com.session_time_period.model.Time_PeriodVO;


@Entity
@Table(name = "activity_session")
public class SessionVO implements Serializable {
    private static final long serialVersionUID = -243893504408926223L;

    @Id
    @Column(name = "activity_session_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activitySessionId;

    @ManyToOne
    @JoinColumn(name = "activity_id",referencedColumnName = "activity_id")
    private ItemVO itemVO;

    @Column(name = "activity_date")
    @NotNull(message = "場次日期請勿空白！")
    private Date activityDate;

    
    @ManyToOne
    @JoinColumn(name = "session_time_period_id", referencedColumnName = "session_time_period_id")
    private Time_PeriodVO time_PeriodVO;

    @Column(name = "duration")
    @Min(message = "活動時長必須為數字，且不得為0", value = 0)
    @Digits(integer = 2, fraction = 1, message = "活動時長必須為數字，且小數點上限為1位")
    private Double duration;
    
    @Column(name = "activity_location")
    @NotEmpty(message="活動地點請勿空白！")
    private String activityLocation;

    @Column(name = "activity_max_part")
    @PositiveOrZero(message = "請勿空白，且只能填寫整數！")
    private Integer activityMaxPart;

    @Column(name = "activity_min_part")
    @PositiveOrZero(message = "請勿空白，且只能填寫整數！")
    private Integer activityMinPart;

    @Column(name = "enroll_total")
    @PositiveOrZero(message = "請勿空白，且只能填寫整數！")
    private Integer enrollTotal;

    @Column(name = "enroll_started")
//    @Column(name = "enroll_started", columnDefinition="datetime")
    @NotNull(message = "開始報名時間請勿空白！")
    private Timestamp enrollStarted;

    @Column(name = "enroll_end")
//    @Column(name = "enroll_end", columnDefinition="datetime")
    @NotNull(message = "結束報名時間請勿空白！")
    private Timestamp enrollEnd;

    @Column(name = "activity_session_state")
    private Integer activitySessionState;

    @Column(name = "activity_note")
    private String activityNote;

    public SessionVO(){
    }


    public Integer getActivitySessionId() {
        return activitySessionId;
    }

    public void setActivitySessionId(Integer activitySessionId) {
        this.activitySessionId = activitySessionId;
    }


    public String getActivityLocation() {
		return activityLocation;
	}


	public void setActivityLocation(String activityLocation) {
		this.activityLocation = activityLocation;
	}


	public Integer getActivityMaxPart() {
        return activityMaxPart;
    }

    public void setActivityMaxPart(Integer activityMaxPart) {
        this.activityMaxPart = activityMaxPart;
    }


    public Integer getActivityMinPart() {
        return activityMinPart;
    }

    public void setActivityMinPart(Integer activityMinPart) {
        this.activityMinPart = activityMinPart;
    }


    public Integer getEnrollTotal() {
        return enrollTotal;
    }

    public void setEnrollTotal(Integer enrollTotal) {
        this.enrollTotal = enrollTotal;
    }


    public Timestamp getEnrollStarted() {
        return enrollStarted;
    }

    public void setEnrollStarted(Timestamp enrollStarted) {
        this.enrollStarted = enrollStarted;
    }


    public Timestamp getEnrollEnd() {
        return enrollEnd;
    }

    public void setEnrollEnd(Timestamp enrollEnd) {
        this.enrollEnd = enrollEnd;
    }

    

    public ItemVO getItemVO() {
		return itemVO;
	}


	public void setItemVO(ItemVO itemVO) {
		this.itemVO = itemVO;
	}


	public Integer getActivitySessionState() {
        return activitySessionState;
    }

    public void setActivitySessionState(Integer activitySessionState) {
        this.activitySessionState = activitySessionState;
    }

    public String getActivityNote() {
        return activityNote;
    }

    public void setActivityNote(String activityNote) {
        this.activityNote = activityNote;
    }


	public Date getActivityDate() {
		return activityDate;
	}


	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}


	public Time_PeriodVO getTime_PeriodVO() {
		return time_PeriodVO;
	}


	public void setTime_PeriodVO(Time_PeriodVO time_PeriodVO) {
		this.time_PeriodVO = time_PeriodVO;
	}


	public Double getDuration() {
		return duration;
	}


	public void setDuration(Double duration) {
		this.duration = duration;
	}
    
    
    
}


