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
import com.tony.graduation.entity.Wuyefei;
import com.tony.graduation.service.WuyefeiService;
import com.tony.graduation.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/wuyefei")
public class WuyefeiController {
	
	@Resource
	private WuyefeiService wuyefeiService;
	private static final Logger log = Logger.getLogger(WuyefeiController.class);

	@RequestMapping("/wuyefeilist")
	public String wuyefeiList(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Wuyefei wuyefei, HttpServletResponse response) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
		List<Wuyefei> wuyefeiList = wuyefeiService.findAll();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(wuyefeiList);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, result);
        log.info("request: store/list , map: " + map.toString());
		return null;
	}
	
	@RequestMapping("/addwuyefei")
	public String addZichan(Wuyefei wuyefei, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        wuyefei.setState("0");
        resultTotal = wuyefeiService.insertwuyefei(wuyefei);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + wuyefei.toString());
        return null;
	}
	
	@RequestMapping("/updatewuyefei")
	public String updateList(@RequestParam(value = "id") String id, Wuyefei wuyefei, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        wuyefei.setId(id);
        wuyefei.setState("0");
        resultTotal = wuyefeiService.updatewuyefei(wuyefei);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + wuyefei.toString());
        return null;
	}
	
	@RequestMapping("/deletewuyefei")
	public String deleteList(@RequestParam(value = "id") String id, Wuyefei wuyefei, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        wuyefei.setId(id);
        resultTotal = wuyefeiService.deletewuyefei(wuyefei);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + wuyefei.toString());
        return null;
	}
}
