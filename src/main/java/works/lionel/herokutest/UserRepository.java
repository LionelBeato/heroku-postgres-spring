package works.lionel.herokutest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<EndUser, Long> {
    EndUser findByName(String name);
}
