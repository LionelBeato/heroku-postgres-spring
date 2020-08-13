package works.lionel.herokutest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/post")
    public void postUser(@RequestBody User user){
        userRepository.save(user);
    }

    @GetMapping("/all")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{name}")
    public User getUserByName(@PathVariable String name){
        return userRepository.findByName(name);
    }

    @GetMapping("/")
    public String getWelcome(){
        return "welcome to my backend";
    }

}
