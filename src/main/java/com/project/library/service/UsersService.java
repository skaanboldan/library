package com.project.library.service;

import com.project.library.repository.UsersRepository;
import com.project.library.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository repository;

    // Kullanıcıyı kaydetme
    public Users saveUser(Users users){
        return repository.save(users);
    }

    // Kullanıcıları kaydetme
    public List<Users> saveUsers(List<Users> users){
        return repository.saveAll(users);
    }

    // Tüm kullanıcıları getirme
    public List<Users> getUsers (){
        return repository.findAll();
    }

    // Belirli bir ID'ye sahip kullanıcıyı getirme
    public Users getUserById (long id){
        return repository.findById(id).orElse(null);
    }

    // İsimle kullanıcıyı getirme
    public Users GetUserByFirstName (String name){
        return repository.findByName(name);
    }

    // Kullanıcıyı silme
    public String deleteUser(Long id) {
        repository.deleteById(id);
        return "user deleted, id: "+id;
    }

    // Kullanıcıyı güncelleme
    public Users updateUser(Users users){
        try{
            Users existingUser = repository.findById(users.getId()).orElse(null);

            assert existingUser != null;
            existingUser.setName((users.getName()));
            return repository.save(existingUser);

        }
        catch (NullPointerException e ){
            e.printStackTrace();
        }

        return null;
    }

    // Kullanıcı sayısını sayma
    public  long countUser(){
        return repository.count();
    }
}
