package security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class UserAuth {
    @Autowired
    UserServices transactionAuthorityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public MyBankUsers save(@RequestBody MyBankUsers transactionAuthority){
        transactionAuthority.setPassword(passwordEncoder.encode(transactionAuthority.getPassword()));
        return transactionAuthorityService.signUp(transactionAuthority);
    }

}