package Moduli;

import java.time.LocalDate;
import java.util.Date;

public class Appuntamento {
    public LocalDate data;
    public String orario;
    public int durata;
    public String nome,luogo;

    public Appuntamento(LocalDate data, String orario, int durata, String nome, String luogo) {
        this.data = data;
        this.orario = orario;
        this.durata = durata;
        this.nome = nome;
        this.luogo = luogo;
    }
    public LocalDate getData() {
        return data;
    }

    public String getOrario() {
        return orario;
    }

    public int getDurata() {
        return durata;
    }

    public String getNome() {
        return nome;
    }

    public String getLuogo() {
        return luogo;
    }


}
