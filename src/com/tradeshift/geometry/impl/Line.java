package com.tradeshift.geometry.impl;

import java.util.ArrayList;

public class Line extends Point {	
	public Line (ArrayList<Double> sides)
	{
		super(sides) ;
		type = Type.Line;
		doValidations();		
	}
	
	public Line ()
	{
		super() ;
		type = Type.Line;
		doValidations() ;
		
	}
	public void setSides(ArrayList<Double> sides)
	{
		this.sides = sides ;	
		validateBasicGeometricStructure();
	}
	
	

}


