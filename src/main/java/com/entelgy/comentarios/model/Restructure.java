package com.entelgy.comentarios.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Restructure implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private ArrayList<String> Data; 

	public ArrayList<String> getData() {
		return Data;
	}

	public void setData(ArrayList<String> data) {
		Data = data;
	}
 
	

}
