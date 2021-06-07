package book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/pageloadcontroller")
public class pageloadcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pageloadcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pages =request.getParameter("page");
		pages =pages.toLowerCase();
		
		if(pages.equals("homepage")) {
			request.getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("/homepage");
		}
	
	}

	

}
