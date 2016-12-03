package com.tradeshift.geometry.impl;

import java.util.ArrayList;

public class Point extends TwoDimensionalPolygon {
	protected Type type = null ;	
	public Point (ArrayList<Double> sides)
	{
		super(sides) ;		
		type = Type.Point;
		doValidations();		
	}
	
	public Point ()
	{
		super() ;
		type = Type.Point;
		doValidations() ;
		
	}
	public void setSides(ArrayList<Double> sides)
	{
		this.sides = sides ;	
		validateBasicGeometricStructure();
	}	
	
	protected void doValidations()
	{		
		addGeometricDetails("Possible Polygon Type based on Data ", type.name()) ;
		super.validateBasicGeometricStructure();		
	}	

}

