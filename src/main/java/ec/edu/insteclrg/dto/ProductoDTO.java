package ec.edu.insteclrg.dto;

import lombok.Data;

@Data
public class ProductoDTO {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private CategoriaDTO category;
}
