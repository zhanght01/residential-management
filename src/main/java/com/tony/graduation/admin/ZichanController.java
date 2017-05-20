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
import com.tony.graduation.entity.Zichan;
import com.tony.graduation.service.ZichanService;
import com.tony.graduation.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/zichan")
public class ZichanController {

	@Resource
	private ZichanService zichanService;
	private static final Logger log = Logger.getLogger(ZichanController.class);

	@RequestMapping("/zichanlist")
	public String zichanList(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Zichan zichan, HttpServletResponse response) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
		List<Zichan> zichanList = zichanService.findAll();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(zichanList);
        result.put("rows", jsonArray);
        ResponseUtil.write(response, result);
        log.info("request: store/list , map: " + map.toString());
		return null;
	}
	
	@RequestMapping("/addzichan")
	public String addZichan(Zichan zichan, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        resultTotal = zichanService.insertzichan(zichan);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + zichan.toString());
        return null;
	}
	
	@RequestMapping("/updatezichan")
	public String updateList(@RequestParam(value = "id") String id, Zichan zichan, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        zichan.setId(id);
        resultTotal = zichanService.updatezichan(zichan);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + zichan.toString());
        return null;
	}
	
	@RequestMapping("/deletezichan")
	public String deleteList(@RequestParam(value = "id") String id, Zichan zichan, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        zichan.setId(id);
        resultTotal = zichanService.deletezichan(zichan);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + zichan.toString());
        return null;
	}
}
