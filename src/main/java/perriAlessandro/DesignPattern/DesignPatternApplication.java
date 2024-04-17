package perriAlessandro.DesignPattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import perriAlessandro.DesignPattern.adapter.Info;
import perriAlessandro.DesignPattern.adapter.InfoAdapter;
import perriAlessandro.DesignPattern.adapter.UserData;
import perriAlessandro.DesignPattern.chainOfResponsibility.*;

import java.util.Date;

@SpringBootApplication
public class DesignPatternApplication {


    public static void main(String[] args) {

        SpringApplication.run(DesignPatternApplication.class, args);

        System.out.println("------------------------ ADAPTER ------------------------");
        Info info = Info.builder().nome("Mario")
                .cognome("Rossi").dataDiNascita(new Date(1990, 2, 26)).build();

        InfoAdapter adapter = new InfoAdapter(info);

        UserData userData = UserData.builder().build();

        userData.getData(adapter); //Dati da info

        //Nome ed età di userData
        System.out.println("Il Nome completo è " + userData.getNomeCompleto());
        System.out.println("L'età è " + userData.getEtà());

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("------------------------------- CHAIN OF RESPONSIBILITY ---------------------------");
        // CREAZIONE DELLA CATENA
        Tenente tenente = new Tenente();
        Capitano capitano = new Capitano();
        Maggiore maggiore = new Maggiore();
        Colonnello colonnello = new Colonnello();
        Generale generale = new Generale();

        tenente.setProssimoUfficiale(capitano);
        capitano.setProssimoUfficiale(maggiore);
        maggiore.setProssimoUfficiale(colonnello);
        colonnello.setProssimoUfficiale(generale);

        // TEST DEL PATTERN
        int[] importi = {500, 1500, 2500, 3500, 4500, 5500};
        for (int importo : importi) {
            System.out.println("Verifica pr l'importo: " + importo);
            tenente.gestisciRichiesta(importo);
        }

    }

}
