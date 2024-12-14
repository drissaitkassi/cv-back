package com.akdriss.cvback.services;

import com.akdriss.cvback.dtos.CVDto;

import java.util.List;

public interface ICVService {
    List<CVDto> getAll();
    List<CVDto> getById(Long id);

    CVDto save();


    CVDto update();
}
