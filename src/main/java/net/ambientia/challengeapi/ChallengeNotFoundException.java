package net.ambientia.challengeapi;

public class ChallengeNotFoundException extends RuntimeException {
    ChallengeNotFoundException(Long id) {
        super("could not find challenge " + id);
    }
}
