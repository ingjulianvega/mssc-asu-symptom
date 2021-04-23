package ingjulianvega.ximic.msscasusymptom.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Symptom implements Serializable {

    static final long serialVersionUID = 4706202561833919786L;

    private String name;

}
