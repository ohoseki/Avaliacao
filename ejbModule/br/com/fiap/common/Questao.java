package br.com.fiap.common;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sun.xml.bind.CycleRecoverable;

@Entity
@Table(name = "questao")
public class Questao implements Serializable, CycleRecoverable {

	private static final long serialVersionUID = 112L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Integer id;

	@Column(name = "codigoavaliacao")
	private Integer codigoAvaliacao;

	@Column(name = "descricao")
	private String descricao;


	@OneToMany(targetEntity = Resposta.class, cascade = CascadeType.ALL, mappedBy = "questao",fetch = FetchType.EAGER)	
	private List<Resposta> respostas;
	

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	

	@Transient
	private Resposta respostaSelecionada;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String string) {
		descricao = string;
	}


	public Integer getCodigoAvaliacao() {
		return codigoAvaliacao;
	}

	public void setCodigoAvaliacao(Integer codigoAvaliacao) {
		this.codigoAvaliacao = codigoAvaliacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Resposta getRespostaSelecionada() {
		return respostaSelecionada;
	}

	public void setRespostaSelecionada(Resposta respostaSelecionada) {
		this.respostaSelecionada = respostaSelecionada;
	}

    public Object onCycleDetected(CycleRecoverable.Context context) {
        Resposta resposta = new Resposta();
        return resposta;
    }	
	
}
