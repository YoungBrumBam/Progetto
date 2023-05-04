package UI;

import Metodi.Metodi;

import java.lang.reflect.Member;
import java.util.Scanner;

public class UIappuntamento {

    Metodi metodi;

    public UIappuntamento(Metodi metodi) {
        this.metodi = metodi;
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int scelta;
            System.out.println("1)Aggiungi appuntamento ad agenda\n" +
                    "2)Modifica dati di un appuntamento\n" +
                    "3)Cerca appuntamento\n" +
                    "4)Elenco appuntamenti ordinati\n" +
                    "Scelta menu:");
            scelta = sc.nextInt();
            switch (scelta) {
                case 1:
                    metodi.aggiungiAppuntamento();
                    break;
                case 2:
                    metodi.modificaAppuntamento();
                    break;
                case 3:
                    System.out.println("1)Cerca appuntamenti per data\n" +
                            "2)Cerca appuntamenti per nome\n" +
                            "Inserire scelta:");
                    scelta = sc.nextInt();
                    switch (scelta) {
                        case 1:
                            metodi.stampaAppuntamentidanome();
                            break;
                        case 2:
                            metodi.stampaAppuntamentidadata();
                            break;
                        default:
                            break;
                    }
                    break;
                case 4:
                    metodi.ordina();
                    break;
                default:
                    break;
            }
        System.out.println("\n\n\n");
        System.out.println("\n\n\n");
        System.out.println("\n\n\n");
    }
}
