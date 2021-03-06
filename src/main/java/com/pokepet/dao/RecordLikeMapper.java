package com.pokepet.dao;

import com.pokepet.model.RecordLike;
import org.apache.ibatis.annotations.Param;

public interface RecordLikeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record_like
     *
     * @mbggenerated Mon Sep 24 00:24:31 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record_like
     *
     * @mbggenerated Mon Sep 24 00:24:31 CST 2018
     */
    int insert(RecordLike record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record_like
     *
     * @mbggenerated Mon Sep 24 00:24:31 CST 2018
     */
    int insertSelective(RecordLike record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record_like
     *
     * @mbggenerated Mon Sep 24 00:24:31 CST 2018
     */
    RecordLike selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record_like
     *
     * @mbggenerated Mon Sep 24 00:24:31 CST 2018
     */
    int updateByPrimaryKeySelective(RecordLike record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table record_like
     *
     * @mbggenerated Mon Sep 24 00:24:31 CST 2018
     */
    int updateByPrimaryKey(RecordLike record);

    RecordLike selectByUserIdAndRecordId(@Param("userId") String userId, @Param("recordId") String recordId);

}