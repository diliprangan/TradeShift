package com.tradeshift.geometry.impl;

import java.util.ArrayList;

public class Angular extends Line {	
	public Angular (ArrayList<Double> sides)
	{
		super(sides) ;
		type = Type.Angular;
		doValidations();		
	}
	
	public Angular ()
	{
		super() ;
		type = Type.Angular;
		doValidations() ;
		
	}
	public void setSides(ArrayList<Double> sides)
	{
		this.sides = sides ;	
		validateBasicGeometricStructure();
	}	
	
	
}



