package projeto_final_bloco_01;

public abstract class Jogo {

	    private int id;
	    private String nome;
	    private String plataforma;
	    private double preco;
    
	    public Jogo(int id, String nome, String plataforma, double preco) {
			super();
			this.id = id;
			this.nome = nome;
			this.plataforma = plataforma;
			this.preco = preco;
		}
	    
	    
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
	
	
		public String getPlataforma() {
			return plataforma;
		}
	
	
		public void setPlataforma(String plataforma) {
			this.plataforma = plataforma;
		}
	
	
		public double getPreco() {
			return preco;
		}
	
	
		public void setPreco(double preco) {
			this.preco = preco;
		}
		
		public abstract void sobre();
		
	
	    
	    
    
}