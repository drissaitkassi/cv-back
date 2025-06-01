package com.akdriss.cvback.services;

import com.akdriss.cvback.dtos.CVDto;
import com.akdriss.cvback.dtos.LanguageDto;
import com.akdriss.cvback.dtos.LanguageRefDto;
import com.akdriss.cvback.entities.Language;
import com.akdriss.cvback.mappers.LanguageMapper;
import com.akdriss.cvback.repositories.LanguageRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ILanguageServiceImpl implements ILanguageService{

    private final LanguageRepo languageRepo;
    private final LanguageMapper languageMapper;
    @Override
    public List<LanguageRefDto> getAll() {
        return languageMapper.toRefListDto(languageRepo.findAll());
    }

    @Override
    public LanguageRefDto getById(Long id) {
        return languageMapper.toRefDto(languageRepo.findById(id).orElseThrow(()->new EntityNotFoundException("language with id "+id+" not found ")));
    }



    @Override
    public LanguageRefDto save(LanguageRefDto languageRefDto) {

        return languageMapper.toRefDto(languageRepo.save(languageMapper.toRefEntity(languageRefDto)));
    }

    @Override
    public LanguageRefDto update(LanguageRefDto languageRefDto) {
        if (languageRefDto.getId()== null)
            throw new RuntimeException("cannot update language with Id null ");
        return languageMapper.toRefDto(languageRepo.save(languageMapper.toRefEntity(languageRefDto)));
    }


}
