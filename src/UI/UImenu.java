package UI;

import Metodi.Metodi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UImenu {
UIagende uIagende;

    public UImenu(UIagende uIagende) {
        this.uIagende = uIagende;
    }

    public void menu() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1)Menu agende\n0)Logout\nScelta menu:");
        int scelta = sc.nextInt();
        do{
            /*
            if (scelta == 1) {
                uIagende.menuAgenda();
            }*/

            switch (scelta) {
                case 0:
                    break;
                case 1:
                    uIagende.menuAgenda();
                    break;
                default:
                    scelta = 0;
                    break;
            }
        }while (scelta != 0);
    }
}
