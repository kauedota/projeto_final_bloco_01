package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.List;

import projeto_final_bloco_01.model.Jogo;
import projeto_final_bloco_01.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {
	
	private List<Jogo> listaJogos = new ArrayList<>();
	
	@Override
	public List<Jogo> listarProdutos() {
		return listaJogos;
	}
	
	@Override
	public Jogo buscarProdutoPorId(int id) {
		for (Jogo jogo : listaJogos) {
			if (jogo.getId() == id) {
				return jogo;
			}
		}
		throw new RuntimeException("Jogo com ID " + id + " não encontrado!");
	}
	
	@Override
	public void cadastrarProduto(Jogo jogo) {
		listaJogos.add(jogo);
		System.out.println("Jogo cadastrado com sucesso!");
	}
	
	@Override
	public void atualizarProduto(int id, Jogo jogoAtualizado) {
		for (int contador = 0; contador < listaJogos.size(); contador++) {
			if (listaJogos.get(contador).getId() == id) {
				listaJogos.set(contador, jogoAtualizado);
				System.out.println("Jogo atualizado com sucesso!");
				return;
			}
		}
		throw new RuntimeException("Jogo com ID " + jogoAtualizado.getId() + " não encontrado!");
	}
	
	@Override
	public void deletarProduto(int id) {
		for (int contador = 0; contador < listaJogos.size(); contador++) {
			if (listaJogos.get(contador).getId() == id) {
				listaJogos.remove(contador);
				System.out.println("Jogo deletado com sucesso!");
				return;
			}
		}
		throw new RuntimeException("Jogo com ID " + id + " não encontrado!");
	}

}
