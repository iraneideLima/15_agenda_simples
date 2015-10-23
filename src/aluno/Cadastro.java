package aluno;

import java.util.List;

import cliente.ICadastro;
import cliente.IContato;

public class Cadastro implements ICadastro {

	@Override
	public boolean resetAgenda(int maxContatos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean adicionarContato(String telefone, String nome) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IContato getContatoByTel(String telefone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean atualizarContato(String telefone, String nome) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerContato(String telefone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<IContato> getContatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getTelefones(String contato) {
		// TODO Auto-generated method stub
		return null;
	}

}
