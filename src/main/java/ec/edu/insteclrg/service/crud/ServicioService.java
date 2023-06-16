package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import ec.edu.insteclrg.domain.Servicio;
import ec.edu.insteclrg.dto.ServicioDTO;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

public class ServicioService extends GenericCrudServiceImpl<Servicio, ServicioDTO>{

	@Override
	public Optional<Servicio> find(ServicioDTO dto) {
		return Optional.empty();
	}

	@Override
	public ServicioDTO mapToDto(Servicio domain) {
		return null;
	}

	@Override
	public Servicio mapToDomain(ServicioDTO dto) {
		return null;
	}

}
