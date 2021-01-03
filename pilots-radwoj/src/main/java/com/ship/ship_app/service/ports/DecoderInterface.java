package com.ship.ship_app.service.ports;


import com.ship.ship_app.model.ShipGdansk;
import com.ship.ship_app.model.ShipGdynia;

import java.io.IOException;
import java.util.List;

public interface DecoderInterface {
    public List<ShipGdynia> getShipListGdynia() throws IOException;
    public List<ShipGdansk> getShipListGdansk() throws IOException;
}
