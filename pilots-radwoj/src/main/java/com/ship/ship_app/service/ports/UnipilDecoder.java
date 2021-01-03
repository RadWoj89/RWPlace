package com.ship.ship_app.service.ports;

import com.ship.ship_app.model.ShipGdansk;
import com.ship.ship_app.model.ShipGdynia;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UnipilDecoder implements DecoderInterface {

    @Override
    public List<ShipGdynia> getShipListGdynia() throws IOException {

        List<ShipGdynia> shipGdyniaList = new ArrayList<>();
        String[] tempTable;
        Document doc = Jsoup.connect("https://www.unipil.pl/?a=ruch").get();
        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");

        String stream = rows.toString().replace("<td class=\"data\">", ";").replace("<td>", ";")
                .replace("</td>", "").replace("<tr>", "").replace("</tr>", "")
                .replace("\n", "").replace(".", "");
        tempTable = stream.split(";");
        ShipGdynia shipGdynia = null;

        for (int i = 1; i < tempTable.length; i = i + 7) {
            shipGdynia = new ShipGdynia();
            shipGdynia.setDate(tempTable[i]);
            shipGdynia.setTime(" " + tempTable[i + 2]);
            shipGdynia.setInfo(tempTable[i + 1]);
            shipGdynia.setName(tempTable[i + 3]);
            shipGdynia.setDeparturePlace(tempTable[i + 5]);
            shipGdynia.setArrivalPlace(tempTable[i + 6]);
            shipGdynia.setId(shipGdynia.getDate() + shipGdynia.getTime() + shipGdynia.getInfo() + shipGdynia.getName() + shipGdynia.getArrivalPlace());
            System.out.println(shipGdynia.getName());
            shipGdyniaList.add(shipGdynia);
        }
        return shipGdyniaList;
    }

    @Override
    public List<ShipGdansk> getShipListGdansk() throws IOException {
        return null;
    }
}