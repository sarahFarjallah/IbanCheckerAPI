package main.java.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Global {
	public static void addCorsHeader(HttpServletRequest request, HttpServletResponse response) {
		String host = "*";

		if (request.getHeader("Origin") != null) {
			host = request.getHeader("Origin").toString();
		}

		response.setHeader("Access-Control-Allow-Origin", host);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		response.setHeader("Access-Control-Allow-Headers",
				"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept, access-control-allow-origin");
		response.setHeader("Access-Control-Max-Age", "1728000");
	}
}
