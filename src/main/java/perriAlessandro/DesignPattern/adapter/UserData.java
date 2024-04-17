package perriAlessandro.DesignPattern.adapter;

import lombok.Data;

@Data
public class UserData {

    private String nomeCompleto;
    private int età;

    public void getData(DataSource ds) {
        nomeCompleto = ds.getNomeCompleto();
        età = ds.getEtà();
    }
}
