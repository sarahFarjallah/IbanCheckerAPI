package main.java.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.ws.rs.Consumes;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import com.google.gson.Gson;

import main.java.service.Global;
import main.java.service.IbanFileCheckerResult;
import main.java.service.TableRowHM;
@WebServlet("/IbanFileServlet")
@MultipartConfig
public class IbanFileServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public IbanFileServlet() {
		super();
	}
	// TODO Auto-generated constructor stub
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// TODO Auto-generated method stub
		String res = null;
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		Global.addCorsHeader(request, response);
		Collection<Part> parts = null;
		List<String> fileData = new ArrayList<String>();
		try {
			parts = request.getParts();
			  for (Part part : parts) {
			    if (part.getName().equals("uploadedfile")) {
			    	InputStream file = part.getInputStream();
			    	fileData = new BufferedReader(new InputStreamReader(file)).lines().collect(Collectors.toList());
			    	break;
			    }
			  }
		} catch (ServletException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			List<TableRowHM> validation = new ArrayList<TableRowHM>();
			IbanFileCheckerResult IFCR = new IbanFileCheckerResult(fileData);
			validation = IFCR.validateIbanFile();
			TableRowHM jsonReadyHM = new TableRowHM();
			jsonReadyHM.put("validation", validation);
			Gson gson = new Gson();
			res = gson.toJson(validation);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		response.getWriter().print(res);
	}

}


