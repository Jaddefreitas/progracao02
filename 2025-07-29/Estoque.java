public class Estoque{

    public Integer quantidade_cada_produto;
    public Double total_valor_produto;
    public Integer adiciona_produto;
    public Integer remove_produto;

    public Estoque(Integer quantidade_cada_produto, Double total_valor_produto, Integer adiciona_produto, Integer remove_produto){

        this.quantidade_cada_produto = quantidade_cada_produto;
        this.total_valor_produto = total_valor_produto;
        this.adiciona_produto = adiciona_produto;
        this.remove_produto = remove_produto;
    }

    public void displayInfo(){

    System.out.println("" + quantidade_cada_produto + "" + total_valor_produto + "" + adiciona_produto + "" + remove_produto);
    }

}
