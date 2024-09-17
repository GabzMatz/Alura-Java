public class Compras{

    private String produto;
    private int valor;

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Compras(String produto, int valor) {
        this.produto = produto;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Compras{" +
                "produto='" + produto + '\'' +
                ", valor=" + valor +
                '}';
    }
}
