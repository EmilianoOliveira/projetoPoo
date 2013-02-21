package br.ufpb.jogo;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class JogoTest {

	Ranking rank;
	Player jogador1;

	@Before
	public void setUp() throws Exception {

		jogador1 = new Player();
		rank = new Ranking();
	}

	@Test
	public void testaAdicionaJogadorNoRanking() {
		rank.adicionarJogador("Chico", 0);
		try {
			Player p = rank.pesquisarJogador("Chico");
			assertTrue(p.getNome().equals("Chico") && p.getPontuacao() == 0);
		} catch (JogadorInexistenteException e) {
			fail("Exceção não deveria ser lançada");
		}
	}

	public void testeContemJogadorNoRanking() {

		rank.adicionarJogador("Joao", 0);
		rank.adicionarJogador("Maria", 0);

		try {
			Player p1 = rank.pesquisarJogador("Joao");
			Player p2 = rank.pesquisarJogador("Maria");
			assertEquals("Joao", p1.getNome());
			assertTrue(p2.getNome().equals("Maria"));
		} catch (JogadorInexistenteException e) {
			fail("Exceção não deveria ser lançada");
		}
		try {
			Player p3 = rank.pesquisarJogador("Carlos");
			fail("Deveria ter lançado a exceção!");
		} catch (JogadorInexistenteException e) {
			// TESTE DEU CERTO
		}

	}
	
	public void testaMudaPontuacaoDoPlayer(){
		
		rank.adicionarJogador("Jose", 0);
		
		try{
			Player p1 = rank.mudarPontuacao("Jose",54);
			assertTrue(p1.getPontuacao()==54);
		} catch (JogadorInexistenteException e){
			fail("Nao deveria lançar a Exceção");
		}
	}
}
