package dk.grell.EnergyAPI;

import java.sql.SQLException;

public class EnergyOutput {


    public static String getMeteringPointsAsHtml(String location) {
        DButils dbUtil = new DButils();
        String returnHTML = null;
        try {
            dbUtil.getConnection();
            dbUtil.createStatement();
            String sql = "select * from energy_metering where location='" + location + "' order by STARTDATE,POSITION";
            dbUtil.resultSet = dbUtil.dbStatement.executeQuery(sql);

            returnHTML = "<html><table>";
            dbUtil.resultSet = dbUtil.dbStatement.executeQuery(sql);
            while (dbUtil.resultSet.next()) {
                returnHTML = returnHTML + "<tr>";
                returnHTML = returnHTML + "<td>" + dbUtil.resultSet.getString("LOCATION") + "</td>";
                returnHTML = returnHTML + "<td>" + dbUtil.resultSet.getDate("STARTDATE") + "</td>";
                returnHTML = returnHTML + "<td>" + dbUtil.resultSet.getInt("POSITION") + "</td>";
                returnHTML = returnHTML + "<td>" + dbUtil.resultSet.getFloat("METERING") + "</td>";
                returnHTML = returnHTML + "</tr>";
            }
            returnHTML = returnHTML + "</table></html>";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return returnHTML;
    }




}