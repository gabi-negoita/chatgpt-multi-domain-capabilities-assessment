package ro.ugal.master.service;

import org.springframework.stereotype.Service;
import ro.ugal.master.database.entity.UserQueryResult;
import ro.ugal.master.repository.UserQueryRepository;

import java.util.List;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserQueryRepository repository;

    public UserQueryServiceImpl(UserQueryRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserQueryResult save(UserQueryResult entity) {
        return repository.save(entity);
    }

}
