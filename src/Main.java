<<<<<<< HEAD
public class Main {
    public static void main(String[] args) {
        
=======
import Models.AdminModel;
import Models.ClienteModel;
import Models.UsuarioModel;
import ModelsDao.AdminDao;
import ModelsDao.ClienteDao;
import ModelsDao.DaoFactory;
import db.DB;
import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        ClienteDao clienteDao = DaoFactory.createClienteDao();

        ClienteModel cliente = clienteDao.findById(3);
        clienteDao.findAll();

        System.out.println(cliente);

        System.out.println(clienteDao.findAll());
>>>>>>> 19f186a (commit 1)
    }
}