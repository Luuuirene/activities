package com.session_time_period.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



import com.activities_session.model.SessionVO;

@Entity
@Table(name = "session_time_period")
public class Time_PeriodVO implements Serializable{

	
	private static final long serialVersionUID = 3110286673838412074L;
	
	@Id
	@Column(name = "session_time_period_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sessionTimePeriodId;
	
	@Column(name = "time_period1")
	@NotNull(message = "請至少輸入一個時段！")
	private Time timePeriod1;
	
	@Column(name = "time_period2")
	private Time timePeriod2;
	
	@Column(name = "time_period3")
	private Time timePeriod3;
	
	@Column(name = "time_period4")
	private Time timePeriod4;
	
	@OneToMany(mappedBy = "time_PeriodVO", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<SessionVO> sessionVOs;
	
	public Time_PeriodVO() {
		
	}

	public Integer getSessionTimePeriodId() {
		return sessionTimePeriodId;
	}

	public void setSessionTimePeriodId(Integer sessionTimePeriodId) {
		this.sessionTimePeriodId = sessionTimePeriodId;
	}

	public Time getTimePeriod1() {
		return timePeriod1;
	}

	public void setTimePeriod1(Time timePeriod1) {
		this.timePeriod1 = timePeriod1;
	}

	public Time getTimePeriod2() {
		return timePeriod2;
	}

	public void setTimePeriod2(Time timePeriod2) {
		this.timePeriod2 = timePeriod2;
	}

	public Time getTimePeriod3() {
		return timePeriod3;
	}

	public void setTimePeriod3(Time timePeriod3) {
		this.timePeriod3 = timePeriod3;
	}

	public Time getTimePeriod4() {
		return timePeriod4;
	}

	public void setTimePeriod4(Time timePeriod4) {
		this.timePeriod4 = timePeriod4;
	}

	public Set<SessionVO> getSessionVOs() {
		return sessionVOs;
	}

	public void setSessionVOs(Set<SessionVO> sessionVOs) {
		this.sessionVOs = sessionVOs;
	}
	
	

}
