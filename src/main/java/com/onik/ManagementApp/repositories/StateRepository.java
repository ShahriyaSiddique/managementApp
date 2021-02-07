package com.onik.ManagementApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onik.ManagementApp.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
