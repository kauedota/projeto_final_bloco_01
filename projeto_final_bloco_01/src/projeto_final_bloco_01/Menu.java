package projeto_final_bloco_01;

import java.util.Scanner;

public class Menu {
    
    public static void main(String[] args) {
        
        Scanner leia = new Scanner(System.in);
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
                    Jogo.listarJogos();
                    break;
                case 2:
                    System.out.print("Digite o ID do jogo: ");
                    int idBusca = leia.nextInt();
                    Jogo.buscarJogoPorId(idBusca);
                    break;
                case 3:
                    Jogo.cadastrarJogo();
                    break;
                case 4:
                    System.out.print("Digite o ID do jogo a ser atualizado: ");
                    int idAtualizar = leia.nextInt();
                    Jogo.atualizarJogo(idAtualizar);
                    break;
                case 5:
                    System.out.print("Digite o ID do jogo a ser deletado: ");
                    int idDeletar = leia.nextInt();
                    Jogo.deletarJogo(idDeletar);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0); // <-- o while tem que ficar aqui, fora do switch!
        
        leia.close();
    }
}
