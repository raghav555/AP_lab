/*
 * @author : Gautam Gupta 2014040
 * @author : Akshat Sinha 2014132
 * */
public class Predictor1 implements Observer
{
	String name;
	private Subject topic;
	Boolean bada =false;
	Double[] five=new Double[5];
	int i;
	Predictor1(String name)
	{
		this.name=name;
		i=0;
	}
	@Override
	public void update() {
		five[i%5]=(Double) topic.getUpdate(this);
		i++;
		double sum = 0;
		if(i>5)
		{
			bada = true;
		}
		if(bada)
		{
			for(int j=0;j<5;j++)
			{
				sum+=five[j];
				//System.out.println(five[j]);
			}
			System.out.println("Preddictor 1 for "+name+" is: "+sum/5);
		}
		else
		{
			//System.out.println("bada nhi hai");
			for(int j=0;j<i;j++)
			{
				sum+=five[j];
				//System.out.println(five[j]);
			}
			System.out.println("Preddictor 1 for "+name+" is: "+sum/i);
		}
	}

	@Override
    public void setSubject(Subject sub) {
        this.topic=sub;
    }
}
