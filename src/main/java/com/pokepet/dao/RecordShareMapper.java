package com.pokepet.dao;

import com.pokepet.model.RecordShare;

public interface RecordShareMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record_share
     *
     * @mbggenerated Wed Nov 14 10:39:53 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record_share
     *
     * @mbggenerated Wed Nov 14 10:39:53 CST 2018
     */
    int insert(RecordShare record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record_share
     *
     * @mbggenerated Wed Nov 14 10:39:53 CST 2018
     */
    int insertSelective(RecordShare record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record_share
     *
     * @mbggenerated Wed Nov 14 10:39:53 CST 2018
     */
    RecordShare selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record_share
     *
     * @mbggenerated Wed Nov 14 10:39:53 CST 2018
     */
    int updateByPrimaryKeySelective(RecordShare record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record_share
     *
     * @mbggenerated Wed Nov 14 10:39:53 CST 2018
     */
    int updateByPrimaryKey(RecordShare record);
}