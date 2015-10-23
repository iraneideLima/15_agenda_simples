package aluno;

import java.util.ArrayList;
import java.util.List;

import cliente.ICadastro;
import cliente.IContato;

public class Cadastro implements ICadastro {
	
	private List<IContato> listaContatos = new ArrayList<IContato>();
	private int maxContatos = 0;
	
	
	boolean validaTelefone(String telefone){
		if (telefone == null)
			return false;
		if (telefone.matches("[0-9]+"))
			return true;
		return false;
	}
	
	@Override
	public boolean resetAgenda(int maxContatos) {
		// TODO Auto-generated method stub
		this.maxContatos = maxContatos;
		
		this.listaContatos.removeAll(listaContatos);
		return true;
	}

	@Override
	public boolean adicionarContato(String telefone, String nome) {
		// TODO Auto-generated method stub
		IContato contato = new Contato(telefone, nome);
		if (getContatoByTel(telefone) == null) {
			if (validaTelefone(telefone) && nome != null){
				if (this.listaContatos.size() < this.maxContatos) {
				this.listaContatos.add(contato);
					return true;			
				}
			}
		}
		return false;
	}

	@Override
	public IContato getContatoByTel(String telefone) {
		// TODO Auto-generated method stub
		for (IContato contato : listaContatos) {
			if (contato.getTelefone().equals(telefone)) {
				return contato;
			}
		}
		return null;
	}

	@Override
	public boolean atualizarContato(String telefone, String nome) {
		for (IContato contato : listaContatos) {
			if(contato.getTelefone().equals(telefone) && (nome != "") && (nome != null)){
				contato.setNome(nome);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removerContato(String telefone) {
		for (IContato contato : listaContatos) {
			if(contato.getTelefone().equals(telefone)){
				listaContatos.remove(contato);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<IContato> getContatos() {
		return listaContatos;
	}

	@Override
	public List<String> getTelefones(String contato) {
		List<String> listaTelefones = new ArrayList<String>();
		
		for (IContato c : listaContatos) {
			if (contato.equals(c.getNome())) {
				listaTelefones.add(c.getTelefone());
			}
		}		
		return listaTelefones;
	}
}
