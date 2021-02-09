package com.example.composite;

import java.util.Date;

import com.example.composite.domain.FileInformation;
import com.example.composite.domain.Folder;
import com.example.composite.service.HierarchyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    HierarchyService hierarchyService;

    @Override
    public void run(String... args) throws Exception {
        
        Folder h1 = new Folder();
        h1.setName("home");
        h1.setDataCriacao(new Date());

        Folder h2 = new Folder();
        h2.setName("user.name");
        h2.setDataCriacao(new Date());

       h1.add(h2);

        FileInformation f1 = new FileInformation();
        f1.setName("relatorio.pdf");
        f1.setDataCriacao(new Date());

        h2.add(f1);

        hierarchyService.save(h1);

        System.out.println(h1.getChildren("/home/user.name/relatorio.pdf"));
    }
    
}
