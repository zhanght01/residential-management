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
import com.tony.graduation.entity.Store;
import com.tony.graduation.entity.Yezhu;
import com.tony.graduation.service.YezhuService;
import com.tony.graduation.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/yezhu")
public class YezhuController {
	
	@Resource
	private YezhuService yezhuService;
	private static final long serialVersionUID = 1L;
	public static final Logger log = Logger.getLogger(YezhuController.class);
	
	/**
	 * 返回当前业主表内的所有数据，用于展示业主信息
	 * 实现了分页
	 * @param page
	 * @param rows
	 * @param yezhu
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String yezhuList(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            Yezhu yezhu, HttpServletResponse response) throws Exception {
		
		Map<String, Object> map = new HashMap<>();
		if (page != null && rows != null) {
            PageBean pageBean = new PageBean(Integer.parseInt(page),
                    Integer.parseInt(rows));
            map.put("start", pageBean.getStart());
            map.put("size", pageBean.getPageSize());
        }
//        if (store.getStatus() != 0) {
//            map.put("status", store.getStatus() + "");
//        }
//        if (store.getNumber() != null) {
//            map.put("number", store.getNumber());
//        }
//        List<Store> storeList = storeService.findStores(map);
//        Long total = storeService.getTotalStores(map);
		List<Yezhu> yezhuList = yezhuService.finAll();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(yezhuList);
        result.put("rows", jsonArray);
//        result.put("total", total);
        ResponseUtil.write(response, result);
        log.info("request: store/list , map: " + map.toString());
		return null;
	}
	
	/**
	 * 添加一个用户信息
	 * @param yezhu
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addlist")
	public String addList(Yezhu yezhu, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("number", yezhu.getNumber());
        JSONObject result = new JSONObject();
        
//        if (yezhu.getUser_id() == null) {			
//        	resultTotal = yezhuService.insertyezhu(yezhu);
//		} else {
//			resultTotal = yezhuService.updateyezhu(yezhu);
//		}
        resultTotal = yezhuService.insertyezhu(yezhu);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
//        if (storeService.findStores(map).size() > 0
//                || Integer.valueOf(store.getLevel()) < 1) {
//            result.put("success", false);
//            ResponseUtil.write(response, result);
//        } else {
//            if (store.getId() == null) {
//                resultTotal = storeService.insertStore(store);
//            } else {
//                resultTotal = storeService.updStore(store);
//            }
//            if (resultTotal > 0) {
//                result.put("success", true);
//            } else {
//                result.put("success", false);
//            }
//            ResponseUtil.write(response, result);
//        }
        log.info("request: yezhu/save , " + yezhu.toString());
        return null;
	}
	
	@RequestMapping("/updatelist")
	public String updateList(@RequestParam(value = "id") String user_id, Yezhu yezhu, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        yezhu.setUser_id(user_id);
        resultTotal = yezhuService.updateyezhu(yezhu);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + yezhu.toString());
        return null;
	}
	
	@RequestMapping("/deletelist")
	public String deleteList(@RequestParam(value = "id") String user_id, Yezhu yezhu, HttpServletResponse response) 
								throws Exception{
		
		int resultTotal = 0;
        JSONObject result = new JSONObject();
        
        yezhu.setUser_id(user_id);
        resultTotal = yezhuService.deleteyezhu(yezhu);
        if (resultTotal > 0) {			
        	result.put("success", true);
		} else {
			result.put("success", false);
		}
        ResponseUtil.write(response, result);
        log.info("request: yezhu/save , " + yezhu.toString());
        return null;
	}
}
