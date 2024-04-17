package perriAlessandro.DesignPattern.adapter;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserData {

    private String nomeCompleto;
    private int età;

    public void getData(DataSource ds) {
        nomeCompleto = ds.getNomeCompleto();
        età = ds.getEtà();
    }
}
