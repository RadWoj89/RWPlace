import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

class Mechanika {

    private Mechanika mech = new Mechanika();
    private List<Rectangle> listaKwadratow = new ArrayList<>();
    int i = 0;

    Rectangle kwadratWskaznik() {
        return new Rectangle();
    }

    void zbieranieKwadratow() {
        if (mech.kwadratWskaznik().getLayoutY() < 360)
        listaKwadratow.add(i, new Rectangle());

    }

    void wykrycieKolizji() {

    }

}
