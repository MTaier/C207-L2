package br.inatel.DAO;

import br.inatel.Model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends ConnectionDAO{
    boolean sucesso = false;

    public boolean insertUser(User user) {
        connectToDB();

        String sql = "INSERT INTO empregado (nome, cpf, projeto) values (?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getNome());
            pst.setString(2, user.getCpf());
            pst.setInt(3, user.getProjeto());
            pst.execute();
            sucesso = true;
        } catch (SQLException exception) {
            System.out.println("Erro: " + exception.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exception) {
                System.out.println("Erro: " + exception.getMessage());
            }
        }
        return sucesso;
    }

    public boolean updateUser(int id, User user) {
        connectToDB();
        String sql = "UPDATE empregado SET nome = ?, cpf = ?, projeto = ? where id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getNome());
            pst.setString(2, user.getCpf());
            pst.setInt(3, user.getProjeto());
            pst.setInt(4, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exception) {
                System.out.println("Erro: " + exception.getMessage());
            }
        }
        return sucesso;
    }

    public boolean deleteUser(int id) {
        connectToDB();
        String sql = "DELETE FROM empregado where id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sucesso = true;
        } catch (SQLException exception) {
            System.out.println("Erro: " + exception.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exception) {
                System.out.println("Erro: " + exception.getMessage());
            }
        }
        return sucesso;
    }

    public ArrayList<User> selectUser() {
        ArrayList<User> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM empregado";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de users: ");
            while (rs.next()) {
                User userAux =  new User(rs.getString("nome"), rs.getString("cpf"), rs.getInt("projeto"));
                System.out.println("Nome = " + userAux.getNome());
                System.out.println("CPF = " + userAux.getCpf());
                System.out.println("Projeto = " + userAux.getProjeto());
                System.out.println("-----------------------------------------");
                users.add(userAux);
            }
            sucesso = true;
        } catch (SQLException exception) {
            System.out.println("Erro: " + exception.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException exception) {
                System.out.println("Erro: " + exception.getMessage());
            }
        }
        return users;
    }

    public ArrayList<User> selectUserByProject2() {
        ArrayList<User> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM empregado WHERE projeto = 2";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de users do projeto 2: ");
            while (rs.next()) {
                User userAux = new User(rs.getString("nome"), rs.getString("cpf"), rs.getInt("projeto"));
                System.out.println("Nome = " + userAux.getNome());
                System.out.println("CPF = " + userAux.getCpf());
                System.out.println("Projeto = " + userAux.getProjeto());
                System.out.println("-----------------------------------------");
                users.add(userAux);
            }
            sucesso = true;
        } catch (SQLException exception) {
            System.out.println("Erro: " + exception.getMessage());
            sucesso = false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException exception) {
                System.out.println("Erro ao fechar recursos: " + exception.getMessage());
            }
        }
        return users;
    }

    public ArrayList<User> selectUserAlexandre() {
        ArrayList<User> users = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM empregado WHERE nome = 'Alexandre'";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de users do projeto 2: ");
            while (rs.next()) {
                User userAux = new User(rs.getString("nome"), rs.getString("cpf"), rs.getInt("projeto"));
                System.out.println("Nome = " + userAux.getNome());
                System.out.println("CPF = " + userAux.getCpf());
                System.out.println("Projeto = " + userAux.getProjeto());
                System.out.println("-----------------------------------------");
                users.add(userAux);
            }
            sucesso = true;
        } catch (SQLException exception) {
            System.out.println("Erro: " + exception.getMessage());
            sucesso = false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException exception) {
                System.out.println("Erro ao fechar recursos: " + exception.getMessage());
            }
        }
        return users;
    }
}
