package com.example.patas_board.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginFilter implements Filter {
    @Autowired
    HttpSession httpSession;

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        //型変換
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;

        httpSession = httpRequest.getSession(false);
        // セッション情報が存在するかつログインユーザーが存在している場合、フィルターを外す
        if (httpSession != null && httpSession.getAttribute("loginUser") != null){
            chain.doFilter(httpRequest,httpResponse);
        } else {
            //httpSession = httpRequest.getSession(true);
            //エラーメッセージリストの作成
            List<String> errorMessages = new ArrayList<>();
            errorMessages.add("ログインしてください");
            // セッションに格納
            httpRequest.getSession().setAttribute("errorMessages", errorMessages);
            //ログインページにリダイレクト
            httpRequest.getRequestDispatcher("/login/form").forward(request, response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
