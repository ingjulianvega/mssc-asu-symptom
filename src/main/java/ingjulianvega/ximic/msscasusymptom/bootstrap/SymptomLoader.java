package ingjulianvega.ximic.msscasusymptom.bootstrap;

import ingjulianvega.ximic.msscasusymptom.domain.SymptomEntity;
import ingjulianvega.ximic.msscasusymptom.domain.repositories.SymptomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class SymptomLoader implements CommandLineRunner {

    private final SymptomRepository symptomRepository;

    @Override
    public void run(String... args) throws Exception {
        if (symptomRepository.count() == 0) {
            loadSymptomObjects();
        }
    }

    private void loadSymptomObjects() {
        symptomRepository.saveAll(Arrays.asList(
                SymptomEntity.builder().name("Dolor de cabeza").build(),
                SymptomEntity.builder().name("Vómito").build(),
                SymptomEntity.builder().name("Mareo").build()
        ));
    }
}