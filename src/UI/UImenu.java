package UI;

import Metodi.Metodi;

import java.util.ArrayList;
import java.util.Scanner;

public class UImenu {
    Metodi metodi = new Metodi(new ArrayList<>());
    UIagende uIagende = new UIagende(metodi);
    UIappuntamenti uIappuntamenti = new UIappuntamenti();


    public void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1)Menu agende\n2)Menu appuntamenti\n3)Logout\nScelta menu:");
        int scelta = sc.nextInt();
        while(scelta != 3){
            switch (scelta){
                case 1:
                    uIagende.menuAgenda();
                    break;
                case 2:
                    uIappuntamenti.menuAppuntamenti();
                    break;
                default:
                    break;
            }
        }
    }
}
