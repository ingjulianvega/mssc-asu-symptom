package ingjulianvega.ximic.msscasusymptom.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "symptom")
public class SymptomParameters {

    private String api;
}
