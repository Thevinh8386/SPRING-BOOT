package com.example.btvnbuoi4.repository;

import com.example.btvnbuoi4.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<SchoolClass, Integer> {
}
