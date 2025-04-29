package org.example.lr3tps.repository;

import org.example.lr3tps.dbModel.StationClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<StationClass, Integer> {
}
