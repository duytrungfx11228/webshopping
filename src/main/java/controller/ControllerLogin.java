package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;

/**
 * Servlet implementation class ControllerLogin
 */
@WebServlet("/login")
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		try {
			request.getSession(true).invalidate();
			// tao mail va pass hop le
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+(\\.[A-Za-z]+){2,6}$";
			String regexPass = "[a-zA-Z9-9_!@#$%^&*]+";
			// lay mail va mat khau tu login
			String user = request.getParameter("username");
			String password = request.getParameter("password");
			String remember = request.getParameter("remember");

			HttpSession session = request.getSession();
			if (!user.matches(regexMail) || password.matches(regexPass)) {
				session.setAttribute("error", "nhap sai email hoac password");
				response.sendRedirect("login.jsp");
			}
			// add cookie
			Cookie cookuser = new Cookie("cookuser", user);
			cookuser.setMaxAge(60 * 60 * 24);
			Cookie cookpass = new Cookie("cookpass", password);
			cookpass.setMaxAge(60 * 60 * 24);
			Cookie cookremem = new Cookie("cookremem", remember);
			cookremem.setMaxAge(60 * 60 * 24);
			response.addCookie(cookuser);
			response.addCookie(cookpass);
			response.addCookie(cookremem);
			// kiem tra tai khoan voi database
			AccountDao ac = new AccountDao();

			if (ac.getAcount(user, password) != null) {
				// set session
				session.setAttribute("userA", ac.getAcount(user, password));
				// dang nhap chap nhan va chuyen de trang admin
				response.sendRedirect("admin.jsp");

			} else {

				String us = null, pass = null;
				Cookie[] cookies = request.getCookies();

				for (Cookie cook : cookies) {
					if (cook.getName().equals("cookuser")) {
						us = cook.getValue();
					}
					if (cook.getName().equals("cookpass")) {
						pass = cook.getValue();
					}
					if(us != null && pass != null) {
						break;
					}
				}

				session.setAttribute("error", "nhap sai email hoac password");
				request.getRequestDispatcher("Login.jsp").forward(request, response);

			}
		} catch (NullPointerException e) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} catch (Exception ex) {
			response.getWriter().println(ex);
		}

	}

}
