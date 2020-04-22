package member.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class SendMailServlet
 */
@WebServlet("/finduser.to")
public class FindUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("find_User");
		String uuid = "";
		for(int i = 0; i < 5; i++) {
			uuid = UUID.randomUUID().toString().replaceAll("-", "");
			uuid = uuid.substring(0, 10);
//			System.out.println(i + ") " + uuid);
		}
		
		Member finduser = new MemberService().findUser(email); // 원래 아이디/비밀번호 받아오기
		
		String encPwd = null;
		
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		byte[] bytes = uuid.getBytes(Charset.forName("UTF-8"));
		md.update(bytes);
		encPwd = Base64.getEncoder().encodeToString(md.digest());
		
		int result = new MemberService().newPwd(email, encPwd); // 임시 비밀번호로 업데이트
		
		
		String page = "";
		String msg = "";

		if (finduser != null || result > 0) {

			page = "view/pages/loginForm.jsp";
			msg = "이메일로 회원님의 정보를 보냈습니다. 확인 후 다시 로그인 해주세요.";

			// 1. 전달받은 값 인코딩
			// - 전송할 값은 html이 아닌 다른 프로토콜로 전송할 것이기 때문에
			// 현재는 별도 인코딩을 하지 않습니다.
			request.setCharacterEncoding("UTF-8");

			final String sender = "cross4613@naver.com"; // 보내는 사람 ID (Ex: @naver.com 까지..)
			final String password = "adad263263"; // 보내는 사람 Password

			String receiver = request.getParameter("find_User"); // 받는 사용자 (Ex: @naver.com 까지..)
			String host = "smtp.naver.com"; // 사용하는 메일

//      System.out.println("---------recv Data Check--------");
//      System.out.println("recvID : " + receiver);
//      System.out.println("title : " + title);
//      System.out.println("content : " + random);
//      System.out.println("--------------------------");

			// Get the session object
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(sender, password);
				}
			});

			// Compose the message
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(sender));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

				// sender Email Address
//         message.setFrom("테스트메일 : <" + sender + ">");
				message.setFrom(sender);

				// Subject
				message.setSubject(" Watch_Next " + " 아이디  / 비밀번호 입니다.");

				// Text
				message.setText("아이디 : " + finduser.getUserId() + "<br> 임시 비밀번호 : " + uuid + "<br> 로그인 후 비밀번호를 변경바랍니다." , "UTF-8",
						"html");
				System.out.println("임시비밀번호 : " + uuid);
				// send the message
				Transport.send(message);

//				System.out.println("전송 완료!!!!");

			} catch (MessagingException e) {
//				System.out.println("전송 실패!! ㅠㅠ");
				e.printStackTrace();
			}

		} else {
			page = "view/pages/FindUserForm.jsp";
			msg = "없는 이메일 주소입니다.";

		}

		request.setAttribute("msg", msg);
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);

	}

	private String setSha512(String substring) {
		// TODO Auto-generated method stub
		return null;
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