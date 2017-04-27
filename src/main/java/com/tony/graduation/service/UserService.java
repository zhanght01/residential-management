package com.tony.graduation.service;

import java.util.List;
import java.util.Map;

import com.tony.graduation.entity.User;

public interface UserService {

    /**
     * �û���¼
     *
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * ��ѯ�û�
     *
     * @param map
     * @return
     */
    public List<User> findUser(Map<String, Object> map);

    /**
     * ��ȡ�û���¼��
     *
     * @param map
     * @return
     */
    public Long getTotalUser(Map<String, Object> map);

    /**
     * �����û�
     *
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * ����û�
     *
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * ɾ���û�
     *
     * @param id
     * @return
     */
    public int deleteUser(Integer id);
}
