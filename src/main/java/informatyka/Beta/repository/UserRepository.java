package informatyka.Beta.repository;

import informatyka.Beta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer>{

    User findByEmail(String email);
    Boolean findByAccountNumber(int accountNumber);
}
