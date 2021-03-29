package cdac.reposp1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdac.modelsp1.Sturegister;

@Repository
public interface RegStrepo extends JpaRepository<Sturegister, Integer> {

}
