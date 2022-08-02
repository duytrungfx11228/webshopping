package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDao;
import model.Cart;
import model.Product;
import model.ProductOrders;

/**
 * Servlet implementation class ControllerAddToCart
 */
@WebServlet("/addtocart")
public class ControllerAddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAddToCart() {
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
		int num = 1;
		Object o = session.getAttribute("cart");
		if(o!= null) {
			cart = (Cart)o;
		} else {
			cart = new Cart();
		}
			try {
				String pid = request.getParameter("pid");
				ListProductDao prd = new ListProductDao();
				Product pro = prd.getProductByid(pid);
				float price = pro.getPrice();
				ProductOrders pr = new ProductOrders(pro, num, price);
				cart.add(pr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		double totalMoney = cart.getAmount();
		session.setAttribute("cart" , cart);
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
