package com.codeblizz.developer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.codeblizz.developer.model.Vehicles;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicles, String>{

	Optional<Vehicles> findRideByMake(String make);
	List<Vehicles> findAll(Vehicles ride);
	Optional<Vehicles> findRideByModel(String model);
	Optional<Vehicles> findRideByStats(String stats);
	Optional<Vehicles> findRideByVin(String vin);
	Optional<Vehicles> findRideByColor(String color);
	Optional<Vehicles> findRideByDescription(String description);
	Optional<Vehicles> findRideByPrice(Double price);
	Optional<Vehicles> findRideByDiscount(Double discount);
	Optional<Vehicles> findRideByLastChecked(String lastChecked);
	Optional<Vehicles> findRideByTorque(String torque);
	Optional<Vehicles> findRideByManYear(String manufacturerYear);
}
