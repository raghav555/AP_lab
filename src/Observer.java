/*
 * @author : Gautam Gupta 2014040
 * @author : Akshat Sinha 2014132
 * */
public interface Observer {
     
    //method to update the observer, used by subject
    public void update();
     
    //attach with subject to observe
    public void setSubject(Subject sub);
}