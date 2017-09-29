package com.yss1.whdapp;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class SqlData {
	
public SqlData(String p1,String p2,String p3,String p4,String p5){
String [] dt= p5.split("[-,\\.]");
//p_date= new GregorianCalendar(Integer.parseInt(dt[2]),Integer.parseInt(dt[1])-1,Integer.parseInt(dt[0]));
//System.out.println(p_date.get());
//dt=p4.split("\\.");
na_date=new GregorianCalendar(Integer.parseInt(dt[0]),Integer.parseInt(dt[1])-1,Integer.parseInt(dt[2]));
//System.out.println(p5);

SNILS=p1.replaceAll("\\s{2,}"," ").trim();
//FIO=p3.trim();
numb=p2;
dtyp=p3;
dpns=p4;
//dcor=p7;
};	
public String getNumb() {
	return numb;
}
//public GregorianCalendar p_date;
private GregorianCalendar na_date;

public String SNILS;

public String getSNILS() {
	return SNILS;
}


//public String getFIO() {
//	return FIO;
//}

public String getDtyp() {
	return dtyp;
}

public String getDpns() {
	return dpns;
}

//public String getDcor() {
//	return dcor;
//}
//public String FIO;
public String dtyp;
public String dpns;
//public String dcor;
public String numb;
//private String sp_date;
private String sna_date;


public String getSna_date() {
	return String.format("%02d", na_date.get(Calendar.DAY_OF_MONTH))+"."+String.format("%02d", na_date.get(Calendar.MONTH)+1)+"."+na_date.get(Calendar.YEAR);
}

//public String getSp_date() {
//	return String.format("%02d", p_date.get(Calendar.DAY_OF_MONTH))+"."+String.format("%02d", p_date.get(Calendar.MONTH)+1)+"."+p_date.get(Calendar.YEAR);
//}

//public void setSp_date(String s) {
//	sp_date=s;
//}

public void setSna_date(String s) {
	sna_date=s;
}


@Override
public String toString() {

	
	return ":"+SNILS+":"+numb+":"+getSna_date()+":"+dtyp+":"+dpns;
}



}
