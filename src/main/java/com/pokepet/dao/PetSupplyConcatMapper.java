package com.pokepet.dao;

import com.pokepet.model.PetSupplyConcat;

public interface PetSupplyConcatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pet_supply_concat
     *
     * @mbggenerated Tue Aug 07 15:31:28 GMT+08:00 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pet_supply_concat
     *
     * @mbggenerated Tue Aug 07 15:31:28 GMT+08:00 2018
     */
    int insert(PetSupplyConcat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pet_supply_concat
     *
     * @mbggenerated Tue Aug 07 15:31:28 GMT+08:00 2018
     */
    int insertSelective(PetSupplyConcat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pet_supply_concat
     *
     * @mbggenerated Tue Aug 07 15:31:28 GMT+08:00 2018
     */
    PetSupplyConcat selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pet_supply_concat
     *
     * @mbggenerated Tue Aug 07 15:31:28 GMT+08:00 2018
     */
    int updateByPrimaryKeySelective(PetSupplyConcat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pet_supply_concat
     *
     * @mbggenerated Tue Aug 07 15:31:28 GMT+08:00 2018
     */
    int updateByPrimaryKey(PetSupplyConcat record);
}