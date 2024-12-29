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
        english.setElementRating(null);
        Language savedEnglish = languageRepo.save(english);

        /**
         * Frensh
         */
        Language frensh=new Language();
        frensh.setId(2L);
        frensh.setName("Frensh");
        frensh.setRateable(true);
        frensh.setDescription("spoken and written frensh");
        frensh.setElementRating(null);
        Language savedFrensh = languageRepo.save(frensh);

        /**
         * Spanish
         */
        Language spanish=new Language();
        spanish.setId(3L);
        spanish.setName("Spanish");
        spanish.setRateable(true);
        spanish.setDescription("spoken and written frensh");
        spanish.setElementRating(null);
        Language savedSpanish = languageRepo.save(spanish);

        /**
         * German
         */

        Language german=new Language();
        german.setId(4L);
        german.setName("German");
        german.setRateable(true);
        german.setDescription("spoken and written frensh");
        german.setElementRating(null);
        Language savedGerman = languageRepo.save(german);



        ElementRating  languageRating1=new ElementRating();
        languageRating1.setId(1L);
        languageRating1.setRating(1);
        languageRating1.setDescription("Elementary Proficiency");
        languageRating1.setLanguages(Stream.of(savedEnglish).collect(Collectors.toList()));

        ElementRating savedLanguageRating1 = elementRatingRepo.save(languageRating1);


        ElementRating  languageRating2=new ElementRating();
        languageRating2.setId(2L);
        languageRating2.setRating(2);
        languageRating2.setDescription("Limited Working Proficiency");
        languageRating2.setLanguages(Stream.of(savedEnglish).collect(Collectors.toList()));

        ElementRating savedLanguageRating2 = elementRatingRepo.save(languageRating2);



        ElementRating  languageRating3=new ElementRating();
        languageRating3.setId(3L);
        languageRating3.setRating(3);
        languageRating3.setDescription("Professional Working Proficiency");
        languageRating3.setLanguages(Stream.of(savedEnglish).collect(Collectors.toList()));

        ElementRating savedLanguageRating3 = elementRatingRepo.save(languageRating3);

        ElementRating  languageRating4=new ElementRating();
        languageRating4.setId(4L);
        languageRating4.setRating(4);
        languageRating4.setDescription("Full Professional Proficiency");
        languageRating4.setLanguages(Stream.of(savedEnglish).collect(Collectors.toList()));

        ElementRating savedLanguageRating4 = elementRatingRepo.save(languageRating4);


        ElementRating  languageRating5=new ElementRating();
        languageRating5.setId(5L);
        languageRating5.setRating(5);
        languageRating5.setDescription("Native / Bilingual Proficiency");
        languageRating5.setLanguages(Stream.of(savedEnglish).collect(Collectors.toList()));

        ElementRating savedLanguageRating5 = elementRatingRepo.save(languageRating5);

    /*    savedEnglish.setElementRating(savedLanguageRating3);
        languageRepo.save(savedEnglish);
        savedFrensh.setElementRating(savedLanguageRating4);
        languageRepo.save(savedFrensh);
        savedSpanish.setElementRating(savedLanguageRating1);
        languageRepo.save(savedSpanish);
        savedGerman.setElementRating(savedLanguageRating1);
        languageRepo.save(savedGerman);*/










    }
}
