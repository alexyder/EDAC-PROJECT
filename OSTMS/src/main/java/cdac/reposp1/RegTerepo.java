package cdac.reposp1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdac.modelsp1.Teacherregister;

@Repository
public interface RegTerepo extends JpaRepository<Teacherregister, Integer> {

}
