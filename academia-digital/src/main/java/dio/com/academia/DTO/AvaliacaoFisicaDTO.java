package dio.com.academia.DTO;

import java.time.LocalDateTime;

import dio.com.academia.entities.AvaliacaoFisica;

public class AvaliacaoFisicaDTO {

	private Long id;

	private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

	private double peso;

	private double altura;

	public AvaliacaoFisicaDTO() {

	}

	public AvaliacaoFisicaDTO(Long id, LocalDateTime dataDaAvaliacao, double peso, double altura) {
		this.id = id;
		this.dataDaAvaliacao = dataDaAvaliacao;
		this.peso = peso;
		this.altura = altura;
	}

	public AvaliacaoFisicaDTO(AvaliacaoFisica entity) {
		id = entity.getId();
		dataDaAvaliacao = entity.getDataDaAvaliacao();
		peso = entity.getPeso();
		altura = entity.getAltura();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataDaAvaliacao() {
		return dataDaAvaliacao;
	}

	public void setDataDaAvaliacao(LocalDateTime dataDaAvaliacao) {
		this.dataDaAvaliacao = dataDaAvaliacao;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

}
