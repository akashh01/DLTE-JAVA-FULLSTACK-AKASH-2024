package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class UserCalls {
    @Autowired
    userServices service;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public MyUsers save(@RequestBody MyUsers myUsers){
        myUsers.setPassword(passwordEncoder.encode(myUsers.getPassword()));
        return service.signUp(myUsers);
    }
}