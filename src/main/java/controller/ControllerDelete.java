package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;

/**
 * Servlet implementation class ControllerDelete
 */
@WebServlet("/delete")
public class ControllerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		Cart cart = null;
		
		Object o = session.getAttribute("cart");
		if (o != null) {
			cart = (Cart) o;
		} else {
			cart = new Cart();
		}
		String pid = request.getParameter("pid");
		int id = Integer.parseInt(pid);
		cart.remmoveItems(id);
		
		double totalMoney = cart.getAmount();
		session.setAttribute("cart", cart);
		session.setAttribute("money", totalMoney);
		request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
