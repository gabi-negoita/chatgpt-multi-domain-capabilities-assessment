package ro.ugal.master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.ugal.master.database.entity.UserQueryResult;

@Repository
public interface UserQueryRepository extends JpaRepository<UserQueryResult, String> {
}
