package com.tradeshift.geometry.impl;

import java.util.ArrayList;
import java.util.HashMap;

public class Cube extends ThreeDobject {	
	protected Type type = null ;
	public Cube (ArrayList<Double> sides)
	{
		super(sides) ;
		type = Type.Cube;		
		doValidations();		
	}
	
	public Cube ()
	{
		super() ;
		type = Type.Cube;
		doValidations() ;
		
	}
	public void setSides(ArrayList<Double> sides)
	{
		this.sides = sides ;	
		validateBasicGeometricStructure();
	}	
	
	protected void doValidations()
	{		
		addGeometricDetails("Possible 3D-Polygon Type based on Data ", type.name()) ;
		super.validateBasicGeometricStructure();		
	}	
	
	

	

}

