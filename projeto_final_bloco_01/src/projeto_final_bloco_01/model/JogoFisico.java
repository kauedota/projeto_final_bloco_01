package projeto_final_bloco_01.model;

public class JogoFisico extends Jogo {
	
	private String midia;
	
	public JogoFisico(int id, String nome, String plataforma, double preco, String midia) {
		super(id, nome, plataforma, preco);
		this.midia = midia;
	}

	public String getMidia() {
		return midia;
	}

	public void setMidia(String midia) {
		this.midia = midia;
	}
	
	@Override
	public void sobre() {
	    System.out.println("Jogo Físico: ID " + getId() + " - " + getNome() +
	                       " - Plataforma: " + getPlataforma() +
	                       " - Preço: R$" + getPreco() +
	                       " - Mídia: " + midia);
	}

}
