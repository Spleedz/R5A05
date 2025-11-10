package demo.user.controller;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.user.modele.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public void addUser(String name, String pwd, String role) {
        User u = new User(name, pwd, role);
        u.setName(name);
        u.setPwd(pwd);
        u.setRole(role);
        userRepository.save(u.toData());
    }

    public Collection<User> getAllUsers() {
        return userRepository.findAll().stream().map(User::new).collect(Collectors.toList());
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id).map(User::new);
    }
}
