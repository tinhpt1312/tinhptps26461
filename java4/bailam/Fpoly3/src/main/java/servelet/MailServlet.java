package servelet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailServlet
 */
@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("view/sendmail/senmail.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.host", "smtp.gmail.com");
		prop.setProperty("mail.smtp.port", "587");
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.smtp.starttls.enable", "true");
		prop.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
		prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		
		
		 Authenticator auth = new Authenticator() {
	            public PasswordAuthentication getPasswordAuthentication() {
	            	String accountName = "tinhptps26461@fpt.edu.vn";
					String accountPass = "dskwgzzemetrrxag";
					return new PasswordAuthentication(accountName, accountPass);
	            }
	        };
	    Session session = Session.getInstance(prop, auth);
		MimeMessage message = new MimeMessage(session);
		
		String to = request.getParameter("nguoinhan").toString();
		String subject = request.getParameter("tieude").toString();
		String comment = request.getParameter("noidung").toString();
		System.out.println(to);
		System.out.println(subject);
		System.out.println(comment);
		
		try {
			message.setFrom(new InternetAddress("tinhptps26461@fpt.edu.vn"));
			message.setRecipients(Message.RecipientType.TO, to);
			message.setSubject(subject, "utf-8");
			message.setText(comment,"utf-8");
			message.setReplyTo(message.getFrom());
			Transport.send(message);
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("view/sendmail/senmail.jsp").forward(request, response);
		doGet(request, response);
	}

}
