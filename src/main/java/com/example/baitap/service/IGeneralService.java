package com.example.baitap.service;

import java.util.List;

public interface IGeneralService<E, T> {

    List<E> findAll(boolean deleted);

    E findById(T id);

    void create(E e);

    void update(T t, E e);

    void removeById(T id);
}
