package com.arief.webfilters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebFilter(filterName = "menu-filter",urlPatterns = {"/page/menu/*"})
public class MenuFilters implements Filter{




    public void init(FilterConfig filterConfig) throws ServletException {

    }


    private void sendErrorPage(ServletResponse servletResponse) throws IOException {
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        response.sendError(403);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpSession sesi = (HttpSession)req.getSession();


        String username = (String) sesi.getAttribute("username");
        String password = (String) sesi.getAttribute("password");

        if(username==null || password==null){
            sendErrorPage(servletResponse);
        }else if(!username.equalsIgnoreCase("arief") || !password.equalsIgnoreCase("arief")){
            sendErrorPage(servletResponse);
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    public void destroy() {

    }
}
