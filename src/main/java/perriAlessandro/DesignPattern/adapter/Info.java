package perriAlessandro.DesignPattern.adapter;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class Info {
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;

}
