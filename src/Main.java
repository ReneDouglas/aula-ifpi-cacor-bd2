import DAO.FuncionarioDAO;
import bancoDeDados.DriverMySQL;
import model.Funcionario;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 1 -> Implemente a função de listar para que retorne todos os funcionários cadastrados.
 *      Utilize o código abaixo (linhas 48:70), mas realize os ajustes necessários:
 *          - Carregue os dados através do modelo Funcionario para, então, apresentá-los
 *          - Corrija o problema no alinhamento das colunas do relatório.
 *
 * 2 -> Implemente a função de alterar/atualizar um funcionário.
 *
 * 3 -> Implemente a função de deletar um funcionário.
 */

public class Main {
    public static void main(String[] args) {


        // INSERIR FUNCIONARIO

        Connection con = DriverMySQL.getConnection();
        PreparedStatement ps = null;

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario();

        funcionario.setNome("TESTE");
        funcionario.setSalario(new BigDecimal("2500.50"));
        funcionario.setDataNasc(LocalDate
                .parse("01/07/1992",
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        funcionario.setDataRegistro(LocalDateTime.now());
        funcionario.setAtivo(true);

        //funcionarioDAO.inserir(funcionario);

        // LISTAR TODOS OS FUNCIONARIOS

        try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM funcionarios")) {

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {

                var dadosFuncionario = "ID: %s \t NOME: %s \t DATA NASC.: %s \t SALÁRIO: %s \t DT. REGISTRO: %s \t ATIVO: %s"
                        .formatted(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getDate("data_nasc"),
                                rs.getBigDecimal("salario"),
                                rs.getTimestamp("data_registro"),
                                rs.getBoolean("cadastro_ativo")
                        );

                System.out.println(dadosFuncionario);
            }
            pstmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}