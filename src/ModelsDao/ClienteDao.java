package ModelsDao;

import Models.ClienteModel;

import java.util.List;

public interface ClienteDao {
    void insert(ClienteModel cliente);
    void update(ClienteModel cliente);
    void delete(Integer id);
    ClienteModel findById(Integer id);
    List<ClienteModel> findAll();
}
