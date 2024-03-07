package ModelsDao;

import Models.AdminModel;

import java.util.List;

public interface AdminDao {
    void insert(AdminModel admin);
    void update(AdminModel admin);
    void delete(Integer id);
    AdminModel findById(Integer id);
    List<AdminModel> findAll();
}
