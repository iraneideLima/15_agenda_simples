package cliente;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import aluno.Cadastro;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestesCadastro {

	@Test
	public void aAdicaoContagem(){
		ICadastro cadastro = new Cadastro();
		cadastro.resetAgenda(10);
		
		assertTrue(cadastro.getContatos().size() == 0);
		assertTrue(cadastro.adicionarContato("11110000", "Pedro Álvares"));
		assertTrue(cadastro.adicionarContato("11110010", "Dom Pedro"));
		assertTrue(cadastro.adicionarContato("11110020", "Rio Branco"));
		
		//Inserir Telefone Duplicado
		assertFalse(cadastro.adicionarContato("11110020", "Rio Nilo"));
		
		assertTrue(cadastro.getContatos().size() == 3);
		
		assertTrue(cadastro.getContatoByTel("11110010")!=null);
		
		assertTrue(cadastro.adicionarContato("22220000", "Pedro Álvares"));
		assertTrue(cadastro.adicionarContato("33330000", "Pedro Álvares"));
		
		assertTrue(cadastro.adicionarContato("22220010", "Dom Pedro"));
		assertTrue(cadastro.adicionarContato("22220020", "Rio Branco"));
	}
	
	@Test
	public void bRemocaoListagem(){
		ICadastro cadastro = new Cadastro();
		cadastro.resetAgenda(4);
		
		assertTrue(cadastro.adicionarContato("11110040", "Pedro Álvares"));
		assertTrue(cadastro.adicionarContato("11110050", "Dom Pedro"));
		assertTrue(cadastro.adicionarContato("11110060", "Floriano Peixoto"));
		
		//Remover contato existente e verificar quantidade de contatos
		assertTrue(cadastro.removerContato("11110040"));
		assertTrue(cadastro.getContatos().size()==2);
		
		//Remover contato nao existente e verificar quantidade de contatos
		assertFalse(cadastro.removerContato("11118888"));
		assertTrue(cadastro.getContatos().size()==2);
		
		assertTrue(cadastro.adicionarContato("35420070", "Marechal Deororo"));
		assertTrue(cadastro.adicionarContato("35480080", "Joaquim Manoel"));
		assertTrue(cadastro.getContatos().size()==4);
		
		//Estourar Limite de Contatos
		assertFalse(cadastro.adicionarContato("35410090", "Chico Xavier"));
		
		assertTrue(cadastro.getContatos()!=null);
		
	}
	
	@Test
	public void cListasTelefones(){
		ICadastro cadastroTest = new Cadastro();
		cadastroTest.resetAgenda(10);
		
		assertTrue(cadastroTest.getContatos().size() == 0);
		assertTrue(cadastroTest.adicionarContato("11110000", "Pedro Álvares"));
		assertTrue(cadastroTest.adicionarContato("11110010", "Dom Pedro"));
		assertTrue(cadastroTest.adicionarContato("11110020", "Rio Branco"));
		
		assertTrue(cadastroTest.getContatos().size() == 3);
		
		assertTrue(cadastroTest.getContatoByTel("11110010")!=null);
		
		assertTrue(cadastroTest.adicionarContato("22220000", "Pedro Álvares"));
		assertTrue(cadastroTest.adicionarContato("33330000", "Pedro Álvares"));
		
		assertTrue(cadastroTest.adicionarContato("22220010", "Dom Pedro"));
		assertTrue(cadastroTest.adicionarContato("22220020", "Rio Branco"));
		
		//Quantidade de telefones do Pedro
		assertTrue(cadastroTest.getTelefones("Pedro Álvares").size()==3);
		
		//Ronildo não tem telefone
		assertTrue(cadastroTest.getTelefones("Ronildo Oliveira").size()==0);
	}

}