package ingjulianvega.ximic.msscasusymptom.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SymptomList implements Serializable {

    static final long serialVersionUID = -3729142181723422349L;

    public ArrayList<SymptomDto> systemList;
}
