/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccountDAO;

/**
 *
 * @author kishi
 */
public class AccountLogic {
     public boolean addUser(Account account) {
    AccountDAO dao = new AccountDAO();
    // 重複アカウントの確認
    Login login = new Login(account.getUserId(), account.getPass());
    if(dao.findByLogin(login) != null) return false;
    boolean rc = dao.addUser(account);
    return rc ;
     }
     
}


