package Moduli;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appuntamento {
    public LocalDate data;
    public LocalTime orario;
    public int durata;
    public String nome,luogo;

    public Appuntamento(LocalDate data, LocalTime orario, int durata, String nome, String luogo) {
        this.data = data;
        this.orario = orario;
        this.durata = durata;
        this.nome = nome;
        this.luogo = luogo;
    }
    public LocalDate getData() {
        return data;
    }

    public LocalTime getOrario() {
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

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setOrario(LocalTime orario) {
        this.orario = orario;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }
}
