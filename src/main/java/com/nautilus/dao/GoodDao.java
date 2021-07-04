package com.nautilus.dao;

import com.nautilus.model.Good;
import com.nautilus.model.User;

import java.util.List;

interface GoodDao {

    User findById(int id);

    Long findIdByName(String login);

    void save(Good good);

    void update(Good good);

    void delete(Good good);

    List<Good> findAll();
}
