package ec.edu.insteclrg.controller.v1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.domain.Servicio;
import ec.edu.insteclrg.dto.ApiResponseDTO;
import ec.edu.insteclrg.dto.ServicioDTO;
import ec.edu.insteclrg.service.crud.ServicioService;

@RestController
@RequestMapping("/api/v1.0/servicio")
public class ServiceController {
	
	@Autowired
	ServicioService service;
	
	@PostMapping
	public ResponseEntity<Object> guardar(@RequestBody ServicioDTO dto) {
		service.save(dto);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<Object> listar() {
		List<ServicioDTO> list = service.findAll(new ServicioDTO());
		if (!list.isEmpty()) {
			ApiResponseDTO<List<ServicioDTO>> response = new ApiResponseDTO<>(true, list);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping
	public ResponseEntity<Object> actualizar(@RequestBody ServicioDTO dto) {
	    Optional<Servicio> domain = service.find(dto);
	    if (domain.isPresent()) {
	        Servicio servicio = service.mapToDomain(dto);
	        servicio.setNombre(dto.getName());
	        
	        service.save(dto);
	        
	        return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@GetMapping(path = "{id}")
	public ResponseEntity<Object> buscar(@PathVariable Long id) {
		ServicioDTO dto = new ServicioDTO();
		dto.setId(id);
		Optional<Servicio> domain = service.find(dto);
		if (domain.isPresent()) {
			dto = service.mapToDto(domain.get());
			return new ResponseEntity<>(new ApiResponseDTO<>(true, dto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
			}
		}
	
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<Object> eliminar(@PathVariable Long id) {
		Optional<Servicio> domain = service.find(new ServicioDTO());
		if (domain.isPresent()) {
			service.delete(null);
			return new ResponseEntity<>(new ApiResponseDTO<>(true, null), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ApiResponseDTO<>(false, null), HttpStatus.NOT_FOUND);
		}
	}

}
