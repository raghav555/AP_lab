/*
 * @author : Gautam Gupta 2014040
 * @author : Akshat Sinha 2014132
 * */
import java.util.ArrayList;

public class Topic implements Subject {

	public ArrayList<Observer>list=new ArrayList<>();
	private static final Object MUTEX= new Object();
	private boolean changed;
	 private double message;

	@Override
	public void register(Observer obj) {
		synchronized (MUTEX) 
		{
	        if(!list.contains(obj)) list.add(obj);
	    }
	}

	@Override
	public void unregister(Observer obj) {
		 synchronized (MUTEX) {
		        list.remove(obj);
		        }
	}

	@Override
	public void notifyObservers() {
		ArrayList <Observer> observersLocal;
		synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.list);
            this.changed=false;
        }
        for (Observer obj : observersLocal) {
            obj.update(); 
        }
	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}
	 public void postMessage(double msg,String name ){
	        //System.out.println("Message Posted to Topic:"+msg);
		 synchronized(MUTEX)
		 	{
			System.out.println(msg+" temp at "+name);
	        this.message=msg;
	        this.changed=true;
	        notifyObservers();
		 	}
		 }
	 

}
