import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bbb
 */
@WebServlet("/SampleServlet")
public class SampleServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public SampleServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");

    String[] select = request.getParameterValues("select");
    String[] insert = request.getParameterValues("insert");
    String[] delete = request.getParameterValues("delete");

    String str_table = "";

    JdbcSample js = new JdbcSample();

    //SELECT DB
    if(select[0] != ""){
      str_table = js.SampleSelect();

      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println(str_table);
    }

    //INSERT DB
    if(insert[0] != ""){
      js.SampleInsert(insert);
    }

    //DELETE DB
    if(delete[0] != ""){
      js.SampleDelete(delete[0]);
    }

  }

}
