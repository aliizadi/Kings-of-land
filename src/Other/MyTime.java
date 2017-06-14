package Other;

import javax.swing.JLabel;

import maps.Map;

public class MyTime implements Runnable {
  
  private final int month_in_year , day_in_month;
  private int halfDay_length;    
  private int [] date ;
  private Map map;
  private JLabel dayViewer, dateViewer;
  private long d;
  private boolean suspend = false; 
  
  public MyTime(int halfDay_length , int []start_date ) {
    
    // TODO Auto-generated constructor stub
    
    month_in_year = 12;
    day_in_month = 3;
    
    this.halfDay_length = halfDay_length ;
    this.date = start_date;
    
    
  }
  
  public MyTime(int halfDay_length , int []start_date, Map map, JLabel dayViewer, JLabel dateViewer ) {

    // TODO Auto-generated constructor stub

    month_in_year = 12;
    day_in_month = 3;

    this.halfDay_length = halfDay_length ;
    this.date = start_date;
    this.map = map;
    this.dayViewer = dayViewer;
    this.dateViewer = dateViewer;

  }
  
  public MyTime(int halfDay_length , int []start_date, Map map) {

	    // TODO Auto-generated constructor stub

	    month_in_year = 12;
	    day_in_month = 3;

	    this.halfDay_length = halfDay_length ;
	    this.date = start_date;
	    this.map = map;
	  }
  
  
  

  public int[] getDate() {
    return date;
  }
  
  public void setDate(int[] date) {
    this.date = date;
  }
  
  public void setDayViewer(JLabel dayViewer) {
	  this.dayViewer = dayViewer;
  }
  
  public void setDateViewer(JLabel dateViewer) {
	  this.dateViewer = dateViewer;
  }
  
  public void setMap(Map map) {
	this.map = map;
}
  
  public synchronized void suspend() { suspend = true; notify(); }
  
  public synchronized void resume() { suspend = false; notify(); }

  @Override
  public void run() {
    
    // TODO Auto-generated method stub
	  
    
    while(true){
    	
    	synchronized (this) {
			
			while(suspend){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
      
      d = System.currentTimeMillis();
      while (d+halfDay_length>System.currentTimeMillis());
      
      //changing day to night
      date[3]++;
      dayViewer.repaint();
      map.repaint();
      
      if(date[3] ==2){
        //forward to next day
        date[2]++;
        
        date[3] = 0;
        
        if(date[2] == day_in_month){
          //forward to next month
          date[1]++;
          dateViewer.repaint();
          map.repaint();
          
          date[2] = 0;
          
          if(date[1] == month_in_year){
            //forward to next year
            date[0]++;
            dateViewer.repaint();
            map.repaint();
            
            date[1] = 0;
          }
          
        }
        //System.out.println(date);
      }

    }
    
  }

}