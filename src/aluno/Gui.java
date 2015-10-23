package aluno;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import cliente.IContato;

public class Gui extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel painel = new JPanel();
	
	private JLabel labelNome = new JLabel();
	private JLabel labelTelefone = new JLabel();
	private JLabel labelLista = new JLabel();
	
	private JTextField campoNome = new JTextField();
	private JTextField campoTelefone = new JTextField();
	private JTextField campoBuscar = new JTextField();
	
	private JButton btAdcionar = new JButton();
	private JButton btRemover = new JButton();
	private JButton btBuscar = new JButton();
	
	DefaultListModel<String> modeloLista = new DefaultListModel<String>();
	JList<String> listaContatos = new JList<String>(modeloLista);
	JScrollPane barraRolagem = new JScrollPane(listaContatos);
	
	DefaultListModel<String> modeloListaBusca = new DefaultListModel<String>();
	JList<String> listaContatosBusca = new JList<String>(modeloListaBusca);
	JScrollPane barraRolagemBusca = new JScrollPane(listaContatosBusca);
	
	Cadastro cadastroGui = new Cadastro();
	
	public Gui(int reset) {
		// TODO Auto-generated constructor stub
			
		cadastroGui.resetAgenda(reset);
		
		this.setSize(430, 600);
		this.setTitle("Cadastro de Telefones - POO");
		this.setLocationRelativeTo(null);
		 
		 	
		instanciaLabels();
		instanciaCampos();
		instanciaBotoes();
		instanciaLista();
		 
		instanciaPainel();
		 
		this.setVisible(true);
	}
	
	void instanciaPainel(){
		painel.setBackground(new Color(245,250, 255));
		painel.setSize(600, 600);
		
		this.add(painel);
	}
	
	void instanciaCampos(){
		campoNome.setBounds(50, 50, 150, 20);
		campoTelefone.setBounds(50, 100, 150, 20);
		campoBuscar.setBounds(50, 300, 150, 20);
		
		this.add(campoNome);
		this.add(campoTelefone);
		this.add(campoBuscar);
	}
	
	void instanciaLabels(){
		labelNome.setText("NOME.:");
		labelNome.setBounds(50, 30, 100, 20);
		
		labelTelefone.setText("TEL .:");
		labelTelefone.setBounds(50, 80, 100, 20);
		
		labelLista.setText("LISTA.:");
		labelLista.setBounds(230, 30, 100, 20);
		
		this.add(labelNome);
		this.add(labelTelefone);
		this.add(labelLista);
	}
	
	void instanciaBotoes(){
		btAdcionar.setText("Adicionar");
		btAdcionar.setBounds(50, 130, 150, 20);
		
		btRemover.setText("Remover");
		btRemover.setBounds(230, 260, 150, 20); 	
		
		btBuscar.setText("Buscar");
		btBuscar.setBounds(230, 300, 150, 20);
		
		this.add(btAdcionar);
		this.add(btRemover);
		this.add(btBuscar);
		
		btAdcionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastroGui.adicionarContato(campoTelefone.getText().toString(),
											 campoNome.getText().toString());
				instanciaLista();
				
				campoNome.setText(null);
				campoTelefone.setText(null);
			}
		});
		
		btRemover.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = listaContatos.getSelectedIndex();
			    if(index >= 0){ //Remove only if a particular item is selected
			    	int indice = listaContatos.getSelectedValue().indexOf(" ");  
					String subsringTelefone = listaContatos.getSelectedValue().substring(0, indice);
					
			    	cadastroGui.removerContato(subsringTelefone);
			    	modeloLista.removeElementAt(index);
			        
			    }
			}
		});
		
		btBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				modeloListaBusca.removeAllElements();
				
				if (cadastroGui.getContatoByTel(campoBuscar.getText())==null){
					//NULO
				}else{
					modeloListaBusca.add(0, cadastroGui.getContatoByTel(campoBuscar.getText()).getNome());
				}
			
				campoBuscar.setText(null);
			}
		});
	}
	
	void instanciaLista(){
		modeloLista.removeAllElements();
		
		int i = 0;
		for (IContato contato : cadastroGui.getContatos()) {
			modeloLista.add(i, contato.toString());
			i++;
		}
		
		barraRolagem.setBounds(230, 50, 150, 200);
		barraRolagemBusca.setBounds(50, 330, 330, 200);
		
		this.add(barraRolagem);
		this.add(barraRolagemBusca);
	}
	
	
	JFrame getJanela(){
		return this;
	}
	
}