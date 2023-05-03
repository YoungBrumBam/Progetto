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
import java.util.*;


public class Metodi {
    public ArrayList<Agenda> agende;

    public Metodi() {
        this.agende = new ArrayList<>();
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

    public void aggiungiAppuntamentodanome(String n, Appuntamento appagg){
        for(Agenda agenda : agende){
            if(n.equals(agenda.getNome())){
                agenda.aggiungiAppuntamento(appagg);
            }
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
                            Appuntamento appuntamento = new Appuntamento(dataapp, orarioapp, durata, nome, luogo);
                            agenda.aggiungiAppuntamento(appuntamento);
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

    public boolean verificaOrario(Appuntamento appcontr, Appuntamento appuntamento) {
        if (appcontr.getData().equals(appuntamento.getData())) {
            LocalTime orariofineapp = appcontr.getOrario().plus(appcontr.getDurata(), ChronoUnit.MINUTES);
            LocalTime orariofineappesist = appuntamento.getOrario().plus(appuntamento.getDurata(), ChronoUnit.MINUTES);
            if (appcontr.getOrario().equals(appuntamento.getOrario())) {
                return false;
            }
            return appcontr.getOrario().isAfter(orariofineappesist) && orariofineapp.isBefore(appuntamento.getOrario());
        }
        return true;
    }

    public boolean agendeVuote(){
        for(Agenda agenda : agende){
            if(agenda.dimAppuntamenti() != 0){
                return false;
            }
        }
        return true;
    }
    public void aggiungiAppuntamento(String n, LocalDate data, LocalTime orario, int durata, String nome, String luogo) {
        Appuntamento appagg = new Appuntamento(data,orario,durata,nome,luogo);
        boolean checkorario = false;
        if(agendeVuote()){
            checkorario = true;
        }else{
            for(Agenda agenda : agende){
                for(Appuntamento appuntamento : agenda.appuntamenti){
                    checkorario = verificaOrario(appagg,appuntamento);
                }
            }
        }

        if(checkorario){
            aggiungiAppuntamentodanome(n,appagg);
        }
        else{
            System.out.println("Appuntamento in conflitto\n");
        }
    }

    public void modificaAppuntamento(String n,LocalDate data, LocalTime orario, int durata, String nome, String luogo){
        Appuntamento appmod = new Appuntamento(data, orario, durata, nome, luogo);
        boolean checkorario = false;
        for(Agenda agenda : agende){
            for(Appuntamento appuntamento : agenda.appuntamenti){
                if(!appmod.getData().equals(appuntamento.getData()) || !appmod.getNome().equals(appuntamento.getNome()) || !appmod.getLuogo().equals(appuntamento.getLuogo())){
                    checkorario = verificaOrario(appmod,appuntamento);
                }
            }
        }
        for (Agenda agenda : agende) {
            for(Appuntamento appuntamento : agenda.appuntamenti){
                if (checkorario) {
                    if (n.equals(agenda.getNome())) {
                        if (appmod.getData().equals(appuntamento.getData()) && appmod.getNome().equals(appuntamento.getNome()) && appmod.getLuogo().equals(appuntamento.getLuogo())) {
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

    public void stampaAppuntamentidanome(String n){
        for(Agenda agenda : agende){
            for(Appuntamento appuntamento : agenda.appuntamenti){
                if(n.equals(appuntamento.getNome())){
                    agenda.stampaAppuntamento(appuntamento);
                }
            }
        }
    }

    public void stampaAppuntamentidadata(String dataString){
        DateTimeFormatter sdt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //mi stampa la data al contrario yyyy/MM/dd
        LocalDate dataapp = LocalDate.parse(dataString, sdt);
        for(Agenda agenda : agende){
            for(Appuntamento appuntamento : agenda.appuntamenti){
                if(dataapp.equals(appuntamento.getData())){
                    agenda.stampaAppuntamento(appuntamento);
                }
            }
        }
    }

    public void ordina(String n){
        ArrayList<Appuntamento> appuntamenticonf = new ArrayList<>();

        for(Agenda agenda : agende){
            if(n.equals(agenda.getNome())){
                appuntamenticonf.addAll(agenda.appuntamenti);
            }
        }

        for(Agenda agenda : agende){
            if(n.equals(agenda.getNome())){
                for(int i = 0; i < appuntamenticonf.size()-1; i++){
                    int min = i;
                    for(int j = i + 1; j < appuntamenticonf.size(); j++){
                        if(appuntamenticonf.get(min).getData().isAfter( appuntamenticonf.get(j).getData())){
                            min = j;
                        }
                    }
                    if(min != i){
                        Appuntamento temp = new Appuntamento(appuntamenticonf.get(min).getData(),appuntamenticonf.get(min).getOrario(),appuntamenticonf.get(min).getDurata(),appuntamenticonf.get(min).getNome(),appuntamenticonf.get(min).getLuogo());
                        appuntamenticonf.set(min,appuntamenticonf.get(i));
                        appuntamenticonf.set(i,temp);
                    }
                }
            }
        }
        for (Appuntamento appuntamento : appuntamenticonf) {
            System.out.println("Data: " + appuntamento.getData() +
                    "\tOrario: " + appuntamento.getOrario() +
                    "\tDurata: " + appuntamento.getOrario() +
                    "\tNome: " + appuntamento.getNome() +
                    "\tLuogo: " + appuntamento.getLuogo());
        }

    }
}


