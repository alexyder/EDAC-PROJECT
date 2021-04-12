package cdac.reposp1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdac.modelsp1.Courses;

@Repository
public interface Coursesrepo extends JpaRepository<Courses, Integer> {

}
