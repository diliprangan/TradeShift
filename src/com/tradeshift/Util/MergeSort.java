package com.tradeshift.Util;

import java.util.ArrayList;

public class MergeSort {
	double total, max ;
	
	public static void main(String[] args)
	{
		MergeSort ms = new MergeSort();
		ArrayList<Double> A = new ArrayList<Double>();		
		A.add(new Double(0));
		A.add(new Double(3.5));
		A.add(new Double(4.6));
		A.add(new Double(2.1));
		A.add(new Double(0.1));
		ArrayList<Double> B =new ArrayList<Double>(A.size());
		ms.sortList(A);
		
	}
	
	public void sortList(ArrayList<Double> A )
	{
		ArrayList<Double> B =new ArrayList<Double>(A.size());
		topDownMergeSort(A, B, A.size());
		for (double i : A)
		{
			total = total + i ;
		}
		max = A.get(A.size()-1).doubleValue();
	}
	
	public double getTotal()
	{
		return total ;
	}
	public double getMax()
	{
		return max ;
	}
	
	
	
	public void topDownMergeSort(ArrayList<Double> A, ArrayList<Double> B, int n)
	{
	    CopyArray(A, 0, n, B);           // duplicate array A[] into B[]
	    topDownSplitMerge(B, 0, n, A);   // sort data from B[] into A[]
	}

	// Sort the given run of array A[] using array B[] as a source.
	// iBegin is inclusive; iEnd is exclusive (A[iEnd] is not in the set).
	private void topDownSplitMerge(ArrayList<Double> B, int iBegin, int iEnd, ArrayList<Double> A)
	{
	    if(iEnd - iBegin < 2)                       // if run size == 1
	        return;                                 //   consider it sorted
	    // split the run longer than 1 item into halves
	    int iMiddle = (iEnd + iBegin) / 2;              // iMiddle = mid point
	    //System.out.println("imiddle : " + iMiddle);
	    // recursively sort both runs from array A[] into B[]
	    topDownSplitMerge(A, iBegin,  iMiddle, B);  // sort the left  run
	    topDownSplitMerge(A, iMiddle,    iEnd, B);  // sort the right run
	    // merge the resulting runs from array B[] into A[]
	    topDownMerge(B, iBegin, iMiddle, iEnd, A);
	}
	
	private void  topDownMerge(ArrayList<Double> A, int iBegin, int iMiddle, int iEnd, ArrayList<Double> B)
	{
	    int i = iBegin;   int j = iMiddle;
	    
	    // While there are elements in the left or right runs...
	    for (int k = iBegin; k < iEnd; k++) {
	        // If left run head exists and is <= existing right run head.
	        if (i < iMiddle && (j >= iEnd || A.get(i).doubleValue() <= A.get(j).doubleValue())) {	            
	            B.set(k, A.get(i)) ;
	            i = i + 1;
	        } else {	            
	            B.set(k, A.get(j)) ;
	            j = j + 1;    
	        }
	    } 
	}
	
	private void CopyArray(ArrayList<Double> A, int iBegin, int iEnd, ArrayList<Double> B)
	{
	    for(int k = iBegin; k < iEnd; k++)	        
	    	B.add(A.get(k));
	    
	}

}
