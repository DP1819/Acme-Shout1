
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Shout;

@Repository
public interface ShoutRepository extends JpaRepository<Shout, Integer> {

	// Queries

	@Query("select count(s) from Shout s")
	Integer numberShouts();

	@Query("select count(s) from Shout s where length(s.text) <= 25")
	Integer numberShortShouts();

	@Query("select count(s) from Shout s where length(s.text) > 25")
	Integer numberLongShouts();

}
