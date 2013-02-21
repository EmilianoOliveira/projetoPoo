


package br.ufpb.jogo;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.*;




public class Jogo {

	public static void main(String [] args) throws JogadorInexistenteException{
			int acertos = 0;
			int erros = 0;
			Ranking ranking = new Ranking();
			int menu = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Novo jogo, 2 - Ranking, 3 - Cr�ditos,  4 - Instru��es, 5 -  Sair"));
			do{
				switch(menu){
					case 1:
						String nome = (JOptionPane.showInputDialog("Digite seu nome: "));
						int pontos = 0;
						ranking.adicionarJogador(nome,pontos);
						Player jogador = ranking.pesquisarJogador(nome);
						Iterator<Player>jogador1 = ranking.getJogadoresOrdenados();
						int nivel = 1;
						boolean start = true;
						while(start==true){ 
							Fase desafio = new Fase(1 + (int)(Math.random() * 11), 1 + (int)(Math.random() * 11),0,1);
							int testa = desafio.testaNivel(jogador.getPontuacao());
							int operacao;
							int opcao1 = (1 + (int)(Math.random() * 10));
							int opcao2 = (1 + (int)(Math.random() * 10));
							int opcao3 = (1 + (int)(Math.random() * 10));
							if (testa == 1){
								operacao = (desafio.getOperando1() + desafio.getOperando2());
								int opcao4 = operacao;
								System.out.println("Qual o resultado da opera��o" + desafio.getOperando1() + "+" + desafio.getOperando2() + "? ");
								System.out.println("\n(1)" + " " + (opcao1) + "\n(2)" + " " + (opcao2) + "\n(3)" + " " + (opcao3) + "\n(4)" + " " + (opcao4));
							}
							else if(testa == 2){
								operacao = (desafio.getOperando1() - desafio.getOperando2());
								int opcao4 = operacao;
								System.out.println("Qual o resultado da opera��o" + desafio.getOperando1() + "-" + desafio.getOperando2() + "? ");
								System.out.println("\n(1)" + " " + (opcao1) + "\n(2)" + " " + (opcao2) + "\n(3)" + " " + (opcao3) + "\n(4)" + " " + (opcao4));
							}
							else if(testa == 3){
								operacao = (desafio.getOperando1() * desafio.getOperando2());
								int opcao4 = operacao;
								System.out.println("Qual o resultado da opera��o" + desafio.getOperando1() + "x" + desafio.getOperando2() + "? ");
								System.out.println("\n(1)" + " " + (opcao1) + "\n(2)" + " " + (opcao2) + "\n(3)" + " " + (opcao3) + "\n(4)" + " " + (opcao4));
							}
							else{
								operacao = (desafio.getOperando1() / desafio.getOperando2());
								int opcao4 = operacao;
								System.out.println("Qual o resultado da opera��o" + desafio.getOperando1() + "/" + desafio.getOperando2() + "? ");
								System.out.println("\n(1)" + " " + (opcao1) + "\n(2)" + " " + (opcao2) + "\n(3)" + " " + (opcao3) + "\n(4)" + " " + (opcao4));
							}
							int resposta =  Integer.parseInt(JOptionPane.showInputDialog("Qual a op��o escolhida 1,2,3 ou 4 ?"));	
							switch(resposta){
								case 1:
									System.out.println("Voc� errou e acabou de perder 5 pontos");
									pontos = pontos - 5;
									jogador.setPontuacao(pontos);
									erros = erros + 1;
									acertos = 0;
									break;
							
								case 2:
									System.out.println("Voc� errou e acabou de perder 5 pontos");
									pontos = pontos - 5;
									jogador.setPontuacao(pontos);
									erros = erros + 1;
									acertos = 0;
									break;
								case 3:
									System.out.println("Voc� errou e acabou de perder 5 pontos");
									pontos = pontos - 5;
									jogador.setPontuacao(pontos);
									erros = erros + 1;
									acertos = 0;
									break;
								
								case 4:
									System.out.println("Voc� acertou e acabou de ganhar 10 pontos");
									pontos = pontos + 10;
									jogador.setPontuacao(pontos);
									erros = 0;
									acertos = acertos+1;
									if(acertos == 3){
										pontos = pontos+30;
										jogador.setPontuacao(pontos);
									}
									break;
							}
							if(erros == 3){
								System.out.println("Voc� perdeu ! Tente outra vez.");
								start = desafio.testaFinal(erros);
							}
							
						}
						break;
					case 2:
						Iterator<Player>jogadores1 = ranking.getJogadoresOrdenados();
						while(jogadores1.hasNext()){
							JOptionPane.showMessageDialog(null, jogadores1.next());
						}
						break;
					case 3:
						JOptionPane.showMessageDialog(null, "Agradecimentos:\n Emiliano Oliveira aluno da UFPB campus IV(Ci�ncias da computa��o)\n" +
								"  Igor Mendes aluno da UFPB campus IV(Ci�ncias da computa��o)\n Ayla Rebou�as Mestre em programa��o orientada ao\n objeto em UFPB campus IV");
							break;
					case 4:
						JOptionPane.showMessageDialog(null, "O jogo � baseado em voc� responder corretamente as opera��es\n matem�ticas(+,-,x,/) que s�o dadas pelo jogo, a cada " +
								"resposta certa\n voc� ganhar� 10 pontos, se acertar 3 vezes seguidas voc� ganhar�\n 50 pontos e passar� de n�vel sendo assim opera��es" +
								"mais dif�ceis, se\n voc� errar tr�s vezes seguidas ir� perder o jogo e sua pontua��o ir� \npara o ranking.");
							break;
					case 5:
						
						break;
					
					default : JOptionPane.showMessageDialog(null,"OP��O INV�LIDA");
				}
				
				menu = Integer.parseInt(JOptionPane.showInputDialog("(1) Novo jogo, (2) Ranking, (3) Cr�ditos, (4) Instru��es, (5) Sair"));
			
			}while(menu<5);
		}
	}