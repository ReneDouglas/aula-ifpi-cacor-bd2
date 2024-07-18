import DAO.FuncionarioDAO;
import bancoDeDados.DriverMySQL;
import model.Funcionario;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

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

        funcionarioDAO.inserir(funcionario);

        try {
            /*ps = con.prepareStatement("SELECT * FROM funcionarios");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("nome"));
            }
            ps.close();
            con.close();*/



        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}