package com.yss1.whdapp;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableController {
	private MainWnd mw;
	public void setMainWnd(MainWnd m)
	{
		mw=m;
	}
    @FXML
    private TableView<SqlData> main_table;
    private ObservableList<SqlData> sqlData = FXCollections.observableArrayList();
    
    
    
    public void initData() {
    	//if (sqlData==null) sqlData;
    	sqlData.clear();
        sqlData.addAll(mw.qr.getAquery());
        main_table.setItems(sqlData);
	}
    
    @FXML
    private TableColumn<SqlData,String> c1;

    @FXML
    private TableColumn<SqlData,String> c2;
    
    @FXML
    private TableColumn<SqlData,String> c3;

    @FXML
    private TableColumn<SqlData,String> c4;

    @FXML
    private TableColumn<SqlData,String> c5;
    
    @FXML
    private TableColumn<SqlData,String> c6;

    @FXML
    private void initialize() {
    	c6.setCellValueFactory(new PropertyValueFactory<>("FIO"));
        c1.setCellValueFactory(new PropertyValueFactory<>("SNILS"));
        c2.setCellValueFactory(new PropertyValueFactory<>("Numb"));
        c3.setCellValueFactory(new PropertyValueFactory<>("dtyp"));
        c4.setCellValueFactory(new PropertyValueFactory<>("dpns"));
        c5.setCellValueFactory(new PropertyValueFactory<>("sna_date"));
        
    }
    
    
}
