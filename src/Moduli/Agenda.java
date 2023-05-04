package Moduli;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Agenda {
    public String nome;

    public ArrayList<Appuntamento> appuntamenti;

    public Agenda(String nome) {
        this.nome = nome;
        appuntamenti = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public ArrayList<Appuntamento> getAppuntamenti(){
        return appuntamenti;
    }

    public void aggiungiAppuntamento(Appuntamento appagg){
        appuntamenti.add(appagg);
    }

    public int dimAppuntamenti(){
        return appuntamenti.size();
    }

    public void stampaAppuntamento(Appuntamento appuntamento){
        System.out.println("Data: " + appuntamento.getData() +
                "\tOrario: " + appuntamento.getOrario() +
                "\tDurata: " + appuntamento.getDurata() +
                "\tNome: " + appuntamento.getNome() +
                "\tLuogo: " + appuntamento.getLuogo() + "\n");
    }


}
