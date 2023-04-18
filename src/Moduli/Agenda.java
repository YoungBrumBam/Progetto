package Moduli;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Agenda {
    public String nome;

    public Agenda(String nome) {
        this.nome = nome;
        ArrayList<Appuntamento> appuntamenti = new ArrayList<>();
    }

    public Appuntamento appuntamentoAggiungi(LocalDate data, LocalTime orario, int durata, String nome, String luogo){
        return new Appuntamento(data,orario,durata,nome,luogo);
    }


}
