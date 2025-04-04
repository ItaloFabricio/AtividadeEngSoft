import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    String nome;
    double preco;

    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}

public class SistemaDeCompras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> carrinho = new ArrayList<>();

        while (true) {
            System.out.println("Escolha um item do menu \nMENU:");
            System.out.println("1. Adicionar produto ao carrinho");
            System.out.println("2. Visualizar carrinho");
            System.out.println("3. Finalizar compra");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();
                    carrinho.add(new Produto(nome, preco));
                    System.out.println(nome + " adicionado ao carrinho!");
                    break;
                case 2:
                    if (carrinho.isEmpty()) {
                        System.out.println("O carrinho está vazio.");
                    } else {
                        System.out.println("Produtos no carrinho:");
                        for (Produto p : carrinho) {
                            System.out.println("- " + p.nome + " (R$" + p.preco + ")");
                        }
                    }
                    break;
                case 3:
                    double total = 0;
                    System.out.println("\nResumo da compra:");
                    for (Produto p : carrinho) {
                        System.out.println("- " + p.nome + " (R$" + p.preco + ")");
                        total += p.preco;
                    }
                    System.out.println("Total a pagar: R$" + total);
                    System.out.println("Compra finalizada! Obrigado por comprar conosco.");
                    carrinho.clear();
                    break;
                case 4:
                    System.out.println("Saindo do sistema. Até logo!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                case 5;
                    System.out.println("\nDigite o número do produto a ser removido: ");
                    int index = scanner.nextInt() - 1;
                    if (index >= 0 && index < carrinho.size()) {
                        carrinho.remove(index);
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("Número inválido!");
                    }
                    break;
            }
        }
    }
}