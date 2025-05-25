package com.akdriss.cvback.batch;


import com.akdriss.cvback.entities.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class SccBatchConfig {




    //job
    @Bean
    public Job testJob(){
        return null;
    }

    //step

    //mapper

    //reader

    //tokenizer

    //beanWrapper

    //writer

    //processor
    @Bean
    public FlatFileItemReader<User> testReder(){
        FlatFileItemReader<User> reader= new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(""));
        reader.setName("csvReader");
        reader.setLinesToSkip(1);
        reader.setLineMapper(testLineMapper());
        return reader;
    }
    @Bean
    public LineMapper<User> testLineMapper() {
        DefaultLineMapper<User> lineMapper =new DefaultLineMapper<>();
        DelimitedLineTokenizer delimitedLineTokenizer =new DelimitedLineTokenizer();
        delimitedLineTokenizer.setNames("firstName","lastName","gender");
        delimitedLineTokenizer.setDelimiter(",");
        BeanWrapperFieldSetMapper<User> beanWrapperFieldSetMapper=new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(User.class);
        lineMapper.setLineTokenizer(delimitedLineTokenizer);
        lineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);


        return lineMapper;
    }



}
