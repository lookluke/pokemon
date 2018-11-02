package com.pokepet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pokepet.model.Pet;

public interface PetMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pet
	 * @mbggenerated  Sat Jul 07 16:34:44 GMT+08:00 2018
	 */
	int deleteByPrimaryKey(String petId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pet
	 * @mbggenerated  Sat Jul 07 16:34:44 GMT+08:00 2018
	 */
	int insert(Pet record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pet
	 * @mbggenerated  Sat Jul 07 16:34:44 GMT+08:00 2018
	 */
	int insertSelective(Pet record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pet
	 * @mbggenerated  Sat Jul 07 16:34:44 GMT+08:00 2018
	 */
	Pet selectByPrimaryKey(String petId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pet
	 * @mbggenerated  Sat Jul 07 16:34:44 GMT+08:00 2018
	 */
	int updateByPrimaryKeySelective(Pet record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table pet
	 * @mbggenerated  Sat Jul 07 16:34:44 GMT+08:00 2018
	 */
	int updateByPrimaryKey(Pet record);

	List<Pet> getPetListByUserId(String userId);

	String getMaxPetNo(@Param("petIdStart") String petIdStart,@Param("year") String year);

	int updatePetsEnergyToOneHundredPercent();

	int countAllPets();

}