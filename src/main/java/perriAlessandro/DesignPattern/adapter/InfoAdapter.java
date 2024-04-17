package perriAlessandro.DesignPattern.adapter;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InfoAdapter implements DataSource {
    private Info info;

    public InfoAdapter(Info info) {
        this.info = info;
    }

    @Override
    public int getEtà() {
        LocalDate dataDiNascita = info.getDataDiNascita();
        LocalDate dataCorrente = LocalDate.now();
        int età = dataCorrente.getYear() - dataDiNascita.getYear();
        return età;
    }

    @Override
    public String getNomeCompleto() {
        return info.getNome() + " " + info.getCognome();
    }
}
