/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.resumewebapp;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
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
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

 private UserDaoInter userDao = Context.instanceUserDao();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int id = Integer.valueOf(request.getParameter("id"));
       String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        
        System.out.println("name="+name);
        System.out.println("surname="+surname);
        
      User user=  userDao.getById(id);
    user.setName(name);
    user.setSurname(surname);
    
    userDao.updateUser(user);
    
    response.sendRedirect("user.jsp");
    }

    

}
