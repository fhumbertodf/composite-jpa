package com.example.composite.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("F")
public class Folder extends Hierarchy {

    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "FOLDER_JOIN_FILELOCATION", joinColumns = {
            @JoinColumn(name = "folder_id") }, inverseJoinColumns = { @JoinColumn(name = "file_information_id") })
    private List<Hierarchy> children = new ArrayList<Hierarchy>();
    
    //@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    //@JoinTable(name = "FOLDER_JOIN_FOLDER", joinColumns = @JoinColumn(name = "parent_folder_id"), inverseJoinColumns = @JoinColumn(name = "folder_ID"))
    //private Hierarchy parent;

    public void add(Hierarchy hierarchy) {
        children.add(hierarchy);
    }

    public void remove(Hierarchy hierarchy) {
        children.remove(hierarchy);
    }

    public List<Hierarchy> getChildren() {
        return children;
    }

    public Hierarchy getChildren(String path) {
        Hierarchy result = null;
        List<Hierarchy> atual = new ArrayList<>();
        atual.add(this);
        for(String str : path.split("/")) {
            for(Hierarchy hie : atual) {
                if(str.equals(hie.getName())) {
                    result = hie;
                    if(hie instanceof Folder) {
                        atual = ((Folder)hie).getChildren();
                    }
                } 
            }
            
        }
        return result;
    }

    @Override
    public String toString() {
        return "Folder " + super.toString();
    }    
}
