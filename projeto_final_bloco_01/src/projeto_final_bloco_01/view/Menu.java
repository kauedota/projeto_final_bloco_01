package projeto_final_bloco_01.view;

import java.util.Scanner;
import projeto_final_bloco_01.model.Jogo;
import projeto_final_bloco_01.model.JogoFisico;
import projeto_final_bloco_01.model.JogoDigital;
import projeto_final_bloco_01.controller.ProdutoController;
import util.Cores;

		public class Menu {
		    
		    private static Scanner leia = new Scanner(System.in);
		    private static ProdutoController controller = new ProdutoController();
		  
		    
		    public static void main(String[] args) {
		        int opcao;
		        do {
		            mostrarMenu();
		            opcao = leia.nextInt();
		            switch (opcao) {
		                case 1 -> listarJogos();
		                case 2 -> buscarJogo();
		                case 3 -> cadastrarJogo();
		                case 4 -> atualizarJogo();
		                case 5 -> deletarJogo();
		                case 0 -> System.out.println("Saindo do sistema...");
		                default -> System.out.println("Opção inválida! Tente novamente.");
		            }
		        } while (opcao != 0);
		        leia.close();
		    }
		
		    private static void mostrarMenu() {
		        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_CYAN_BOLD + "===============================" + Cores.TEXT_RESET);
		        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE_BOLD + "        LOJA DE GAMES          " + Cores.TEXT_RESET);
		        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_CYAN_BOLD + "===============================" + Cores.TEXT_RESET);

		        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD + "1 - Listar todos os Jogos      " + Cores.TEXT_RESET);
		        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD + "2 - Buscar Jogo pelo ID        " + Cores.TEXT_RESET);
		        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD + "3 - Cadastrar Jogo             " + Cores.TEXT_RESET);
		        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_GREEN_BOLD + "4 - Atualizar Jogo             " + Cores.TEXT_RESET);
		        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_RED_BOLD + "5 - Deletar Jogo               " + Cores.TEXT_RESET); // destaque crítico
		        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_PURPLE_BOLD + "0 - Sair                       " + Cores.TEXT_RESET);         // saída também crítica

		        System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_CYAN_BOLD + "===============================" + Cores.TEXT_RESET);
		        System.out.print(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW_BOLD + "Digite a opção desejada:       " + Cores.TEXT_RESET);
		    }



		
		    private static void listarJogos() {
		        for (Jogo jogo : controller.listarProdutos()) {
		            jogo.sobre();
		        }
		    }
		
		    private static void buscarJogo() {
		        System.out.print("Digite o ID do jogo: ");
		        int idBusca = leia.nextInt();
		        try {
		            Jogo jogo = controller.buscarProdutoPorId(idBusca);
		            jogo.sobre();
		        } catch (RuntimeException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		
		    private static void cadastrarJogo() {
		        System.out.print("Digite o tipo de jogo (1 - Físico, 2 - Digital): ");
		        int tipo = leia.nextInt();
		        System.out.print("Digite o ID do jogo: ");
		        int id = leia.nextInt();
		        leia.nextLine(); // limpa buffer
		
		        System.out.print("Digite o nome do jogo: ");
		        String nome = leia.nextLine();
		        System.out.print("Digite a plataforma do jogo: ");
		        String plataforma = leia.nextLine();
		        System.out.print("Digite o preço do jogo: ");
		        double preco = leia.nextDouble();
		
		        if (tipo == 1) {
		            leia.nextLine();
		            System.out.print("Digite a mídia do jogo: ");
		            String midia = leia.nextLine();
		            controller.cadastrarProduto(new JogoFisico(id, nome, plataforma, preco, midia));
		        } else if (tipo == 2) {
		            System.out.print("Digite o tamanho em GB do jogo: ");
		            double tamanhoGB = leia.nextDouble();
		            controller.cadastrarProduto(new JogoDigital(id, nome, plataforma, preco, tamanhoGB));
		        } else {
		            System.out.println("Tipo inválido!");
		        }
		    }
		
		    private static void atualizarJogo() {
		        System.out.print("Digite o ID do jogo que deseja atualizar: ");
		        int idAtualizar = leia.nextInt();
		        leia.nextLine();
		
		        System.out.print("Digite o novo nome: ");
		        String novoNome = leia.nextLine();
		        System.out.print("Digite a nova plataforma: ");
		        String novaPlataforma = leia.nextLine();
		        System.out.print("Digite o novo preço: ");
		        double novoPreco = leia.nextDouble();
		
		        System.out.print("Digite o novo tipo (1 - Físico, 2 - Digital): ");
		        int tipoAtualizar = leia.nextInt();
		        leia.nextLine();
		
		        if (tipoAtualizar == 1) {
		            System.out.print("Digite a nova mídia: ");
		            String novaMidia = leia.nextLine();
		            controller.atualizarProduto(idAtualizar, new JogoFisico(idAtualizar, novoNome, novaPlataforma, novoPreco, novaMidia));
		        } else if (tipoAtualizar == 2) {
		            System.out.print("Digite o novo tamanho em GB: ");
		            double novoTamanhoGB = leia.nextDouble();
		            controller.atualizarProduto(idAtualizar, new JogoDigital(idAtualizar, novoNome, novaPlataforma, novoPreco, novoTamanhoGB));
		        } else {
		            System.out.println("Tipo inválido!");
		        }
		    }
		
		    private static void deletarJogo() {
		        System.out.print("Digite o ID do jogo que deseja deletar: ");
		        int idDeletar = leia.nextInt();
		        try {
		            controller.deletarProduto(idDeletar);
		        } catch (RuntimeException e) {
		            System.out.println(e.getMessage());
		        }
		    }
		}
