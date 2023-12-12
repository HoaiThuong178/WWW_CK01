package vn.edu.iuh.fit.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.models.Post;
import vn.edu.iuh.fit.models.User;
import vn.edu.iuh.fit.repositories.PostRepository;
import vn.edu.iuh.fit.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserRepository userRepository;
    private PostRepository postRepository;

    @GetMapping()
    public String index(Model model
    ){
        List<User> users = userRepository.findAll();


        model.addAttribute("users", users);

        return "users/index";

    }

//    users/{id}/posts
    @GetMapping("/{id}/posts")
    public String posts(Model model, @PathVariable ("id") long id) {
        Optional<User> user = userRepository.findById(id);

        List<Post> posts=postRepository.findByAuthor(user.get());

        model.addAttribute("posts",posts);

        return "posts/post";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }

    @PostMapping
    public String addPost(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @PutMapping
    public String updatePost(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/add")
    public String addGet(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "users/Add";
    }
    @GetMapping("/{id}/update")
    public String updateGet(@PathVariable("id") Long id,Model model) {
        Optional<User> user = userRepository.findById(id);

        model.addAttribute("user", user.get());

        return "users/update";
    }
}
