
import Metodi.Metodi;
import UI.UIagenda;
import UI.UIappuntamento;
import UI.UImenu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Metodi metodi = new Metodi();
        UIappuntamento uIappuntamento = new UIappuntamento(metodi);
        UIagenda uIagenda = new UIagenda(metodi,uIappuntamento);
        UImenu uImenu = new UImenu(uIagenda);
        uImenu.menu();
    }
}