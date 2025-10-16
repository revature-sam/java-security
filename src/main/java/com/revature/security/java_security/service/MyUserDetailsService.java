package com.revature.security.java_security.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import java.util.ArrayList;
import com.revature.security.java_security.repo.UserRepo;
import com.revature.security.java_security.model.UserPrincipal;
import com.revature.security.java_security.model.Users;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService {
    @Autowired
    private UserRepo userRepo;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }
}
