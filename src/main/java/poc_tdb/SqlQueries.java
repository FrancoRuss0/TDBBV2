package poc_tdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component

public class SqlQueries {
	private SqlProperty sqlProperty ;

	
	public SqlQueries(SqlProperty sqlProperty) {
		this.sqlProperty = sqlProperty;

	}
	
	
	public Statement dbConnection() throws SQLException {
		
        Connection connection = sqlProperty.dataSource().getConnection();
        Statement statement = connection.createStatement();
		return statement;
                
	}
//	public void clearTemporaryTables(){
//		try {
//		;
//		ResultSet resultSet = connessione().executeQuery("SELECT * FROM Res WHERE PNRLocatorID = 'FAKZBC'"); 
//
//		ResultSetMetaData metaData = resultSet.getMetaData();
//        int columnCount = metaData.getColumnCount();
//
//        // Itera sulle righe del ResultSet
//        while (resultSet.next()) {
//            // Per ogni riga, stampa tutti i valori
//            for (int i = 1; i <= columnCount; i++) {
//                String columnName = metaData.getColumnName(i);  // Ottieni il nome della colonna
//                String value = resultSet.getString(i);          // Ottieni il valore della colonna
//                System.out.println(columnName + ": " + value);
//            }
//            System.out.println("-----------");  // Separatore tra le righe
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
	public void clearTemporaryTables(){
		try {
			dbConnection().executeUpdate("DELETE FROM Res_Temp");
			dbConnection().executeUpdate("DELETE FROM TktDocument_Temp");
		}catch (SQLException e) {
	        e.printStackTrace();
		    }
	}
	
	
	
}
