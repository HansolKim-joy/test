package letter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import letter.model.service.LetterService;
import letter.model.vo.Letter;
import member.model.vo.Member;

/**
 * Servlet implementation class LetterSendServlet
 */
@WebServlet("/letter_send.do")
public class LetterSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LetterSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		LetterService service = new LetterService();
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		String sendName = request.getParameter("send_name");
		String sendTitle = request.getParameter("send_title");
		String sendContent = request.getParameter("send_content");
		
		String sendId = service.getUserId(sendName);
		Letter l = new Letter(userId, sendTitle, sendContent, sendId);
		
		int result = service.letterSend(l);
		String page = "";
		
		if(result > 0) {
			page = request.getContextPath() + "/letter.view";
			response.sendRedirect(page);
		}else {
			page = "view/letter/letter_send.jsp";
			request.setAttribute("msg", "이 닉네임을 가진 유저가 없습니다.");
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
