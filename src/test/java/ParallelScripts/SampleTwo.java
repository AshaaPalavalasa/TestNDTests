package ParallelScripts;

import org.testng.annotations.Test;

public class SampleTwo {
	@Test
	  public void SampleTestOne() {
		  
			  long id=Thread.currentThread().getId();
			  System.out.println("SampleTestOne"+ id);
	  }
	  @Test
	  public void SampletestTwo() {
		  
			  long id=Thread.currentThread().getId();
			  System.out.println("SampletestTwo"+ id);
	  }
	  @Test
	  public void SampletestThree() {
		  
			  long id=Thread.currentThread().getId();
			  System.out.println("SampletestThree"+ id);
	  }
	  @Test
	  public void SampletestFour() {
		  
			  long id=Thread.currentThread().getId();
			  System.out.println("SampletestFour"+ id);
	  }
}
