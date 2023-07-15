package ro.ugal.master;

import ro.ugal.master.database.entity.UserQueryResult;
import ro.ugal.master.user.UserQueryResponse;

import java.util.function.Function;

import static ro.ugal.master.StringUtils.sanitizeString;

public class UserQueryResponseToUserQueryResultConverter implements Function<UserQueryResponse, UserQueryResult> {

    @Override
    public UserQueryResult apply(UserQueryResponse userQueryResponse) {
        return UserQueryResult.builder()
                .id(userQueryResponse.getId())
                .title(userQueryResponse.getTitle())
                .input(userQueryResponse.getInput())
                .inputType(userQueryResponse.getInputType().getValue())
                .result(userQueryResponse.getResult())
                .output(sanitizeString(userQueryResponse.getOutput()))
                .rating(userQueryResponse.getRating().getValue())
                .comment(userQueryResponse.getComment())
                .reference(userQueryResponse.getReference().getValue())
                .confidence(userQueryResponse.getConfidence().getValue())
                .timestamp(userQueryResponse.getTimestamp())
                .model(userQueryResponse.getModel().getValue())
                .build();
    }

}
