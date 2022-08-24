package com.nagarro.comparator;

import com.nagarro.model.*;
import java.util.*;

public class Compare
{	
	public void sortingPriority(List<TShirt> list, int choice)
	{
		if(choice==1)
		{
			Comparator<TShirt> comparePrice = new Comparator<TShirt>() {
	
				public int compare(TShirt t1, TShirt t2) {
					// TODO Auto-generated method stub
					if (t1.getPrice() > t2.getPrice()) {
						return 1;
					}
					return -1;
				}
			};
			
			Collections.sort(list,comparePrice);
		}
		else if(choice==2)
		{
			Comparator<TShirt> compareRate = new Comparator<TShirt>() {
	
				public int compare(TShirt t1, TShirt t2) {
					// TODO Auto-generated method stub
					if (t1.getRating() < t2.getRating()) {
						return 1;
					}
					return -1;
				}
			};
			
			Collections.sort(list,compareRate);
		}
	}
}

