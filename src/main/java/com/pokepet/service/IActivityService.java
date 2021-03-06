package com.pokepet.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.pokepet.model.ActActivity;
import com.pokepet.model.ActActivityRegister;
import com.pokepet.model.ActActivityVote;

public interface IActivityService {

	/**
	 * 获取活动列表
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	JSONObject getActivityList(int pageNum, int pageSize);

	JSONObject getRealActivityList(int pageNum, int pageSize);

	/**
	 * 获取活动详情
	 * 
	 * @param id
	 * @return
	 */
	ActActivity getActivity(String id);


	/**
	 * 获取活动统计数据
	 * @param id
	 * @return
     */
	Map<String,Object> getActivityStatistics(String id);

	/**
	 * 保存活动信息
	 * 
	 * @param act
	 * @return
	 */
	boolean saveActivity(ActActivity act);

	/**
	 * 获取活动参与者列表
	 * 
	 * @param userId
	 * @param search
	 * @param activityId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	JSONObject getActivityRegisterList(String userId, String search, String activityId, int pageNum, int pageSize);

	/**
	 * 获取参赛者信息
	 * 
	 * @param registerId
	 * @return
	 */
	Map<String, Object> getActivityRegister(String registerId, String userId);

	/**
	 * 保存参赛者信息
	 * 
	 * @param register
	 * @return
	 */
	boolean saveActivityRegister(ActActivityRegister register);

	/**
	 * 保存投票信息
	 * 
	 * @param vote
	 * @return
	 */
	boolean saveVote(ActActivityVote vote);

//	boolean chkVoteStatus(String voterId, String registerId);

	/**
	 * 检验用户有无参加活动
	 * 
	 * @param activityId
	 * @param userId
	 * @return
	 */
	ActActivityRegister getRegisterByActivityIdAndUserId(String activityId, String userId);

	/**
	 * 获取参赛者排名
	 * 
	 * @param activityId
	 * @param registerId
	 * @return
	 */
	int getRegisterRanking(String activityId, String registerId);

	/**
	 * 获取用户对该次活动今日已投票数量
	 * @param activityId
	 * @param userId
	 * @param strDate
	 * @return
	 */
	int getVoteCountByActivityIdAndUserIdAndDate(String activityId, String userId, String strDate);


	boolean countVisitorForAct(String activityId,String userId);

}
