package dio.com.academia.DTO;

import java.time.LocalDate;

import javax.persistence.Column;

import dio.com.academia.entities.Aluno;

public class AlunoDTO {

	private Long id;

	private String nome;

	@Column(unique = true)
	private String cpf;

	private String bairro;

	private LocalDate dataDeNascimento;
	
	
	public AlunoDTO(){
		
	}


	public AlunoDTO(Long id, String nome, String cpf, String bairro, LocalDate dataDeNascimento) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.bairro = bairro;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public AlunoDTO(Aluno entity) {
		id = entity.getId();
		nome = entity.getNome();
		cpf = entity.getCpf();
		bairro = entity.getBairro();
		dataDeNascimento = entity.getDataDeNascimento();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}


	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	
	
	
}
