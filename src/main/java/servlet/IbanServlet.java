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
import main.java.service.IbanCheckerResult;
import main.java.service.TableRowHM;
@WebServlet("/IbanServlet")
public class IbanServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public IbanServlet() {
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
		LocalDateTime dt = LocalDateTime.now();
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		String action = "";
		Global.addCorsHeader(request, response);
		String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		Gson g = new Gson(); 
		TableRowHM root = g.fromJson(body, TableRowHM.class);
		action = root.getAsString("action");
		String accountNumber = root.getAsString("account_number");
		switch (action) {
			case "validateSingleIBAN":
				try {
					IbanCheckerResult ICR = new IbanCheckerResult(accountNumber);
					ArrayList<TableRowHM> validation = ICR.validateIban();
					TableRowHM jsonReadyHM = new TableRowHM();
					jsonReadyHM.put("validation", validation);
					Gson gson = new Gson();
					res = gson.toJson(validation);
				}catch(Exception e) {
					
				}
		}
			
		response.getWriter().print(res);
	}
}


