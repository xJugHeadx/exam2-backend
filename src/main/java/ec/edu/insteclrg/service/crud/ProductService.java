package ec.edu.insteclrg.service.crud;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.insteclrg.domain.Product;
import ec.edu.insteclrg.dto.ProductoDTO;
import ec.edu.insteclrg.service.GenericCrudServiceImpl;

@Service
public class ProductService extends GenericCrudServiceImpl<Product, ProductoDTO> {

	@Override
	public Optional<Product> find(ProductoDTO dto) {
		return Optional.empty();
	}

	@Override
	public ProductoDTO mapToDto(Product domain) {
		return null;
	}

	@Override
	public Product mapToDomain(ProductoDTO dto) {
		return null;
	}
}
