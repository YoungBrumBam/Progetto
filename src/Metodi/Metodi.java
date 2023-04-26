package Metodi;

import Moduli.Agenda;
import Moduli.Appuntamento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class Metodi {
    public ArrayList<Agenda> agende;

    public Metodi(ArrayList<Agenda> agende) {
        this.agende = agende;
    }

    public ArrayList<Agenda> getAgende() {
        return agende;
    }

    public int dimAgende(){
        return agende.size();
    }

    public int dimAppuntamenti(String n){
        for(Agenda agenda : this.agende){
            if(n.equals(agenda.getNome())) {
                return agenda.dimAppuntamenti();
            }
        }
        return 0;
    }
    public void stampaAgende(){
        int i = 1;
        for(Agenda agenda : agende){
            System.out.println(i + "\tNome: " + agenda.getNome());
            i++;
        }
    }

    public void stampaAppuntamenti(String n){
        int i = 1;
        for(Agenda agenda : this.agende){
            if(n.equals(agenda.getNome())) {
                for(Appuntamento appuntamento : agenda.getAppuntamenti()){
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
    public void aggiungiAgenda(String n){
        Agenda agenda = new Agenda(n);
        agende.add(agenda);
    }

    public void pulisciAgenda(String n){
        for(int i = 0; i < this.agende.size(); i++){
            if(n.equals(Agenda.getNome()))
            {
                Agenda agenda = this.agende.get(i);
                this.agende.remove(agenda);
            }
        }
    }
    public void appuntamentidaFile(String n){
        for(Agenda agenda : getAgende()) {
            if(n.equals(agenda.getNome())) {
                try {
                    FileReader fr = new FileReader("C:/Users/Admin/OneDrive/Desktop/appuntamenti.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String stringRead = br.readLine();

                    while (stringRead != null) {
                        StringTokenizer st = new StringTokenizer(stringRead, " ");
                        try {
                            String dataString = st.nextToken();
                            DateTimeFormatter sdt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate dataapp = LocalDate.parse(dataString,sdt);

                            String orario = st.nextToken();
                            int durata = Integer.parseInt(st.nextToken());
                            String nome = st.nextToken();
                            String luogo = st.nextToken();

                            agenda.aggiungiAppuntamento(dataapp, orario, durata, nome, luogo);
                            System.out.println("Appuntamento aggiunto correttamente\n");
                        } catch (NumberFormatException nfe) {
                            System.out.println("Appuntamento non aggiunto\n");
                        }
                        stringRead = br.readLine();
                    }
                    br.close();
                } catch (FileNotFoundException fnf) {
                    System.out.println("File non aperto correttamente\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Agenda non esistente\n");

            }
        }
    }
}
