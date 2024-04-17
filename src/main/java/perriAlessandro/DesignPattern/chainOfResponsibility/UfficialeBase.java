package perriAlessandro.DesignPattern.chainOfResponsibility;

import lombok.Setter;


public abstract class UfficialeBase implements Ufficiale {
    @Setter
    protected Ufficiale prossimoUfficiale;
    protected int stipendio;

    public UfficialeBase(int stipendio) {
        this.stipendio = stipendio;
    }


    @Override
    public void gestisciRichiesta(int importo) {
        if (importo <= stipendio) {
            System.out.println(getClass().getSimpleName() + " può gestire la richiesta.");
        } else if (prossimoUfficiale != null) {
            prossimoUfficiale.gestisciRichiesta(importo);
        } else {
            System.out.println("Nessun ufficiale può gestire la richiesta.");
        }
    }
}
