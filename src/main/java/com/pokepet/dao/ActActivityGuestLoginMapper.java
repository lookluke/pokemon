package com.pokepet.dao;

import com.pokepet.model.ActActivityGuestLogin;

public interface ActActivityGuestLoginMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity_guest_login
     *
     * @mbggenerated Tue Nov 13 21:54:39 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity_guest_login
     *
     * @mbggenerated Tue Nov 13 21:54:39 CST 2018
     */
    int insert(ActActivityGuestLogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity_guest_login
     *
     * @mbggenerated Tue Nov 13 21:54:39 CST 2018
     */
    int insertSelective(ActActivityGuestLogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity_guest_login
     *
     * @mbggenerated Tue Nov 13 21:54:39 CST 2018
     */
    ActActivityGuestLogin selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity_guest_login
     *
     * @mbggenerated Tue Nov 13 21:54:39 CST 2018
     */
    int updateByPrimaryKeySelective(ActActivityGuestLogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_activity_guest_login
     *
     * @mbggenerated Tue Nov 13 21:54:39 CST 2018
     */
    int updateByPrimaryKey(ActActivityGuestLogin record);
}