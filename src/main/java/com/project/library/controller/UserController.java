package com.project.library.controller;

import com.project.library.service.UsersService;
import com.project.library.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController

public class UserController {

    @Autowired
    private UsersService service;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    // Kullanıcı ekleme
    @PostMapping("/user/add")
    public CompletableFuture<Users> addUser(@RequestBody Users users) {
        return CompletableFuture.supplyAsync(() -> service.saveUser(users), taskExecutor);
    }

    // Birden fazla kullanıcı ekleme
    @PostMapping("/user/add/multiple")
    public CompletableFuture<List<Users>> addProducts(@RequestBody List<Users> users) {
        return CompletableFuture.supplyAsync(() -> service.saveUsers(users), taskExecutor);
    }

    // Kullanıcı sayısını alma
    @GetMapping("/user/count")
    public CompletableFuture<Long> getCountOfProducts() {
        return CompletableFuture.supplyAsync(() -> service.countUser(), taskExecutor);
    }

    // Tüm kullanıcıları getirme
    @GetMapping("/user/list")
    public CompletableFuture<List<Users>> findAllUsers() {
        return CompletableFuture.supplyAsync(() -> service.getUsers(), taskExecutor);
    }

    // Belirli bir ID'ye sahip kullanıcıyı getirme
    @GetMapping("/user/id/{id}")
    public CompletableFuture<Users> findUserById(@PathVariable long id) {
        return CompletableFuture.supplyAsync(() -> service.getUserById(id), taskExecutor);
    }

    // İsimle kullanıcıyı getirme
    @GetMapping("/user/name/{firstName}")
    public CompletableFuture<Users> findUserByName(@PathVariable String firstName) {
        return CompletableFuture.supplyAsync(() -> service.GetUserByFirstName(firstName), taskExecutor);
    }

    // Kullanıcı güncelleme
    @PutMapping("/user/update")
    public CompletableFuture<Users> updateUser(@RequestBody Users users) {
        return CompletableFuture.supplyAsync(() -> service.updateUser(users), taskExecutor);
    }

    // Kullanıcı silme
    @DeleteMapping("/user/delete/{id}")
    public CompletableFuture<String> deleteProduct(@PathVariable long id) {
        return CompletableFuture.supplyAsync(() -> service.deleteUser(id), taskExecutor);
    }
}
