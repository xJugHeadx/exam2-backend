package ec.edu.insteclrg.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.domain.Login;
import ec.edu.insteclrg.dto.ApiResponseDTO;
import ec.edu.insteclrg.dto.LoginDTO;
import ec.edu.insteclrg.service.crud.LoginService;

@RestController
@RequestMapping("/api/v1.0/login")
public class LoginController {
	@Autowired
	LoginService service;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO) {
		Login user = service.findbyUsername(loginDTO.getUsername());

		if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
			return new ResponseEntity<>(new ApiResponseDTO<>(true, "Inicio de sesión exitoso"), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, "Credenciales de inicio de sesion invalidos"), HttpStatus.UNAUTHORIZED);
		}
	}
}
