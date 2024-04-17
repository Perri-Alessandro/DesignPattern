package perriAlessandro.DesignPattern.adapter;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Info {
    private String nome;
    private String cognome;
    private Date dataDiNascita;

}
