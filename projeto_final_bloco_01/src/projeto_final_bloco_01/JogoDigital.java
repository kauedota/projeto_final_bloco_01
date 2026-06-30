package projeto_final_bloco_01;

public class JogoDigital extends Jogo {
	
	private double tamanhoGB;

	public JogoDigital(int id, String nome, String plataforma, double preco, double tamanhoGB) {
		super(id, nome, plataforma, preco);
	}
	
	public double getTamanhoGB() {
		return tamanhoGB;
	}
	
	public void setTamanhoGB(double tamanhoGB) {
		this.tamanhoGB = tamanhoGB;
	}

	@Override
	public void sobre() {
		System.out.println(
				"Jogo Digital: " + getNome() + " - Plataforma: " + getPlataforma() + " - Preço: R$" + getPreco() + " - Tamanho: " + tamanhoGB + "GB");

	}

}
