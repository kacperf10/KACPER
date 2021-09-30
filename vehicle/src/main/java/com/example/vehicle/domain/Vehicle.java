package com.example.vehicle.domain;

import java.util.HashSet;
import java.util.Optional;

import javax.persistence.*;

@Entity
@Table
public class Vehicle {

	@Id
	@SequenceGenerator(name = "vehicle_sequence")

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_sequence")
	private long ID;
	private String registrationNumber;
	private String make;
	private String model;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	Owner owner;

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner optional) {
		this.owner = optional;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public Vehicle(String registrationNumber, String make, String model, Owner owner) {
		this.owner = owner;
		this.registrationNumber = registrationNumber;
		this.make = make;
		this.model = model;

	}

	public Vehicle(Long id, String registrationNumber, String make, String model, Object owner) {

		this.ID = id;
		this.owner = (Owner) owner;

		this.registrationNumber = registrationNumber;
		this.make = make;
		this.model = model;

	}

	public Vehicle() {

	}

	@Override
	public String toString() {
		return "Vehicle [ID=" + ID + ", registrationNumber=" + registrationNumber + ", make=" + make + ", model="
				+ model + ", owner=" + owner + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ID ^ (ID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

}
