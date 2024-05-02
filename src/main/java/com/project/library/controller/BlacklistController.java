package com.project.library.controller;

import com.project.library.model.Blacklist;
import com.project.library.model.Book;
import com.project.library.service.BlackListService;
import com.project.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlacklistController {

     @Autowired
     private BlackListService service;


    @PostMapping("/blacklist/add/{userId}")
    public Blacklist addBlacklist(@PathVariable long userId){
        System.out.println(userId);
        return service.addBlackList(userId);
    }

}
