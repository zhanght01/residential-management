package com.tony.graduation.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tony.graduation.dao.BookDao;
import com.tony.graduation.dao.StoreBookDao;
import com.tony.graduation.dao.StoreDao;
import com.tony.graduation.entity.StoreBook;
import com.tony.graduation.service.StoreBookService;

/**
 * @author 1034683568@qq.com
 * @project_name ssm-maven
 * @date 2017-3-1
 */
@Service("storeBookService")
public class StoreBookServiceImpl implements StoreBookService {
    private static final long serialVersionUID = 1L;
    @Resource
    private BookDao bookDao;
    @Resource
    private StoreDao storeDao;
    @Resource
    private StoreBookDao storeBookDao;

    @Override
    public List<StoreBook> findStoreBooks(Map<String, Object> map) {
        List<StoreBook> storeBooks = storeBookDao.findStoreBooks(map);
        for (StoreBook s : storeBooks) {
            try {
                s.setBook(bookDao.getBookById(s.getBookId()));
                s.setStore(storeDao.getStoreById(s.getStoreId()));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("书架信息错误," + s.getBookId() + "," + s.getStoreId());
            }
        }
        return storeBooks;
    }

    @Override
    public Long getTotalStoreBooks(Map<String, Object> map) {
        return storeBookDao.getTotalStoreBooks(map);
    }

    @Override
    public int updStoreBook(StoreBook storebook) {
        return storeBookDao.updStoreBook(storebook);
    }

    @Override
    public int delStoreBook(String id) {
        return storeBookDao.delStoreBook(id);
    }

    @Override
    public StoreBook getStoreBookById(String id) {
        StoreBook s = storeBookDao.getStoreBookById(id);
        s.setBook(bookDao.getBookById(s.getBookId()));
        s.setStore(storeDao.getStoreById(s.getStoreId()));
        return s;
    }

}
