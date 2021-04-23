package ingjulianvega.ximic.msscasusymptom.services;


import ingjulianvega.ximic.msscasusymptom.web.model.Symptom;
import ingjulianvega.ximic.msscasusymptom.web.model.SymptomDto;
import ingjulianvega.ximic.msscasusymptom.web.model.SymptomList;

import java.util.UUID;

public interface SymptomService {
    SymptomList get();

    SymptomDto getById(UUID id);

    void create(Symptom symptom);

    void updateById(UUID id, Symptom symptom);

    void deleteById(UUID id);
}
