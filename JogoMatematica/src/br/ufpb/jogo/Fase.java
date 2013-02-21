package br.ufpb.jogo;

public class Fase {
	int operando1;
	int operando2;
	int pontuacao;
	int nivel;
	
	public Fase(){
		this(0,0,0,1);
	}
	public Fase(int operando1, int operando2, int pontuacao, int nivel){
		this.operando1 = operando1;
		this.operando2 = operando2;
		this.pontuacao = pontuacao;
		this.nivel = nivel;
	}
	public int testaNivel(int pontos){
		if (pontos<= 0){
			nivel = 1;
		}
		else if (pontos >= 30 && pontos <=60){
			nivel = 2;
		}
		else if (pontos >= 60 && pontos <=90){
			nivel = 3;
		}
		else{
			nivel = 4;
		}
		return nivel;
	}
	
	public boolean testaFinal(int erros){
		if(erros >= 0 && erros <3){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int getOperando1() {
		return operando1;
	}
	public int getOperando2() {
		return operando2;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
}

