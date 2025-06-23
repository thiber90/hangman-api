package hangman.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttemptRepository extends JpaRepository<AttemptEntity, Long> {
    @Query("SELECT a FROM AttemptEntity a JOIN a.game g WHERE g.name = :name")
    List<AttemptEntity> findAttemptsByGameName(@Param("name") String name);
}