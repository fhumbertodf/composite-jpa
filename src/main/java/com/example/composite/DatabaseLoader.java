package com.example.composite;

import java.util.Date;

import com.example.composite.domain.FileInformation;
import com.example.composite.domain.Folder;
import com.example.composite.service.FolderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    FolderService folderService;

    @Override
    public void run(String... args) throws Exception {

        Folder h1 = new Folder();
        h1.setName("home");
        h1.setDataCriacao(new Date());

        h1 = folderService.save(h1);

        Folder h2 = new Folder();
        h2.setName("user.name");
        h2.setDataCriacao(new Date());

        folderService.add(h1.gethId(), h2);
        
        FileInformation f1 = new FileInformation();
        f1.setName("relatorio.pdf");
        f1.setDataCriacao(new Date());

        folderService.add(h2.gethId(), f1);

        System.out.println(f1);
    }

}
