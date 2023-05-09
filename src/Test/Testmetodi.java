package Test;
import Metodi.Metodi;
import Moduli.Agenda;
import Moduli.Appuntamento;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class Testmetodi {
    @Test
    void testAggiuntaAgenda(){
        //ArrayList<Agenda> agende = new ArrayList<>();
        Metodi metodi = new Metodi();
        metodi.aggiungiAgenda();//"Ufficio");
        metodi.aggiungiAgenda();//"Casa");
        metodi.stampaAgende();
        assertEquals(2,metodi.dimAgende());
    }

    @Test
    void testRimuoviAgenda(){
        //ArrayList<Agenda> agende = new ArrayList<>();
        Metodi metodi = new Metodi();
        metodi.aggiungiAgenda();//"Ufficio");
        assertEquals(1,metodi.dimAgende());
        metodi.pulisciAgenda();//"Ufficio");
        assertEquals(0,metodi.dimAgende());
    }

    @Test
    void testdimAgenda(){
        //ArrayList<Agenda> agende = new ArrayList<>();
        //ArrayList<Appuntamento> appuntamenti = new ArrayList<>();
        Metodi metodi = new Metodi();
        metodi.aggiungiAgenda();//"Ufficio");
        metodi.aggiungiAgenda();//"Casa");
        assertEquals(2,metodi.dimAgende());
    }

    @Test
    void testFile() throws IOException {
        //ArrayList<Agenda> agende = new ArrayList<>();
        Metodi metodi = new Metodi();
        metodi.aggiungiAgenda();//"Ufficio");
        metodi.appuntamentidaFile();//"Ufficio");
        assertNotEquals(0,metodi.dimAppuntamenti("Ufficio"));
        metodi.stampaAppuntamenti();//"Ufficio");
    }

    @Test
    void testScrivi() throws IOException{
        //ArrayList<Agenda> agende = new ArrayList<>();
        Metodi metodi = new Metodi();
        metodi.aggiungiAgenda();//"Ufficio");
        metodi.appuntamentidaFile();//"Ufficio");
        metodi.aggiungiAgenda();//"Casa");
        metodi.scriviAgendaFile();
    }
    @Test
    void testAggiungiapp(){
        //ArrayList<Agenda> agende = new ArrayList<>();
        Metodi metodi = new Metodi();
        metodi.aggiungiAgenda();//"Ufficio");
        metodi.aggiungiAgenda();//"Casa");
        metodi.aggiungiAppuntamento();//"Ufficio",LocalDate.of(2023, 3, 3), LocalTime.of(18,30),20,"Gianni","Milano");
        metodi.aggiungiAppuntamento();//"Casa",LocalDate.of(2023, 3, 3), LocalTime.of(18,20),20,"Gianni","Milano");
        metodi.aggiungiAppuntamento();//"Casa",LocalDate.of(2023, 3, 10), LocalTime.of(18,20),20,"Lorenzo","Napoli");
        metodi.stampaAppuntamenti();//"Ufficio");
        metodi.stampaAppuntamenti();//"Casa");
    }
    @Test
    void testModifica(){
        //ArrayList<Agenda> agende = new ArrayList<>();
        Metodi metodi = new Metodi();
        metodi.aggiungiAgenda();//"Ufficio");
        metodi.aggiungiAgenda();//"Casa");
        metodi.aggiungiAppuntamento();//"Ufficio",LocalDate.of(2023, 3, 10), LocalTime.of(18,30),20,"Mario","Londra");
        metodi.aggiungiAppuntamento();//"Casa",LocalDate.of(2023, 3, 3), LocalTime.of(17,50),10,"Gianni","Milano");
        metodi.stampaAppuntamenti();//"Ufficio");
        metodi.stampaAppuntamenti();//"Casa");
        metodi.modificaAppuntamento();//"Casa",LocalDate.of(2023, 3, 3), LocalTime.of(17,50),15,"Gianni","Milano");
        metodi.stampaAppuntamenti();//"Ufficio");
        metodi.stampaAppuntamenti();//"Casa");
    }
    @Test
    void teststampadatoNome(){
        //ArrayList<Agenda> agende = new ArrayList<>();
        Metodi metodi = new Metodi();
        metodi.aggiungiAgenda();//"Ufficio");
        metodi.aggiungiAgenda();//"Casa");
        metodi.aggiungiAppuntamento();//"Ufficio");//,LocalDate.of(2023, 3, 10), LocalTime.of(18,30),20,"Mario","Londra");
        metodi.aggiungiAppuntamento();//"Casa");//,LocalDate.of(2023, 3, 3), LocalTime.of(17,50),10,"Gianni","Milano");
        metodi.modificaAppuntamento();//"Casa",LocalDate.of(2023, 3, 3), LocalTime.of(17,50),15,"Gianni","Milano");
        metodi.aggiungiAppuntamento();//"Ufficio");//,LocalDate.of(2023, 3, 30), LocalTime.of(17,30),50,"Gianni","Instanbul");
        metodi.stampaAppuntamentidanome();//"Gianni");
    }
    @Test
    void teststampadatoData(){
        //ArrayList<Agenda> agende = new ArrayList<>();
        Metodi metodi = new Metodi();
        metodi.aggiungiAgenda();//"Ufficio");
        metodi.aggiungiAgenda();//"Casa");
        metodi.aggiungiAppuntamento();//"Ufficio");//,LocalDate.of(2023, 3, 10), LocalTime.of(18,30),20,"Mario","Londra");
        metodi.aggiungiAppuntamento();//"Casa");//,LocalDate.of(2023, 3, 3), LocalTime.of(17,50),10,"Gianni","Milano");
        metodi.modificaAppuntamento();//"Casa",LocalDate.of(2023, 3, 3), LocalTime.of(17,50),15,"Gianni","Milano");
        metodi.aggiungiAppuntamento();//"Ufficio");//,LocalDate.of(2023, 3, 30), LocalTime.of(17,30),50,"Gianni","Instanbul");
        metodi.stampaAppuntamentidadata();//"03/03/2023");
    }
    @Test
    void ordinadate(){
        Metodi metodi = new Metodi();
        metodi.aggiungiAgenda();//"Ufficio");
        metodi.aggiungiAgenda();//"Casa");
        metodi.aggiungiAppuntamento();//"Ufficio");//,LocalDate.of(2023, 3, 10), LocalTime.of(18,30),20,"Mario","Londra");
        metodi.aggiungiAppuntamento();//"Ufficio");//,LocalDate.of(2023, 2, 4), LocalTime.of(17,30),50,"Gianni","Instanbul");
        metodi.aggiungiAppuntamento();//"Ufficio");//,LocalDate.of(2023, 1, 5), LocalTime.of(17,30),50,"Gianni","Instanbul");
        metodi.aggiungiAppuntamento();//"Ufficio");//,LocalDate.of(2023, 3, 30), LocalTime.of(17,30),50,"Gianni","Instanbul");
        metodi.stampaAppuntamenti();//"Ufficio");
        metodi.ordina();//"Ufficio");

    }
}
