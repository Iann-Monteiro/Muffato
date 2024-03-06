package ModelsDao;

import Models.AdminModel;
import Models.ClienteModel;

import java.util.List;

public interface AdminDao {
    void insert(AdminModel admin);
    void update(AdminModel admin);
    void delte(AdminModel admin);
    AdminModel findById(Integer id);
    List<AdminModel> findAll();
}
