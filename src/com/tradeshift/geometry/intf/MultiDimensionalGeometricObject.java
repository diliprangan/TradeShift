package com.tradeshift.geometry.intf;
import java.util.HashMap;

public interface MultiDimensionalGeometricObject {
	
	public enum Dimension{
	       ZeroDimensionalPoint (0), OneDimensionalLine(1), TwoDimensionalPolygon(2), ThreeDobject(3), ComplexGeometricObject(4);
	       private int value;
	       private Dimension(int value) {
	            this.value = value;
	       }
	       public int getValue(){
	        return value;
	       }
	       public static String getDimensionalClass(int dim)
	       {
	    	   //System.out.println("Value of dim" + dim);	    	   
	    	   for(Dimension dime: Dimension.values())
	    	   {
	    		   //System.out.println("Now Comparing " + dime.getValue() + " for " + dime.name() + " with " + dim);
	    		   if (dime.getValue() == dim)
	    		   {
	    			   //System.out.println("Returning " + dime.name());
	    			   return dime.name();
	    		   }
	    	   }
	    	   return ComplexGeometricObject.name() ;
	       }
	       public static Dimension getDimensionalName(int dim)
	       {
	    	   for(Dimension dime: Dimension.values())
	    	   {
	    		   //System.out.println("Now Comparing " + dime.getValue() + " for " + dime.name() + " with " + dim);
	    		   if (dime.getValue() == dim)
	    			   return dime ;
	    	   }
	    	   return ComplexGeometricObject ;
	       }
	       
	       
	       
	   }
		
	public void validateBasicGeometricStructure() ;
	public HashMap<String, String> getGeometricDetails() ;
	public void displayGeometricDetails() ;
	

}
