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
import com.tony.graduation.entity.Park;
import com.tony.graduation.service.ParkService;
import com.tony.graduation.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/park")
public class ParkController {
	
	@Resource
	private ParkService parkService;
	private static final Logger log = Logger.getLogger(ParkController.class);
	
	@RequestMapping("/parking")
	public String findPark(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Park park, HttpServletResponse response) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
		List<Park> parkList = parkService.findPark();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(parkList);

        result.put("rows", jsonArray);
        ResponseUtil.write(response, result);
        log.info("request: store/list , map: " + map.toString());
		return null;
	}
	/**
	 * 空闲车位
	 * @param page
	 * @param rows
	 * @param park
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/unpark")
	public String findUnPark(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Park park, HttpServletResponse response) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
		List<Park> parkList = parkService.findUnPark();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(parkList);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, result);
        log.info("request: store/list , map: " + map.toString());
		return null;
	}
	
	@RequestMapping("/allpark")
	public String findAllPark(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Park park, HttpServletResponse response) throws Exception {
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
		List<Park> parkList = parkService.findAllPark();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(parkList);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, result);
        log.info("request: store/list , map: " + map.toString());
		return null;
	}
	
	@RequestMapping("/deletepark")
	public String deletePark(@RequestParam(value = "id") String id, Park park, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        park.setId(id);
        resultTotal = parkService.deletePark(park);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + park.toString());
        return null;
	}
	
	@RequestMapping("/addpark")
	public String addPark(Park park, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        if (park.getSuoyouren() == null || park.getSuoyouren().equals("")) {			
        	park.setState("0");
		} else {
			park.setState("1");
		}
        resultTotal = parkService.insertPark(park);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + park.toString());
        return null;
	}
	
	@RequestMapping("/updatepark")
	public String updatePark(@RequestParam(value = "id") String id, Park park, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        park.setId(id);
        if (park.getState().equals("0")) {			
        	park.setState("1");
		} else {
			park.setState("0");
			park.setSuoyouren("");
		}
        resultTotal = parkService.updatePark(park);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + park.toString());
        return null;
	}
}
