package visaoaluno;


public class Contato implements IContato {
	
	private String nome;
	private String telefone;
	
	public Contato(String telefone, String nome) {
		// TODO Auto-generated constructor stub
		this.nome = nome;		
		this.telefone = telefone;
	}
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}

	@Override
	public void setNome(String nome) {
		// TODO Auto-generated method stub
		this.nome = nome;
	}

	@Override
	public String getTelefone() {
		// TODO Auto-generated method stub
		return this.telefone;
	}

	@Override
	public void setTelefone(String telefone) {
		// TODO Auto-generated method stub
		this.telefone = telefone;
	}

}
