package DaoImplJDBC;

import Enums.UsuarioEnums;
import Models.AdminModel;
import ModelsDao.AdminDao;
import db.DB;
import db.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoJDBC implements AdminDao {

    private Connection connection;

    public AdminDaoJDBC(Connection connection){
        this.connection = connection;
    }
    @Override
    public void insert(AdminModel admin) {
        PreparedStatement statement = null;

        try{
            statement = connection.prepareStatement(
                    "INSERT INTO admin (nome, cpf, rg, email, telefone) " +
                            "VALUES (?, ?, ?, ?, ?)",
                    statement.RETURN_GENERATED_KEYS
            );

            statement.setString(1, admin.getNome());
            statement.setString(2, admin.getCpf());
            statement.setString(3, admin.getRg());
            statement.setString(4, admin.getEmail());
            statement.setString(5, admin.getTelefone());

            int rowsAffected = statement.executeUpdate();

            if(rowsAffected > 0){
                ResultSet resultSet = statement.getGeneratedKeys();
                if(resultSet.next()){
                    int id = resultSet.getInt(1);
                    admin.setId(id);
                }
                DB.closeResultSet(resultSet);
            }else{
                throw new DBException("Erro inesperado. Nenhuma linha foi afetada");
            }

        }catch(SQLException e) {
            throw new DBException(e.getMessage());
        }finally {
            DB.closeStatement(statement);
        }
    }

    @Override
    public void update(AdminModel admin) {
        PreparedStatement statement = null;

        try{
            statement = connection.prepareStatement(
                    "UPDATE admin set nome = ?, cpf =  ?, rg = ?, email = ?, telefone=? WHERE id = ?"
            );

            statement.setString(1, admin.getNome());
            statement.setString(2, admin.getCpf());
            statement.setString(3, admin.getRg());
            statement.setString(4, admin.getEmail());
            statement.setString(5, admin.getTelefone());
            statement.setInt(6, admin.getId());

            statement.executeUpdate();
        }catch(SQLException e) {
            throw new DBException(e.getMessage());
        }finally {
            DB.closeStatement(statement);
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("DELETE FROM admin WHERE id = ?");

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if(rows == 0){
                throw new DBException("Id não encontrado!");
            }
        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }finally {
            DB.closeStatement(statement);
        }
    }

    @Override
    public AdminModel findById(Integer id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            statement = connection.prepareStatement(
                    "SELECT admin.* " +
                            "FROM admin WHERE admin.id = ?");

            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                return  instantiateAdmin(resultSet);
            }

            return null;
        }catch(SQLException e){
            throw new DBException(e.getMessage());
        }finally {
            DB.closeStatement(statement);
            DB.closeResultSet(resultSet);
        }
    }

    private AdminModel instantiateAdmin(ResultSet resultSet) throws SQLException {
        AdminModel admin = new AdminModel();
        admin.setId(resultSet.getInt("id"));
        admin.setCpf(resultSet.getString("cpf"));
        admin.setEmail(resultSet.getString("email"));
        admin.setNome(resultSet.getString("nome"));
        admin.setRg(resultSet.getString("rg"));
        admin.setTelefone(resultSet.getString("telefone"));
        admin.setTipo(UsuarioEnums.ADMIN);

        return admin;
    }

    @Override
    public List<AdminModel> findAll() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            statement = connection.prepareStatement("SELECT admin.* FROM admin ORDER BY nome");

            resultSet = statement.executeQuery();

            List<AdminModel> list = new ArrayList<>();
            while(resultSet.next()){
                AdminModel admin = instantiateAdmin(resultSet);
                list.add(admin);
            }

            return list;

        }catch(SQLException e){
            throw new DBException(e.getMessage());
        }finally {
            DB.closeResultSet(resultSet);
            DB.closeStatement(statement);
        }
    }
}
