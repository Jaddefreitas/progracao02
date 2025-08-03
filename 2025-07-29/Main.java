import java.util.Scanner;

public class Main{
    public static void main (String[]args){

        System.out.println("Digite os dados do produto:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome:");
        String nome = scanner.nextLine();
        System.out.print("Preco:");
        Double preco = Double.valueOf(scanner.nextLine());
        System.out.print("Quantidade em estoque:");
        Integer quantidade = Integer.valueOf(scanner.nextLine());
        Produtos produto1 = new Produtos(nome, preco, quantidade);

        Double total_valor_produto = produto1.preco * produto1.quantidade;

        System.out.println("Dados do produto:" + produto1.nome + "," +produto1.preco+ "," +produto1.quantidade+ "," +total_valor_produto);
        
        System.out.println("Insira o numero de produtos que deseja adicionar:");
        Integer adiciona_produto = Integer.valueOf(scanner.nextLine());
        produto1.quantidade = produto1.quantidade + adiciona_produto;
        total_valor_produto = produto1.preco * produto1.quantidade;

        System.out.println("Dado atualizado:" + produto1.nome + "," +produto1.preco+ "," +produto1.quantidade+ "," +total_valor_produto);


        System.out.println("Insira o numero de produtos que deseja remover:");
        Integer remove_produto = Integer.valueOf(scanner.nextLine());
        produto1.quantidade = produto1.quantidade - remove_produto;
        total_valor_produto = produto1.preco * produto1.quantidade;

        System.out.println("Dado atualizado:" + produto1.nome + "," +produto1.preco+ "," +produto1.quantidade+ "," +total_valor_produto);

        scanner.close();
    }
}
