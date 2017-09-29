package com.yss1.whdapp;

import java.io.IOException;
import java.util.concurrent.Executors;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller {
	private MainWnd mw;
	public void setMainWnd(MainWnd m)
	{
		mw=m;
	}
	//ArrayList<SqlData> sdata;
    @FXML
    private ProgressIndicator progress;

    @FXML
    private Label warn;
    
    @FXML
    private Button run;

    @FXML
    private Button close;

    @FXML
    private TextField snils;

    @FXML
    void closeWindow(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void make_query(ActionEvent event) throws IOException {
    	
    	//GregorianCalendar q=new GregorianCalendar(2014,1,27);
    	//System.out.println(String.format("%02d", q.get(Calendar.DAY_OF_MONTH))+"."+String.format("%02d", q.get(Calendar.MONTH))+"."+q.get(Calendar.YEAR));
    	//System.exit(0);
    	warn.setText("");
    	//sdata=new ArrayList<SqlData>();
//    	progress.setVisible(true);
//    	
//    	Task<String> ts=new Task<String>() {
//
//			@Override
//			protected String call() throws Exception {
//				// TODO Auto-generated method stub
//				return null;
//			}
//    	
//    	};
    	
//    	 Task<Void> task = new Task<Void>() {
//
//    		    @Override
//    		    protected Void call() throws Exception {
//    		        double TimeStart = 0d;
//    		        for (int row = 0; row < 100; row++) {
//    		            TimeStart = TimeStart + 0.01;
//    		            updateProgress(TimeStart, 1);
//    		            try {
//    		                Thread.sleep(27);
//    		            } catch (InterruptedException e) {
//    		            }
//    		        }
//    		        return null;
//    		    }
//    		  };
//    		  progress.progressProperty().bind(task.progressProperty());
//
//    		  Executors.newCachedThreadPool().submit(task);
//    		  
    	
    	
    	//.setProgress(0.5);
    	
    	mw.qr.run(snils.getText().replaceAll("[\\s,-]","").trim().substring(0,9));
    	
    	if (mw.qr.getAquery().size()<1)
    	{
    		//warn.setText(snils.getText().replaceAll("[\\s,-]","").trim().substring(0,9));
    		warn.setText("Ïî ÑÍÈËÑ "+snils.getText()+" íåò äàííûõ.");
    		//progress.setVisible(false);
    		return;
    	}
    	
    	//progress.setVisible(false);
    	
		//URL url = MainWnd.class.getResource("/table_window.fxml");
		
		//FXMLLoader loader = new FXMLLoader();
		//loader.setLocation(url);
    	FXMLLoader loader = new FXMLLoader(mw.getClass().getResource("/table_window.fxml"));
    	
		BorderPane pane = loader.load();
		TableController controller = loader.getController();
		controller.setMainWnd(mw);
		controller.initData();
		Scene scene = new Scene( pane );
        Stage stage = new Stage();
		stage.setScene(scene);
	    stage.show();
        ToExcel te=new ToExcel(mw);
        te.export();
    }

}


