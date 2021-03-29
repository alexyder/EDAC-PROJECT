package cdac.reposp1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cdac.modelsp1.Queries;

@Repository
public interface Queriesrepo extends JpaRepository<Queries, Integer> {

	@Query("from Queries where prn = :x")
	List<Queries> findmyquery(@Param("x") int prn);

	@Transactional
	@Modifying
	@Query("update Queries set reply = :r where qid = :q")
	int replydone(@Param("q") int qid, @Param("r") String reply);

}
