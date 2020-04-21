package create.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import create.model.service.CreateService;
import create.model.vo.Create;
import review.model.service.ReviewService;
import review.model.vo.Review;


/**
 * Servlet implementation class CreateUpdateServlet
 */
@WebServlet("/update.cr")
public class CreateUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		String title = request.getParameter("creW_createName");
		String director = request.getParameter("creW_directorName");
		String content = request.getParameter("editor_content");
		
		Create c = new Create();
		c.setbNO(cNo);
		c.setbTitle(title);
		c.setcDirector(director);
		c.setbContent(content);
		
		
		int result = new CreateService().updateCreate(c);
		
		String page = null;
		if(result>0) {
			page="detail.creat?cNo=" + cNo;
			response.sendRedirect(page);
		} else {
			page = "view/errorPage/errorPage.jsp";
			request.setAttribute("msg", "게시글 수정에 실패하였습니다.");
			request.getRequestDispatcher(page).forward(request, response);
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
