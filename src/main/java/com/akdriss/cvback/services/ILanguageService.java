package com.akdriss.cvback.services;

import com.akdriss.cvback.dtos.CVDto;
import com.akdriss.cvback.dtos.LanguageDto;

import java.util.List;

public interface ILanguageService extends GenericService<LanguageDto>{
    List<LanguageDto> getAll();
    LanguageDto getById(Long id);

    LanguageDto save(LanguageDto cvDto);


    LanguageDto update(LanguageDto cvDto);
}
