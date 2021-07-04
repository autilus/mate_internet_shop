package com.nautilus.service;

import com.nautilus.model.Good;
import com.nautilus.model.User;

import java.util.List;

public interface GoodService {
    User findById(int id);

    Long findIdByName(String name);

    void save(Good good);

    void update(Good good);

    void delete(Good good);

    List<Good> findAll();
}
