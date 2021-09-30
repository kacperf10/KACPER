package com.example.vehicle.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.vehicle.domain.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
