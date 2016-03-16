/*
 * @author : Gautam Gupta 2014040
 * @author : Akshat Sinha 2014132
 * */
public class Main {

	public static void main(String[] args) {

		
		Runnable place1 = new thread("Delhi",61) ;
		new Thread(place1).start();
		Runnable place2 = new thread("Mumbai",67) ;
		new Thread(place2).start();
		Runnable place3 = new thread("Chennai",71) ;
		new Thread(place3).start();	 
	}

}
