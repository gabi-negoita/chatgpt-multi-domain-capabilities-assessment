package ro.ugal.master.converter;

import ro.ugal.master.chatgpt.model.Difficulty;
import ro.ugal.master.chatgpt.model.UserQueryConfidence;

import java.util.function.Function;

public class DifficultyToUserQueryConfidenceConverter implements Function<Difficulty, UserQueryConfidence> {

    @Override
    public UserQueryConfidence apply(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                return UserQueryConfidence.HIGH;
            case MEDIUM:
                return UserQueryConfidence.MEDIUM;
            case HARD:
                return UserQueryConfidence.LOW;
        }

        return null;
    }
}
