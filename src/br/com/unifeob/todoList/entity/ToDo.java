package br.com.unifeob.todoList.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class ToDo {

	private Long id;
	private String descricao;
	private Calendar dataTermino;
	private String concluida;
	private String favorita;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}

	@Column(columnDefinition="default 'N'")
	public String getConcluida() {
		return concluida;
	}

	public void setConcluida(String concluida) {
		if(concluida != null){
			this.concluida = concluida;
		}else{
			this.concluida = "N";
		}
	}
	
	@Column(columnDefinition="default 'N'")
	public String getFavorita() {
		return favorita;
	}
	
	public void setFavorita(String favorita) {
		if(favorita != null){
			this.favorita = favorita;
		}else{
			this.favorita = "N";
		}
		this.favorita = favorita;
	}

}
