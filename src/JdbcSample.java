import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author kenji.someya
 *
 */
public class JdbcSample {

  public String SampleSelect(){

    Connection connection = null;
    String trSample = "";

    try {

      // MySQLデータベースに接続 (DB名,ID,パスワード)
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "pass");
      // ステートメントを作成
      Statement statement = connection.createStatement();

      // SELECT
//      ResultSet rset = statement.executeQuery("SELECT * FROM world.city");
//      あとで戻すこと
      ResultSet rset = statement.executeQuery("SELECT * FROM world.city WHERE ID > 4070 ORDER BY ID");

      while ( rset.next() ) {
        String tdSample =
            "<td>" + rset.getString(1) + "</td>" +
            "<td>" + rset.getString(2) + "</td>" +
            "<td>" + rset.getString(3) + "</td>" +
            "<td>" + rset.getString(4) + "</td>" +
            "<td>" + rset.getString(5) + "</td>";
        trSample += "<tr>" + tdSample + "</tr>";
      }

      // 結果セットをクローズ
      rset.close();
      // ステートメントをクローズ
      statement.close();
      // 接続をクローズ
      connection.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return trSample;
  }

  public void SampleInsert(String[] sampleData){

    Connection connection = null;

    String[] someSampleData = sampleData[0].split("__");

    try {

      // MySQLデータベースに接続 (DB名,ID,パスワード)
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "pass");
      // ステートメントを作成
      Statement statement = connection.createStatement();

      // INSERT
      String sql = "INSERT INTO world.city (ID, Name, CountryCode, District, Population) VALUES (" + someSampleData[0] + ", \"" + someSampleData[1] + "\", \"" + someSampleData[2] + "\", \"" + someSampleData[3] + "\", \"" + someSampleData[4] + "\")";
      System.out.println(sql);
      statement.executeUpdate(sql);

      // ステートメントをクローズ
      statement.close();
      // 接続をクローズ
      connection.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public void SampleDelete(String delete){

    Connection connection = null;

    try {

      // MySQLデータベースに接続 (DB名,ID,パスワード)
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "pass");
      // ステートメントを作成
      Statement statement = connection.createStatement();

      // DELETE
      String sql = "DELETE FROM world.city WHERE ID = " + delete;
      statement.executeUpdate(sql);

      // ステートメントをクローズ
      statement.close();
      // 接続をクローズ
      connection.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
