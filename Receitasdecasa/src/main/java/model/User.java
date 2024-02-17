package model;

public class User {
	private int id;
	private String nome;
	private String email;
	private String senha;
	private int qntReceitas;
	private Boolean admin;

	public User() {

	}

	public User(int id, String nome, String email, String senha, int qntReceitas, Boolean admin) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.qntReceitas = qntReceitas;
		this.admin = admin;
	}

	// Gets e sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public int getQntReceitas() {
		return qntReceitas;
	}

	public void setQntReceitas(int qntReceitas) {
		this.qntReceitas = qntReceitas;
	}
}
