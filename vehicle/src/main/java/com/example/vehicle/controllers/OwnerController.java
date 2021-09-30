package com.example.vehicle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vehicle.domain.Owner;
import com.example.vehicle.domain.Vehicle;
import com.example.vehicle.repositories.OwnerRepository;

@Controller
public class OwnerController {
	private final OwnerRepository ownerRepository;

	@Autowired
	public OwnerController(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@GetMapping("/addownerform")
	public String showAddForm(Owner owner) {
		return "owners/add";
	}
	
	@RequestMapping("/deleteowner/{id}")
	public String deleteVehicle(@PathVariable("id") String id) {

		ownerRepository.deleteById((long) Integer.parseInt(id));
		return "redirect:/owners";
	}

	@PostMapping("/addowner")
	public String addOwner(@Validated Owner owner, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "owners/add";
		}
		ownerRepository.save(owner);
		return "redirect:/owners";
	}

	@RequestMapping("/owners")
	public String getOwners(Model model) {
		if(ownerRepository.count()==0) return "redirect:/addownerform" ;
		model.addAttribute("owners", ownerRepository.findAll());
		return "owners/list";

	}

}
