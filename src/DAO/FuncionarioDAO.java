package DAO;

import bancoDeDados.DriverMySQL;
import model.Funcionario;

import java.sql.*;
import java.util.List;

public class FuncionarioDAO {

    public void inserir(Funcionario
                         funcionario){

        Connection con = DriverMySQL.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("""
            INSERT INTO funcionarios (nome, data_nasc, salario, data_registro, cadastro_ativo)
            VALUES (?, ?, ?, ?, ?)
            """);
            stmt.setString(1, funcionario.getNome());
            stmt.setDate(2, Date.valueOf(funcionario.getDataNasc()));
            stmt.setBigDecimal(3, funcionario.getSalario());
            stmt.setTimestamp(4, Timestamp.valueOf(funcionario.getDataRegistro()));
            stmt.setBoolean(5, funcionario.isAtivo());

            stmt.execute();
            System.out.println("Funcionário cadastrado com sucesso.");
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
    public List<Funcionario> listar() {
        return List.of();
    }
    public void atualizar(Funcionario funcionario) {

    }
    public void deletar(Funcionario funcionario) {

    }
}
