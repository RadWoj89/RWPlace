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
public class PilociGdanskDecoder implements DecoderInterface {

    @Override
    public List<ShipGdansk> getShipListGdansk() throws IOException {

        List<ShipGdansk> shipGdanskList = new ArrayList<>();
        String[] tempTable;
        Document doc = Jsoup.connect("http://www.gdanskpilot.pl/0/index.php?content=traffic").get();
        Element table = doc.select("table").get(0);
        Elements rows = table.select("tr");

        String stream = rows.toString().replace("<td>",";").replace("</td>","")
                .replace("<tr>","").replace("</tr>","").replace("\n","")
                .replace(".","").replace("-", "");
        tempTable = stream.split(";");
        ShipGdansk shipGdansk = null;

        for (int i = 1; i < tempTable.length; i = i + 7) {
            shipGdansk = new ShipGdansk();
            shipGdansk.setDate(tempTable[i]);
            shipGdansk.setTime(" " + tempTable[i + 2]);
            shipGdansk.setInfo(tempTable[i + 1]);
            shipGdansk.setName(tempTable[i + 3]);
            shipGdansk.setDeparturePlace(tempTable[i + 5]);
            shipGdansk.setArrivalPlace(tempTable[i + 6]);
            shipGdansk.setId(shipGdansk.getDate() + shipGdansk.getTime() + shipGdansk.getInfo() + shipGdansk.getName() + shipGdansk.getArrivalPlace());
            //System.out.println(shipGdansk.getName());
            shipGdanskList.add(shipGdansk);
        }
        return shipGdanskList;
    }

    @Override
    public List<ShipGdynia> getShipListGdynia() throws IOException {
        return null;
    }
}
