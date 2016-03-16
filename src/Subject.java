/*
 * @author : Gautam Gupta 2014040
 * @author : Akshat Sinha 2014132
 * */
public interface Subject {
		 
	    //methods to register and unregister observers
	    public void register(Observer obj);
	    public void unregister(Observer obj);
	     
	    //method to notify observers of change
	    public void notifyObservers();
	     
	    //method to get updates from subject
	    public Object getUpdate(Observer obj);
	     
	}


