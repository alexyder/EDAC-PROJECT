package cdac.reposp1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdac.modelsp1.Stlogindbda;

@Repository
public interface LoginDbdarepo extends JpaRepository<Stlogindbda, Integer> {

}
