package Negocio;

import java.util.ArrayList;
public class GerenciadorJogador {
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

	public void cadastrarJogador(Jogador jogador) throws ObjetoJaExistenteException {
		if(buscarJogador(jogador)){
			throw new ObjetoJaExistenteException("Esse jogador j� existe");
		}
		jogadores.add(jogador);
	}
	public void removerJogador(Jogador jogador) throws ObjetoInexistenteException{
		if(!buscarJogador(jogador)){
			throw new ObjetoInexistenteException("Esse jogador n�o existe");
		}
		jogadores.remove(jogador);
	}
}
