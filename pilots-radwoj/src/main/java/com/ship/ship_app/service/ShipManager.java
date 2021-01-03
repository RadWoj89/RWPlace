package com.ship.ship_app.service;

import com.ship.ship_app.model.ShipGdansk;
import com.ship.ship_app.model.ShipGdynia;
import com.ship.ship_app.service.ports.PilociGdanskDecoder;
import com.ship.ship_app.service.ports.UnipilDecoder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ShipManager implements InitializingBean {
    private ShipRepositoryGdynia shipRepositoryGdynia;
    private ShipRepositoryGdansk shipRepositoryGdansk;
    private UnipilDecoder unipilDecoder;
    private PilociGdanskDecoder pilociGdanskDecoder;
    private List<ShipGdynia> lastUpdatedShipGdyniaList = new ArrayList<>();
    private List<ShipGdansk> lastUpdatedShipGdanskList = new ArrayList<>();


    @Autowired
    public ShipManager(ShipRepositoryGdynia shipRepositoryGdynia, ShipRepositoryGdansk shipRepositoryGdansk,
                       UnipilDecoder unipilDecoder, PilociGdanskDecoder pilociGdanskDecoder) {
        this.shipRepositoryGdynia = shipRepositoryGdynia;
        this.shipRepositoryGdansk = shipRepositoryGdansk;
        this.unipilDecoder = unipilDecoder;
        this.pilociGdanskDecoder = pilociGdanskDecoder;
    }

    public void updateAllChanges() throws IOException {

        List<ShipGdynia> newShipGdynias = new ArrayList<>(findDifferencesBetweenLastUpdatedListAndActualList().listOfNewShipGdynias);
        List<ShipGdansk> newShipGdansks = new ArrayList<>(findDifferencesBetweenLastUpdatedListAndActualList().listOfNewShipGdansks);
        List<ShipGdynia> outdatedShipGdynias = new ArrayList<>(findDifferencesBetweenLastUpdatedListAndActualList().listOfOutdatedShipGdynias);
        List<ShipGdansk> outdatedShipGdansks = new ArrayList<>(findDifferencesBetweenLastUpdatedListAndActualList().listOfOutdatedShipGdansks);
        for (ShipGdynia outdatedShipGdynia : outdatedShipGdynias) {
            System.out.println("removed: " + outdatedShipGdynia.getName());
            shipRepositoryGdynia.remove(outdatedShipGdynia.getId());
        }

        for (ShipGdansk outdatedShipGdansk : outdatedShipGdansks) {
            System.out.println("removed: " + outdatedShipGdansk.getName());
            shipRepositoryGdansk.remove(outdatedShipGdansk.getId());
        }

        for (ShipGdynia newShipGdynia : newShipGdynias) {
            System.out.println("added:   " + newShipGdynia.getName());
            shipRepositoryGdynia.update(newShipGdynia);
        }

        for (ShipGdansk newShipGdansk : newShipGdansks) {
            System.out.println("added:   " + newShipGdansk.getName());
            shipRepositoryGdansk.update(newShipGdansk);
        }

        lastUpdatedShipGdyniaList.addAll(newShipGdynias);
        lastUpdatedShipGdanskList.addAll(newShipGdansks);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }

    private ChangesInShips findDifferencesBetweenLastUpdatedListAndActualList() throws IOException {
        List<ShipGdynia> actualShipGdyniaList = unipilDecoder.getShipListGdynia();
        List<ShipGdansk> actualShipGdanskList = pilociGdanskDecoder.getShipListGdansk();
        ChangesInShips changesInShips = new ChangesInShips();

        for (ShipGdynia shipGdynia : actualShipGdyniaList) {
            if (lastUpdatedShipGdyniaList.contains(shipGdynia)) {
                changesInShips.listOfUnchangedShipGdynias.add(shipGdynia);
            } else {
                changesInShips.listOfNewShipGdynias.add(shipGdynia);
            }
        }

        for (ShipGdansk shipGdansk : actualShipGdanskList) {
            if (lastUpdatedShipGdanskList.contains(shipGdansk)) {
                changesInShips.listOfUnchangedShipGdansks.add(shipGdansk);
            } else {
                changesInShips.listOfNewShipGdansks.add(shipGdansk);
            }
        }

        for (ShipGdynia shipGdynia : lastUpdatedShipGdyniaList) {
            if (!actualShipGdyniaList.contains(shipGdynia)) {
                changesInShips.listOfOutdatedShipGdynias.add(shipGdynia);
            }
        }

        for (ShipGdansk shipGdansk : lastUpdatedShipGdanskList) {
            if (!actualShipGdanskList.contains(shipGdansk)) {
                changesInShips.listOfOutdatedShipGdansks.add(shipGdansk);
            }
        }
        return changesInShips;
    }

   static private class ChangesInShips {
        Set<ShipGdynia> listOfNewShipGdynias = new HashSet<>();
        Set<ShipGdynia> listOfOutdatedShipGdynias = new HashSet<>();
        Set<ShipGdynia> listOfUnchangedShipGdynias = new HashSet<>();

        Set<ShipGdansk> listOfNewShipGdansks = new HashSet<>();
        Set<ShipGdansk> listOfOutdatedShipGdansks = new HashSet<>();
        Set<ShipGdansk> listOfUnchangedShipGdansks = new HashSet<>();
    }
}
