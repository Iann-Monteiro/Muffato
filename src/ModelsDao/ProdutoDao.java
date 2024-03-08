package ModelsDao;

public interface ProdutoDao {
    double calValorProduto(double precoProduto, int quantidadeProduto);
    void findProduto(String idProduto);



}
