package com.tradeshift.geometry.impl;

import java.util.ArrayList;

public class OneDLine extends OneDPoint {	
	public OneDLine (ArrayList<Double> sides)
	{
		super(sides) ;
		type = Type.OneDLine;
		doValidations();		
	}
	
	public OneDLine ()
	{
		super() ;
		type = Type.OneDLine;
		doValidations() ;
		
	}
	public void setSides(ArrayList<Double> sides)
	{
		this.sides = sides ;	
		validateBasicGeometricStructure();
	}
	
	

}



