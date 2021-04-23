package ingjulianvega.ximic.msscasusymptom.web.Mappers;


import ingjulianvega.ximic.msscasusymptom.domain.SymptomEntity;
import ingjulianvega.ximic.msscasusymptom.web.model.SymptomDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface SymptomMapper {
    SymptomDto symptomEntityToSymptomDto(SymptomEntity symptomEntity);

    SymptomEntity symptomDtoToSymptomEntity(SymptomDto symptomDto);

    ArrayList<SymptomDto> symptomEntityListToSymptomDtoList(List<SymptomEntity> symptomEntityList);
}
