package com.akdriss.cvback.mappers;

import com.akdriss.cvback.dtos.*;
import com.akdriss.cvback.entities.*;
import com.akdriss.cvback.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
@Slf4j
public class CVMapper implements GenericMapper<CV, CVDto> {

    private final CandidateMapper candidateMapper;
    private final ExperienceMapper experienceMapper;
    private final DegreeMapper degreeMapper;
    private final InterestMapper interestMapper;
    private final LanguageRatingRepo languageRatingRepo;
    private final SkillRatingRepo skillRatingRepo;
    private final OtherSkillRatingRepo otherSkillRatingRepo;




    @Override
    public CVDto toDto(CV cv) {
        CVDto cvDto=new CVDto();
        cvDto.setId(cv.getId());
        cvDto.setOffer(cv.getOffer());
        cvDto.setCandidate(candidateMapper.toDto(cv.getCandidate()));
        if (cv.getId() != null){
            List<LanguageRating> languageRatings = languageRatingRepo.findByCv_Id(cv.getId());

            List<LanguageDto> languageDtos = languageRatings.stream().map(l -> {
                Language language = l.getLanguage();

                ElementRating elementRating = l.getElementRating();
                ElementRatingDto elementRatingDto = new ElementRatingDto();
                elementRatingDto.setId(elementRating.getId());
                elementRatingDto.setRating(elementRating.getRating());
                elementRatingDto.setDescription(elementRating.getDescription());

                LanguageDto languageDto = new LanguageDto();
                languageDto.setId(language.getId());
                languageDto.setDescription(language.getDescription());
                languageDto.setName(language.getName());
                languageDto.setRateable(language.getRateable());
                languageDto.setElementRatingDto(elementRatingDto);
                return languageDto;
            }).toList();
            cvDto.setLanguages(languageDtos);

            List<SkillRating> skillRatings = skillRatingRepo.findByCv_Id(cv.getId());
            List<SkillDto> skillDtos = skillRatings.stream().map(s -> {
                Skill skill = s.getSkill();

                ElementRating elementRating = s.getElementRating();
                ElementRatingDto elementRatingDto = new ElementRatingDto();
                elementRatingDto.setId(elementRating.getId());
                elementRatingDto.setRating(elementRating.getRating());
                elementRatingDto.setDescription(elementRating.getDescription());
                SkillDto skillDto = new SkillDto();
                skillDto.setId(skill.getId());
                skillDto.setName(skill.getName());
                skillDto.setDescription(skill.getDescription());
                skillDto.setRateable(skill.getRateable());
                skillDto.setElementRatingDto(elementRatingDto);

                return skillDto;

            }).toList();

            cvDto.setSkills(skillDtos);

            List<OtherSkillRating> otherSkillRatings = otherSkillRatingRepo.findByCv_Id(cv.getId());

            List<OtherSkillDto> otherSkillDtos = otherSkillRatings.stream().map(os -> {
                OtherSkill otherSkill = os.getOtherSkill();

                ElementRating elementRating = os.getElementRating();
                ElementRatingDto elementRatingDto = new ElementRatingDto();
                elementRatingDto.setId(elementRating.getId());
                elementRatingDto.setRating(elementRating.getRating());
                elementRatingDto.setDescription(elementRating.getDescription());
                OtherSkillDto otherSkillDto = new OtherSkillDto();
                otherSkillDto.setId(otherSkill.getId());
                otherSkillDto.setName(otherSkill.getName());
                otherSkillDto.setDescription(otherSkill.getDescription());
                otherSkillDto.setRateable(otherSkill.getRateable());
                otherSkillDto.setElementRatingDto(elementRatingDto);

                return otherSkillDto;

            }).toList();

            cvDto.setOtherSkills(otherSkillDtos);

        }


        cvDto.setExperiences(experienceMapper.toListDto(cv.getExperiences()));
        cvDto.setDegrees(degreeMapper.toListDto(cv.getDegrees()));
        cvDto.setIntrests(interestMapper.toListDto(cv.getIntrests()));

        return cvDto;
    }

    @Override
    public CV toEntity(CVDto cvDto) {
        CV cv=new CV();
        cv.setId(cvDto.getId());
        cv.setOffer(cvDto.getOffer());
        cv.setCandidate(candidateMapper.toEntity(cvDto.getCandidate()));
        //cv.setLanguages(languageMapper.toListEntities(cvDto.getLanguages()));
        cv.setExperiences(experienceMapper.toListEntities(cvDto.getExperiences()));
        //cv.setSkills(skillMapper.toListEntities(cvDto.getSkills()));
        cv.setDegrees(degreeMapper.toListEntities(cvDto.getDegrees()));
        cv.setIntrests(interestMapper.toListEntities(cvDto.getIntrests()));
        //cv.setOtherSkills(otherSkillsMapper.toListEntities(cvDto.getOtherSkills()));
        return cv;
    }

    @Override
    public List<CVDto> toListDto(List<CV> cvs) {
        return cvs.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CV> toListEntities(List<CVDto> cvDtos) {
        return cvDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
