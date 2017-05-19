package com.tony.graduation.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tony.graduation.entity.Fangke;
import com.tony.graduation.entity.PageBean;
import com.tony.graduation.entity.Yezhu;
import com.tony.graduation.service.FangkeService;
import com.tony.graduation.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/fangke")
public class FangkeController {

	@Resource
	private FangkeService fangkeService;
	public static final Logger log = Logger.getLogger(FangkeController.class);
	
	@RequestMapping("/finish")
	public String findFinish(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Yezhu yezhu, HttpServletResponse response) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
		List<Fangke> fangkeList = fangkeService.findFinish();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(fangkeList);

        result.put("rows", jsonArray);
//        result.put("total", total);
        ResponseUtil.write(response, result);
        log.info("request: store/list , map: " + map.toString());
		return null;
	}
	
	@RequestMapping("/unfinish")
	public String findUnFinish(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Yezhu yezhu, HttpServletResponse response) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
		List<Fangke> fangkeList = fangkeService.findUnFinish();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(fangkeList);
        result.put("rows", jsonArray);
//        result.put("total", total);
        ResponseUtil.write(response, result);
        log.info("request: store/list , map: " + map.toString());
		return null;
	}
	
	@RequestMapping("/deletefangke")
	public String deleteFangke(@RequestParam(value = "id") String user_id, Fangke fangke, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        fangke.setUser_id(user_id);
        resultTotal = fangkeService.deleteFangke(fangke);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + fangke.toString());
        return null;
	}
	
	@RequestMapping("/addfangke")
	public String addFangke(Fangke fangke, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        fangke.setStatus("1");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fangke.setBegin(sdf.format(new Date()));
        resultTotal = fangkeService.insertFangke(fangke);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + fangke.toString());
        return null;
	}
	
	@RequestMapping("/updatefangke")
	public String updateFangke(@RequestParam(value = "id") String user_id, Fangke fangke, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        fangke.setUser_id(user_id);
        fangke.setStatus("0");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fangke.setEnd(sdf.format(new Date()));
        resultTotal = fangkeService.updateFangke(fangke);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + fangke.toString());
        return null;
	}
}
