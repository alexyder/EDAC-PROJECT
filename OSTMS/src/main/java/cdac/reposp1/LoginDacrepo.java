package cdac.reposp1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdac.modelsp1.Stlogindac;

@Repository
public interface LoginDacrepo extends JpaRepository<Stlogindac, Integer> {

}
