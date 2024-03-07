import ModelsDao.AdminDao;
import ModelsDao.ClienteDao;
import ModelsDao.DaoFactory;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        AdminDao adminDao = DaoFactory.createAdminDao();
        ClienteDao clienteDao = DaoFactory.createClienteDao();

        System.out.println(clienteDao.findAll());
    }
}