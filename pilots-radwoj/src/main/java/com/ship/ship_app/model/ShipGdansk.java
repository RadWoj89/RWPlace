package com.ship.ship_app.model;

import com.github.fabiomaffioletti.firebase.document.FirebaseDocument;
import com.github.fabiomaffioletti.firebase.document.FirebaseId;

@FirebaseDocument("/Gdansk")
public class ShipGdansk {
    @FirebaseId
    private String id;
    private String name;
    private String date;
    private String time;
    private String info;

    private String departurePlace;
    private String arrivalPlace;

    public ShipGdansk() {
    }

    public ShipGdansk(String id, String name, String date, String time, String info, String departurePlace, String arrivalPlace) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.info = info;
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (this == object) {
            return true;
        }

        if (object instanceof ShipGdansk) {
            ShipGdansk shipGdanskDetails = (ShipGdansk) object;
            if (name.equals(shipGdanskDetails.name) && info.equals(shipGdanskDetails.info) && time.equals(shipGdanskDetails.time)
            && date.equals(shipGdanskDetails.date)) {
                return true;
            }
        }
        return false;
    }
}
