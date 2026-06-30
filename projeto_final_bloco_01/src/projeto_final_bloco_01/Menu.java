package projeto_final_bloco_01;

import java.util.Scanner;
import projeto_final_bloco_01.controller.ProdutoController;

public class Menu {
    
    public static void main(String[] args) {
        
        Scanner leia = new Scanner(System.in);
        ProdutoController controller = new ProdutoController();
        int opcao;
     
        do {
            System.out.println("===================================");
            System.out.println("      LOJA DE GAMES");
            System.out.println("===================================");
            System.out.println("1 - Listar todos os Jogos");
            System.out.println("2 - Buscar Jogo pelo ID");
            System.out.println("3 - Cadastrar Jogo");
            System.out.println("4 - Atualizar Jogo");
            System.out.println("5 - Deletar Jogo");
            System.out.println("0 - Sair");
            System.out.println("===================================");
            System.out.print("Digite a opção desejada: ");
            
            opcao = leia.nextInt();
            
            switch (opcao) {
            case 1:
                for (Jogo jogo : controller.listarProdutos()) {
                    jogo.sobre();
                }
                break;
            case 2:
                System.out.println("Digite o ID do jogo que deseja buscar: ");
                int idBusca = leia.nextInt();
                try {
                    Jogo jogo = controller.buscarProdutoPorId(idBusca);
                    jogo.sobre();
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 3:
                System.out.println("Digite o tipo de jogo (1 - Físico, 2 - Digital): ");
                int tipo = leia.nextInt();
                System.out.println("Digite o ID do jogo: ");
                int id = leia.nextInt();
                leia.nextLine();

                System.out.println("Digite o nome do jogo: ");
                String nome = leia.nextLine();

                System.out.println("Digite a plataforma do jogo: ");
                String plataforma = leia.nextLine();

                System.out.println("Digite o preço do jogo: ");
                double preco = leia.nextDouble();

                if (tipo == 1) {
                    leia.nextLine();
                    System.out.println("Digite a mídia do jogo: ");
                    String midia = leia.nextLine();
                    JogoFisico jogoFisico = new JogoFisico(id, nome, plataforma, preco, midia);
                    controller.cadastrarProduto(jogoFisico);
                } else if (tipo == 2) {
                    System.out.println("Digite o tamanho em GB do jogo: ");
                    double tamanhoGB = leia.nextDouble();
                    JogoDigital jogoDigital = new JogoDigital(id, nome, plataforma, preco, tamanhoGB);
                    controller.cadastrarProduto(jogoDigital);
                } else {
                    System.out.println("Tipo de jogo inválido!");
                }
                break;
            case 4:
                System.out.println("Digite o ID do jogo que deseja atualizar: ");
                int idAtualizar = leia.nextInt();
                leia.nextLine();

                System.out.println("Digite o novo nome do jogo: ");
                String novoNome = leia.nextLine();

                System.out.println("Digite a nova plataforma do jogo: ");
                String novaPlataforma = leia.nextLine();

                System.out.println("Digite o novo preço do jogo: ");
                double novoPreco = leia.nextDouble();

                System.out.println("Digite o novo tipo de jogo (1 - Físico, 2 - Digital): ");
                int tipoAtualizar = leia.nextInt();
                leia.nextLine();

                if (tipoAtualizar == 1) {
                    System.out.println("Digite a nova mídia do jogo: ");
                    String novaMidia = leia.nextLine();
                    JogoFisico jogoFisicoAtualizado = new JogoFisico(idAtualizar, novoNome, novaPlataforma, novoPreco, novaMidia);
                    controller.atualizarProduto(idAtualizar, jogoFisicoAtualizado);
                } else if (tipoAtualizar == 2) {
                    System.out.println("Digite o novo tamanho em GB do jogo: ");
                    double novoTamanhoGB = leia.nextDouble();
                    JogoDigital jogoDigitalAtualizado = new JogoDigital(idAtualizar, novoNome, novaPlataforma, novoPreco, novoTamanhoGB);
                    controller.atualizarProduto(idAtualizar, jogoDigitalAtualizado);
                } else {
                    System.out.println("Tipo de jogo inválido!");
                }
                break;
            case 5:
                System.out.println("Digite o ID do jogo que deseja deletar: ");
                int idDeletar = leia.nextInt();
                try {
                    controller.deletarProduto(idDeletar);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 0:
                System.out.println("Saindo do sistema...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
        
        leia.close();
    }
}
