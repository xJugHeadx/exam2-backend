package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.Login;
import ec.edu.insteclrg.dto.LoginDTO;
import ec.edu.insteclrg.persistence.LoginRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class LoginService extends GenericCrudServiceImpl<Login, LoginDTO>{
	@Autowired
	private LoginRepository loginRepository; 
	@Override
	public Optional<Login> find(LoginDTO dto) {
		return Optional.empty();
	}

	@Override
	public LoginDTO mapToDto(Login domain) {
		return null;
	}

	@Override
	public Login mapToDomain(LoginDTO dto) {
		return null;
	}
	public Login findbyUsername(String user) {
		return loginRepository.findByUser(user);
	}

	}
