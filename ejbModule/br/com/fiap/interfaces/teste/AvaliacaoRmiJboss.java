package br.com.fiap.interfaces.teste;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.Avaliacao;
import br.com.fiap.common.Questao;

public class AvaliacaoRmiJboss {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "192.168.0.27:1099");

		Context context;
		try {
			context = new InitialContext(props);

			Avaliacao avaliacao = (Avaliacao) context.lookup("AvaliacaoBean/remote");

			List<Questao> questao = avaliacao.obterQuestoes(1);

			for (int i = 0; i < questao.size(); i++) {

				if (i == 0) {

					System.out.println("*******Avaliacao " + (i + 1) + "**********");

				}

				System.out.println((i + 1) + "-" + questao.get(i).getDescricao());

				for (int z = 0; z < questao.get(i).getRespostas().size(); z++) {
					System.out.println("     " + (z + 1) + "-" + questao.get(i).getRespostas().get(z).getDescricao());
				}

				if (i == questao.size() - 1) {

					System.out.println("*******Final da Avaliacao " + (i) + "**********");

				}

			}

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
