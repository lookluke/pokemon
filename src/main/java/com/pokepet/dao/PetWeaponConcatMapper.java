package com.pokepet.dao;

import java.util.List;
import java.util.Map;

import com.pokepet.model.PetWeaponConcat;

public interface PetWeaponConcatMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pet_weapon_concat
	 * @mbggenerated  Tue Aug 07 13:22:20 GMT+08:00 2018
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pet_weapon_concat
	 * @mbggenerated  Tue Aug 07 13:22:20 GMT+08:00 2018
	 */
	int insert(PetWeaponConcat record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pet_weapon_concat
	 * @mbggenerated  Tue Aug 07 13:22:20 GMT+08:00 2018
	 */
	int insertSelective(PetWeaponConcat record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pet_weapon_concat
	 * @mbggenerated  Tue Aug 07 13:22:20 GMT+08:00 2018
	 */
	PetWeaponConcat selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pet_weapon_concat
	 * @mbggenerated  Tue Aug 07 13:22:20 GMT+08:00 2018
	 */
	int updateByPrimaryKeySelective(PetWeaponConcat record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pet_weapon_concat
	 * @mbggenerated  Tue Aug 07 13:22:20 GMT+08:00 2018
	 */
	int updateByPrimaryKey(PetWeaponConcat record);

	/**
	 * 根据petID获取装备栏装备信息
	 * @param petId
	 * @return
	 */
	List<Map<String, Object>> getWeaponByPetId(String petId);
	
	/**
	 * 根据userId获取用户装备信息
	 * @param userId
	 * @return
	 */
	List<Map<String, Object>> getWeaponByUserId(String userId);
}