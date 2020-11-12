package net.ambientia.challengeapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitChallenge {

    private static final Logger log = LoggerFactory.getLogger(InitChallenge.class);

    @Bean
    CommandLineRunner initChallenges(ChallengeRepository repository) {
        return args -> {
            log.info("Saving " + repository.save(new Challenge("challenge 1")));
            log.info("Saving " + repository.save(new Challenge("challenge 2")));
        };
    }
}
