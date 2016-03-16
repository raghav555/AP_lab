/*
 * @author : Gautam Gupta 2014040
 * @author : Akshat Sinha 2014132
 * */

public class thread  implements Runnable {
	TempSensor t ;
	int Prime ;
	Topic subject ; 
	Observer obj1 ;
	Observer obj2 ;
	Observer obj3 ;
	Observer obj4 ;
	String name;
	static Boolean a=false;
	private final Object MUTEX = new Object();
	public thread(String name , int Prime) {
		this.name=name;
		   t = new TempSensor(name);
           this.Prime=Prime;
           
           subject =  new Topic();
           
           obj1 = new SerializeTemperature(t.log);
           obj2 = new Predictor1(name);
           obj3 = new Predictor2(name);
           obj4 = new GenerateStats(t.log);
           
           subject.register(obj1);
           subject.register(obj2);
           subject.register(obj3);
           subject.register(obj4);
           
           obj1.setSubject(subject);
           obj2.setSubject(subject);
           obj3.setSubject(subject);
           obj4.setSubject(subject);
	   }

	   public void run() {
           while(true)
           {
	           try{
	        	 synchronized (MUTEX) 
		   			{
		        	   Double temp_change = t.logTemp(Prime);
		        	   subject.postMessage(temp_change , name);
			           Thread.sleep(5000);
		   			}
	           	}
	           	catch(Exception e)
	           	{
	           		e.printStackTrace();
	           	}
           }    
	   }
}
