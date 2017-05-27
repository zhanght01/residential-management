package com.tony.graduation.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tony.graduation.entity.PageBean;
import com.tony.graduation.entity.Shuifei;
import com.tony.graduation.service.ShuifeiService;
import com.tony.graduation.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/shuifei")
public class ShuifeiController {
	@Resource
	private ShuifeiService shuifeiService;
	private static final Logger log = Logger.getLogger(ShuifeiController.class);

	@RequestMapping("/shuifeilist")
	public String zichanList(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Shuifei shuifei, HttpServletResponse response) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
		List<Shuifei> shuifeiList = shuifeiService.findAll();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(shuifeiList);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, result);
        log.info("request: store/list , map: " + map.toString());
		return null;
	}
	
	@RequestMapping("/addshuifei")
	public String addZichan(Shuifei shuifei, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        shuifei.setState("0");
        resultTotal = shuifeiService.insertshuifei(shuifei);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + shuifei.toString());
        return null;
	}
	
	@RequestMapping("/updateshuifei")
	public String updateList(@RequestParam(value = "id") String id, Shuifei shuifei, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        shuifei.setId(id);
        shuifei.setState("0");
        resultTotal = shuifeiService.updateshuifei(shuifei);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + shuifei.toString());
        return null;
	}
	
	@RequestMapping("/deleteshuifei")
	public String deleteList(@RequestParam(value = "id") String id, Shuifei shuifei, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        shuifei.setId(id);
        resultTotal = shuifeiService.deleteshuifei(shuifei);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + shuifei.toString());
        return null;
	}
}
