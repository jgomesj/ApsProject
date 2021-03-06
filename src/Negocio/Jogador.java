package Negocio;


import Excecao.BalasEsgotadasException;
import Model.Canhao;
import Model.Usuario;

@SuppressWarnings("serial")
public class Jogador extends Usuario{
	private static int score = 10;
	public static boolean isGameOver = false;
	private Canhao canhao;
	public Jogador(){
		score = 10;
		int id = super.getId();
		id++;
		super.setId(id);
		super.setTipo("jogador");
	}
	public static void setScoreInicial(){
		score = 10;
	}
	public static void incrementarScore(){
		score++;
	}
	public static void decrementarScore(){
		score--;
		if(score == 0){
			isGameOver = true;
		}
	}
	public static int getScore() {
		
		return score;
	}
	public Canhao getCanhao() {
		return canhao;
	}
	public void setCanhao(Canhao canhao){
		this.canhao = canhao;
	}
	public void atirar() throws BalasEsgotadasException{
		this.canhao.getMunicao().diminuirQuantidadeDeBalas();
	}
}
