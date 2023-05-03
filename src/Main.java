
import Metodi.Metodi;
import Moduli.Agenda;
import UI.UIagende;
import UI.UIappuntamenti;
import UI.UImenu;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        Metodi metodi = new Metodi();
        UIappuntamenti uIappuntamenti = new UIappuntamenti(metodi);
        UIagende uIagende = new UIagende(metodi,uIappuntamenti);
        UImenu uImenu = new UImenu(uIagende);
        uImenu.menu();
    }
}