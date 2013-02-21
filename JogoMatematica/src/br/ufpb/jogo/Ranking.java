package br.ufpb.jogo;


import java.io.IOException;
import java.util.*;

public class Ranking {

	private GravadorRanking gravador = new GravadorRanking();
	private List <Player> jogadores;

	public Ranking(){
		this.jogadores = new ArrayList <Player>();
		gravador = new GravadorRanking();
		carregaJogadores();
	}
		

	private void gravaJogadores(){
		try{
			gravador.gravaJogadores(jogadores);
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}
		
	}	
	
	
	
	private void carregaJogadores(){
		try{
			jogadores = gravador.leJogadores();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			this.jogadores = new ArrayList<Player>();
		}
	}
	
    public void adicionarJogador(String nome, int pontos){
    	this.jogadores.add(new Player(nome, pontos));
    	gravaJogadores();
    }

    public Player pesquisarJogador(String nome) throws JogadorInexistenteException {
        
        for(Player aux: jogadores){
            if(aux.getNome().equals(nome)){
                return aux;
            }
        }
        throw new JogadorInexistenteException("Jogador não encontrado : " + nome);
    }
	
    public Player mudarPontuacao(String nome, int pontuacao) throws JogadorInexistenteException {
        
        for(Player aux: jogadores){
            if(aux.getNome().equals(nome)){
                aux.setPontuacao(pontuacao);
            }
        }
        throw new JogadorInexistenteException("Jogador não encontrado : " + nome);
    }
	//private void ordenarRanking(){
		//Collections.sort(jogadores);
		//Collections.reverse(jogadores);
	//}

	public List <Player> getDadosDoRanking(){

		return jogadores;
	}
	
	public Collection<Player> getJogadores() {
		Collection<Player> jogadores = new ArrayList<Player>();
		jogadores.addAll(this.jogadores);
		return jogadores;
	}

	public Iterator<Player> getJogadoresOrdenados() {
		Collections.sort(this.jogadores);
		return this.jogadores.iterator();
	}

}


