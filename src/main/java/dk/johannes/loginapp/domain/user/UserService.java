package dk.johannes.loginapp.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public User getUserByName(String username){
        User userByName = userRepository.findByUsername(username);
        return userByName;
    }

    public List<User> getAllUsers(){
        List<User> all = userRepository.findAll();
        return all;
    }

    public void createUser(UserDTO userDTO){
        String encode = encoder.encode(userDTO.getPassword());

        User user = new User(encode, userDTO.getUsername());
        userRepository.save(user);
    }
}
