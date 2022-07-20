package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.Category;
import ec.edu.insteclrg.dto.CategoriaDTO;
import ec.edu.insteclrg.persistence.CategoryRepository;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class CategoryService extends GenericCrudServiceImpl<Category, CategoriaDTO> {

	@Autowired
	private CategoryRepository repository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public Optional<Category> find(CategoriaDTO dto) {
		return repository.findById(dto.getId());
	}

	@Override
	public CategoriaDTO mapToDto(Category domain) {
		return modelMapper.map(domain, CategoriaDTO.class);
	}

	@Override
	public Category mapToDomain(CategoriaDTO dto) {
		return modelMapper.map(dto, Category.class);
	}

}
