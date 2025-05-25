package com.akdriss.cvback;

import com.akdriss.cvback.entities.ElementRating;
import com.akdriss.cvback.entities.Language;
import com.akdriss.cvback.repositories.ElementRatingRepo;
import com.akdriss.cvback.repositories.LanguageRepo;
import com.akdriss.cvback.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class CvBackApplication implements CommandLineRunner{

    @Autowired
    LanguageRepo languageRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ElementRatingRepo elementRatingRepo;



    public static void main(String[] args) {
        SpringApplication.run(CvBackApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        /**
         * Fixtures :
         * ElementRating
         * Languages
         * Users
         *
         */


        /**
         * English
         */
        Language english=new Language();
        english.setId(1L);
        english.setName("English");
        english.setRateable(true);
        english.setDescription("spoken and written english ");

        Language savedEnglish = languageRepo.save(english);

        /**
         * Frensh
         */
        Language frensh=new Language();
        frensh.setId(2L);
        frensh.setName("Frensh");
        frensh.setRateable(true);
        frensh.setDescription("spoken and written frensh");

        Language savedFrensh = languageRepo.save(frensh);

        /**
         * Spanish
         */
        Language spanish=new Language();
        spanish.setId(3L);
        spanish.setName("Spanish");
        spanish.setRateable(true);
        spanish.setDescription("spoken and written frensh");

        Language savedSpanish = languageRepo.save(spanish);

        /**
         * German
         */

        Language german=new Language();
        german.setId(4L);
        german.setName("German");
        german.setRateable(true);
        german.setDescription("spoken and written frensh");

        Language savedGerman = languageRepo.save(german);



        ElementRating  languageRating1=new ElementRating();
        languageRating1.setId(1L);
        languageRating1.setRating(1);
        languageRating1.setDescription("Elementary Proficiency");
        //languageRating1.setLanguages(Stream.of(savedEnglish).collect(Collectors.toList()));

        ElementRating savedLanguageRating1 = elementRatingRepo.save(languageRating1);


        ElementRating  languageRating2=new ElementRating();
        languageRating2.setId(2L);
        languageRating2.setRating(2);
        languageRating2.setDescription("Limited Working Proficiency");
        //languageRating2.setLanguages(Stream.of(savedEnglish).collect(Collectors.toList()));

        ElementRating savedLanguageRating2 = elementRatingRepo.save(languageRating2);



        ElementRating  languageRating3=new ElementRating();
        languageRating3.setId(3L);
        languageRating3.setRating(3);
        languageRating3.setDescription("Professional Working Proficiency");
        //languageRating3.setLanguages(Stream.of(savedEnglish).collect(Collectors.toList()));

        ElementRating savedLanguageRating3 = elementRatingRepo.save(languageRating3);

        ElementRating  languageRating4=new ElementRating();
        languageRating4.setId(4L);
        languageRating4.setRating(4);
        languageRating4.setDescription("Full Professional Proficiency");
        //languageRating4.setLanguages(Stream.of(savedEnglish).collect(Collectors.toList()));

        ElementRating savedLanguageRating4 = elementRatingRepo.save(languageRating4);


        ElementRating  languageRating5=new ElementRating();
        languageRating5.setId(5L);
        languageRating5.setRating(5);
        languageRating5.setDescription("Native / Bilingual Proficiency");
        //languageRating5.setLanguages(Stream.of(savedEnglish).collect(Collectors.toList()));

        ElementRating savedLanguageRating5 = elementRatingRepo.save(languageRating5);


        /**
         * generic rating
         */
        ElementRating  genericRating1=new ElementRating();
        genericRating1.setId(6L);
        genericRating1.setRating(1);
        genericRating1.setDescription("Beginner | Little to no experience or knowledge in this skill.");
        //genericRating1.setLanguages(Stream.of(savedEnglish).collect(Collectors.toList()));

        ElementRating savedSkillRating1 = elementRatingRepo.save(genericRating1);

        ElementRating  genericRating2=new ElementRating();
        genericRating2.setId(7L);
        genericRating2.setRating(2);
        genericRating2.setDescription("Novice | Basic understanding and limited ability to perform the skill.");
        //genericRating2.setLanguages(Stream.of(savedEnglish).collect(Collectors.toList()));

        ElementRating savedSkillRating2 = elementRatingRepo.save(genericRating2);


        ElementRating  genericRating3=new ElementRating();
        genericRating3.setId(8L);
        genericRating3.setRating(3);
        genericRating3.setDescription("Intermediate | Functional knowledge and the ability to perform tasks with some independence.");
        //genericRating3.setLanguages(Stream.of(savedEnglish).collect(Collectors.toList()));

        ElementRating savedSkillRating3 = elementRatingRepo.save(genericRating3);

        ElementRating  genericRating4=new ElementRating();
        genericRating4.setId(9L);
        genericRating4.setRating(4);
        genericRating4.setDescription("Advanced | High level of proficiency and strong expertise in the skill.");
        //genericRating4.setLanguages(Stream.of(savedEnglish).collect(Collectors.toList()));

        ElementRating savedSkillRating4 = elementRatingRepo.save(genericRating4);

        ElementRating  genericRating5=new ElementRating();
        genericRating5.setId(10L);
        genericRating5.setRating(5);
        genericRating5.setDescription("Expert | Mastery of the skill, recognized as a leader or authority in the field.");
        //genericRating4.setLanguages(Stream.of(savedEnglish).collect(Collectors.toList()));

        ElementRating savedSkillRating5 = elementRatingRepo.save(genericRating5);

    /*

    Beginner | Little to no experience or knowledge in this skill.
    Novice | Basic understanding and limited ability to perform the skill.
    Intermediate | Functional knowledge and the ability to perform tasks with some independence.
    Advanced | High level of proficiency and strong expertise in the skill.
    Expert | Mastery of the skill, recognized as a leader or authority in the field.


    savedEnglish.setElementRating(savedLanguageRating3);
        languageRepo.save(savedEnglish);
        savedFrensh.setElementRating(savedLanguageRating4);
        languageRepo.save(savedFrensh);
        savedSpanish.setElementRating(savedLanguageRating1);
        languageRepo.save(savedSpanish);
        savedGerman.setElementRating(savedLanguageRating1);
        languageRepo.save(savedGerman);*/


    }
}
