package hello;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete and methods
public interface UserRepository extends CrudRepository<User, Long> {

}