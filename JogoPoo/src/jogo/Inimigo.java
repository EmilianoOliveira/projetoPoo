package jogo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Inimigo {

	private Image imagenDoInimigo;
	private int x;
	private int y;
	private boolean isVisivel;
	
	private int largura; 
	private int altura;

	private static final int LARGURA_DA_TELA = 500;
	private static final int VELOCIDADE_DE_MOVIMENTO = 1;

	private static int CONT = 0;
	
	public Inimigo(int x, int y) {

		this.x = x;
		this.y = y;

		ImageIcon referenciaDoObjeto;
		if(CONT++ % 3 == 0){
			referenciaDoObjeto = new ImageIcon("res\\inimigo_2.gif");
		
		} else {
			
			referenciaDoObjeto = new ImageIcon("res\\inimigo_1.png");
		}
		imagenDoInimigo = referenciaDoObjeto.getImage();
		
		this.largura = imagenDoInimigo.getWidth(null);
		this.altura = imagenDoInimigo.getHeight(null);

		isVisivel = true;
	}

	public void mexer(){

		if(this.x < 0){
			this.x = LARGURA_DA_TELA;
		} else {
			this.x -= VELOCIDADE_DE_MOVIMENTO;
		}
		
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public boolean isVisivel() {
		return isVisivel;	
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public Image getImagem() {
		return imagenDoInimigo;
	}

	
	public Rectangle getBounds(){  // trata a colisão, se bater morre
		return new Rectangle(x, y, largura, altura);
	}
	
}
