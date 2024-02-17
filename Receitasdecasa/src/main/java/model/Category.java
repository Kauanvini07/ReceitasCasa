package model;

public class Category {
	private int id;
	private String nome;
	
	public Category(){
		super();
	}
	
	public Category(int id, String nome){
		super();
		this.id=id;
		this.nome=nome;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
}
