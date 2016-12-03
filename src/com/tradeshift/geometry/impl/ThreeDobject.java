package com.tradeshift.geometry.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import com.tradeshift.Util.MergeSort;
import com.tradeshift.geometry.intf.MultiDimensionalGeometricObject;
import com.tradeshift.geometry.intf.MultiDimensionalGeometricObject.Dimension;

public abstract class ThreeDobject implements
		MultiDimensionalGeometricObject {
	
	protected HashMap <String, String> geometryDetails = new LinkedHashMap<String, String> ();
	public enum Type{
	       Cube(6), Unknown(1);
	       private int value;
	       private Type(int value) {
	            this.value = value;
	       }
	       public int getValue(){
	        return value;
	       }	       
	       
	   }
	
	public static String determineGeometricFigure(int numberOfSides)
   	{
   		for(Type typ: Type.values())
    	   {
    		   if (typ.getValue() == numberOfSides)
    			   return typ.name();
    	   }
    	   return Type.Unknown.name() ;
   	}
	
	protected  Dimension dimensions = null ;
	protected ArrayList <Double> sides = null ;
	protected ArrayList <Double> angles = null ;
	protected String shape = null ;
	protected boolean basicValidationsPassed = false ;
	public ThreeDobject()
	{
		dimensions = Dimension.ThreeDobject ;
		addGeometricDetails("Dimension- Data", dimensions.getValue() + " Dimensional Object...");
	}
	
	public ThreeDobject(int dime, ArrayList <Double> listOfSides)
	{
		this(listOfSides) ;
		dimensions = Dimension.getDimensionalName(dime) ;
		
	}
	
	public ThreeDobject(ArrayList <Double> listOfSides)
	{
		this();		
		sides = listOfSides ;
		if ((sides != null) && (sides.size() > 0))
			addGeometricDetails("Sides Data", "This is a " + sides.size() +  " sided 3D Object..." );
	}
	
	public void validateBasicGeometricStructure()
	{
		if ((sides != null) && (sides.size() > 5))
		{
			MergeSort mSort = new MergeSort() ;
			mSort.sortList(sides);
			if ((mSort.getTotal() - mSort.getMax()) > mSort.getMax())
			{			
				addGeometricDetails("Basic_Validations", "Passed - Just Checked for 3D - Polygon Inequalities");
				basicValidationsPassed = true ;
			}
			else
				addGeometricDetails("Basic_Validations", "Failed - Just Checked for 3D - Polygon Inequalities");				
		}
		else
			addGeometricDetails("Basic_Validations", "Passed - Nothing to Validate");
	}
	
	public void displayGeometricDetails()
	{
		if ((geometryDetails.size() > 0))
		{
			Iterator it = geometryDetails.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " ::: " + pair.getValue());		        
		    }
		}
		else
			System.out.println("No Details to display for the data provided");
		
	}
	
	public void addGeometricDetails(String key, String info)
	{
		geometryDetails.put(key, info);
	}
		
	public HashMap<String, String> getGeometricDetails() {
		// TODO Auto-generated method stub
		return geometryDetails;
	}
	

}

