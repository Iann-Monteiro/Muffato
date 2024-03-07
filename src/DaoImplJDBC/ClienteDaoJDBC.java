package DaoImplJDBC;

import Enums.UsuarioEnums;
import Models.ClienteModel;
import ModelsDao.ClienteDao;
import db.DB;
import db.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJDBC implements ClienteDao {
    private Connection connection;

    public ClienteDaoJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void insert(ClienteModel cliente) {
        PreparedStatement statement = null;

        try{
            statement = connection.prepareStatement(
                    "INSERT INTO cliente (nome, cpf, rg, email, telefone) " +
                            "VALUES (?, ?, ?, ?, ?)",
                    statement.RETURN_GENERATED_KEYS
            );

            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getRg());
            statement.setString(4, cliente.getEmail());
            statement.setString(5, cliente.getTelefone());

            int rowsAffected = statement.executeUpdate();

            if(rowsAffected > 0){
                ResultSet resultSet = statement.getGeneratedKeys();
                if(resultSet.next()){
                    int id = resultSet.getInt(1);
                    cliente.setId(id);
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
    public void update(ClienteModel cliente) {
        PreparedStatement statement = null;

        try{
            statement = connection.prepareStatement(
                    "UPDATE cliente set nome = ?, cpf =  ?, rg = ?, email = ?, telefone=? WHERE id = ?"
            );

            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getRg());
            statement.setString(4, cliente.getEmail());
            statement.setString(5, cliente.getTelefone());
            statement.setInt(6, cliente.getId());

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
            statement = connection.prepareStatement("DELETE FROM cliente WHERE id = ?");

            statement.setInt(1, id);

            int row = statement.executeUpdate();

            if(row == 0){
                throw new DBException("Id não encontrado!");
            }
        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }finally {
            DB.closeStatement(statement);
        }
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
                return  instantiateCliente(resultSet);
            }

            return null;
        }catch(SQLException e){
            throw new DBException(e.getMessage());
        }finally {
            DB.closeStatement(statement);
            DB.closeResultSet(resultSet);
        }
    }

    private ClienteModel instantiateCliente(ResultSet resultSet) throws SQLException {
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

    @Override
    public List<ClienteModel> findAll() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            statement = connection.prepareStatement("SELECT cliente.* FROM cliente ORDER BY nome");

            resultSet = statement.executeQuery();

            List<ClienteModel> list = new ArrayList<>();
            while(resultSet.next()){
                ClienteModel cliente = instantiateCliente(resultSet);
                list.add(cliente);
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
