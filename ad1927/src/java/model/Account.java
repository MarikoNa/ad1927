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
public class Account {
    private String name;
    private String userId;
    private String pass;
    private int morning;
    private int noon;
    private int night;
    
    public Account(String name, String userId,String pass, int morning,int noon,int night) {
        this.name = name;
        this.userId = userId;
        this.pass = pass;
        this.morning = morning;
        this.noon = noon;
        this.night = night;
    }
    
    public String getName(){ return name; }
    public String getUserId() {return userId;}
    public String getPass() {return pass;}
    public int getMorning() {return morning;}
    public int getNoon() {return noon;}
    public int getNight() {return night;}
}
