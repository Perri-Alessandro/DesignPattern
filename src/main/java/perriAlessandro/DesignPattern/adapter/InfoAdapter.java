package perriAlessandro.DesignPattern.adapter;

import lombok.Data;

import java.util.Date;

@Data
public class InfoAdapter implements DataSource {
    private Info info;

    public InfoAdapter(Info info) {
        this.info = info;
    }

    @Override
    public int getEtà() {
        Date dataDiNascita = info.getDataDiNascita();
        Date dataCorrente = new Date();
        int età = dataCorrente.getYear() - dataDiNascita.getYear();
        return età;
    }

    @Override
    public String getNomeCompleto() {
        return info.getNome() + " " + info.getCognome();
    }
}
