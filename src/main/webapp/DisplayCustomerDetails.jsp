<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"> 
    <title>Customer Details</title>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background: linear-gradient(135deg, #74ebd5, #ACB6E5);
            margin: 0;
            padding: 20px;
        }
        h2 {
            color: #2f4f4f;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 5px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #6A82FB;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Customer Details</h2>
    <table>
        <thead>
            <tr>
                <th>Full Name</th>
                <th>Address</th>
                <th>Phoneno</th>
                <th>Emailid</th>
                <th>DOB</th>
                <th>Accno</th>
                <th>Acctype</th>             
                <th>Idproof</th>
            </tr>
        </thead>
        <tbody>
            <%
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;

                try {
                    // Load MySQL JDBC Driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Establish connection to the database
                    String url = "jdbc:mysql://localhost:3306/dbforbankapp"; // Update with your database URL
                    String user = "root"; // Update with your database username
                    String password = "sqllogin"; // Update with your database password
                    conn = DriverManager.getConnection(url, user, password);

                    // Create SQL statement
                    stmt = conn.createStatement();
                    String sql = "SELECT  Fullname, Address, Phoneno, Emailid, DOB, Accno, Acctype, Idproof FROM customer";
                    rs = stmt.executeQuery(sql);

                    // Iterate through the result set and display the data
                    while (rs.next()) {
                        out.println("<tr>");
                        out.println("<td>" + rs.getString("Fullname") + "</td>");
                        out.println("<td>" + rs.getString("Address") + "</td>");
                        out.println("<td>" + rs.getString("Phoneno") + "</td>");
                        out.println("<td>" + rs.getString("Emailid") + "</td>");
                        out.println("<td>" + rs.getString("DOB") + "</td>");
                        out.println("<td>" + rs.getString("Accno") + "</td>");
                        out.println("<td>" + rs.getString("Acctype") + "</td>");
                        out.println("<td>" + rs.getString("Idproof") + "</td>");
                  
                        out.println("</tr>");
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    out.println("<tr><td colspan='10'>Error loading database driver: " + e.getMessage() + "</td></tr>");
                } catch (SQLException e) {
                    e.printStackTrace();
                    out.println("<tr><td colspan='10'>SQL error: " + e.getMessage() + "</td></tr>");
                } finally {
                    // Close ResultSet, Statement, and Connection
                    if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
                    if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
                    if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
                }
            %>
        </tbody>
    </table>
</body>
</html>
