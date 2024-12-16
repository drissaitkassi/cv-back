package com.akdriss.cvback.services;

import com.akdriss.cvback.dtos.CVDto;
import com.akdriss.cvback.mappers.CVMapper;
import com.akdriss.cvback.repositories.CVRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CVServiceImpl implements ICVService{

    private final CVRepository cvRepository;
    private final CVMapper cvMapper;
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
        return cvMapper.toDto(cvRepository.save(cvMapper.toEntity(cvDto)));
    }

    @Override
    public CVDto update(CVDto cvDto) {
        return null;
    }
}
