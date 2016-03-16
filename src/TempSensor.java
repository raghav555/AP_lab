/*
 * @author : Gautam Gupta 2014040
 * @author : Akshat Sinha 2014132
 * */
public class TempSensor {
	
	TempLog log ;
	
	TempSensor(String name)
	{
		log = new TempLog(name ,36.0);
	}
	
	double logTemp(int Prime)
	{
		double d = randGen(20,60,Prime) ;
		log.temp.add(d);
		return d ;
	}
	
	double randGen(int U , int L , int Prime)
	{
		double x = System.currentTimeMillis()%317;
		x = x%Prime;
		return U + x%(L-U) ;
	}

}
