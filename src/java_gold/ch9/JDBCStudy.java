package java_gold.ch9;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JDBCStudy {
    public static void main(String[] args) throws ClassNotFoundException {

        // JDBC v3.0まではJDBCドライバの明示的なロードが必要
        // v4.0以降はクラスパスから自動的にロードされる。
        //Class.forName("JDBCドライバのクラス名");

        // DriverManagerクラスのgetConnectionメソッドでconnection取得
        // 以降はそのconnectionメソッドに対して操作を行う
        try(Connection conn = DriverManager.getConnection("URL","USER", "PASS");
                // Statementはインターフェースなのでnewはできない
                Statement statement = conn.createStatement();) {


        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // java.sql ⇒ Date and Time API
    static void convertDateTime(java.sql.Date sqlDate, java.sql.Time sqlTime, java.sql.Timestamp sqlTimestamp) {
        LocalDate localDate = sqlDate.toLocalDate();
        LocalTime localTime = sqlTime.toLocalTime();
        LocalDateTime localDateTime = sqlTimestamp.toLocalDateTime();
    }

    static void useExecute(Statement statement) throws SQLException{
        // executeメソッドでSELECTと更新どっちもできる
        // SELECTかつResultSetがある場合はtrue
        // 更新あるいはResultSetが無ければfalse
        boolean result = statement.execute("Something SQL");
        if(result) {
            // getResultSetメソッドで後からResultSetを取得可能
            ResultSet resultSet = statement.getResultSet();
        } else {
            // getUpdateCountメソッドで更新行数を取得可能
            int count = statement.getUpdateCount();
        }
    }
}
