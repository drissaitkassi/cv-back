package com.akdriss.cvback.mappers;

import java.util.List;

public interface GenericMapper <E,D>{

    D toDto(E e);
    E toEntity(D d);

    List<D> toListDto(List<E> es);
    List<E> toListEntities(List<D> ds);






}
