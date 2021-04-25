package ingjulianvega.ximic.msscasusymptom.domain.repositories;

import ingjulianvega.ximic.msscasusymptom.domain.SymptomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface SymptomRepository extends JpaRepository<SymptomEntity, UUID>, JpaSpecificationExecutor<SymptomEntity> {
    List<SymptomEntity> findAllByOrderByName();
}
