package servelet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig
@WebServlet("/upload1")
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/view/demo/upload.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uploadFolder = request.getServletContext().getRealPath("/uploads");
		Path uploadPath = Paths.get(uploadFolder);
		if(!Files.exists(uploadPath)) {
			Files.createDirectory(uploadPath);
		}
		Part imagePart = request.getPart("image");
		Part documentPart = request.getPart("document");
		
		String imageFilename = Path.of(imagePart.getSubmittedFileName()).getFileName().toString();
		String documentFilename = Path.of(documentPart.getSubmittedFileName()).getFileName().toString();
		
    	imagePart.write(Paths.get(uploadPath.toString(), imageFilename).toString());
 	   
		documentPart.write(Paths.get(uploadPath.toString(), documentFilename).toString());
		
		
		request.setAttribute("image",imageFilename);
		request.setAttribute("document",documentFilename);
		request.getRequestDispatcher("/view/demo/result.jsp").forward(request, response);
		
	}

}
