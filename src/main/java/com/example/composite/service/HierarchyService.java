package com.example.composite.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.example.composite.domain.Hierarchy;
import com.example.composite.repository.HierarchyRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("hierarchyService")
@Transactional
public class HierarchyService {

    HierarchyRepository hierarchyRepository;

    public HierarchyService(HierarchyRepository hierarchyRepository) {
        this.hierarchyRepository = hierarchyRepository;
    }

    public Hierarchy save(Hierarchy hierarchy) {
        return hierarchyRepository.save(hierarchy);         
    }

    public Page<Hierarchy> findAll(Pageable pageable) {
        return hierarchyRepository.findAll(pageable);
    }

    public Optional<Hierarchy> findOne(Integer id) {
        return hierarchyRepository.findById(id);
    }

    public void delete(Integer id) {
        hierarchyRepository.deleteById(id);
    }    
}