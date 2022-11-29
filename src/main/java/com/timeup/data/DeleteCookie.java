package com.timeup.data;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookie {
    public static void deleteOneCookie(HttpServletRequest request,
            HttpServletResponse response,
            Cookie[] cookies, String cookieName) {
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if (cookieName.equals(cookie.getName())) {
                    
                	 cookie.setMaxAge(0); //delete the cookie
                     cookie.setPath("/"); //allow the download application to access it
                     response.addCookie(cookie);
                }
            }
        }
    }
}
