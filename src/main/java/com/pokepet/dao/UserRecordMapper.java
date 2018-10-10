package com.pokepet.dao;

import java.util.List;
import java.util.Map;

import com.pokepet.model.UserRecord;

public interface UserRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbggenerated Thu Sep 20 14:08:43 GMT+08:00 2018
     */
    int deleteByPrimaryKey(String recordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbggenerated Thu Sep 20 14:08:43 GMT+08:00 2018
     */
    int insert(UserRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbggenerated Thu Sep 20 14:08:43 GMT+08:00 2018
     */
    int insertSelective(UserRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbggenerated Thu Sep 20 14:08:43 GMT+08:00 2018
     */
    UserRecord selectByPrimaryKey(String recordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbggenerated Thu Sep 20 14:08:43 GMT+08:00 2018
     */
    int updateByPrimaryKeySelective(UserRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_record
     *
     * @mbggenerated Thu Sep 20 14:08:43 GMT+08:00 2018
     */
    int updateByPrimaryKey(UserRecord record);


    List<Map<String, Object>> selectRecordList(Map<String,Object> map);
}