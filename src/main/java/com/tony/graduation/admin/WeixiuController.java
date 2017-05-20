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
import com.tony.graduation.entity.Weixiu;
import com.tony.graduation.service.WeixiuService;
import com.tony.graduation.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/weixiu")
public class WeixiuController {
	
	@Resource
	private WeixiuService weixiuService;
	private static final Logger log = Logger.getLogger(WeixiuController.class);
	
	@RequestMapping("/weixiuing")
	public String findPark(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Weixiu weixiu, HttpServletResponse response) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
		List<Weixiu> weixiuList = weixiuService.findWeixiu();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(weixiuList);

        result.put("rows", jsonArray);
        ResponseUtil.write(response, result);
        log.info("request: store/list , map: " + map.toString());
		return null;
	}
	
	@RequestMapping("/unweixiu")
	public String findUnPark(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Weixiu weixiu, HttpServletResponse response) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
		List<Weixiu> weixiuList = weixiuService.findUnWeixiu();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(weixiuList);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, result);
        log.info("request: store/list , map: " + map.toString());
		return null;
	}
	
	@RequestMapping("/allweixiu")
	public String findAllPark(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Weixiu weixiu, HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
		List<Weixiu> weixiuList = weixiuService.findAll();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(weixiuList);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, result);
        log.info("request: store/list , map: " + map.toString());
		return null;
	}
	
	@RequestMapping("/deleteweixiu")
	public String deletePark(@RequestParam(value = "id") String id, Weixiu weixiu, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        weixiu.setId(id);
        resultTotal = weixiuService.deleteweixiu(weixiu);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + weixiu.toString());
        return null;
	}
	
	@RequestMapping("/addweixiu")
	public String addPark(Weixiu weixiu, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        weixiu.setStatus("0");
        resultTotal = weixiuService.insertweixiu(weixiu);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + weixiu.toString());
        return null;
	}
	
	@RequestMapping("/updateweixiu")
	public String updatePark(@RequestParam(value = "id") String id, Weixiu weixiu, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        weixiu.setId(id);
        weixiu.setStatus("1");
        
        resultTotal = weixiuService.updateweixiu(weixiu);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + weixiu.toString());
        return null;
	}
}
