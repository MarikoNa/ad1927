/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author g15927nm
 */
import dao.AccountDAO;
import javax.servlet.http.HttpSession;

public class LoginLogic {
    //Account account;
    public Account execute(Login login) {
        AccountDAO dao = new AccountDAO();
        Account account  = dao.findByLogin(login);
        return account;
    }
}
