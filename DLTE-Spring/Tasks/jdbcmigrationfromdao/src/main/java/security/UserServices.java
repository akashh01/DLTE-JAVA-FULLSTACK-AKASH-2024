package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServices implements UserDetailsService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MyBankUsers signUp(MyBankUsers myUsers){
        int ack = jdbcTemplate.update("insert into user_auth values(?,?,?,?,?,?)",new Object[]{
                myUsers.getUsername(),
                myUsers.getPassword(),
                myUsers.getRole(),
                myUsers.getAddress(),
                myUsers.getContact(),
                myUsers.getEmail()
        });
        return myUsers;
    }

    public MyBankUsers findByUsername(String username){
        MyBankUsers officials = jdbcTemplate.queryForObject("select * from user_auth where username=?",
                new Object[]{username},new BeanPropertyRowMapper<>(MyBankUsers.class));
        return officials;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyBankUsers officials = findByUsername(username);
        if(officials==null)
            throw new UsernameNotFoundException(username);
        return officials;
    }
}
