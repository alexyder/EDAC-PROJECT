package cdac.reposp1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdac.modelsp1.Teacherlogin;

@Repository
public interface Loginteacherrepo extends JpaRepository<Teacherlogin, Integer> {

}
