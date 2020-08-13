package works.lionel.herokutest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public void postUser(User user){
        userRepository.save(user);
    }

    @GetMapping(path="/all")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path="/{name}")
    public User getUserByName(@PathVariable String name){
        return userRepository.findByName(name);
    }

    @GetMapping(path="/")
    public String getWelcome(){
        return "welcome to my backend";
    }

}
