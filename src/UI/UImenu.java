package UI;

import Metodi.Metodi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UImenu {
    UIagenda uIagenda;

    public UImenu(UIagenda uIagenda) {
        this.uIagenda = uIagenda;
    }

    public void menu() throws IOException {
        Scanner sc = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("1)Menu agende\n0)Logout\nScelta menu:");
            scelta = sc.nextInt();
            switch (scelta) {
                case 0:
                    break;
                case 1:
                    uIagenda.menu();
                    break;
            }
        }while (scelta != 0) ;
    }
}

