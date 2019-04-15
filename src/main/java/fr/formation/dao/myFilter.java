package fr.formation.dao;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class myFilter implements Filter {

	public void init1(FilterConfig arg0) throws ServletException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void doFilter1(ServletRequest request, ServletResponse response, FilterChain arg2)
			throws IOException, ServletException {
		response.getWriter().println("Bonjout tout le monde !! c'est juste le filtre !!");
	}

	public void destroy() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

}