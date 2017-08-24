/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.AccountLogic;

/**
 *
 * @author kishi
 */
@WebServlet(name = "UserAddServlet", urlPatterns = {"/UserAddServlet"})
public class UserAddServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/useradd.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    // リクエストパラメータの取得
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String userId = request.getParameter("userId");
    String pass = request.getParameter("pass");
    
    boolean isOK = true;
    // パラメータのチェック
    if(name.length() == 0 || userId.length() == 0 || pass.length() == 0) {
        isOK = false;
    }
    boolean result = false;
    if(isOK) {
    Account account = new Account(name, userId, pass, 0, 0, 0);
    AccountLogic al = new AccountLogic();
    result = al.addUser(account);
    }
    // 登録処理の成否によって処理を分岐
    if (result && isOK) { // 登録成功時
      // フォワード
      RequestDispatcher dispatcher =
          request.getRequestDispatcher("/WEB-INF/jsp/useraddOK.jsp");
      dispatcher.forward(request, response);
      
    } else if(!isOK){ // 入力に不備
        // リダイレクト
        response.sendRedirect("/ad1927/UserAddServlet");
    } else { // アカウント情報が重複
        RequestDispatcher dispatcher =
          request.getRequestDispatcher("/WEB-INF/jsp/useraddFail.jsp");
      dispatcher.forward(request, response);
    }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
