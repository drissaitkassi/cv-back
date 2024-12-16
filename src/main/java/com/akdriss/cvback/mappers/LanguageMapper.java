package com.akdriss.cvback.mappers;

import com.akdriss.cvback.dtos.LanguageDto;
import com.akdriss.cvback.entities.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LanguageMapper implements GenericMapper<Language, LanguageDto> {

    private final ElementRatingMapper elementRatingMapper;

    @Override
    public LanguageDto toDto(Language language) {
        return new LanguageDto(language.getId(), language.getName(), language.getDescription(), language.getRateable(),elementRatingMapper.toDto(language.getElementRating()));
    }

    @Override
    public Language toEntity(LanguageDto languageDto) {
        Language language = new Language();
        language.setId(languageDto.getId());
        language.setElementRating(language.getElementRating());
        language.setRateable(languageDto.getRateable());
        language.setName(languageDto.getName());
        language.setElementRating(elementRatingMapper.toEntity(languageDto.getElementRatingDto()));
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
}
