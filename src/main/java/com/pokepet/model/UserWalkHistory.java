package com.pokepet.model;

import java.math.BigDecimal;
import java.util.Date;

public class UserWalkHistory {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_walk_history.history_id
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	private String historyId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_walk_history.user_id
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	private String userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_walk_history.pet_id
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	private String petId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_walk_history.start_time
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	private Date startTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_walk_history.finish_time
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	private Date finishTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_walk_history.distance
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	private Integer distance;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_walk_history.exp
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	private Integer exp;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_walk_history.vitality
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	private Integer vitality;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_walk_history.del_flag
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	private String delFlag;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_walk_history.history_id
	 * @return  the value of user_walk_history.history_id
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public String getHistoryId() {
		return historyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_walk_history.history_id
	 * @param historyId  the value for user_walk_history.history_id
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_walk_history.user_id
	 * @return  the value of user_walk_history.user_id
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_walk_history.user_id
	 * @param userId  the value for user_walk_history.user_id
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_walk_history.pet_id
	 * @return  the value of user_walk_history.pet_id
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public String getPetId() {
		return petId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_walk_history.pet_id
	 * @param petId  the value for user_walk_history.pet_id
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public void setPetId(String petId) {
		this.petId = petId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_walk_history.start_time
	 * @return  the value of user_walk_history.start_time
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_walk_history.start_time
	 * @param startTime  the value for user_walk_history.start_time
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_walk_history.finish_time
	 * @return  the value of user_walk_history.finish_time
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public Date getFinishTime() {
		return finishTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_walk_history.finish_time
	 * @param finishTime  the value for user_walk_history.finish_time
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_walk_history.distance
	 * @return  the value of user_walk_history.distance
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public Integer getDistance() {
		return distance;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_walk_history.distance
	 * @param distance  the value for user_walk_history.distance
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_walk_history.exp
	 * @return  the value of user_walk_history.exp
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public Integer getExp() {
		return exp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_walk_history.exp
	 * @param exp  the value for user_walk_history.exp
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public void setExp(Integer exp) {
		this.exp = exp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_walk_history.vitality
	 * @return  the value of user_walk_history.vitality
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public Integer getVitality() {
		return vitality;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_walk_history.vitality
	 * @param vitality  the value for user_walk_history.vitality
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public void setVitality(Integer vitality) {
		this.vitality = vitality;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_walk_history.del_flag
	 * @return  the value of user_walk_history.del_flag
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public String getDelFlag() {
		return delFlag;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_walk_history.del_flag
	 * @param delFlag  the value for user_walk_history.del_flag
	 * @mbggenerated  Tue Jun 05 16:24:38 CST 2018
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}