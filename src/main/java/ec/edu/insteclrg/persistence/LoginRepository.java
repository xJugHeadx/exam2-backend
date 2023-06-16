package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
	
	 Login findByUser(String user);
}
