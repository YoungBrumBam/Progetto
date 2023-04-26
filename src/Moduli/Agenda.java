package Moduli;

import java.time.LocalDate;
import java.util.ArrayList;

public class Agenda {
    public static String nome;

    public ArrayList<Appuntamento> appuntamenti;

    public Agenda(String nome) {
        this.nome = nome;
        appuntamenti = new ArrayList<>();
    }

    public static String getNome() {
        return nome;
    }

    public ArrayList<Appuntamento> getAppuntamenti(){
        return appuntamenti;
    }

    public void aggiungiAppuntamento(LocalDate data, String orario, int durata, String nome, String luogo){
        Appuntamento appuntamento = new Appuntamento(data, orario, durata, nome, luogo);
        appuntamenti.add(appuntamento);
    }

    public int dimAppuntamenti(){
        return appuntamenti.size();
    }

}
