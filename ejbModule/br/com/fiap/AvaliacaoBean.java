package br.com.fiap;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fiap.common.Questao;

@Stateless
@Remote(Avaliacao.class)
@WebService

public class AvaliacaoBean implements Avaliacao, Serializable {

	private static final long serialVersionUID = 61L;
	@PersistenceContext(name = "Avaliacao")
	private EntityManager em;

	public List<Questao> obterQuestoes(int codigoAvaliacao) {
		// Espera retornar a questao e em seguida as respostas

		List<Questao> avaliacao = em.createQuery("from Questao que where que.codigoAvaliacao=:pCodigoAvaliacao")
				.setParameter("pCodigoAvaliacao", codigoAvaliacao).getResultList();
		return avaliacao;

	}

	@Remove
	public void removerEJB() {
		System.out.println("Removendo instancia deste EJB.");
	}

}
