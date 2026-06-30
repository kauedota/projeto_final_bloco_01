package projeto_final_bloco_01.repository;

import java.util.List;

import projeto_final_bloco_01.Jogo;

public interface ProdutoRepository {

	List<Jogo> listarProdutos();

	Jogo buscarProdutoPorId(int id);

	void cadastrarProduto();

	void atualizarProduto(int id);

	void deletarProduto(int id);

}
