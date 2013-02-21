package br.ufpb.jogo;

public class JogadorInexistenteException extends Exception {
	
		private static final long serialVersionUID = 1L;
		public JogadorInexistenteException(){
	        this("Jogador inexistente");
	    }
	    public JogadorInexistenteException(String message){
	        super(message);
	    	    
	    }
}
