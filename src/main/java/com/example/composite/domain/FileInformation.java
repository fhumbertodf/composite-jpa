package com.example.composite.domain;

//import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("FI")
public class FileInformation extends Hierarchy {

    private static final long serialVersionUID = 1L;

    //@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    //@JoinTable(name = "FILEINFORMATION_JOIN_FOLDER", joinColumns = @JoinColumn(name = "filelocation_id"), inverseJoinColumns = @JoinColumn(name = "folder_ID"))
    //private Hierarchy parent;

    @Override
    public String toString() {
        return "FileInformation " + super.toString();
    }
}
