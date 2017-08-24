/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author g15927nm
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
    private final String DRIVER_NAME = "org.apache.derby.jdbc.ClientDriver";
    private final String JDBC_URL = "jdbc:derby://localhost:1527/healthyDB";
          
    private final String DB_USER = "db";
    private final String DB_PASS = "db";
    
    public Account findByLogin(Login login) {
        Connection conn = null;
        Account account = null;
        try { 
            // JDBCドライバを読み込む
            Class.forName(DRIVER_NAME);
            
            // データベースに接続
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            
            // セレクト文を準備
            String sql = "SELECT NAME, USER_ID, PASS, MORNING, NOON, NIGHT FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,login.getUserId());
            pStmt.setString(2,login.getPass());
            
            // SELECT文を実行し、結果表を取得
            ResultSet rs = pStmt.executeQuery();
            
            // 一致したユーザーが存在した場合
            // そのユーザーを表すAccountインスタンスを生成
            if(rs.next()) {
                String name = rs.getString("NAME");
                String userId = rs.getString("USER_ID");
                String pass = rs.getString("PASS");
                int morning = rs.getInt("MORNING");
                int noon = rs.getInt("NOON");
                int night = rs.getInt("NIGHT");
                
                account = new Account(name, userId, pass, morning, noon, night);
                
            }
        } catch(SQLException e) {
           e.printStackTrace();
           return null;
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベースを切断
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();;
                    return null;
                }
            }
        }
        return account;
    }
    public boolean addUser(Account account) {
        Connection conn = null;
        int result = 1;
        try {
      // JDBCドライバを読み込む
      Class.forName(DRIVER_NAME);

      // データベースに接続
      conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

     // INSERT文の準備(idは自動連番なので指定しなくてよい）
      String sql = "INSERT INTO ACCOUNT(NAME, USER_ID, PASS, MORNING, NOON, NIGHT) VALUES(?, ?, ?, ?, ?, ?)";
      // SELECT文を準備
      // String sql = "SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      pStmt.setString(1, account.getName());
      pStmt.setString(2, account.getUserId());
      pStmt.setString(3, account.getPass());
      pStmt.setInt(4, 0);
      pStmt.setInt(5, 0);
      pStmt.setInt(6, 0);
      result = pStmt.executeUpdate();
     
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      // データベースを切断
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    // 登録の成功、不成功を返す
    if (result == 1) {
         return true;
      }else{
          return false;
      }
    }
    
    public boolean updateAccount(String time, int point, String userId) {
        Connection conn = null;
        int result = 1;
        try {
            // JDBCドライバを読み込む
            Class.forName(DRIVER_NAME);

            // データベースに接続
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            if(time.equals("MORNING")) {
                String sql = "UPDATE ACCOUNT SET MORNING = 0, NOON = 0, NIGHT = 0 WHERE USER_ID = ?";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, userId);
                result = pStmt.executeUpdate();
            }
            String sql = "UPDATE ACCOUNT SET "+time+" = ? WHERE USER_ID = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, point);
            pStmt.setString(2, userId);
            
            // UPDATE文を実行
            result = pStmt.executeUpdate(); // 処理された行数
     
        } catch (SQLException e) {
          e.printStackTrace();
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        } finally {
          // データベースを切断
          if (conn != null) {
            try {
              conn.close();
            } catch (SQLException e) {
              e.printStackTrace();
            }
          }
        }
        if (result == 1) {
            return true;
        }else{
            return false;
      }
    }
}
