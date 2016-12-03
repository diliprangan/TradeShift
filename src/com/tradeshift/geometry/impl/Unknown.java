package com.tradeshift.geometry.impl;

import java.util.ArrayList;

public class Unknown extends Cube {	
	public Unknown (ArrayList<Double> sides)
	{
		super(sides) ;
		type = Type.Unknown;
		doValidations();		
	}
	
	public Unknown (int dimension , ArrayList<Double> sides)
	{
		super(sides) ;
		type = Type.Unknown;
		doValidations();		
	}
	
	public Unknown ()
	{
		super() ;
		type = Type.Unknown;
		doValidations() ;
		
	}
	public void setSides(ArrayList<Double> sides)
	{
		this.sides = sides ;	
		validateBasicGeometricStructure();
	}
	
	

}



