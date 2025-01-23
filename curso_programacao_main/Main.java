package curso_programacao_main;

import java.util.Scanner;

import Entities.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estoque estoque = new Estoque(1000); //inicia um estoque com a capacidade de 1000 produtos
		Scanner sc = new Scanner(System.in);
		
		boolean exibirMenu = true; 
		
		while(exibirMenu) {
			
			int opcao;
			System.out.println("MENU");
			System.out.println("1 - Cadastrar Produto");
			System.out.println("2 - Remover Produto");
			System.out.println("3 - Listar Produtos");
			System.out.println("4 - Buscar Produto");
			System.out.println("5 - Encerrar/ Sair");
			System.out.print("Digite sua opção: ");
			opcao = sc.nextInt();
			
			switch (opcao) {
				
			case 1:
				System.out.println("[MENU/ CADASTRO DE PRODUTO]");
				System.out.print("Nome do produto: ");
				String nome = sc.next();
				System.out.print("Preço: ");
				double preco = sc.nextDouble();
				System.out.print("Codigo: ");
				int codigo = sc.nextInt();
				sc.nextLine();
				System.out.print("Quantidade: ");
				int quantidade = sc.nextInt();
				sc.nextLine();
				Produto produto = new Produto(nome, preco, codigo);				
				estoque.adicionarProdutoNoEstoque(produto, quantidade);
				
				System.out.printf("Produto: ID: %d | Nome: %s | R$ %.2f | Qt. %d%n", codigo, nome, preco, quantidade);
				System.out.println("[Adicionado com sucesso] pressione enter para voltar ao menu...");
				sc.nextLine();
				break;
			
			case 2:
				System.out.println("[MENU/ REMOVER PRODUTO]");
				System.out.print("Codigo do produto: ");
				codigo = sc.nextInt();
				sc.nextLine();
				System.out.print("Quantidade: ");
				quantidade = sc.nextInt();
				sc.nextLine();
				
				estoque.removerProduto(codigo, quantidade);
				produto = estoque.buscarProduto(codigo);
				
				System.out.printf("Produto: ID: %d | Nome: %s | Qt. %d%n", codigo, produto.getNome(), quantidade);
				System.out.println("[Removido com sucesso!] pressione enter para voltar ao menu...");
				sc.nextLine();
				break;
				
			case 3:
				System.out.println("[MENU/ LISTA DE PRODUTOS EM ESTOQUE]");
				
				estoque.ListarProdutosEmEstoque();
				
				System.out.println("pressione enter para voltar ao menu...");
				sc.nextLine();
				break;
			
			case 4:
				System.out.println("[MENU/ BUSCAR PRODUTO]");
				System.out.print("Codigo do produto: ");
				codigo = sc.nextInt();
				sc.nextLine();
				produto = estoque.buscarProduto(codigo);
				quantidade = estoque.consultarQuantidadeEmEstoque(codigo);
				
				System.out.printf("Produto: ID: %d | Nome: %s | Qt. %d%n", codigo, produto.getNome(), quantidade);
				System.out.println("pressione enter para voltar ao menu...");
				sc.nextLine();
				break;
				
			case 5:
				System.out.println("Programa encerrado...");
				exibirMenu = false;
				break;
				
			default:
				System.out.println("Opção inválida");
				break;
				
			}
			
			
			
		}
				
		sc.close();
		


	}

}
