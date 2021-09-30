package com.example.vehicle.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class Owner {

	@Id
	@SequenceGenerator(name = "owner_sequence", allocationSize = 1)

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_sequence")
	private long ID;
	private String firstName;
	private String lastName;

	@OneToMany(mappedBy = "owner", orphanRemoval = true)
	private Set<Vehicle> vehicles = new HashSet<>();

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Owner(String firstName, String lastName) {

		this.firstName = firstName;
		this.lastName = lastName;

	}

	public Owner() {
	}

	@Override
	public String toString() {
		return "Owner [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", vehicles=" + vehicles
				+ "]";
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
		Owner other = (Owner) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

}
