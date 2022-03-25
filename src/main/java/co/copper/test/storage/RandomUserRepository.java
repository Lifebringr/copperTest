package co.copper.test.storage;

import co.copper.test.datamodel.RandomUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RandomUserRepository extends CrudRepository<RandomUser,Long> {

}
