package com.example.composite.repository;

import com.example.composite.domain.Hierarchy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HierarchyRepository extends JpaRepository<Hierarchy, Integer> {

}
