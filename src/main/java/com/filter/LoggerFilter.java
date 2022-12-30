package com.filter;

import com.watch.model.User;
import com.watch.services.IUserService;
import com.watch.services.Imp.UserServiceImp;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(urlPatterns = {"/admin-product", "/admin-order", "/admin-delete-product", "/order-details" })
public class LoggerFilter extends HttpServlet implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession ss = req.getSession();
        User user = (User) ss.getAttribute("user");
        if((user != null) && (user.getRole() == 1)){
            chain.doFilter(request, response);
        }else{
            resp.sendRedirect(req.getContextPath() +"/login");
        }

    }
}

