/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Login;

/**
 *
 * @author kubotamari
 */
@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        HttpSession session = request.getSession();
        
        // 食品リストを生成してセッションスコープに保存
        ArrayList<String> foodList = new ArrayList<String>();
        session.setAttribute("foodList",foodList);
        
        // セッションスコープからユーザ情報を取得
        Login loginUser = (Login) session.getAttribute("login");
        
        if(loginUser == null) { // ログインしていない場合
            // リダイレクト
            response.sendRedirect("/ad1927/"); // トップページを表示

        } else { // ログイン済みの場合
            // フォワード
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
            dispatcher.forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        
        // 追加ボタンが押された時に選択されていた食品の配列を作成
        String foods[] = new String[11];
        foods[0] = request.getParameter("dailyproduct");
        foods[1] = request.getParameter("egg");
        foods[2] = request.getParameter("vegetable");
        foods[3] = request.getParameter("mushroom");
        foods[4] = request.getParameter("seaweed");
        foods[5] = request.getParameter("potatos");
        foods[6] = request.getParameter("fruits");
        foods[7] = request.getParameter("flesh");
        foods[8] = request.getParameter("fish");
        foods[9] = request.getParameter("grain");
        foods[10] = request.getParameter("oands");

        // セッションスコープに保存された食品リストを取得
        HttpSession session = request.getSession();
        ArrayList<String> foodList = (ArrayList<String>) session.getAttribute("foodList");
        
        // 食品リストに選択された食品を追加
        for(int i=0; i<foods.length; i++) {
            if(foods[i].length() != 0) {
                foodList.add(foods[i]);
            }
        }
        
        // セッションスコープに変更した食品リストを保存
        session.setAttribute("foodList", foodList);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        dispatcher.forward(request, response);
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
