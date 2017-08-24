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
public class Login {
    private String userId;
    private String pass;
    public Login(String userId,String pass) {
        this.userId = userId;
        this.pass = pass;
    }
    public String getUserId() {return userId;}
    public String getPass() {return pass;}
}
