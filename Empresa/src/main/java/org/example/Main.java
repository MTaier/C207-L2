package org.example;

import br.inatel.DAO.UserDAO;
import br.inatel.Model.User;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        User user1 = new User("Leticia", "222.222.222-22", 5);
        User user2 = new User("Felipe", "651.218.684-26", 5);
        User user3 = new User("Maria", "879.125.684-18", 5);

        userDAO.updateUser(3, user1);

        //userDAO.insertUser(user2);
        //userDAO.insertUser(user3);

        userDAO.selectUser();

        userDAO.selectUserByProject2();

        userDAO.selectUserAlexandre();

        //userDAO.deleteUser(6);
    }
}