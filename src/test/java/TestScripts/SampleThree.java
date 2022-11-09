package TestScripts;

import org.testng.annotations.Test;

public class SampleThree {
  @Test(groups="FirstRequirement")
  public void SearchPlaywright() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Playwright"+id);
  }
  @Test(groups="SecondRequirement")
  public void SearchCypress() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Cypress"+id);
  }
  @Test(groups="ThirdRequirement")
  public void SearchCucumber() {
	  long id=Thread.currentThread().getId();
	  System.out.println("Cucumber"+id);
  }
}
