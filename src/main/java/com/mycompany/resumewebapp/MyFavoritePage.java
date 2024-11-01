/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.resumewebapp;

import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
import com.mycompany.main.Context;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author ADMIN
 */
@WebServlet(name = "MyFavoritePage", urlPatterns = {"/MyFavoritePage"})
public class MyFavoritePage extends HttpServlet {
    
    
  
    private SkillDaoInter skillDao = Context.instanceSkillDao();
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    )throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyFavoritePage</title>");            
            out.println("</head>");
            out.println("<body>");
            
                out.println(skillDao.getAll()+"<br>");
            
            out.println("<h1>Servlet MyFavoritePage at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
    }}

    
  
    
  
   protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
     
    //   String requestStr = getAllDataFromRequest(req);
       String name = String.valueOf(req.getParameter("name"));
        Skill s =new Skill(0, name);
                boolean b = skillDao.insertSkill(s);
                 System.out.println(s);
                 
                 
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet MyFavoritePage</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("I GOT POST REQUEST");
        
            out.println("user inserted:"+s + "<br>");
        
        out.println("</body>");
        out.println("</html>");
    }  } 
}



