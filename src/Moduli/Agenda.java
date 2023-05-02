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
    public Appuntamento inputAppuntamento(){
        DateTimeFormatter sdt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

        Scanner scdata = new Scanner(System.in);
        String data = scdata.next();
        LocalDate datapp = LocalDate.parse(data,sdt);
        Scanner scorario = new Scanner(System.in);
        String orario = scorario.next();
        LocalTime orarioapp = LocalTime.parse(orario,dtf);
        Scanner scdurata = new Scanner(System.in);
        int durata = scdurata.nextInt();
        Scanner scnome = new Scanner(System.in);
        String nome = scnome.next();
        Scanner scluogo = new Scanner(System.in);
        String luogo = scluogo.next();
        Appuntamento appuntamento = new Appuntamento(datapp,orarioapp,durata,nome,luogo);
        return appuntamento;
    }

}
