package DaoImplJDBC;

import Enums.UsuarioEnums;
import Models.ClienteModel;
import ModelsDao.AdminDao;
import ModelsDao.ClienteDao;
import db.DB;
import db.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClienteDaoJDBC implements ClienteDao {
    private Connection connection;

    public ClienteDaoJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(ClienteModel cliente) {

    }

    @Override
    public void update(ClienteModel cliente) {

    }

    @Override
    public void delte(ClienteModel cliente) {

    }

    @Override
    public ClienteModel findById(Integer id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            statement = connection.prepareStatement(
                    "SELECT cliente.* " +
                            "FROM cliente WHERE cliente.id = ?");

            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if(resultSet.next()){
                ClienteModel cliente = new ClienteModel();
                cliente.setId(resultSet.getInt("id"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setRg(resultSet.getString("rg"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setTipo(UsuarioEnums.CLIENTE);

                return cliente;
            }

            return null;
        }catch(SQLException e){
            throw new DBException(e.getMessage());
        }finally {
            DB.closeStatement(statement);
            DB.closeResultSet(resultSet);
        }
    }

    @Override
    public List<ClienteModel> findAll() {
        return null;
    }
}
