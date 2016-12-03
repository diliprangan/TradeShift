package com.tradeshift.geometry.impl;

import java.util.ArrayList;

import com.tradeshift.geometry.impl.TwoDimensionalPolygon.Type;

public class Polygon extends QuadriLateral {		
	protected enum PolygonType {EquiSided, Undefined, Invalid } ;
	public Polygon (ArrayList<Double> sides)
	{
		super(sides) ;
		type = Type.Polygon;
		doValidations();		
	}
	
	public Polygon ()
	{
		super() ;
		type = Type.Polygon;			
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
		if ((type == Type.Polygon) && (sides != null ) && (sides.size() > 4))
			determinePolygonType() ;
	}
	
	private void  determinePolygonType()
	{
		if (!basicValidationsPassed)
			addGeometricDetails(type.name() + " Type based on Data is an ", PolygonType.Invalid.name().toUpperCase() + " Polygon..") ;
		else
		{
			if (sides.get(0).doubleValue() == sides.get(sides.size() -1).doubleValue()) 
				addGeometricDetails(type.name() + " Type based on Data is an ", PolygonType.EquiSided.name().toUpperCase() + " Polygon..") ;
			else
			{				
					addGeometricDetails(type.name() + " Type based on Data is an ", PolygonType.Undefined.name().toUpperCase() + " Polygon..") ;				
			}
		}
			
	}


}

