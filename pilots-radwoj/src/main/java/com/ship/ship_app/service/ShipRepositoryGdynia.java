package com.ship.ship_app.service;

import com.github.fabiomaffioletti.firebase.repository.DefaultFirebaseRealtimeDatabaseRepository;
import com.ship.ship_app.model.ShipGdynia;
import org.springframework.stereotype.Repository;

@Repository
public class ShipRepositoryGdynia extends DefaultFirebaseRealtimeDatabaseRepository<ShipGdynia, String> {
}

