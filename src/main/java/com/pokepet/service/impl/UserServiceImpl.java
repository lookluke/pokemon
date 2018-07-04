package com.pokepet.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokepet.dao.UserMapper;
import com.pokepet.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	private static int userIdGrenc = -1;

	private static int year = -1;

	private final static String USER_ID_TEMP = "hu-03+区号+年份（后两位）+00001";

	@Autowired
	private UserMapper userMapper;

	@Override
	public String createUserId(String areaId) {
		Calendar cal = Calendar.getInstance();

		if (cal.get(Calendar.YEAR) != year) {
			year = cal.get(Calendar.YEAR);
			String maxId = userMapper.getMaxUserNo(USER_ID_TEMP.substring(0, 3), (year+"").substring(2));
			userIdGrenc = null == maxId ? 1 : Integer.parseInt(maxId)+1;
			return createUserId(areaId);
		} else {
			String userIdEnd = "000000" + userIdGrenc++;
			return "hu-03" + areaId + ("" + year).substring(2, 4)
					+ userIdEnd.substring(userIdEnd.length() - 6, userIdEnd.length());
		}

	}

}