package com.akdriss.cvback.mappers;

import com.akdriss.cvback.dtos.CVDto;
import com.akdriss.cvback.entities.CV;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CVMapper implements GenericMapper<CV, CVDto> {

    private final CandidateMapper candidateMapper;
    private final LanguageMapper languageMapper;
    private final ExperienceMapper experienceMapper;
    private final SkillMapper skillMapper;
    private final DegreeMapper degreeMapper;
    private final InterestMapper interestMapper;
    private final OtherSkillsMapper otherSkillsMapper;



    @Override
    public CVDto toDto(CV cv) {
        CVDto cvDto=new CVDto();
        cvDto.setId(cvDto.getId());
        cvDto.setOffer(cv.getOffer());
        cvDto.setCandidate(candidateMapper.toDto(cv.getCandidate()));
        cvDto.setLanguages(languageMapper.toListDto(cv.getLanguages()));
        cvDto.setExperiences(experienceMapper.toListDto(cv.getExperiences()));
        cvDto.setSkills(skillMapper.toListDto(cv.getSkills()));
        cvDto.setDegrees(degreeMapper.toListDto(cv.getDegrees()));
        cvDto.setIntrests(interestMapper.toListDto(cv.getIntrests()));
        cvDto.setOtherSkills(otherSkillsMapper.toListDto(cv.getOtherSkills()));
        return cvDto;
    }

    @Override
    public CV toEntity(CVDto cvDto) {
        CV cv=new CV();
        cv.setId(cvDto.getId());
        cv.setOffer(cvDto.getOffer());
        cv.setCandidate(candidateMapper.toEntity(cvDto.getCandidate()));
        cv.setLanguages(languageMapper.toListEntities(cvDto.getLanguages()));
        cv.setExperiences(experienceMapper.toListEntities(cvDto.getExperiences()));
        cv.setSkills(skillMapper.toListEntities(cvDto.getSkills()));
        cv.setDegrees(degreeMapper.toListEntities(cvDto.getDegrees()));
        cv.setIntrests(interestMapper.toListEntities(cvDto.getIntrests()));
        cv.setOtherSkills(otherSkillsMapper.toListEntities(cvDto.getOtherSkills()));
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
