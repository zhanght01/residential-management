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
import com.tony.graduation.entity.Tousu;
import com.tony.graduation.service.TousuService;
import com.tony.graduation.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/tousu")
public class TousuController {
	
	@Resource
	private TousuService tousuService;
	private static final Logger log = Logger.getLogger(TousuController.class);
	
	@RequestMapping("/tousuing")
	public String findPark(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Tousu tousu, HttpServletResponse response) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
		List<Tousu> tousuList = tousuService.findTousu();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(tousuList);

        result.put("rows", jsonArray);
        ResponseUtil.write(response, result);
        log.info("request: store/list , map: " + map.toString());
		return null;
	}
	
	@RequestMapping("/untousu")
	public String findUnPark(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Tousu tousu, HttpServletResponse response) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
		List<Tousu> tousuList = tousuService.findUnTousu();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(tousuList);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, result);
        log.info("request: store/list , map: " + map.toString());
		return null;
	}
	
	@RequestMapping("/alltousu")
	public String findAllPark(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Tousu tousu, HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
		List<Tousu> tousuList = tousuService.findAll();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(tousuList);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, result);
        log.info("request: store/list , map: " + map.toString());
		return null;
	}
	
	@RequestMapping("/deletetousu")
	public String deletePark(@RequestParam(value = "id") String id, Tousu tousu, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        tousu.setId(id);
        resultTotal = tousuService.deletetousu(tousu);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + tousu.toString());
        return null;
	}
	
	@RequestMapping("/addtousu")
	public String addPark(Tousu tousu, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        tousu.setStatus("0");
        resultTotal = tousuService.inserttousu(tousu);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + tousu.toString());
        return null;
	}
	
	@RequestMapping("/updatetousu")
	public String updatePark(@RequestParam(value = "id") String id, Tousu tousu, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        tousu.setId(id);
        tousu.setStatus("1");
        
        resultTotal = tousuService.updatetousu(tousu);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + tousu.toString());
        return null;
	}
}
