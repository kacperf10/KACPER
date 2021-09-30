package com.example.vehicle.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.vehicle.domain.Owner;
import com.example.vehicle.domain.Vehicle;
import com.example.vehicle.repositories.OwnerRepository;

import com.example.vehicle.repositories.VehicleRepository;

@Controller
public class VehicleController {
	private final VehicleRepository vehicleRepository;
	private final OwnerRepository ownerRepository;

	@Autowired
	public VehicleController(VehicleRepository vehicleRepository, OwnerRepository ownerRepository) {
		this.vehicleRepository = vehicleRepository;
		this.ownerRepository = ownerRepository;
	}

	@RequestMapping("/")
	public String goHome() {
		return "home";
	}

	@GetMapping("/addvehicleform")
	public String showAddForm(Vehicle vehicle, Model model) {
		if(ownerRepository.count()==0) return "redirect:/owners";
		model.addAttribute("owners", ownerRepository.findAll());
		return "vehicles/add";
	}

	@RequestMapping("/deletevehicle/{id}")
	public String deleteVehicle(@PathVariable("id") String id) {

		vehicleRepository.deleteById((long) Integer.parseInt(id));
		return "redirect:/vehicles";
	}

	@PostMapping("/addvehicle")
	public String addVehicle(@Validated Vehicle vehicle, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "vehicles/add";
		}

		vehicleRepository.save(vehicle);
		return "redirect:/vehicles";
	}

	@GetMapping("/vehicles")
	public String getVehicles(Model model) {
		if(vehicleRepository.count()==0) return "redirect:/addvehicleform";
		model.addAttribute("vehicles", vehicleRepository.findAll());
		return "vehicles/list";

	}

}
