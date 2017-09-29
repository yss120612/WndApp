package com.yss1.whdapp;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import com.ibm.as400.access.*;

public class Query {
	public ArrayList<SqlData> getAquery() {
		return aquery;
	}

	private ArrayList<SqlData> aquery;
	private ArrayList<String> sec; 
	public Query() {
		aquery = new ArrayList<SqlData>();
		sec = new ArrayList<String>();
		
		try
        {
            FileReader fr = new FileReader("main.pass");
			BufferedReader reader = new BufferedReader(fr);
            String c= reader.readLine();
            while(c != null){
                 
                sec.add(c);
                c = reader.readLine();
            }
            reader.close();
            fr.close();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
		finally {

		}
		
		if (sec.size()!=5)
		{
			throw new NullPointerException("������������ ���������� � ����� main.pass");
		}
	}

	public ArrayList<SqlData> run(String inp) {
		aquery.clear();
		Connection con = null;
		try {
			DriverManager.registerDriver(new AS400JDBCDriver());
			con = DriverManager.getConnection(sec.get(0), sec.get(1), sec.get(2));
			Statement stmt = con.createStatement();
			stmt.execute(sec.get(3) + inp + "/')");
			ResultSet rs = stmt.executeQuery("SELECT * " + sec.get(4));
			ResultSetMetaData md = rs.getMetaData();
			


			while (rs.next()) {
				aquery.add(new SqlData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getDate(5).toString()));
			}
			rs.close();
			stmt.close();

		} catch (Exception e) {
			System.out.println("\nERROR:++ " + e.getMessage());
		}

		try {
			con.close();
		} catch (Exception e) {
			System.out.println("\nERROR:+++ " + e.getMessage());
		}

		return aquery;
	}

}
