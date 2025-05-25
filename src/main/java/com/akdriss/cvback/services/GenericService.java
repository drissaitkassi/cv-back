package com.akdriss.cvback.services;

import java.util.List;

public interface GenericService <D>{

    List<D> getAll();
    D getById(Long id);
    D save(D d);
    D update(D d);
}
