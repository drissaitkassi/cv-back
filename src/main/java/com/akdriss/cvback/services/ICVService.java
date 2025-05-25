package com.akdriss.cvback.services;

import com.akdriss.cvback.dtos.CVDto;

import java.util.List;

public interface ICVService extends GenericService<CVDto> {
    List<CVDto> getAll();
    CVDto getById(Long id);

    CVDto save(CVDto cvDto);


    CVDto update(CVDto cvDto);
}
