package com.akdriss.cvback.services;

import com.akdriss.cvback.dtos.CVDto;
import com.akdriss.cvback.dtos.LanguageDto;
import com.akdriss.cvback.dtos.LanguageRefDto;

import java.util.List;

public interface ILanguageService extends GenericService<LanguageRefDto>{
    List<LanguageRefDto> getAll();
    LanguageRefDto getById(Long id);

    LanguageRefDto save(LanguageRefDto cvDto);


    LanguageRefDto update(LanguageRefDto cvDto);
}
