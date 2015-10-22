package cliente;

import java.util.List;

public interface ICadastro {
	
	//inicia a agenda apagando qualquer contato que nela possua.
	//também seta o limite da memória para adicionar contatos.
	boolean resetAgenda(int maxContatos);
	
	//Adiciona um contato a agenda passando nome e telefone
	//Nao podem existir duas entradas com o mesmo telefone
	//
	//O telefone deve ser composto apenas de digitos.
	//O nome não pode estar vazio
	//
	//Se o contato foi adicionado com sucesso retorne true
	boolean adicionarContato(String telefone, String nome);
	
	//Função que retorna o nome do contato a partir do seu telefone
	IContato getContatoByTel(String telefone);
	
	//atualiza o contato com esse Telefone
	//retorne false caso telefone não seja encontrado ou
	//nao esteja de acordo com os requisitos para adicionar um novo contato
	boolean atualizarContato(String telefone, String nome);
	
	//remove o contato desse telefone
	boolean removerContato(String telefone);
	
	//devolve todos os telefones da lista
	List<String> getContatos();
	
	//Dado o nome de um contato retorne a lista de telefones
	//que ele possui. Caso o contato não exista, retorne null.
	//A lista deve ser ordenada pela ordem de inserção na agenda,
	//ou seja, os primeiros inseridos devem aparecer primeiro na lista
	List<String> getTelefones(String contato);
}
