/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author kubotamari
 */
public class Food implements Serializable{
    private String name;
    private int number;
    private int weight;
    public Food(String name, int number, int weight) {
        this.name = name;
        this.number = number;
        this.weight = weight;
    }
    public String getName(){ return name; }
    public int getNumber(){ return number; }
    public int getWeight(){ return weight; }
    
}
