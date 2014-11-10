package ui;

import dao.SessionManager;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("all")
public class HibernateFilter implements Filter {
  public void destroy() {
  }
  
  public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
    SessionManager.openSession();
    chain.doFilter(request, response);
    SessionManager.closeSession();
  }
  
  public void init(final FilterConfig arg0) throws ServletException {
  }
}
