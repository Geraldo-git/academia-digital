package dio.com.academia.DTO;

import java.time.LocalDateTime;

import dio.com.academia.entities.Matricula;

public class MatriculaDTO {

	private Long id; 
	private LocalDateTime dataDaMatricula = LocalDateTime.now();
	
	public MatriculaDTO() {
		
	}

	public MatriculaDTO(Long id, LocalDateTime dataDaMatricula) {
		this.id = id;
		this.dataDaMatricula = dataDaMatricula;
	}
	
	public MatriculaDTO(Matricula entity) {
		id = entity.getId();
		dataDaMatricula = entity.getDataDaMatricula();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataDaMatricula() {
		return dataDaMatricula;
	}

	public void setDataDaMatricula(LocalDateTime dataDaMatricula) {
		this.dataDaMatricula = dataDaMatricula;
	}

	
	
	
	
	
}
