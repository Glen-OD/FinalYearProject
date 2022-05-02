#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package};

import org.graphwalker.core.machine.ExecutionContext;

/**
 * Implements the GraphWalker model: src/main/resources/SmallTest.json
 * <p/>
 * The interface SmallTest, that SomeSmallTest implements, is generated by
 * running: mvn graphwalker:generate-sources
 * also: mvn compile
 */
public class SomeSmallTest extends ExecutionContext implements SmallTest {

  @Override
  public void e_FirstAction() {
    System.out.println("Running: e_FirstAction");
  }

  @Override
  public void e_AnotherAction() {
    System.out.println("Running: e_AnotherAction");
  }

  @Override
  public void e_SomeAction() {
    System.out.println("Running: e_SomeAction");
  }

  @Override
  public void e_SomeOtherAction() {
    System.out.println("Running: e_SomeOtherAction");
  }

  @Override
  public void v_VerifyInitialState() {
    System.out.println("Running: v_VerifyInitialState");
  }

  @Override
  public void v_VerifyFirstAction() {
    System.out.println("Running: v_VerifyFirstAction");
  }

  @Override
  public void v_NewVertex() {
    System.out.println("Running: v_NewVertex");
  }
}