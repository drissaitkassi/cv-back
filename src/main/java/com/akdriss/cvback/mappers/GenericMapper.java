package com.akdriss.cvback.mappers;

public interface GenericMapper <T,D>{

    D toDto(T t);
    T toEntity(D d);




}
