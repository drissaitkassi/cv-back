package com.akdriss.cvback.services;

import com.akdriss.cvback.dtos.CVDto;
import com.akdriss.cvback.entities.*;
import com.akdriss.cvback.mappers.*;
import com.akdriss.cvback.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CVServiceImpl implements ICVService{

    private final CVRepository cvRepository;
    private final CVMapper cvMapper;
    private final LanguageMapper languageMapper;
    private final ExperienceMapper experienceMapper;
    private final SkillMapper skillMapper;
    private final DegreeMapper degreeMapper;
    private final InterestMapper interestMapper;
    private final OtherSkillsMapper otherSkillsMapper;
    private final ElementRatingMapper elementRatingMapper;

    private final LanguageRepo languageRepo;
    private final ExperienceRepo experienceRepo;
    private final SkillRepo skillRepo;
    private final DegreeRepo degreeRepo;
    private final InterestRepo interestRepo;
    private final OtherSkillRepo otherSkillRepo;
    private final ElementRatingRepo elementRatingRepo;
    private final UserRepo userRepo;
    private final ContactRepo contactRepo;

    @Override
    public List<CVDto> getAll() {
        return cvMapper.toListDto(cvRepository.findAll());
    }

    @Override
    public CVDto getById(Long id) {
        return cvMapper.toDto(cvRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("CV NOT FOUND")));
    }

    @Override
    public CVDto save(CVDto cvDto) {
        //candidate is connected user  from token
        CV cv=new CV();
        Contact contact= contactRepo.save(getAthenticatedUser().getContact());

        User athenticatedUser = getAthenticatedUser();
        athenticatedUser.setContact(contact);
        User savedUser = userRepo.save(athenticatedUser);


        cv.setOffer(cvDto.getOffer());
        cv.setCandidate(savedUser);

        List<Language> languages=cvDto.getLanguages().stream().map(l -> {
            Language language = languageMapper.toEntity(l);
            ElementRating savedElementRating = elementRatingRepo.save(language.getElementRating());
            language.setElementRating(savedElementRating);
           return language;
        }).toList();

        languageRepo.saveAll(languages);
        cv.setLanguages(languages);
        List<Experience> experiences=experienceMapper.toListEntities(cvDto.getExperiences());
        experienceRepo.saveAll(experiences);
        cv.setExperiences(experiences);

        List<Skill> skills =cvDto.getSkills().stream().map(s -> {
            Skill skill = skillMapper.toEntity(s);
            ElementRating savedElementRating = elementRatingRepo.save(skill.getElementRating());
            skill.setElementRating(savedElementRating);
            return skill;
        }).toList();
        skillRepo.saveAll(skills);
        cv.setSkills(skills);

        List<Degree> degrees =degreeMapper.toListEntities(cvDto.getDegrees());
        degreeRepo.saveAll(degrees);
        cv.setDegrees(degrees);
        List<Intrest> intrests=interestMapper.toListEntities(cvDto.getIntrests());
        interestRepo.saveAll(intrests);
        cv.setIntrests(intrests);

        List<OtherSkill> otherSkills=cvDto.getOtherSkills().stream().map(os -> {
            OtherSkill otherSkill = otherSkillsMapper.toEntity(os);
            ElementRating savedElementRating = elementRatingRepo.save(otherSkill.getElementRating());
            otherSkill.setElementRating(savedElementRating);
            return otherSkill;
        }).toList();
        otherSkillRepo.saveAll(otherSkills);
        cv.setOtherSkills(otherSkills);

        CV savedCV=cvRepository.save(cv);


        return cvMapper.toDto(savedCV);
    }

    @Override
    public CVDto update(CVDto cvDto) {
        return null;
    }

    public User getAthenticatedUser(){
        User u= new User();
        Contact c= new Contact();
        u.setFirstName("DRISS");
        u.setLastName("AITKASSI");
        c.setEmail("driss.aitkassi@gmail.com");
        u.setContact(c);
        return u;
    }
}
