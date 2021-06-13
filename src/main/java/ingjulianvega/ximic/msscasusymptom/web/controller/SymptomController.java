package ingjulianvega.ximic.msscasusymptom.web.controller;


import ingjulianvega.ximic.msscasusymptom.services.SymptomService;
import ingjulianvega.ximic.msscasusymptom.web.model.Symptom;
import ingjulianvega.ximic.msscasusymptom.web.model.SymptomDto;
import ingjulianvega.ximic.msscasusymptom.web.model.SymptomList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SymptomController implements SymptomI {

    private final SymptomService symptomService;

    @Override
    public ResponseEntity<SymptomList> get(Boolean usingCache) {
        return new ResponseEntity<>(symptomService.get(usingCache), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SymptomDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(symptomService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Symptom symptom) {
        symptomService.create(symptom);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Symptom symptom) {
        symptomService.updateById(id, symptom);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        symptomService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
