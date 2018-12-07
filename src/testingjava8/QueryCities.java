package testingjava8;

import java.sql.*;
import java.util.Scanner;

public class QueryCities {
	
	public static void pullCities() {
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("Select dc.DaycareName, c.CityName, s.StateAbbr FROM OakesDB.Daycare dc INNER JOIN OakesDB.City c ON dc.LocationID = c.LocationID INNER JOIN OakesDB.State s on dc.StateID = s.idState WHERE c.CityName = 'Seattle' ");
				//Select dc.DaycareName, c.CityName, s.StateAbbr FROM OakesDB.Daycare dc INNER JOIN OakesDB.City c ON dc.LocationID = c.LocationID INNER JOIN OakesDB.State s on dc.StateID = s.idState WHERE c.CityName = 'Seattle';

				
			)
			{
				String format = "%-20s %-10s %15s %n";
				rs.beforeFirst();
				System.out.format(format, "DaycareName", "CityName", "StateAbbr");
				System.out.println("---------------------------------------------------------");
				
				while(rs.next()) {
					
					System.out.format(format, rs.getString("DaycareName"), rs.getString("CityName"), rs.getString("StateAbbr"));
				}
			} catch (SQLException e) {
				DBUtil.showErrorMessage(e);
			}
	}
	
	public void pullSubService() {
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT DC.DaycareName, SS.SubServiceName FROM OakesDB.Daycare DC INNER JOIN OakesDB.DaycaretoService DS ON DC.DaycareID = DS.DaycareID INNER JOIN OakesDB.ServiceCategory SC ON DS.ServiceID = SC.ServiceCatID INNER JOIN OakesDB.City C ON C.LocationID = DC.LocationID INNER JOIN OakesDB.SubService SS ON SS.ServiceID = DS.ServiceID AND DS.SubServiceID = SS.ServiceSubCatID WHERE SC.CategoryName = 'Grooming' AND C.CityName = 'Seattle'");
				//SELECT DC.DaycareName, SS.SubServiceName FROM OakesDB.Daycare DC INNER JOIN OakesDB.DaycaretoService DS ON DC.DaycareID = DS.DaycareID INNER JOIN OakesDB.ServiceCategory SC ON DS.ServiceID = SC.ServiceCatID INNER JOIN OakesDB.City C ON C.LocationID = DC.LocationID INNER JOIN OakesDB.SubService SS ON SS.ServiceID = DS.ServiceID AND DS.SubServiceID = SS.ServiceSubCatID WHERE SC.CategoryName = 'Grooming' AND C.CityName = 'Seattle';


				
			)
			{
				String format = "%-20s %-10s %n";
				rs.beforeFirst();
				System.out.format(format, "DaycareName", "CityName");
				System.out.println("------------------------------------------------");
				
				while(rs.next()) {
					
					System.out.format(format, rs.getString("DaycareName"), rs.getString("CityName"));
				}
			} catch (SQLException e) {
				DBUtil.showErrorMessage(e);
			}
	}
	
	public void pullcityname() {
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT DC.DaycareName, C.CityName FROM OakesDB.Daycare DC INNER JOIN OakesDB.City C ON DC.LocationID = C.LocationID INNER JOIN OakesDB.DaycareToAmmenity DA ON DC.DaycareID = DA.DaycareID INNER JOIN OakesDB.AmmenitiesProvided AP ON DA.AmmenityID = AP.idAmmenityID WHERE AP.AmmenityDesc = 'Webcam'");
				//SELECT DC.DaycareName, C.CityName FROM OakesDB.Daycare DC INNER JOIN OakesDB.City C ON DC.LocationID = C.LocationID INNER JOIN OakesDB.DaycareToAmmenity DA ON DC.DaycareID = DA.DaycareID INNER JOIN OakesDB.AmmenitiesProvided AP ON DA.AmmenityID = AP.idAmmenityID WHERE AP.AmmenityDesc = "Webcam";

				
			)
			{
				String format = "%-20s %-10s %n";
				rs.beforeFirst();
				System.out.format(format, "DaycareName", "SubServiceName");
				System.out.println("------------------------------------------------");
				
				while(rs.next()) {
					
					System.out.format(format, rs.getString("DaycareName"), rs.getString("SubServiceName"));
				}
			} catch (SQLException e) {
				DBUtil.showErrorMessage(e);
			}
	}
	
	
	public static void main(String[] args) throws SQLException {
		Scanner user_input = new Scanner(System.in);
		String choice;
		System.out.println("Enter An Action: /n [1] Pull a Query of Cities");
		choice = user_input.next();
		if (choice == "1") {
			pullCities();
		}
		
	
		
		
		
	}
}
