package com.project.library.service;

import com.project.library.model.Blacklist;
import com.project.library.model.Transactions;
import com.project.library.repository.BlackListRepository;
import com.project.library.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlackListService {
    @Autowired
    private BlackListRepository blackListRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    public Blacklist addBlackList(Long userId){

        Transactions transaction=new Transactions(
                "add_blackList",
                new java.sql.Date(new java.util.Date().getTime()),
                "completed",
                userId
        );
        transactionsRepository.save(transaction);

        Blacklist blacklist =new Blacklist(userId,new java.sql.Date(new java.util.Date().getTime()));
        System.out.println(blacklist.getUserId());

        return  blackListRepository.save(blacklist);
    }
    public Blacklist removeBlackListUser(Long userId){

                Transactions transaction=new Transactions(
                        "remove_blacklist",
                        new java.sql.Date(new java.util.Date().getTime()),
                        "completed",
                        userId
                );
        transactionsRepository.save(transaction);
        return blackListRepository.deleteByUserId(userId);
    }
    public Boolean isBlackListedUser(Long userId){
        return blackListRepository.countByUserId(userId) != 0;
    }
}
