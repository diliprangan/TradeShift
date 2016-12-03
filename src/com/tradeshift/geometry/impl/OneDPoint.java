package com.tradeshift.geometry.impl;

import java.util.ArrayList;

public class OneDPoint extends OneDimensionalLine {
	protected Type type = null ;	
	public OneDPoint (ArrayList<Double> sides)
	{
		super(sides) ;		
		type = Type.OneDPoint;
		doValidations();		
	}
	
	public OneDPoint ()
	{
		super() ;
		type = Type.OneDPoint;
		doValidations() ;
		
	}
	public void setSides(ArrayList<Double> sides)
	{
		this.sides = sides ;	
		validateBasicGeometricStructure();
	}	
	
	protected void doValidations()
	{		
		addGeometricDetails("Possible One Dimensional Type based on Data ", type.name()) ;
		super.validateBasicGeometricStructure();		
	}	

}

