package Negocio;

import java.io.IOException;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Excecao.BalasEsgotadasException;
import Excecao.FaseNaoDisponivelException;
import Excecao.JogadorNaoLogadoException;
import Excecao.LoginInexistenteException;
import Excecao.ObjetoInexistenteException;
import Excecao.ObjetoJaExistenteException;
import Model.Canhao;
import Model.Fase;
import Model.Jogo;
import Model.Municao;
import Model.Problema;
import Model.Professor;

@SuppressWarnings("deprecation")
public class JogoTest {
	
	private Jogo jogo;
	
	@Before
	public void iniciarTeste() throws IOException{
		jogo = new Jogo();
		jogo.iniciandoDAO();
	}
	
	@After
	public void destruirArquivo(){
		jogo.destruirArquivo();
	}
	
	@Test
	public void iniciarJogo(){
		Assert.assertFalse("O jogo j� iniciou acabado", jogo.jogoAcabou());
	}
	
	private Professor instanciarObjetoProfessor(){
		Professor p1 = new Professor();
		p1.setNome("Ant�nio");
		p1.setSenha("81011054");
		return p1;
	}
	
	private Jogador instanciarObjetoJogador(){
		Jogador j1 = new Jogador();
		j1.setNome("Rodrigo");
		j1.setSenha("alucard1800");
		return j1;
	}
	
	private Problema instanciarObjetoProblema(){
		Problema pro1 = new Problema();
		pro1.setQuestao("Qual o resultado da opera��o (3x3)�?");
		pro1.setResposta(81);
		return pro1;
	}
	
	private Fase instanciarObjetoFase(){
		Fase f1 = new Fase();
		return f1;
	}
	
	private Canhao instanciarObjetoCanhao(){
		Canhao c = new Canhao();
		return c;
	}
	
	@Test
	public void cadastrarProfessor() throws Exception{
		Professor p1 = instanciarObjetoProfessor();
		jogo.cadastrarProfesssor(p1);
		Jogo novoJogo = new Jogo();
		Assert.assertEquals("Esse teste espera que o valor do arquivo cadastrado atualize para 1", 1, novoJogo.getQuantidadeDeProfessoresCadastrados());
	}
	
	@Test
	public void removerProfessor() throws Exception{
		Professor p1 = instanciarObjetoProfessor();
		jogo.cadastrarProfesssor(p1);
		Jogo novoJogo = new Jogo();
		novoJogo.removerProfessor(p1);
		Assert.assertEquals("Esse teste remove um objeto professor do arquivo", 0, novoJogo.getQuantidadeDeProfessoresCadastrados());
		
	}
	
	@Test(expected=ObjetoJaExistenteException.class)
	public void cadastrarMesmoProfessorDuasVezes() throws Exception{
		Professor p1 = instanciarObjetoProfessor();
		jogo.cadastrarProfesssor(p1);
		Jogo novoJogo = new Jogo();
		novoJogo.cadastrarProfesssor(p1);
		
	}
	
	@Test
	public void verificaSeNomeDoProfessorEstaCorreto() throws Exception {
		Professor p1 = instanciarObjetoProfessor();
		p1.setNome("Madalena");
		p1.setSenha("01411023");
		jogo.cadastrarProfesssor(p1);
		Jogo novoJogo = new Jogo();
		ArrayList<Professor> listaProfessores = novoJogo.listarProfessores();
		Assert.assertEquals("Esse teste espera que o professor cadastrado seja igual ao professor salvo na lista", p1.getNome(), listaProfessores.get(0).getNome());
	}
	
	@Test(expected = ObjetoInexistenteException.class)
	public void removerProfessorInexistente() throws Exception {
		Professor p1= instanciarObjetoProfessor();
		jogo.cadastrarProfesssor(p1);
		Jogo novoJogo = new Jogo();
		Professor p2 = instanciarObjetoProfessor();
		p2.setNome("Joao");
		p2.setSenha("01013456");
		novoJogo.removerProfessor(p2);
	}
	
	@Test(expected = ObjetoInexistenteException.class)
	public void removerMesmoProfessorDuasVezes() throws Exception{
		Professor p1 = instanciarObjetoProfessor();
		jogo.cadastrarProfesssor(p1);
		Jogo novoJogo = new Jogo();
		novoJogo.removerProfessor(p1);
		Jogo maisUmJogo = new Jogo();
		maisUmJogo.removerProfessor(p1);
		
	}
	
	@Test
	public void cadastrarJogador() throws Exception{
		Jogador j1 = instanciarObjetoJogador();
		jogo.cadastrarJogador(j1);
		Jogo novoJogo = new Jogo();
		Assert.assertEquals("Esse teste espera que a quantidade de jogadores cadastrados seja igual a 1", 1, novoJogo.getQuantidadeDeJogadoresCadastrados());
	}
	
	@Test
	public void verificarSeNomeDoJogadorEstaCorreto() throws IOException, Exception{
		Jogador j1 = instanciarObjetoJogador();
		jogo.cadastrarJogador(j1);
		Jogo novoJogo = new Jogo();
		ArrayList<Jogador> listaJogadores = novoJogo.listarJogadores();
		Assert.assertEquals("Esse teste verifica se o nome do jogador foi cadastrado corretamente", j1.getNome(), listaJogadores.get(0).getNome());
	}
	
	@Test(expected=ObjetoJaExistenteException.class)
	public void cadastrarJogadorJaCadastrado() throws IOException, Exception{
		Jogador j1 = instanciarObjetoJogador();
		jogo.cadastrarJogador(j1);
		Jogo novoJogo = new Jogo();
		novoJogo.cadastrarJogador(j1);
	}
	
	@Test
	public void removerJogador() throws IOException, Exception{
		Jogador j1 = instanciarObjetoJogador();
		jogo.cadastrarJogador(j1);
		Jogo novoJogo = new Jogo();
		novoJogo.removerJogador(j1);
		Assert.assertEquals("Esse teste espera que o valor do arquivo de cadastro atualize para 1", 0, novoJogo.getQuantidadeDeJogadoresCadastrados());
		
	}
	
	@Test(expected=ObjetoInexistenteException.class)
	public void removerMesmoJogadorDuasVezes() throws IOException, Exception{
		Jogador j1 = instanciarObjetoJogador();
		jogo.cadastrarJogador(j1);
		Jogo novoJogo = new Jogo();
		novoJogo.removerJogador(j1);
		Jogo maisUmJogo = new Jogo();
		maisUmJogo.removerJogador(j1);
	}
	
	@Test(expected=ObjetoInexistenteException.class)
	public void removerJogadorInexistente() throws IOException, Exception{
		Jogador j1 = instanciarObjetoJogador();
		jogo.cadastrarJogador(j1);
		Jogador j2 = instanciarObjetoJogador();
		j2.setNome("Wandemberg");
		j2.setSenha("atecubanos");
		Jogo novoJogo = new Jogo();
		novoJogo.removerJogador(j2);
	}
	
	@Test
	public void cadastrarProblema() throws Exception{
		Professor p1 = instanciarObjetoProfessor();
		jogo.cadastrarProfesssor(p1);
		Jogo novoJogo = new Jogo();
		novoJogo.loginProfessor(p1);
		Problema pro1 = instanciarObjetoProblema();
		pro1.setQuestao("Qual a metade de dois mais dois?");
		pro1.setResposta(3);
		novoJogo.cadastrarProblema(pro1);
		Jogo maisUmJogo = new Jogo();
		Assert.assertEquals("Esse teste espera que o valor da lista de problemas atualize para 1", 1, maisUmJogo.getQuantidadeDeProblemasCadastrados());
	}
	
	@Test(expected = ObjetoInexistenteException.class)
	public void senhaDeProfessorComMenosDeQuatroDigitosImpossibilidadeDeCadastro() throws Exception{
		Professor p1 = instanciarObjetoProfessor();
		p1.setSenha("ufpb");
		jogo.cadastrarProfesssor(p1);
	}
	

}
