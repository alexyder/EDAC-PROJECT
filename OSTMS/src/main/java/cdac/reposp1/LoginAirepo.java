package cdac.reposp1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdac.modelsp1.Stloginai;

@Repository
public interface LoginAirepo extends JpaRepository<Stloginai, Integer> {

}
