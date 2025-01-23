package Entities;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
	private Produto[] ListaProdutos;
	private int[] quantidadesPorProduto;
	private int capacidadeMaximaArmazenamento;
	private int totalDeProdutosRegistrados;
	
	public Estoque(int capacidadeMaximaArmazenamento) {
		this.capacidadeMaximaArmazenamento = capacidadeMaximaArmazenamento;
		this.ListaProdutos = new Produto[capacidadeMaximaArmazenamento];
		this.quantidadesPorProduto = new int[capacidadeMaximaArmazenamento];
		this.totalDeProdutosRegistrados = 0;
		
	}
	
	public void adicionarProdutoNoEstoque(Produto produto, int quantidade) {
		for(int i = 0; i < totalDeProdutosRegistrados; i++) {
			if(ListaProdutos[i].getCodigo() == produto.getCodigo()) {
				quantidadesPorProduto[i] += quantidade;
				return;
			}
		}
		
		if(totalDeProdutosRegistrados < capacidadeMaximaArmazenamento) {
			ListaProdutos[totalDeProdutosRegistrados] = produto;
			quantidadesPorProduto[totalDeProdutosRegistrados] = quantidade;
			totalDeProdutosRegistrados++;
		}
		
	}
	
	public void removerProduto(int codigo, int quantidade) {
		for(int i = 0; i < totalDeProdutosRegistrados; i++) {
			if(ListaProdutos[i].getCodigo() == codigo) {
				if( quantidadesPorProduto[i] >= quantidade) {
					quantidadesPorProduto[i]-= quantidade;
					
					if(quantidadesPorProduto[i] == 0) {
						for (int j = i; j < totalDeProdutosRegistrados - 1; j++) {
							ListaProdutos[j] = ListaProdutos[j + 1];
							quantidadesPorProduto[j] = quantidadesPorProduto[j + 1];
						}
						totalDeProdutosRegistrados--;
					}
					return;
				}
				else {
					throw new IllegalArgumentException("Quantidade em estoque insuficiente");
				}
			}
		}
		throw new IllegalArgumentException("Produto não encontrado no estoque");
	}
	
	public Produto buscarProduto(int codigo) {
		for (int i = 0; i < totalDeProdutosRegistrados; i++) {
			if (ListaProdutos[i].getCodigo() == codigo) {
				return ListaProdutos[i];
			}
		}
		return null;
	}
	
	public void ListarProdutosEmEstoque(){
		List<String> produtosDisponiveis = new ArrayList<>();
		
		for (int i = 0; i < totalDeProdutosRegistrados; i++) {
			Produto produto = ListaProdutos[i];
			String descricao = String.format(
					"ID: %d | Nome: %s | Qt.: %d", produto.getCodigo(), produto.getNome(), quantidadesPorProduto[i]
					);
			produtosDisponiveis.add(descricao);
		}
		
		if (produtosDisponiveis.isEmpty()) {
			System.out.println("Não há produtos em estoque");
		}
		else {
			for (String produto : produtosDisponiveis) {
				System.out.println(produto);
			}
		}
	}
	
	public int consultarQuantidadeEmEstoque(int codigo) {
		for (int i = 0; i < totalDeProdutosRegistrados; i++) {
			if(ListaProdutos[i].getCodigo() == codigo) {
				return quantidadesPorProduto[i];
			}
		}
		return 0;
	}
	

}
