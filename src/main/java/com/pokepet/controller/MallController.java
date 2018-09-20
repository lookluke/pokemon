package com.pokepet.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.pokepet.annotation.ResponseResult;
import com.pokepet.model.Commodity;
import com.pokepet.model.PetSupply;
import com.pokepet.model.PetWeapon;
import com.pokepet.service.ICommodityService;
import com.pokepet.service.IPetSupplyService;
import com.pokepet.service.IPetWeaponService;

@ResponseResult
@RestController
@RequestMapping("/mall")
public class MallController {

	@Autowired
	IPetWeaponService petWeaponService;

	@Autowired
	IPetSupplyService petSupplyService;

	@Autowired
	ICommodityService commodityService;

	/**
	 * 装备列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/weaponList", method = RequestMethod.GET)
	public List<PetWeapon> getWeaponList() {
		return petWeaponService.getWeaponList();
	}

	/**
	 * 补给列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/supplyList", method = RequestMethod.GET)
	public List<PetSupply> getSupplyList() {
		return petSupplyService.getSupplyList();
	}

	/**
	 * 购买装备
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/buyWeapon", method = RequestMethod.POST, consumes = "application/json")
	public JSONObject buyWeapon(@RequestBody JSONObject data) {
		String userId = data.getString("userId");
		String weaponId = data.getString("weaponId");
		String payWay = data.getString("payWay");
		return petWeaponService.buyWeapon(userId, weaponId, payWay, data);
	}

	/**
	 * 购买补给
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/buySupply", method = RequestMethod.POST, consumes = "application/json")
	public JSONObject buySupply(@RequestBody JSONObject data) {
		String userId = data.getString("userId");
		String supplyId = data.getString("supplyId");
		String payWay = data.getString("payWay");
		return petWeaponService.buySupply(userId, supplyId, payWay, data);
	}

	/**
	 * 商品列表（分页）
	 * 
	 * @param search
	 * @param typeList
	 * @param brandList
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/commodityList", method = RequestMethod.GET)
	public List<Commodity> geCommodityList(@RequestParam("search") String search,
			@RequestParam("typeList") String typeList, @RequestParam("brandList") String brandList,
			@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
		String[] typeArr = typeList.split("");

		List<String> list = Arrays.asList(typeArr);
		return commodityService.getCommodityList(search, null, null, pageNum, pageSize);
	}

	/**
	 * 获取商品
	 * 
	 * @param commodityId
	 * @return
	 */
	@RequestMapping(value = "/commodity", method = RequestMethod.GET)
	public Commodity geCommodity(@RequestParam("commodityId") String commodityId) {
		return null;
	}

}
