package com.nautilus.service;

import com.nautilus.dao.GoodDaoImpl;
import com.nautilus.model.Good;
import com.nautilus.model.User;

import java.util.List;

public class GoodServiceImpl implements GoodService {
    private GoodDaoImpl goodDao = new GoodDaoImpl();

    @Override
    public User findById(int id) {
        return goodDao.findById(id);
    }

    @Override
    public Long findIdByName(String name) {
        return goodDao.findIdByName(name);
    }

    @Override
    public void save(Good good) {
        goodDao.save(good);
    }

    @Override
    public void update(Good good) {
        goodDao.update(good);
    }

    @Override
    public void delete(Good good) {
        goodDao.delete(good);
    }

    @Override
    public List<Good> findAll() {
        return goodDao.findAll();
    }


}
