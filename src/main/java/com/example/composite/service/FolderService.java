package com.example.composite.service;

import javax.transaction.Transactional;

import com.example.composite.domain.Folder;
import com.example.composite.domain.Hierarchy;
import com.example.composite.repository.HierarchyRepository;

import org.springframework.stereotype.Service;

@Service("folderService")
@Transactional
public class FolderService {

    HierarchyRepository hierarchyRepository;

    public FolderService(HierarchyRepository hierarchyRepository) {
        this.hierarchyRepository = hierarchyRepository;
    }

    public Folder save(Folder folder) {
        if (folder.gethId() == null) {
            return hierarchyRepository.save(folder);
        } else {
            return null;
        }
    }

    public void add(Integer hierarchyId, Hierarchy hierarchy) {
        Hierarchy hie = hierarchyRepository.findById(hierarchyId).get();
        Folder fo = null;        
        if (hie instanceof Folder) {
            fo = (Folder) hie;
            fo.add(hierarchy);
        }        
    }
}
