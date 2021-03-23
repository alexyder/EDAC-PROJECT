package cdac.reposp2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cdac.modelsp2.Cnoti;

@Repository
public interface Cnotirepo extends JpaRepository<Cnoti, Integer> {

	@Query("from Cnoti where course = :x")
	List<Cnoti> findbycourse(@Param("x") String course);

}
