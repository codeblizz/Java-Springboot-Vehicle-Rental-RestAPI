package com.codeblizz.developer.controller;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeblizz.developer.model.Vehicles;
import com.codeblizz.developer.repository.VehicleRepository;

@RestController
@RequestMapping("/ride")
@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
public class VehicleController {

	@Autowired
	VehicleRepository vehicleRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
	
	@GetMapping("/all")
	private Collection<Vehicles> getAllRide(Vehicles ride){
		logger.info("Getting all ride: {}", ride);
		List<Vehicles> veh = vehicleRepo.findAll(ride);
		return veh;
	}
	@GetMapping("/{id}")
	private ResponseEntity<Vehicles> getRideById(@PathVariable String objectId) {
		logger.info("Getting ride by id", objectId);
		Optional<Vehicles> veh = vehicleRepo.findById(objectId);
		return veh.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/make")
	private ResponseEntity<Vehicles> getRideByMake(@PathVariable String make){
		logger.info("Getting ride by make: {}", make);
		Optional<Vehicles> veh = vehicleRepo.findRideByMake(make);
		return veh.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/model")
	private ResponseEntity<Vehicles> getRideByModel(@PathVariable String model){
		logger.info("Getting ride by model: {}", model);
		Optional<Vehicles> veh = vehicleRepo.findRideByModel(model);
		return veh.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/stats")
	private ResponseEntity<Vehicles> getRideByStats(@PathVariable String stats){
		logger.info("Getting ride by make: {}", stats);
		Optional<Vehicles> veh = vehicleRepo.findRideByStats(stats);
		return veh.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/vin")
	private ResponseEntity<Vehicles> getRideByVin(@PathVariable String vin){
		logger.info("Getting ride by model: {}", vin);
		Optional<Vehicles> veh = vehicleRepo.findRideByVin(vin);
		return veh.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/color")
	private ResponseEntity<Vehicles> getRideByColor(@PathVariable String color){
		logger.info("Getting ride by model: {}", color);
		Optional<Vehicles> veh = vehicleRepo.findRideByColor(color);
		return veh.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/description")
	private ResponseEntity<Vehicles> getRideByDescription(@PathVariable String description){
		logger.info("Getting ride by make: {}", description);
		Optional<Vehicles> veh = vehicleRepo.findRideByDescription(description);
		return veh.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/price")
	private ResponseEntity<Vehicles> getRideByPrice(@PathVariable Double price){
		logger.info("Getting ride by model: {}", price);
		Optional<Vehicles> veh = vehicleRepo.findRideByPrice(price);
		return veh.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/discount")
	private ResponseEntity<Vehicles> getRideByDiscount(@PathVariable Double discount){
		logger.info("Getting ride by model: {}", discount);
		Optional<Vehicles> veh = vehicleRepo.findRideByDiscount(discount);
		return veh.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/lastChecked")
	private ResponseEntity<Vehicles> getRideByLastChecked(@PathVariable String lastChecked){
		logger.info("Getting ride by make: {}", lastChecked);
		Optional<Vehicles> veh = vehicleRepo.findRideByLastChecked(lastChecked);
		return veh.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/torque")
	private ResponseEntity<Vehicles> getRideByTorque(@PathVariable String torque){
		logger.info("Getting ride by model: {}", torque);
		Optional<Vehicles> veh = vehicleRepo.findRideByTorque(torque);
		return veh.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/year")
	private ResponseEntity<Vehicles> getRideByDiscount(@PathVariable String manufacturerYear){
		logger.info("Getting ride by model: {}", manufacturerYear);
		Optional<Vehicles> veh = vehicleRepo.findRideByManYear(manufacturerYear);
		return veh.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
}
