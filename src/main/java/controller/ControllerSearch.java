package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDao;
import model.Category;
import model.Product;

/**
 * Servlet implementation class ControllerSearch
 */
@WebServlet("/Search")
public class ControllerSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String txt = request.getParameter("txt");
		String indexPage = request.getParameter("index");
		if (indexPage == null) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		
		ListProductDao prd = new ListProductDao();
		
		int count = prd.totalSearch(txt);
		int endpage = count/6;
		if(count%6 != 0) {
			endpage ++;
		}
		// search product
		List<Product> lists = prd.searchProduct(txt);
		// load category
		
		List<Category> listc = prd.getCategory();
		// search product
		HttpSession session = request.getSession();
		session.setAttribute("listct", listc);
		session.setAttribute("listp", lists);
		session.setAttribute("endp", endpage);// tao phan trang
		session.setAttribute("tag", index);
		session.setAttribute("txtsearch", txt);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
