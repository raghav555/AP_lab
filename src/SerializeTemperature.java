/*
 * @author : Gautam Gupta 2014040
 * @author : Akshat Sinha 2014132
 * */
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeTemperature implements Observer {

	TempLog t ;
	Subject sub ;
	private final Object MUTEX= new Object();
	
	SerializeTemperature(TempLog t)
	{
		this.t = t ;
	}
	
	@Override
	public void update() {
		synchronized (MUTEX) 
		{
			Object msg = sub.getUpdate(this);
	        if(msg == null){
	            System.out.println(t.place+":: No new message");
	        }else
	        {
	        //System.out.println(t.place+":: Consuming message::"+ (double)msg);
	        try{
	 		   
	    		FileOutputStream fout = new FileOutputStream("./src/"+t.place+".ser");
	    		ObjectOutputStream oos = new ObjectOutputStream(fout);   
	    		oos.writeObject(t);
	    		oos.close();
	    		System.out.println(t.place + "---Done");
	    		   
	    	   }catch(Exception ex){
	    		   ex.printStackTrace();
	    	   }
	        
	        }
		}
		
	}

	@Override
	public void setSubject(Subject sub) {
		this.sub = sub ;
	}
	

}
