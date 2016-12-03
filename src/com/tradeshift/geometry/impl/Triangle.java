package com.tradeshift.geometry.impl;

import java.util.ArrayList;
import java.util.HashMap;

public class Triangle extends Angular {	
	protected enum TriangleType {Equilateral, Isosceles, Scalene, Invalid } ;
	public Triangle (ArrayList<Double> sides)
	{
		super(sides) ;
		type = Type.Triangle;		
		doValidations();		
	}
	
	public Triangle ()
	{
		super() ;
		type = Type.Triangle;
		doValidations() ;
		
	}
	public void setSides(ArrayList<Double> sides)
	{
		this.sides = sides ;	
		validateBasicGeometricStructure();
	}	
	
	protected void doValidations()
	{		
		super.doValidations() ;
		if ((type == Type.Triangle)&& (sides != null ) &&  (sides.size() == 3))
			determineTriangleType() ;
	}
	
	private void  determineTriangleType()
	{
		if (!basicValidationsPassed)
			addGeometricDetails(type.name() + " Type based on Data is an ", TriangleType.Invalid.name().toUpperCase() + " triangle..") ;
		else
		{
			if (sides.get(0).doubleValue() == sides.get(2).doubleValue()) 
				addGeometricDetails(type.name() + " Type based on Data is an ", TriangleType.Equilateral.name().toUpperCase() + " triangle..") ;
			else
			{
				if ((sides.get(1).doubleValue() == sides.get(0).doubleValue()) || (sides.get(1).doubleValue() == sides.get(2).doubleValue())) 
					addGeometricDetails(type.name() + " Type based on Data is an ", TriangleType.Isosceles.name().toUpperCase() + " triangle..") ;
				else
					addGeometricDetails(type.name() + " Type based on Data is an ", TriangleType.Scalene.name().toUpperCase() + " triangle..") ;
			}
		}
			
	}

	

}
