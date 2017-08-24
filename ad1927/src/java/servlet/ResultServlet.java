/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.AccountDAO;
import dao.FoodDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Food;
import model.Login;
import model.GetFoodListLogic;

/**
 *
 * @author kubotamari
 */
@WebServlet(name = "ResultServlet", urlPatterns = {"/ResultServlet"})
public class ResultServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResultServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResultServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
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
    /*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    */
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
        String meal = request.getParameter("meal"); // MORNING or NOON or NIGHT
        
        // パラメータをチェック
        boolean isOK = true;
        if(meal == null) isOK = false;
        
        String showTime = ""; // 結果画面で表示するため
        if(isOK) {
        switch(meal) {
            case "MORNING": showTime = "朝食"; break;
            case "NOON": showTime = "昼食"; break;
            case "NIGHT": showTime = "夕食"; break;
        }
        }
        request.setAttribute("showTime", showTime);
        
        HttpSession session = request.getSession();
        ArrayList<String> foodList = (ArrayList<String>) session.getAttribute("foodList");

        // 食品リストを取得して、リクエストスコープに保存
        GetFoodListLogic getFoodListLogic = new GetFoodListLogic();
        List<Food> foodsList = getFoodListLogic.execute(foodList);
        request.setAttribute("foodsList", foodsList);
        
        // 点数計算
        int point = 0;
        int[] nPoint = new int[4];
        for(int i=0; i<foodsList.size(); i++) {
            int number = foodsList.get(i).getNumber();
            point += number;
            nPoint[number-1] += number;
        }
        
        // 点数をリクエストスコープに保存
        request.setAttribute("point", point);
        request.setAttribute("nPoint", nPoint);
        
        // セッションスコープからユーザーIDを取得
        Login login = (Login) session.getAttribute("login");
        String userId = login.getUserId();
        
        // ACCOUNTに点数をセット
        AccountDAO adao = new AccountDAO();
        boolean result = adao.updateAccount(meal, point, userId);
        
        // フォワード
        if(result) { // 点数セット成功
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
            dispatcher.forward(request, response);
        } else { // 点数セット失敗
            // リダイレクト
            response.sendRedirect("/ad1927/ResultServlet");
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
