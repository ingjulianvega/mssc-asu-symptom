package ingjulianvega.ximic.msscasusymptom.services;

import ingjulianvega.ximic.msscasusymptom.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasusymptom.domain.SymptomEntity;
import ingjulianvega.ximic.msscasusymptom.domain.repositories.SymptomRepository;
import ingjulianvega.ximic.msscasusymptom.exception.SymptomException;
import ingjulianvega.ximic.msscasusymptom.web.Mappers.SymptomMapper;
import ingjulianvega.ximic.msscasusymptom.web.model.Symptom;
import ingjulianvega.ximic.msscasusymptom.web.model.SymptomDto;
import ingjulianvega.ximic.msscasusymptom.web.model.SymptomList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class SymptomServiceImpl implements SymptomService {

    private final SymptomRepository symptomRepository;
    private final SymptomMapper symptomMapper;

    @Cacheable(cacheNames = "symptomListCache", condition = "#usingCache == false")
    @Override
    public SymptomList get(Boolean usingCache) {
        log.debug("get()...");
        return SymptomList
                .builder()
                .systemList(symptomMapper.symptomEntityListToSymptomDtoList(symptomRepository.findAllByOrderByName()))
                .build();
    }

    @Cacheable(cacheNames = "symptomCache")
    @Override
    public SymptomDto getById(UUID id) {
        log.debug("getById()...");
        return symptomMapper.symptomEntityToSymptomDto(
                symptomRepository.findById(id)
                        .orElseThrow(() -> SymptomException
                                .builder()
                                .httpStatus(HttpStatus.BAD_REQUEST)
                                .apiCode(ErrorCodeMessages.SYMPTOM_NOT_FOUND_API_CODE)
                                .error(ErrorCodeMessages.SYMPTOM_NOT_FOUND_ERROR)
                                .message(ErrorCodeMessages.SYMPTOM_NOT_FOUND_MESSAGE)
                                .solution(ErrorCodeMessages.SYMPTOM_NOT_FOUND_SOLUTION)
                                .build() ));
    }

    @Override
    public void create(Symptom symptom) {
        log.debug("create()...");
        symptomMapper.symptomEntityToSymptomDto(
                symptomRepository.save(
                        symptomMapper.symptomDtoToSymptomEntity(
                                SymptomDto
                                        .builder()
                                        .name(symptom.getName())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, Symptom symptom) {
        log.debug("updateById...");
        SymptomEntity evidenceEntity = symptomRepository.findById(id)
                .orElseThrow(() -> SymptomException
                        .builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .apiCode(ErrorCodeMessages.SYMPTOM_NOT_FOUND_API_CODE)
                        .error(ErrorCodeMessages.SYMPTOM_NOT_FOUND_ERROR)
                        .message(ErrorCodeMessages.SYMPTOM_NOT_FOUND_MESSAGE)
                        .solution(ErrorCodeMessages.SYMPTOM_NOT_FOUND_SOLUTION)
                        .build());

        evidenceEntity.setName(symptom.getName());

        symptomRepository.save(evidenceEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        symptomRepository.deleteById(id);
    }
}
