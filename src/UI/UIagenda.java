package UI;

import Metodi.Metodi;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class UIagenda {
    UIappuntamento uIappuntamento;
    Metodi metodi;

    public UIagenda(Metodi metodi , UIappuntamento uIappuntamento) {
        this.metodi = metodi;
        this.uIappuntamento = uIappuntamento;
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int scelta;
        do {
            if (metodi.dimAgende() == 0) {
                System.out.println("1) creare una nuova agenda vuota fornendone il nome\n" +
                        "0)TORNA AL MENU PRINCIPALE\nScelta menu:");
                scelta = sc.nextInt();
                switch (scelta) {
                    case 1:
                        metodi.aggiungiAgenda();
                        break;
                    case 0:
                        break;
                    default:
                        scelta = 0;
                        break;
                }
            } else {
                System.out.println("1) creare una nuova agenda vuota fornendone il nome\n" +
                        "2) cancellare un agenda anche se sono presenti appuntamenti\n" +
                        "3) creare una nuova agenda leggendo gli appuntamenti da file\n" +
                        "4) scrivere un agenda su file\n" +
                        "5) stampa agende\n" +
                        "6) menu appuntamenti\n" +
                        "0) TORNA AL MENU PRINCIPALE\n" +
                        " scelta menu rubrica:");
                scelta = sc.nextInt();

                switch (scelta) {
                    case 0:
                        break;
                    case 1:
                        metodi.aggiungiAgenda();
                        break;
                    case 2:
                        metodi.pulisciAgenda();
                        break;
                    case 3:
                        try {
                            metodi.appuntamentidaFile();
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
                        uIappuntamento.menu();
                        break;
                    default:
                        scelta = 0;
                        break;
                }
            }
            System.out.println("\n\n\n");
        } while (scelta != 0);
    }
}
