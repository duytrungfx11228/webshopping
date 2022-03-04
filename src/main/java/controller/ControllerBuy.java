package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import model.Cart;

/**
 * Servlet implementation class ControllerBuy
 */
@WebServlet("/buy")
public class ControllerBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerBuy() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Cart cart = null;

		Object o = session.getAttribute("cart");
		if (o != null) {
			cart = (Cart) o;
		} else {
			cart = new Cart();
		}
		
		try {
			
			 String email = request.getParameter("email");
			 String address = request.getParameter("address");
			 String discount = request.getParameter("discount");

			if (email != "" && address != "" ) {
				OrderDao odd = new OrderDao();
				odd.addOders(email, discount, address);
				int id = odd.getIdOrder();
				odd.addOrderDetail(cart,id);
				session.removeAttribute("cart");
				
				response.sendRedirect("ControllerHome");
			} else {
				response.sendRedirect("Cart.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
