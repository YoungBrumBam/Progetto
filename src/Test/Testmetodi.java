package Test;
import Metodi.Metodi;
import Moduli.Agenda;
import Moduli.Appuntamento;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class Testmetodi {
    @Test
    void testAggiuntaAgenda(){
        ArrayList<Agenda> agende = new ArrayList<>();
        Metodi metodi = new Metodi(agende);
        metodi.aggiungiAgenda("Ufficio");
        metodi.aggiungiAgenda("Casa");
        metodi.stampaAgende();
        assertEquals(2,metodi.dimAgende());
    }

    @Test
    void testRimuoviAgenda(){
        ArrayList<Agenda> agende = new ArrayList<>();
        Metodi metodi = new Metodi(agende);
        metodi.aggiungiAgenda("Ufficio");
        assertEquals(1,metodi.dimAgende());
        metodi.pulisciAgenda("Ufficio");
        assertEquals(0,metodi.dimAgende());
    }

    @Test
    void testdimAgenda(){
        ArrayList<Agenda> agende = new ArrayList<>();
        ArrayList<Appuntamento> appuntamenti = new ArrayList<>();
        Metodi metodi = new Metodi(agende);
        metodi.aggiungiAgenda("Ufficio");
        metodi.aggiungiAgenda("Casa");
        assertEquals(2,metodi.dimAgende());
    }

    @Test
    void testFile(){
        ArrayList<Agenda> agende = new ArrayList<>();
        Metodi metodi = new Metodi(agende);
        metodi.aggiungiAgenda("Ufficio");
        metodi.appuntamentidaFile("Ufficio");
        assertNotEquals(0,metodi.dimAppuntamenti("Ufficio"));
        metodi.stampaAppuntamenti("Ufficio");
    }
}
