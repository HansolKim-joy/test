package create.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import create.model.service.CreateService;

/**
 * Servlet implementation class CreateDeleteServlet
 */
@WebServlet("/delete.cr")
public class CreateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rNo = Integer.parseInt(request.getParameter("cNo").trim());
		System.out.println("rNo " + rNo);
		int result = new CreateService().deleteCreate(rNo);
		
		if(result > 0) {
			response.sendRedirect("list.cr");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("view/errorPage/errorPage.jsp");
			request.setAttribute("msg", "창작글 삭제를 실패했습니다.");
			view.forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
