package br.ufpb.jogo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;




public class Player implements Comparable <Player> {

		private String nome;
		private int pontos;
		

		public Player(){
			this("",0);
		}

		public Player (String nome, int pontos){
			this.nome = nome;
			this.pontos = 0;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getPontuacao() {
			return pontos;
		}

		public void setPontuacao(int pontuacao) {
			this.pontos = pontuacao;
		}
		public String toString(){
			return this.nome +" "+ this.pontos;

		}

		@Override
		public int compareTo(Player jogador){
			if(this.pontos>jogador.pontos){
				return 1;
			}
			else if(this.pontos == jogador.pontos){
				return 0;
			}
			else{
				return -1;
			}
		}
	    
}







