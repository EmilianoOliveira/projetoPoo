package br.ufpb.jogo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;



public class GravadorRanking {
	
	public List<Player>leJogadores() throws IOException{
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream (new FileInputStream("jogadores.txt"));
			return (List<Player>)in.readObject();
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo não encontrado", e);
		}catch(IOException e){
			throw e;
		}catch(ClassNotFoundException e){
			throw new IOException("Esta classe não foi encontrada", e);
		}finally{
			if (in!=null){
				in.close();
			}
		}
	}
	public void gravaJogadores(List<Player>jogador) throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("jogadores.txt"));
			out.writeObject(jogador);
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo não encontrado", e);
		}catch(IOException e){
			throw e;
		}finally{
			if (out!=null){
				out.close();
			}
		}	
	}
}





