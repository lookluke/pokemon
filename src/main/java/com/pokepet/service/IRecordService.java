package com.pokepet.service;

import com.pokepet.model.UserLongRecord;
import com.pokepet.model.UserRecord;

import java.util.List;
import java.util.Map;

/**
 * Created by Fade on 2018/9/19.
 */
public interface IRecordService {


    int updateLongRecord(UserLongRecord longRecord);

    int insertLongRecord(UserLongRecord longRecord);

    int updateRecord(UserRecord userRecord);

    int insertRecord(UserRecord userRecord);


    List<Map<String,Object>> selectUserRecordList(String userId,int pageNum,int pageSize);


    List<Map<String,Object>> selectRecommendList(int pageNum,int pageSize);

    List<Map<String,Object>> selectCharityList(int pageNum,int pageSize);
}
