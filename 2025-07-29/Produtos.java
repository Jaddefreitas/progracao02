public class Produtos {

    public String nome;
    public Double preco;
    public Integer quantidade;
    

    public Produtos(String nome, Double preco, Integer quantidade){
        
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;

    }

    public void displayInfo(){

        System.out.println("" + nome + "" + preco + "" + quantidade);
    }
    
    public Double total_valor_produto(){

        Double total_valor_produto = this.preco * this.quantidade;
        return total_valor_produto;
        
    }
}
