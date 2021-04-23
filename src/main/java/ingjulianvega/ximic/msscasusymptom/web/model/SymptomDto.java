package ingjulianvega.ximic.msscasusymptom.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SymptomDto implements Serializable {

    static final long serialVersionUID = -1726092744870633889L;

    private UUID id;
    private String name;

}
