package dio.com.academia.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "tb_matriculas")
public class Matricula {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	private LocalDateTime dataDaMatricula = LocalDateTime.now();

	public Matricula() {
	}

	public Matricula(Long id, LocalDateTime dataDaMatricula) {
		this.id = id;
		this.dataDaMatricula = dataDaMatricula;
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

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
