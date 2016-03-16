/*
 * @author : Gautam Gupta 2014040
 * @author : Akshat Sinha 2014132
 * */
import java.util.Collections;
import java.util.Vector;

public class GenerateStats implements Observer {

	TempLog t ;
	Subject sub ;
	private final Object MUTEX= new Object();
	double Mean   , Median , Max , Min  ;
	int n  ;
	
	GenerateStats(TempLog t)
	{
		this.t = t ;
		Mean = 0.0 ;
		Median = 0.0 ;
		Max = 0.0 ;
		Min = 70.0 ;
		n = 0 ;
	}
	
	
	@Override
	public void update() {
		{
		synchronized (MUTEX) 
		{
			Object msg = sub.getUpdate(this);
	        if(msg == null){
	            System.out.println(t.place+":: No new message");
	        }else
	        {
	        double temp = (double)msg ;
	        //System.out.println(t.place+":: Consuming message::"+ temp);
	        try{
	 		   
	    		n = n + 1 ;
	    		Mean = (Mean*(n-1)+ temp)/(n);
	    		if(Max < temp)
	    		{
	    			Max = temp ;
	    		}
	    		
	    		if(Min > temp)
	    		{
	    			Min = temp ;
	    		}
	    		
	    		Vector<Double> temp_list = new Vector<>(t.temp);
	    		Collections.sort(temp_list);
	    		if(n%2 == 0)
	    			Median = (temp_list.get(n/2) + temp_list.get(n/2+1))/2 ;
	    		else
	    			Median = temp_list.get(n/2+1);
	    		
	    		System.out.println(t.place +" : "+Mean + "," + Median + "," + Max + "," + Min);
	    		   
	    	   }catch(Exception ex){
	    		   ex.printStackTrace();
	    	   }
	        
	        }
		}
		}

	}

	@Override
	public void setSubject(Subject sub) {
		this.sub = sub ;
	}

}
