package cdac.reposp1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdac.modelsp1.Gnoti;

@Repository
public interface Gnotirepo extends JpaRepository<Gnoti, Integer> {

}
