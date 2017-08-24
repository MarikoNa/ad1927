/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Food;

/**
 *
 * @author kubotamari
 */
public class FoodDAO {
    private final String DRIVER_NAME = "org.apache.derby.jdbc.ClientDriver";
    private final String JDBC_URL = "jdbc:derby://localhost:1527/healthyDB";

    private final String DB_USER = "db";
    private final String DB_PASS = "db";
    
    private int sum = 0;
    
    public List<Food> findFood(ArrayList<String> nameList) {
        Connection conn = null;
        List<Food> foodList = new ArrayList<Food>();
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(
            JDBC_URL, DB_USER, DB_PASS);
            
            for(int i=0; i< nameList.size(); i++) {
            // SELECT文の準備
            String sql = "SELECT NAME, NUMBER, WEIGHT FROM FOOD WHERE NAME = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, nameList.get(i));
            
            // SELECTを実行
            ResultSet rs = pStmt.executeQuery();
            
            // SELECT文の結果をArrayListに格納
            if(rs.next()) {
                String name = rs.getString("NAME");
                int number = rs.getInt("NUMBER");
                int weight = rs.getInt("WEIGHT");
                Food food = new Food(name, number, weight);
                foodList.add(food);
            }
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if(conn != null) {
                try {
                    conn.close();
                } catch(SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return foodList;
    }
    public int calculate(ArrayList<String> nameList) {
        Connection conn = null;
        List<Food> foodList = new ArrayList<Food>();
        //String food = "";
        try { 
            // JDBCドライバを読み込む
            Class.forName(DRIVER_NAME);
            
            // データベースに接続
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            
            for(int i=0; i<foodList.size(); i++) {
            // セレクト文を準備
            String sql = "SELECT NAME, NUMBER, WEIGHT FROM FOOD WHERE NAME = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,nameList.get(i));
            
            // SELECT文を実行し、結果表を取得
            ResultSet rs = pStmt.executeQuery();
            
            // 一致した食品が存在した場合
            if(rs.next()) {
                String name = rs.getString("NAME");
                int number = rs.getInt("NUMBER");
                int weight = rs.getInt("WEIGHT");
                Food food = new Food(name, number, weight);
            }
            }
        } catch(SQLException e) {
           e.printStackTrace();
           return 0;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } finally {
            // データベースを切断
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();;
                    return 0;
                }
            }
        }
        return sum;
    }
}
