package perriAlessandro.DesignPattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import perriAlessandro.DesignPattern.adapter.Info;
import perriAlessandro.DesignPattern.adapter.InfoAdapter;
import perriAlessandro.DesignPattern.adapter.UserData;
import perriAlessandro.DesignPattern.chainOfResponsibility.*;

import java.time.LocalDate;
import java.util.Scanner;

@SpringBootApplication
public class DesignPatternApplication {


    public static void main(String[] args) {

        SpringApplication.run(DesignPatternApplication.class, args);
        Scanner sc = new Scanner(System.in);


        System.out.println("------------------------ ADAPTER ------------------------");

        System.out.print("Inserisci il nome: ");
        String name = sc.nextLine();
        System.out.print("Inserisci il cognome: ");
        String surname = sc.nextLine();

        boolean dataValida = false;

        while (!dataValida) {
            try {
                System.out.print("Inserisci la data di nascita (formato yyyy-mm-dd): ");
                LocalDate data = LocalDate.parse(sc.nextLine());

                Info info = Info.builder().nome(name)
                        .cognome(surname).dataDiNascita(data).build();

                InfoAdapter adapter = new InfoAdapter(info);

                UserData userData = UserData.builder().build();

                userData.getData(adapter); //Dati da info

                //Nome ed età di userData
                System.out.println("Il Nome completo è " + userData.getNomeCompleto());
                System.out.println("L'età è " + userData.getEtà());
                dataValida = true;

            } catch (Exception e) {
                System.out.println("Formato data non valido. Assicurati di inserire la data nel formato corretto (yyyy-mm-dd).");
            }
        }


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

        sc.close();
    }

}
