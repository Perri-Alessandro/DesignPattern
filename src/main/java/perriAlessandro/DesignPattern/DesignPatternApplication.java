package perriAlessandro.DesignPattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import perriAlessandro.DesignPattern.adapter.Info;
import perriAlessandro.DesignPattern.adapter.InfoAdapter;
import perriAlessandro.DesignPattern.adapter.UserData;

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
    }

}
