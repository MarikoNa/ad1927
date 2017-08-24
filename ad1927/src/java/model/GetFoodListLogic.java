/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.FoodDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kubotamari
 */
public class GetFoodListLogic {
    public List<Food> execute(ArrayList<String> nameList) {
        FoodDAO dao = new FoodDAO();
        List<Food> foodList = dao.findFood(nameList);
        return foodList;
    }
}
