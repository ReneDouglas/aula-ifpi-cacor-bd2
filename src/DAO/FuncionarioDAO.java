package DAO;

import bancoDeDados.DriverMySQL;
import model.Funcionario;

import java.sql.*;
import java.time.LocalDate;
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
    public List<Funcionario> listarTodos() {
        return List.of();
    }

    public Funcionario listarPorId(Integer id) {

        Connection con = DriverMySQL.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM funcionarios WHERE id = ?")) {

            ResultSet rs = pstmt.executeQuery();
            Funcionario funcionario = null;
            while(rs.next()) {

                funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                //funcionario.setDataNasc(rs.getDate("data_nasc"));
                funcionario.setSalario(rs.getBigDecimal("salario"));
                //funcionario.setDataRegistro(rs.getTimestamp("data_registro"));
                funcionario.setAtivo(rs.getBoolean("cadastro_ativo"));
            }
            return funcionario;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void atualizar(Funcionario funcionario) {

        Connection con = DriverMySQL.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("""
            UPDATE funcionarios SET
                        nome = ?,
                        data_nasc = ?, 
                        salario = ?, 
                        data_registro = ?, 
                        cadastro_ativo = ? 
            WHERE id = ?;
            
            """);
            stmt.setString(1, funcionario.getNome());
            stmt.setDate(2, Date.valueOf(funcionario.getDataNasc()));
            stmt.setBigDecimal(3, funcionario.getSalario());
            stmt.setTimestamp(4, Timestamp.valueOf(funcionario.getDataRegistro()));
            stmt.setBoolean(5, funcionario.isAtivo());
            stmt.setInt(6, funcionario.getId());

            stmt.executeUpdate();
            System.out.println("Funcionário atualizado com sucesso.");
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public void deletar(Funcionario funcionario) {

        Connection con = DriverMySQL.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("""
                    DELETE FROM funcionarios WHERE id = ?;
            """);
            stmt.setInt(1, funcionario.getId());

            stmt.executeUpdate();
            System.out.println("Funcionário deletado com sucesso.");
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
