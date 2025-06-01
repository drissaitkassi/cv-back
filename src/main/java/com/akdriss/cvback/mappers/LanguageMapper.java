package com.akdriss.cvback.mappers;

import com.akdriss.cvback.dtos.LanguageDto;
import com.akdriss.cvback.dtos.LanguageRefDto;
import com.akdriss.cvback.entities.ElementRating;
import com.akdriss.cvback.entities.Language;
import com.akdriss.cvback.enums.Type;
import com.akdriss.cvback.repositories.ElementRatingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LanguageMapper implements GenericMapper<Language, LanguageDto> {

    private final ElementRatingMapper elementRatingMapper;
    private final ElementRatingRepo elementRatingRepo;

    @Override
    public LanguageDto toDto(Language language) {

        LanguageDto languageDto = new LanguageDto();
        languageDto.setId(language.getId());
        languageDto.setName(language.getName());
        languageDto.setDescription(language.getDescription());
        languageDto.setRateable(language.getRateable());
       //languageDto.setElementRatingDto(elementRatingMapper.toListDto(language.get()));
        return languageDto;
    }

    @Override
    public Language toEntity(LanguageDto languageDto) {
        Language language = new Language();
        language.setId(languageDto.getId());
        language.setName(languageDto.getName());
        language.setDescription(languageDto.getDescription());
        //language.setElementRating(language.getElementRating());
        language.setRateable(languageDto.getRateable());

        //language.setElementRating(elementRatingMapper.toEntity(languageDto.getElementRatingDto()));
        return language;

    }

    @Override
    public List<LanguageDto> toListDto(List<Language> languages) {
        return languages.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Language> toListEntities(List<LanguageDto> languageDtos) {
        return languageDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }


    public LanguageRefDto toRefDto(Language language) {

        LanguageRefDto languageRefDto = new LanguageRefDto();
        languageRefDto.setId(language.getId());
        languageRefDto.setName(language.getName());
        languageRefDto.setDescription(language.getDescription());
        languageRefDto.setRateable(language.getRateable());
        List<ElementRating> allByType = elementRatingRepo.findAllByType(Type.LANGUAGE);

        languageRefDto.setElementRatingDtos(elementRatingMapper.toListDto(allByType));
        return languageRefDto;
    }

    public Language toRefEntity(LanguageRefDto languageRefDto) {

        Language language = new Language();
        language.setId(languageRefDto.getId());
        language.setName(languageRefDto.getName());
        language.setDescription(languageRefDto.getDescription());
        language.setRateable(languageRefDto.getRateable());

        return language;
    }

    public List<LanguageRefDto> toRefListDto(List<Language> languages) {
        return languages.stream().map(this::toRefDto).collect(Collectors.toList());
    }
    public List<Language>   toRefListEntity(List<LanguageRefDto> languageRefDtos) {
        return languageRefDtos.stream().map(this::toRefEntity).collect(Collectors.toList());
    }

}
