package projeto_final_bloco_01.repository;

import java.util.List;

import projeto_final_bloco_01.model.Jogo;

public interface ProdutoRepository {

    List<Jogo> listarProdutos();

    Jogo buscarProdutoPorId(int id);

    void cadastrarProduto(Jogo jogo);

    void atualizarProduto(int id, Jogo jogoAtualizado);

    void deletarProduto(int id);
}
