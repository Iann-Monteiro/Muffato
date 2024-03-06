package ModelsDao;

import DaoImplJDBC.AdminDaoJDBC;
import DaoImplJDBC.ClienteDaoJDBC;
import db.DB;
import java.sql.*;


public class DaoFactory {
    public static AdminDao createAdminDao(){
        return new AdminDaoJDBC();
    }

    public static ClienteDao createClienteDao() throws SQLException {
        return new ClienteDaoJDBC(DB.getConnection());
    }

}
