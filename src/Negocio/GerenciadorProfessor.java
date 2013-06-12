package Negocio;
import java.util.ArrayList;

public class GerenciadorProfessor {
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	
	public void cadastrarProfessor(Professor professor) throws ObjetoJaExistenteException, ObjetoInexistenteException {
		if(buscarProfessor(professor)){
			throw new ObjetoJaExistenteException("Esse professor j� existe");
		}
		if(professor.getSenha() == null || professor.getSenha().length() < 4){
			throw new ObjetoInexistenteException("Senha inv�lida");
		}
		professores.add(professor);
	}
}
