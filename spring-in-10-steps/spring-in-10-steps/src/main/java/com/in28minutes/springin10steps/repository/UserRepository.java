package com.in28minutes.springin10steps.repository;

import com.in28minutes.springin10steps.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Repository
public class UserRepository {

    private static List<User> users=new ArrayList<>();

    private static int  usercount=3;

    static {
        users.add(new User(1,"Nishant",new Date()));
        users.add(new User(2,"Prashant",new Date()));
        users.add(new User(3,"Suresh",new Date()));

    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if (user.getId()==null)
            user.setId(++usercount);
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for (User user:users){
            if (user.getId()==id){
                return user;
            }


        }
        return null;
    }


}
