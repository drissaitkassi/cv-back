package com.akdriss.cvback.services;

import com.akdriss.cvback.dtos.CVDto;
import com.akdriss.cvback.entities.*;
import com.akdriss.cvback.enums.Gender;
import com.akdriss.cvback.mappers.*;
import com.akdriss.cvback.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
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
    private final LanguageRatingRepo languageRatingRepo;
    private final SkillRatingRepo skillRatingRepo;
    private final OtherSkillRatingRepo otherSkillRatingRepo;

    @Override
    public List<CVDto> getAll() {
        return cvMapper.toListDto(cvRepository.findAll());
    }

    @Override
    public CVDto getById(Long id) {
        Optional<CV> cv1 = cvRepository.findById(id);
        log.info(" result for cv byId {}",cv1.get().toString());

        return cvMapper.toDto(cvRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("CV NOT FOUND")));
    }

    @Override
    public CVDto save(CVDto cvDto) {
        CV cv=new CV();
        User athenticatedUser = getAthenticatedUser();


        cv.setOffer(cvDto.getOffer());
        cv.setCandidate(athenticatedUser);

        CV savedCv = cvRepository.save(cv);


        List<Language> languages=cvDto.getLanguages().stream().map(l -> {
            Language language = null;
            if (l.getId() != null){
                Optional<Language> langById = languageRepo.findById(l.getId());

                Optional<ElementRating> ratingById = elementRatingRepo.findById(l.getElementRatingDto().getId());

                if (langById.isPresent() && ratingById.isPresent()){
                    LanguageRating languageRating= new LanguageRating();
                    languageRating.setCv(savedCv);
                    languageRating.setLanguage(langById.get());
                    languageRating.setElementRating(ratingById.get());
                    languageRatingRepo.save(languageRating);
                    language= langById.get();
                }




            }
           return language;
        }).toList();




        List<Skill> skills =cvDto.getSkills().stream().map(s -> {
            Skill skill= null;
            Optional<ElementRating> ratingById = elementRatingRepo.findById(s.getElementRatingDto().getId());

            if (s.getId() != null){
                Optional<Skill> skillById = skillRepo.findById(s.getId());


                if (skillById.isPresent() && ratingById.isPresent()){
                    SkillRating skillRating = new SkillRating();
                    skillRating.setSkill(skillById.get());
                    skillRating.setCv(savedCv);
                    skillRating.setElementRating(ratingById.get());
                    skillRatingRepo.save(skillRating);
                    skill = skillById.get();

                }}

            return skill;
        }).toList();



        List<OtherSkill> otherSkills =cvDto.getOtherSkills().stream().map(s -> {
            OtherSkill otherSkill= null;
            Optional<ElementRating> ratingById = elementRatingRepo.findById(s.getElementRatingDto().getId());

            if (s.getId() != null){
                Optional<OtherSkill> skillById = otherSkillRepo.findById(s.getId());


                if (skillById.isPresent() && ratingById.isPresent()){
                    OtherSkillRating skillRating = new OtherSkillRating();
                    skillRating.setOtherSkill(skillById.get());
                    skillRating.setCv(savedCv);
                    skillRating.setElementRating(ratingById.get());
                    otherSkillRatingRepo.save(skillRating);
                    otherSkill = skillById.get();

                }}

            return otherSkill;
        }).toList();




        /*
         *
         *  experiences
         *  degree
         *  interests
         */


        List<Experience> experiences=experienceMapper.toListEntities(cvDto.getExperiences()).stream().map(e -> {
            e.setCv(savedCv);
            return e;
        }).toList();
        experienceRepo.saveAll(experiences);
        cv.setExperiences(experiences);

        List<Degree> degrees =degreeMapper.toListEntities(cvDto.getDegrees()).stream().map(d -> {
            d.setCv(savedCv);
            return d;
        }).toList();
        degreeRepo.saveAll(degrees);
        cv.setDegrees(degrees);


        List<Intrest> intrests=interestMapper.toListEntities(cvDto.getIntrests()).stream().map(i -> {
            i.setCv(savedCv);
            return i;
        }).toList();
        interestRepo.saveAll(intrests);
        cv.setIntrests(intrests);


        //CV finalSavedCv=cvRepository.save(savedCv);
        return cvMapper.toDto(savedCv);


    }

    @Override
    public CVDto update(CVDto cvDto) {
        return null;
    }

    public User getAthenticatedUser(){
        User u= new User();
        Contact c= new Contact();
        //u.setId(5L);
        u.setFirstName("DRISS");
        u.setLastName("AITKASSI");
        u.setGender(Gender.MALE);
        c.setEmail("driss.aitkassi@gmail.com");
        c.setAddress("fake address");
        c.setPhone("+21232145");


        Contact saved = contactRepo.save(c);
        u.setContact(saved);

        return userRepo.save(u);
    }
}
