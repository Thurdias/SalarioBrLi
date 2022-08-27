package negocio;

import java.util.Collection;

import persistencia.ColaboradorDAO;

public class Colaborador {
	// Propriedades da classe
	private int id = 0;
	private Cargo objCargo = null;
	private String nome = "";

	// M�todos construtores da classe
	public Colaborador() {
		super();
	}

	public Colaborador(int id, Cargo objCargo, String nome) {
		super();
		this.id = id;
		this.objCargo = objCargo;
		this.nome = nome;
	}

	// M�todos get/set da classe
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cargo getObjCargo() {
		return objCargo;
	}

	public void setObjCargo(Cargo objCargo) {
		this.objCargo = objCargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	// M�todos da classe
	public static Collection<Colaborador> getTodos() throws Exception {
		return new ColaboradorDAO().getTodos();
	}
	
	public void persistir() throws Exception {
		new ColaboradorDAO().persistir(this);
	}
}