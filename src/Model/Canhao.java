package Model;

public class Canhao {
	
	//Atributos 
	private Tiro tiro; //Referencia do tipo Tiro(referente a classe Tiro)
	private int posicaoX = 250;//Posi��o X do canhao em rela��o a tela
	private int posicaoY = 500;//Posi��o Y do canhao em rela��o a tela
	
	public int getPosicaoX() {//M�todo que recupera atributo privado posicaoX
		return posicaoX;
	}
	
	public void setPosicaoX(int posicaoX) {//M�todo que muda o valor do atributo posicaoX
		this.posicaoX = posicaoX;
	}
	
	public int getPosicaoY() {//M�todo que recupera atributo privado posicaoY
		return posicaoY;
	}
	
	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}
	
	public Tiro getTiro() {
		return tiro;
	}
	
	public void setTiro(Tiro tiro) {
		this.tiro = tiro;
	}

}
