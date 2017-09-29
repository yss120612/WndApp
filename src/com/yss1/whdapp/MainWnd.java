package com.yss1.whdapp;
import javafx.application.*;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.*;

import java.net.URL;
import java.sql.*;



import com.ibm.as400.access.*;


public class MainWnd extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	public Query qr;
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		qr=new Query();

		//URL url = MainWnd.class.getResource("main_window.fxml");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_window.fxml"));
		//loader.setLocation(url);
		BorderPane pane = null;
		try
		{
		pane = (BorderPane) loader.load();
		}
		catch (Exception E)
		{
			System.out.println(E.getMessage());
		
			System.exit(0);
		}
		Controller controller = loader.getController();
	    controller.setMainWnd(this);
		
		Scene scene = new Scene( pane );
		stage.setScene(scene);
	    stage.show();
	    
	    //Thread.sleep(1000);
	    //System.out.println(controller.toString());
	    
	    
	    
	}

}
