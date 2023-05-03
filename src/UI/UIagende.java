package UI;

import Metodi.Metodi;
import Moduli.Agenda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UIagende {
    Metodi metodi;
    UIappuntamenti uIappuntamenti;
    public UIagende(Metodi metodi,UIappuntamenti uIappuntamenti) {
        this.metodi = metodi;
        this.uIappuntamenti = uIappuntamenti;
    }

    public void menuAgenda(){
        int scelta;
        Scanner scscelta = new Scanner(System.in);
        //Scanner sc = new Scanner(System.in);

        do {
            if(metodi.dimAgende() == 0){
                System.out.println("1) creare una nuova agenda vuota fornendone il nome\n" +
                        "0)TORNA AL MENU PRINCIPALE");
                scelta = scscelta.nextInt();
                switch(scelta){
                    case 1:
                        System.out.println("Inserisci nome della nuova aggenda: ");
                        String nomeagg = scscelta.next();
                        metodi.aggiungiAgenda(nomeagg);
                        break;
                    case 0:
                        break;
                    default:
                        scelta = 0;
                        break;
                }
            }else{
                System.out.println("1) creare una nuova agenda vuota fornendone il nome\n" +
                        "2) cancellare un agenda anche se sono presenti appuntamenti\n" +
                        "3) creare una nuova agenda leggendo gli appuntamenti da file\n" +
                        "4) scrivere un agenda su file\n" +
                        "5) stampa agende\n" +
                        "6) menu appuntamenti\n" +
                        "0) TORNA AL MENU PRINCIPALE\n" +
                        " scelta menu rubrica:");
                scelta = scscelta.nextInt();

                switch (scelta) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("Inserisci nome della nuova aggenda: ");
                        String nomeagg = scscelta.next();
                        metodi.aggiungiAgenda(nomeagg);
                        break;
                    case 2:
                        System.out.println("Inserisci nome della nuova aggenda: ");
                        String nomecanc = scscelta.next();
                        metodi.pulisciAgenda(nomecanc);
                        break;
                    case 3:
                        System.out.println("Inserisci nome della nuova aggenda: ");
                        String nomeagdafile = scscelta.next();
                        try {
                            metodi.appuntamentidaFile(nomeagdafile);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 4:
                        try {
                            metodi.scriviAgendaFile();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 5:
                        metodi.stampaAgende();
                        break;
                    case 6:
                        uIappuntamenti.menuAppuntamenti();
                        break;
                    default:
                        scelta = 0;
                        break;
                }
            }

        }while(scelta != 0);
    }

}
