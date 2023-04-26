package UI;

import Metodi.Metodi;
import Moduli.Agenda;

import java.util.ArrayList;
import java.util.Scanner;

public class UIagende {
    Agenda agenda;
    Metodi metodi;
    UImenu uImenu;
    public UIagende(Metodi metodi) {
        this.metodi = metodi;
    }

    public void menuAgenda(){
        int scelta;
        Scanner scscelta = new Scanner(System.in);
        do {
        System.out.println("1) creare una nuova agenda vuota fornendone il nome\n" +
                "2) cancellare un agenda anche se sono presenti appuntamentiInserire\n" +
                "3) creare una nuova agenda leggendo gli appuntamenti da file\n" +
                "4) scrivere un agenda su file\n" +
                "5) stampa agende\n" +
                "0) TORNA AL MENU PRINCIPALE\n" +
                " scelta menu rubrica:");
        scelta = scscelta.nextInt();
            switch (scelta) {
                case 1:
                    Scanner scnome = new Scanner(System.in);
                    System.out.println("Inserisci nome della nuova aggenda: ");
                    String n = scnome.next();
                    metodi.aggiungiAgenda(n);
                    metodi.stampaAgende();
                    break;
                case 2:
                    break;
                default:
                    scelta = 0;
                    break;
            }
        }while(scelta != 0);
    }

}
