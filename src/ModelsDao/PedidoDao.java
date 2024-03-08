package ModelsDao;

public interface PedidoDao {
    void findPedido(int idPedido);
    void calcFrete(double distancia, int quantidadeTotal);
    void quantidadeTotal(int idPedido, int quantidadeProduto);
}
