package cdac.reposp3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdac.modelsp3.Myfiles;

@Repository
public interface Myfilesrepo extends JpaRepository<Myfiles, Integer> {

	List<Myfiles> findByCourse(String course);

}
