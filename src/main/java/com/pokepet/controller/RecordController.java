package com.pokepet.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pokepet.util.UUIDUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pokepet.annotation.ResponseResult;
import com.pokepet.model.UserLongRecord;
import com.pokepet.model.UserRecord;
import com.pokepet.service.IRecordService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Fade on 2018/9/11.
 */

@RestController
@RequestMapping("/record")
@ResponseResult
public class RecordController {

    @Autowired
    IRecordService recordService;


    @RequestMapping(value = "/longRecord/{userId}",method = RequestMethod.POST)
    public boolean  createPetRecord(@RequestBody JSONObject data, @PathVariable("userId")String userId){
        String recordId=data.getString("recordId");
        String petId=data.getString("petId");
        String title=data.getString("title");
        String content=data.getString("content");
        String abbreImgArr=data.getString("abbreImgArr");
        String type=data.getString("type");

        //处理缩略图片
        String abbreImg="";
        JSONArray abbreList=JSONArray.parseArray(abbreImgArr);
        if(abbreList.size()>3){
            List<Object> abbreSubList=abbreList.subList(0,3);
            abbreImg=JSONArray.toJSONString(abbreSubList);
        }else{
            abbreImg=JSONArray.toJSONString(abbreList);
        }
        UserLongRecord record=new UserLongRecord();
        if(StringUtils.isNotEmpty(recordId)){ //编辑已有故事
            record.setRecordId(recordId);
            record.setTitle(title);
            record.setContent(content);
            record.setAbbreImg(abbreImg);
            record.setUserId(userId);
            record.setPetId(petId);
            record.setCreateTime(new Date());
            record.setCheckState("1");
            record.setDelFlag("0");
            record.setType(type);
            recordService.updateLongRecord(record);
        }else{
            record.setRecordId(UUIDUtils.randomUUID());
            record.setTitle(title);
            record.setContent(content);
            record.setAbbreImg(abbreImg);
            record.setUserId(userId);
            record.setPetId(petId);
            record.setCreateTime(new Date());
            record.setCheckState("1");
            record.setDelFlag("0");
            record.setType(type);
            record.setRecommend("0");
            recordService.insertLongRecord(record);
        }

        return true;

    }

    /**
     * 上传短文
     * @param data
     * @param userId
     * @return
     */
    @RequestMapping(value = "/shortRecord/{userId}",method = RequestMethod.POST)
    public JSONObject  createUserRecord(@RequestBody JSONObject data, @PathVariable("userId")String userId){
        JSONObject resData=new JSONObject();
        String recordId=data.getString("recordId");
        String title=data.getString("title");
        String content=data.getString("content");
        String images=data.getString("images");
        String recommendState=data.getString("recommendState");
        String location=data.getString("location");
        String detailLocation=data.getString("detailLocation");
        String lat=data.getString("lat");
        String lng=data.getString("lng");
        String type=data.getString("type");
        String city=data.getString("city");
        String operateType="";

        UserRecord record=new UserRecord();
        if(StringUtils.isNotEmpty(recordId)){ //编辑已有故事
            operateType="update";
            record.setRecordId(recordId);
            record.setTitle(title);
            record.setContent(content);
            record.setImages(images);
            record.setUserId(userId);
            record.setCreateTime(new Date());
            record.setCheckState("1");
            record.setDelFlag("0");
            record.setRecommend(recommendState);
            record.setType(type);
            record.setLocation(location);
            record.setDetailLocation(detailLocation);
            record.setLat(lat);
            record.setLng(lng);
            record.setCity(city);
            recordService.updateRecord(record);
        }else{
            operateType="insert";
            recordId=UUIDUtils.randomUUID();
            record.setRecordId(recordId);
            record.setTitle(title);
            record.setContent(content);
            record.setImages(images);
            record.setUserId(userId);
            record.setCreateTime(new Date());
            record.setCheckState("1");
            record.setDelFlag("0");
            record.setRecommend(recommendState);
            record.setType(type);
            record.setLocation(location);
            record.setDetailLocation(detailLocation);
            record.setLat(lat);
            record.setLng(lng);
            record.setCity(city);
            recordService.insertRecord(record);
        }
        resData.put("recordId",recordId);
        resData.put("type",type);
        resData.put("operateType",operateType);
        resData.put("operateResult",true);
        resData.put("lat",lat);
        resData.put("lng",lng);
        resData.put("city",city);
        resData.put("content",content);
        return resData;
    }


    @RequestMapping(value = "/vanishRedisPoint",method = RequestMethod.POST)
    public boolean vanishRedisPoint(@RequestBody JSONObject data){
        String recordId=data.getString("recordId");
        boolean result=recordService.vanishRedisPoint(recordId);
        return result;
    }


    @RequestMapping(value = "/recommend",method = RequestMethod.GET)
    public List<Map<String,Object>> getRecommendList(HttpServletRequest request){

        int pageNum=request.getParameter("pageNum").equals(null)?0:Integer.parseInt(request.getParameter("pageNum"));
        int pageSize=request.getParameter("pageSize").equals(null)?0:Integer.parseInt(request.getParameter("pageSize"));
        String userId=request.getParameter("userId");
        List<Map<String,Object>> records=recordService.selectRecommendList(pageNum,pageSize,userId);
        for(Map<String, Object> recommendRecord:records){

            String type= (String) recommendRecord.get("type");
            String abbreImg=(String) recommendRecord.get("abbreImg");
            String images=(String) recommendRecord.get("images");
            switch (type){
                case "0": //故事长文截取文字内容

                    recommendRecord.put("abbreImg",JSON.parseArray(abbreImg));
                    recommendRecord.put("content",generateAbbreContent(recommendRecord));
                    break;
                case "1": //科普长文截取文字内容
                    recommendRecord.put("abbreImg",JSON.parseArray(abbreImg));
                    recommendRecord.put("content",generateAbbreContent(recommendRecord));
                    break;
                case "2": //短文截取文字内容
                    //页面显示逻辑
                    String content=recommendRecord.get("content").toString();
                    String abbrContent="";
                    String leftContent="";
                    boolean extend=false;
                    if(content.length()>40){
                        abbrContent= content.substring(0,40);
                        leftContent=content.substring(40);
                        extend=true;

                    }

                    recommendRecord.put("abbrContent",abbrContent);
                    recommendRecord.put("leftContent",leftContent);
                    recommendRecord.put("extend",extend);
                    recommendRecord.put("images",JSON.parseArray(images));
                    break;

            }

            SimpleDateFormat format=new SimpleDateFormat("MM-dd");
            recommendRecord.put("createtime",format.format(recommendRecord.get("createtime")));
        }

        return records;

    }




    @RequestMapping(value = "/charity",method = RequestMethod.GET)
    public List<Map<String,Object>> getCharityList(HttpServletRequest request){

        int pageNum=request.getParameter("pageNum").equals(null)?0:Integer.parseInt(request.getParameter("pageNum"));
        int pageSize=request.getParameter("pageSize").equals(null)?0:Integer.parseInt(request.getParameter("pageSize"));
        String city = request.getParameter("city");
        int dayLimit = null == request.getParameter("dayLimit") ? -1 : Integer.parseInt(request.getParameter("dayLimit"));
        String userId=request.getParameter("userId");

        List<Map<String,Object>> records=recordService.selectCharityList(pageNum,pageSize,userId,city,dayLimit);
        for(Map<String, Object> petRecord:records){

            String type= (String) petRecord.get("type");
            String images=(String) petRecord.get("images");
            switch (type){
                case "3":
                    petRecord.put("images",JSON.parseArray(images));
                    break;
            }

            SimpleDateFormat format=new SimpleDateFormat("MM-dd");
            petRecord.put("createtime",format.format(petRecord.get("createtime")));
        }

        return records;

    }




    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public List<Map<String,Object>> getUserRecord(@PathVariable("userId")String userId,HttpServletRequest request){

        int pageNum=request.getParameter("pageNum").equals(null)?0:Integer.parseInt(request.getParameter("pageNum"));
        int pageSize=request.getParameter("pageSize").equals(null)?0:Integer.parseInt(request.getParameter("pageSize"));

        List<Map<String,Object>> records=recordService.selectUserRecordList(userId,pageNum,pageSize);
        for(Map<String, Object> petRecord:records){

            String type= (String) petRecord.get("type");
            String abbreImg=(String) petRecord.get("abbreImg");
            String images=(String) petRecord.get("images");
            switch (type){
                case "0": //故事长文截取文字内容

                    petRecord.put("abbreImg",JSON.parseArray(abbreImg));
                    petRecord.put("content",generateAbbreContent(petRecord));
                    break;
                case "1": //科普长文截取文字内容
                    petRecord.put("abbreImg",JSON.parseArray(abbreImg));
                    petRecord.put("content",generateAbbreContent(petRecord));
                    break;
                case "2": //短文截取文字内容
                    String content=petRecord.get("content").toString();
                    if(content.length()>40){
                        content= content.substring(0,40)+"...";
                    }
                    petRecord.put("images",JSON.parseArray(images));
                    petRecord.put("content",content);
                    break;
                case "3":
                    petRecord.put("images",JSON.parseArray(images));
                    String content2=petRecord.get("content").toString();
                    if(content2.length()>40){
                        content2= content2.substring(0,40)+"...";
                    }
                    petRecord.put("content",content2);
                    break;
            }

            SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日");
            petRecord.put("createtime",format.format(petRecord.get("createtime")));
        }

        return records;

    }



    @RequestMapping(value = "/recordList/{userId}",method = RequestMethod.GET)
    public List<Map<String,Object>> getUserRecordList(@PathVariable("userId")String userId,HttpServletRequest request){

        int pageNum=request.getParameter("pageNum").equals(null)?0:Integer.parseInt(request.getParameter("pageNum"));
        int pageSize=request.getParameter("pageSize").equals(null)?0:Integer.parseInt(request.getParameter("pageSize"));
        List<Map<String,Object>> records=recordService.selectUserCheckedRecordList(userId,pageNum,pageSize);
        for(Map<String, Object> petRecord:records){

            String type= (String) petRecord.get("type");
            String abbreImg=(String) petRecord.get("abbreImg");
            String images=(String) petRecord.get("images");
            switch (type){
                case "0": //传记
                    petRecord.put("abbreImg",JSON.parseArray(abbreImg));
                    petRecord.put("content",generateAbbreContent(petRecord));
                    break;
                case "1": //科普
                    petRecord.put("abbreImg",JSON.parseArray(abbreImg));
                    petRecord.put("content",generateAbbreContent(petRecord));
                    break;
                case "2"://日记
                    String content=petRecord.get("content").toString();
                    if(content.length()>40){
                        content= content.substring(0,40)+"...";
                    }
                    petRecord.put("images",JSON.parseArray(images));
                    petRecord.put("content",content);
                    break;
            }

            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            petRecord.put("createtime",format.format(petRecord.get("createtime")));
        }

        return records;

    }



    private String generateAbbreContent(Map<String, Object> map){
        JSONArray contentItem= JSON.parseArray(String.valueOf(map.get("content")));
        String abbrContent="";
        for(Object jsonObject:contentItem){
            JSONObject item=JSON.parseObject(jsonObject.toString());
            if(item.getString("type").equals("0")){
                String content= String.valueOf(item.get("data"));
                if(content.length()>40){
                    abbrContent= content.substring(0,40)+"...";
                }else{
                    abbrContent=content;
                }
                break;
            }
        }
        return abbrContent;
    }

	/**
	 * 短文列表（分页）
	 * @param search	搜索"标题/昵称"
	 * @param checkStatus	审核 0：未审核 1：审核通过 2：审核失败
	 * @param recommend	推荐 0：公开 1：私有
	 * @param recordType	0：故事 1：科普 2:日记 3:紧急事件
	 * @param city	所在城市
	 * @param dayLimit	时间范围
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/recordList", method = RequestMethod.GET)
	public JSONObject getRecordList(HttpServletRequest request) {
		String search = request.getParameter("search");
		String checkStatus = request.getParameter("checkStatus");
		String recommend = request.getParameter("recommend");
		String recordType = request.getParameter("recordType");
		String city = request.getParameter("city");
		int dayLimit = null == request.getParameter("dayLimit") ? -1 : Integer.parseInt(request.getParameter("dayLimit"));
		int pageNum = null == request.getParameter("pageNum") ? -1 : Integer.parseInt(request.getParameter("pageNum"));
		int pageSize = null == request.getParameter("pageSize") ? -1 : Integer.parseInt(request.getParameter("pageSize"));
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("search", search);
		param.put("checkStatus", checkStatus);
		param.put("recommend", recommend);
		param.put("recordType", recordType);
		param.put("city", city);
		param.put("dayLimit", dayLimit);
		return recordService.getRecordList(param, pageNum, pageSize);
	}



    @RequestMapping(value = "/repo/{recordId}",method = RequestMethod.GET)
    public Map<String,Object> getRepoRecordDetail(@PathVariable("recordId")String recordId,HttpServletRequest request){

        String type=request.getParameter("type");
        String userId=request.getParameter("userId");
        Map<String,Object> recordDetail=new HashMap<>();

        switch (type){
            case "0": //故事长文
                recordDetail=recordService.selectLongRecordByRecordId(recordId,userId);
                break;
            case "1": //科普长文
                recordDetail=recordService.selectLongRecordByRecordId(recordId,userId);
                break;
            case "2": //短文截取文字内容
                recordDetail=recordService.selectRecordByRecordId(recordId,userId);
                break;
            case "3":
                recordDetail=recordService.selectRecordByRecordId(recordId,userId);
                break;
        }

        if(recordDetail!=null){
            SimpleDateFormat format=new SimpleDateFormat("yyy-MM-dd HH:mm");
            recordDetail.put("createtime",format.format(recordDetail.get("createtime")));
        }

        return recordDetail;

    }



    @RequestMapping(value = "/repo",method = RequestMethod.POST)
    public boolean uptRecord(HttpServletRequest request){
        boolean uptResult=false;
        String recordRq=request.getParameter("recordReq");
        JSONObject recordObj=JSON.parseObject(recordRq);
        String type=recordObj.getString("type");

        if(type.equals("0") || type.equals("1")){
            UserLongRecord userLongRecord=JSONObject.parseObject(recordRq,UserLongRecord.class);
            uptResult=recordService.updateLongRecord(userLongRecord)>0;
        }else{
            UserRecord userRecord=JSONObject.parseObject(recordRq,UserRecord.class);
            uptResult=recordService.updateRecord(userRecord)>0;
        }

        return uptResult;

    }


    @RequestMapping(value = "/petRecord/{petId}",method = RequestMethod.GET)
    public List<Map<String,Object>>  getPetRecord(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @PathVariable("petId")String petId){
        List<Map<String,Object>> records=recordService.getPetRecordList(pageNum,pageSize,petId);
        for(Map<String, Object> recommendRecord:records){
            String abbreImg=(String) recommendRecord.get("abbreImg");
            recommendRecord.put("abbreImg",JSON.parseArray(abbreImg));
            recommendRecord.put("content",generateAbbreContent(recommendRecord));
            SimpleDateFormat format=new SimpleDateFormat("MM-dd");
            recommendRecord.put("createtime",format.format(recommendRecord.get("createtime")));
        }

        return records;

    }


    @RequestMapping(value = "/collection/{userId}",method = RequestMethod.GET)
    public List<Map<String,Object>>  getCollectRecord(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @PathVariable("userId")String userId){
        List<Map<String,Object>> records=recordService.getCollectRecordList(pageNum,pageSize,userId);
        for(Map<String, Object> petRecord:records){

            String type= (String) petRecord.get("type");
            String abbreImg=(String) petRecord.get("abbreImg");
            String images=(String) petRecord.get("images");
            switch (type){
                case "0": //故事长文截取文字内容

                    petRecord.put("abbreImg",JSON.parseArray(abbreImg));
                    petRecord.put("content",generateAbbreContent(petRecord));
                    break;
                case "1": //科普长文截取文字内容
                    petRecord.put("abbreImg",JSON.parseArray(abbreImg));
                    petRecord.put("content",generateAbbreContent(petRecord));
                    break;
                case "2": //短文截取文字内容
                    String content=petRecord.get("content").toString();
                    if(content.length()>40){
                        content= content.substring(0,40)+"...";
                    }
                    petRecord.put("images",JSON.parseArray(images));
                    petRecord.put("content",content);
                    break;
                case "3":
                    petRecord.put("images",JSON.parseArray(images));
                    JSONObject content2=JSON.parseObject(petRecord.get("content").toString());
                    petRecord.put("content",content2.getString("detailInfo"));
                    break;
            }

            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            petRecord.put("createtime",format.format(petRecord.get("createtime")));
        }

        return records;

    }





    @RequestMapping(value = "/like",method = RequestMethod.POST)
    public boolean recordLike(HttpServletRequest request){
        String userId=request.getParameter("userId");
        String recordId=request.getParameter("recordId");
        String recordType=request.getParameter("recordType");
        boolean flag=recordService.updateRecordLike(userId,recordId,recordType);
        return flag;
    }


    @RequestMapping(value = "/collect",method = RequestMethod.POST)
    public boolean recordCollect(HttpServletRequest request){
        String userId=request.getParameter("userId");
        String recordId=request.getParameter("recordId");
        boolean flag=recordService.updateRecordCollect(userId,recordId);
        return flag;

    }




    @RequestMapping(value = "/share",method = RequestMethod.POST)
    public boolean recordShare(HttpServletRequest request){
        String userId=request.getParameter("userId");
        String recordId=request.getParameter("recordId");
        String recordType=request.getParameter("recordType");

        boolean flag=recordService.insertRecordShare(userId,recordId,recordType);
        return flag;

    }




    @RequestMapping(value = "/visit",method = RequestMethod.POST)
    public boolean recordVisit(HttpServletRequest request){
        String userId=request.getParameter("userId");
        String recordId=request.getParameter("recordId");
        String recordType=request.getParameter("recordType");

        boolean flag=recordService.insertRecordVisit(userId,recordId,recordType);
        return flag;

    }

	/**
	 * 长文列表（分页）
	 * @param search	搜索"标题/昵称"
	 * @param checkStatus	审核 0：未审核 1：审核通过 2：审核失败
	 * @param recordType	文章类型 0: 宠物故事 1：科普 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/longRecordList", method = RequestMethod.GET)
	public JSONObject getLongRecordList(HttpServletRequest request) {
		String search = request.getParameter("search");
		String checkStatus = request.getParameter("checkStatus");
		String recordType = request.getParameter("recordType");
		int pageNum = null == request.getParameter("pageNum") ? -1 : Integer.parseInt(request.getParameter("pageNum"));
		int pageSize = null == request.getParameter("pageSize") ? -1 : Integer.parseInt(request.getParameter("pageSize"));
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("search", search);
		param.put("checkStatus", checkStatus);
		param.put("recordType", recordType);
		return recordService.getLongRecordList(param, pageNum, pageSize);
	}
	
	/**
	 * 获取长文详情
	 * @param recordId 长文id
	 * @return
	 */
	@RequestMapping(value = "/longRecord", method = RequestMethod.GET)
	public JSONObject getLongRecord(@RequestParam("recordId") String recordId) {
		return JSONObject.parseObject(JSONObject.toJSONString(recordService.getLongRecord(recordId)));
	}
	/**
	 * 审核长文
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/chkLongRecord", method = RequestMethod.POST)
	public boolean chkLongRecord(@RequestBody JSONObject data) {
		UserLongRecord record = JSONObject.toJavaObject(data, UserLongRecord.class);
		record.setCheckDatetime(new Date());//设置审核时间
		return recordService.uptLongRecord(record);
	}
	
	/**
	 * 获取短文详情
	 * @param recordId 短文id
	 * @return
	 */
	@RequestMapping(value = "/shortRecord", method = RequestMethod.GET)
	public JSONObject getShortRecord(@RequestParam("recordId") String recordId) {
		return JSONObject.parseObject(JSONObject.toJSONString(recordService.getShortRecord(recordId)));
	}
	/**
	 * 审核短文
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/chkShortRecord", method = RequestMethod.POST)
	public boolean chkShortRecord(@RequestBody JSONObject data) {
		UserRecord record = JSONObject.toJavaObject(data, UserRecord.class);
		record.setCheckDatetime(new Date());//设置审核时间
		return recordService.uptShortRecord(record);
	}


}
