/*
 * @author : Gautam Gupta 2014040
 * @author : Akshat Sinha 2014132
 * */
import java.io.Serializable;
import java.util.Vector;

public class TempLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String place ;
	Vector<Double> temp = new Vector<>();
	
	TempLog(String place , double temp)
	{
		this.place = place ;
		this.temp.add(temp) ;
	}
	
	void add(Double d)
	{
		temp.add(d);
	}
}
