package com.akdriss.cvback.mappers;

import com.akdriss.cvback.dtos.CandidateDto;
import com.akdriss.cvback.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class CandidateMapper implements GenericMapper<User, CandidateDto> {
    private final ContactMapper contactMapper;
    @Override
    public CandidateDto toDto(User user) {
        return new CandidateDto(user.getFirstName(), user.getLastName(), user.getGender(), user.getAvatar(),contactMapper.toDto(user.getContact()));
    }

    @Override
    public User toEntity(CandidateDto candidateDto) {
        return null;
    }

    @Override
    public List<CandidateDto> toListDto(List<User> users) {
        return null;
    }

    @Override
    public List<User> toListEntities(List<CandidateDto> candidateDtos) {
        return null;
    }
}
