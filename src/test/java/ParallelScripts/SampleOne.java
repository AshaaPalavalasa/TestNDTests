package ParallelScripts;

import org.testng.annotations.Test;

public class SampleOne {
  @Test
  public void testOne() {
	  
		  long id=Thread.currentThread().getId();
		  System.out.println("TestOne"+ id);
  }
  @Test
  public void testTwo() {
	  
		  long id=Thread.currentThread().getId();
		  System.out.println("TestTwo"+ id);
  }
  @Test
  public void testThree() {
	  
		  long id=Thread.currentThread().getId();
		  System.out.println("TestThree"+ id);
  }
  @Test
  public void testFour() {
	  
		  long id=Thread.currentThread().getId();
		  System.out.println("TestFour"+ id);
  }
}
