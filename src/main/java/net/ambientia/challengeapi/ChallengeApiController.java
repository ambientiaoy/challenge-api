package net.ambientia.challengeapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChallengeApiController {

    private final ChallengeRepository repository;

    ChallengeApiController(ChallengeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/challenges")
    List<Challenge> all() {
        return repository.findAll();
    }

    @PostMapping("/challenges")
    Challenge newEmployee(@RequestBody Challenge challenge) {
        return repository.save(challenge);
    }

    @GetMapping("/challenges/{id}")
    Challenge one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ChallengeNotFoundException(id));
    }

    @PutMapping("/challenges/{id}")
    Challenge replaceEmployee(@RequestBody Challenge newChallenge, @PathVariable Long id) {

        return repository.findById(id)
                .map(challenge -> {
                    challenge.setName(newChallenge.getName());
                    return repository.save(challenge);
                })
                .orElseGet(() -> {
                    newChallenge.setId(id);
                    return repository.save(newChallenge);
                });
    }

    @DeleteMapping("/challenges/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
