package com.onik.ManagementApp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onik.ManagementApp.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
