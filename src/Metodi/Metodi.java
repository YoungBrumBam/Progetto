package Metodi;

import Moduli.Agenda;
import Moduli.Appuntamento;

import java.io.*;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Metodi {
    public ArrayList<Agenda> agende;

    public Metodi(ArrayList<Agenda> agende) {
        this.agende = agende;
    }

    public ArrayList<Agenda> getAgende() {
        return agende;
    }

    public int dimAgende() {
        return agende.size();
    }

    public int dimAppuntamenti(String n) {
        for (Agenda agenda : this.agende) {
            if (n.equals(agenda.getNome())) {
                return agenda.dimAppuntamenti();
            }
        }
        return 0;
    }

    public void stampaAgende() {
        int i = 1;
        for (Agenda agenda : agende) {
            System.out.println(i + "\tNome: " + agenda.getNome());
            i++;
        }
    }

    public void stampaAppuntamenti(String n) {
        int i = 1;
        for (Agenda agenda : this.agende) {
            if (n.equals(agenda.getNome())) {
                for (Appuntamento appuntamento : agenda.appuntamenti) {
                    System.out.println(i + "\tData: " + appuntamento.getData() +
                            "\tOrario: " + appuntamento.getOrario() +
                            "\tDurata: " + appuntamento.getDurata() +
                            "\tNome: " + appuntamento.getNome() +
                            "\tLuogo: " + appuntamento.getLuogo() + "\n");
                    i++;

                }
            }
        }
    }

    public void aggiungiAgenda(String n) {
        Agenda agenda = new Agenda(n);
        agende.add(agenda);
        if (n.equals(agenda.getNome())) {
            System.out.println("Agenda aggiunta correttamente\n");
        }
    }

    public void pulisciAgenda(String n) {
        for (int i = 0; i < this.agende.size(); i++) {
            if (n.equals(agende.get(i).getNome())) {
                Agenda agenda = this.agende.get(i);
                this.agende.remove(agenda);
            }
        }
    }

    public void appuntamentidaFile(String n) throws IOException {
        for (Agenda agenda : getAgende()) {
            if (n.equals(agenda.getNome())) {
                try {
                    FileReader fr = new FileReader("./appuntamenti.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String stringRead = br.readLine();

                    while (stringRead != null) {
                        StringTokenizer st = new StringTokenizer(stringRead, " ");
                        try {
                            String dataString = st.nextToken();
                            //DateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
                            DateTimeFormatter sdt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //mi stampa la data al contrario yyyy/MM/dd
                            LocalDate dataapp = LocalDate.parse(dataString, sdt);
                            //LocalDate dataapp = LocalDate.parse(st.nextToken());
                            //String dataString = sdt.format(dataapp);

                            String orarioString = st.nextToken();
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
                            LocalTime orarioapp = LocalTime.parse(orarioString, dtf);

                            int durata = Integer.parseInt(st.nextToken());
                            String nome = st.nextToken();
                            String luogo = st.nextToken();

                            agenda.aggiungiAppuntamento(dataapp, orarioapp, durata, nome, luogo);
                            System.out.println("Appuntamento aggiunto correttamente\n");
                        } catch (NumberFormatException nfe) {
                            System.out.println("Appuntamento non aggiunto\n");
                        }
                        stringRead = br.readLine();
                    }
                    br.close();
                } catch (FileNotFoundException fnf) {
                    System.out.println("File non aperto correttamente\n");
                }
            } else {
                System.out.println("Agenda non esistente\n");

            }
        }
    }

    public void scriviAgendaFile() throws IOException {
        int i = 0;
        try {
            FileWriter fw = new FileWriter("./agenda.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Agenda agenda : this.agende) {
                bw.newLine();
                bw.write(agenda.getNome() + "\n");
                for (Appuntamento appuntamento : agenda.getAppuntamenti()) {
                    if (agenda.getAppuntamenti() != null) {
                        bw.write("Data: " + appuntamento.getData() +
                                "\tOrario: " + appuntamento.getOrario() +
                                "\tDurata: " + appuntamento.getDurata() +
                                "\tNome: " + appuntamento.getNome() +
                                "\tLuogo: " + appuntamento.getLuogo() + "\n");
                    } else {
                        bw.write("Non ci sono appuntamenti per questa agenda\n");
                    }
                }
                i++;
            }
            bw.flush();
            bw.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("File non trovato\n");
        }
    }

    public int verificaOrario(LocalDate data, LocalTime orario, int durata) {
        int check = 0;
        for (Agenda agenda : agende) {
            for (Appuntamento appuntamento : agenda.appuntamenti) {
                if (!agenda.appuntamenti.isEmpty()) {
                    if (data.equals(appuntamento.getData())) {
                        LocalTime orariofineapp = orario.plus(durata, ChronoUnit.MINUTES);
                        LocalTime orariofineappesist = appuntamento.getOrario().plus(appuntamento.getDurata(), ChronoUnit.MINUTES);
                        if (!orario.equals(appuntamento.getOrario())) {
                            if (orario.isAfter(appuntamento.getOrario()) && orariofineapp.isAfter(orariofineappesist)) {
                                check = 1;
                            }
                            else{
                                check = 0;
                            }
                            if (orario.isBefore(appuntamento.getOrario()) && orariofineapp.isBefore(orariofineappesist)) {
                                check = 1;
                            }
                            else{
                                check = 0;
                            }
                        }
                    }
                }
            }
        }
        return check;
    }

    public int agendaVuota(){
        int check = 0;
        for(Agenda agenda : agende){
            for(Appuntamento appuntamento : agenda.appuntamenti){
                if(dimAppuntamenti(agenda.getNome()) == 0){
                    check = 0;
                }
                else{
                    check = 1;
                }
            }
        }
        return check;
    }
    public void aggiungiAppuntamento(String n, LocalDate data, LocalTime orario, int durata, String nome, String luogo) {
        //Scanner scnome = new Scanner(System.in);
        //System.out.println("Inserire nome dell'agenda a cui si vuole aggiungere l'appuntamento:");
        //String n = scnome.next();

        for (Agenda agenda : agende) {
            for(Appuntamento appuntamento : agenda.appuntamenti){
                if(n.equals(appuntamento.getNome())){
                    if(agenda.appuntamenti.isEmpty() && agendaVuota() == 0){
                        agenda.aggiungiAppuntamento(data,orario,durata,nome,luogo);
                        break;
                    }
                    if(verificaOrario(data,orario,durata) == 1){
                        agenda.aggiungiAppuntamento(data,orario,durata,nome,luogo);
                        break;
                    }
                    else{
                        System.out.println("Appuntamento in conflitto con un altro\n");
                    }
                }

            }
        }
    }

    public void modificaAppuntamento(String n,LocalDate data, LocalTime orario, int durata, String nome, String luogo){
        boolean checkorario = false;
        Appuntamento appmod = new Appuntamento(data,orario,durata,nome,luogo);
        for (Agenda agenda : agende) {
            for (Appuntamento appuntamento : agenda.appuntamenti) {
                if (!agenda.appuntamenti.isEmpty()) {
                    if (!appmod.equals(appuntamento)) {
                        LocalTime orariofineapp = orario.plus(durata, ChronoUnit.MINUTES);
                        LocalTime orariofineappesist = appuntamento.getOrario().plus(appuntamento.getDurata(), ChronoUnit.MINUTES);
                        if (orario.isAfter(appuntamento.getOrario()) || orariofineapp.isBefore(orariofineappesist)) {
                            checkorario = true;
                        } else {
                            System.out.println("Appuntamento si sovrappone a un altro\n");
                        }
                    }
                }
            }
        }
        if (checkorario) {
            for (Agenda agenda : agende) {
                for(Appuntamento appuntamento : agenda.appuntamenti){
                    if (n.equals(agenda.getNome())) {
                        //if(data.equals(appuntamento.getData()) && orario.equals(appuntamento.getOrario()) && durata==appuntamento.getDurata() && )
                        if(appuntamento.equals(appmod)) {
                            appuntamento.setData(data);
                            appuntamento.setDurata(durata);
                            appuntamento.setLuogo(luogo);
                            appuntamento.setOrario(orario);
                            appuntamento.setNome(nome);
                            System.out.println("Appuntamento modificato\n");
                        }
                    }
                }
            }
        }
    }
}
