package br.com.fiap.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.xml.bind.CycleRecoverable;

@Entity
@Table(name = "resposta")
public class Resposta implements Serializable, CycleRecoverable {

	private static final long serialVersionUID = 113L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private int id;

	@Column(name = "descricao")
	private String descricao;

	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigoquestao") // nome fisico da coluna no banco de dados
	private Questao questao;

	public String getDescricao() {
		return descricao;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setDescricao(String string) {
		descricao = string;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
    public Object onCycleDetected(CycleRecoverable.Context context) {
        Questao questao = new Questao();
        return questao;
    }		

}
