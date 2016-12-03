package com.tradeshift.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.tradeshift.geometry.intf.MultiDimensionalGeometricObject;

public class GeometryTest {

	static int dimensionLoc = -1 ;
	static int sidesLoc = -1 ;
	private String geometricDimensionalClass ;
	MultiDimensionalGeometricObject mdgo = null ;
	public static void main(String[] args) {
		int dimension =0 ;		
		ArrayList<Double> sides =new ArrayList<Double>() ;
		
		System.out.println("*****************Validating Input Data**************************");
		System.out.println("");
		if (!passedParameterValidations(args))
		{
			printUsage() ;
			System.exit(0);
		}		
		try
		{
			dimension = Integer.parseInt(args[dimensionLoc+1]);
			if ((dimension == 0) || (dimension > 3))
			{
				System.out.println("We currently support only 3 dimensions. Value of Dimensions should be 1, 2 or 3 ");
				printUsage() ;
				System.exit(0);
			}
		}
		catch (Exception e)
		{
			System.out.println("Dimensions parameter need to be an Integer ");
			printUsage() ;
			System.exit(0);
		}
		try
		{
			loadSides(args, sides);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(0);			
		}
		//System.out.println("Looks good");
		GeometryTest tt = new GeometryTest(dimension, sides);
		
		
	}
	
	public GeometryTest(int dimensions, ArrayList<Double> sides)
	{
		ArrayList<Double>  modifiedSides = sides ;
		
		if ((dimensions == 1) && (sides != null ) && (sides.size() > 1))
		{			
			System.out.println("The Data provided is 1 Dimension but more than 1 side is provided. So i will take just the first side");
			ArrayList <Double> tmp = new ArrayList <Double>() ;
			tmp.add(sides.get(0));
			modifiedSides = tmp ;			
		}
		
		System.out.println("*****************Done Validating Input Data**************************");
		System.out.println("");
		System.out.println("*****************Data Provided Start*******************************");
		System.out.println("Dimensions ::: " + dimensions);
		System.out.println("Sides      ::: " + modifiedSides.size() + " sides");
		System.out.println("*****************Data Provided End ********************************");
		System.out.println("");
		System.out.println("**Our Recommendations based on Data Provided **********************");
		System.out.println("");
		
		
		geometricDimensionalClass = MultiDimensionalGeometricObject.Dimension.getDimensionalClass(dimensions);
		//System.out.println(this.getClass().getPackage().getName());
		Class<?> geometricStructuralClazz = determineGeometricStructure(modifiedSides);
		if (geometricStructuralClazz != null)
		{
			try {
				Constructor<?> cons = geometricStructuralClazz.getConstructor(ArrayList.class);
				mdgo = (MultiDimensionalGeometricObject)cons.newInstance(modifiedSides);
				mdgo.displayGeometricDetails();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {				
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//System.out.print(pkg);;
		
	}
	
	private Class<?> determineGeometricStructure( ArrayList<Double> sides)
	{
		Class<?> geometricDimClazz = null ;
		Class<?> geometricStructuralClazz = null;
		
		String pkg = "com.tradeshift.geometry.impl.";
		try {
			geometricDimClazz = this.getClass().getClassLoader().loadClass(pkg+geometricDimensionalClass);
			//Class<?> clazz = Class.forName(pkg+geometricDimensionalClass+".class", true, TriangleTest.class.getClassLoader());
			//System.out.println(geometricDimClazz.getName());
			Class[] argTypes = new Class[] { int.class };
			Method m = geometricDimClazz.getMethod("determineGeometricFigure", argTypes);
			Object geoStructureClass  = m.invoke(null,  (Object) (sides.size()));
			geometricStructuralClazz = this.getClass().getClassLoader().loadClass(pkg+geoStructureClass.toString());
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return geometricStructuralClazz ;
	}
	
	private static void printUsage()
	{
		System.out.println ("Usage :: java TrianagleTest -dimensions <Number Of Dimensions> -sides side1 side2 side3");
	}
	
	private static boolean passedParameterValidations(String[] args)
	{
		boolean validationPassed = false ;
		if (args.length < 2)
		{
			System.out.println("No Arguments provided ");
			return validationPassed ;
			//printUsage() ;
			
		}
		for (int argCount =0 ; argCount < args.length ; argCount++)
		{
			if (args[argCount].equalsIgnoreCase("-dimensions"))
				dimensionLoc = argCount ;
			if (args[argCount].equalsIgnoreCase("-sides"))
				sidesLoc = argCount ;			
		}
		
		if ((dimensionLoc < 0) || (sidesLoc < 0))
		{
			System.out.println("No Dimensions or Sides provided ");
			return validationPassed ;
		}
		
		if ((dimensionLoc == args.length-1) || (sidesLoc == args.length-1))
		{
			System.out.println("Either No Dimensions or Sides provided ");
			return validationPassed ;
		}
		
		if (Math.abs(dimensionLoc-sidesLoc) == 1)
		{
			System.out.println("Either No Dimensions or Sides provided ");
			return validationPassed ;
		}
		return true ;

	}
	
	private static void loadSides(String[] args, ArrayList<Double> sides) throws IllegalArgumentException
	{
		int endPoint = 0 ;
		if (sidesLoc > dimensionLoc)
			endPoint = args.length ;
		else
			endPoint = dimensionLoc ;	
		for (int i = sidesLoc+1; i < endPoint; i++)
		{
			try
			{
				Double side = Double.parseDouble(args[i]);
				if (side > 0)
					sides.add(side) ;
				else
					System.out.println("Not adding this side of value " + side.doubleValue() + " to the structural list of sides as it is <= 0. This will impact your expected results as the geometric structure will change..");
			}
			catch (Exception e)
			{
				throw new IllegalArgumentException("The value of the side(s) has to be a valid number ") ;
			}
		}
			
	}
	
	

}
