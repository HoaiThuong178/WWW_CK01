package vn.edu.iuh.fit;

import com.thedeanda.lorem.Lorem;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.models.Post;
import vn.edu.iuh.fit.models.User;
import vn.edu.iuh.fit.repositories.PostRepository;
import vn.edu.iuh.fit.repositories.UserRepository;

import java.time.Instant;
import java.time.LocalDateTime;

@SpringBootApplication
@AllArgsConstructor
public class Ck1Application {
    private UserRepository userRepository;
    private PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ck1Application.class, args);
    }

    @Bean
    public CommandLineRunner hoaithuong(){
        return args -> {
            for (int i = 0; i < 3; i++) {
//                User user=new User(Instant.now(),"pass "+ i);
                User user = new User(Lorem.getPhone(), LocalDateTime.now(), Lorem.getLastName(), Lorem.getWords(10), Lorem.getWords(5), LocalDateTime.now(), "a", Lorem.getFirstName(), Lorem.getFirstName(), Lorem.getPhone() + "gmail.com");

                userRepository.save(user);
                for (int j = 0; j < 3; j++) {
                    Post post=new Post(true,Instant.now(),"title "+j,user);
                    postRepository.save(post);
                }
            }
        };
    }
}
