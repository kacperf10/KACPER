package com.example.vehicle.bootstrap;

import java.util.HashSet;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.vehicle.domain.Owner;
import com.example.vehicle.domain.Vehicle;
import com.example.vehicle.repositories.OwnerRepository;
import com.example.vehicle.repositories.VehicleRepository;

@Component
public class BootstrapData implements CommandLineRunner {
	private final OwnerRepository ownerRepository;
	private final VehicleRepository vehicleRepository;

	public BootstrapData(OwnerRepository ownerRepository, VehicleRepository vehicleRepository) {

		this.ownerRepository = ownerRepository;
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		Owner adam = new Owner("Adam", "Kowalski");
		Vehicle car1 = new Vehicle("WU434", "Opel", "Corsa", adam);
		Vehicle car2 = new Vehicle("WE1234", "Mitsubishi", "Lancer", adam);
		Owner kacper = new Owner("Kacper", "Fugas");
		ownerRepository.save(kacper);
		adam.getVehicles().add(car2);
		adam.getVehicles().add(car1);
		ownerRepository.save(adam);
		vehicleRepository.save(car2);

		vehicleRepository.save(car1);

		System.out.println("Started in Bootstrap");

		System.out.println(vehicleRepository.count() + " vehicles created");

		System.out.println(ownerRepository.count() + " owners created");

	}

}
