package com.ship.ship_app.service;

import com.github.fabiomaffioletti.firebase.repository.DefaultFirebaseRealtimeDatabaseRepository;
import com.ship.ship_app.model.ShipGdansk;
import org.springframework.stereotype.Repository;

@Repository
public class ShipRepositoryGdansk extends DefaultFirebaseRealtimeDatabaseRepository<ShipGdansk, String> {
}
