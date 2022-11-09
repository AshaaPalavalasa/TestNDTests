package ParallelScripts;

import org.testng.annotations.Test;

public class MathodInvocation {
  @Test(invocationCount=10, threadPoolSize=4, timeOut=2000)
  public void MultipleRunTest() {
	  long id=Thread.currentThread().getId();
	  System.out.println("SampleTestOne"+ id);
  }
}
