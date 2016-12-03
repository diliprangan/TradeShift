package com.tradeshift.geometry.impl;

import java.util.ArrayList;

public class QuadriLateral extends Triangle {		
	protected enum QuadriLateralType {Square, Rectangale, Other, Invalid } ;
	public QuadriLateral (ArrayList<Double> sides)
	{
		super(sides) ;
		type = Type.QuadriLateral;
		doValidations();		
	}
	
	public QuadriLateral ()
	{
		super() ;
		type = Type.QuadriLateral;
		doValidations() ;
		
	}
	public void setSides(ArrayList<Double> sides)
	{
		this.sides = sides ;	
		doValidations() ;
	}	
	
	protected void doValidations()
	{
		super.doValidations();
		if ((type == Type.QuadriLateral) && (sides != null ) && (sides.size() == 4))
			determineQuadriLateralType() ;
	}
	
	private void  determineQuadriLateralType()
	{
		if (!basicValidationsPassed)
			addGeometricDetails(type.name() + " Type based on Data is an ", QuadriLateralType.Invalid.name().toUpperCase() + " quadrilateral..") ;
		else
		{
			if (sides.get(0).doubleValue() == sides.get(sides.size() -1).doubleValue()) 
				addGeometricDetails(type.name() + " Type based on Data is an ", QuadriLateralType.Square.name().toUpperCase() + " quadrilateral..") ;
			else
			{
				if ((sides.get(1).doubleValue() == sides.get(0).doubleValue()) && (sides.get(2).doubleValue() == sides.get(3).doubleValue()) )
					addGeometricDetails(type.name() + " Type based on Data is an ", QuadriLateralType.Rectangale.name().toUpperCase() + " quadrilateral..") ;
				else
					addGeometricDetails(type.name() + " Type based on Data is an ", QuadriLateralType.Other.name().toUpperCase() + " quadrilateral..") ;
			}
		}
			
	}


}
