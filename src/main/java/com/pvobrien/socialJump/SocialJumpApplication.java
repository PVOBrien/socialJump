package com.pvobrien.socialJump;

import com.pvobrien.socialJump.domain.Location;
import com.pvobrien.socialJump.domain.LocationRepository;
import com.pvobrien.socialJump.domain.User;
import com.pvobrien.socialJump.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SocialJumpApplication {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LocationRepository locationRepository;

    private static final Logger logger = LoggerFactory.getLogger(SocialJumpApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SocialJumpApplication.class, args);
        logger.info("Hello World!");
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {

            logger.info("In the runner now...");

            Location location1 = new Location("Washington", "agriculture");
            Location location2 = new Location("Silicon Valley", "tech");
            locationRepository.save(location1);
            locationRepository.save(location2);

            userRepository.save(new User("the Pal", 5, location1));
            userRepository.save(new User("the Gracie", 2, location1));
            userRepository.save(new User("the Shawn", 7, location2));
        };
    }
}
