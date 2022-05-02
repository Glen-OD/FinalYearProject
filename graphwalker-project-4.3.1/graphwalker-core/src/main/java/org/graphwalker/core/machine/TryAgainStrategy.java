package org.graphwalker.core.machine;


import org.graphwalker.core.model.Edge;
import org.graphwalker.core.model.Element;
import org.graphwalker.core.model.Requirement;
import org.graphwalker.core.model.Vertex;

import java.util.List;

import static org.graphwalker.core.model.Edge.RuntimeEdge;

/**
 * <h1>TryAgainStrategy</h1>
 * The TryAgainStrategy handles the way GraphWalker handles failures during test execution.
 * </p>
 * The default way of handling a failure when executing a test, is to stop the test run and bail out.
 * This class goes back to the previous node and then re-executes the connecting edge between the previous and failed node
 * </p>
 *
 * @author Glen O'Donovan
 */
public class TryAgainStrategy implements ExceptionStrategy {

  @Override
  public void handle(Machine machine, MachineException exception) {
    Context context = exception.getContext();

    if(context.getCurrentElement() instanceof RuntimeEdge)
    {
      if(((RuntimeEdge) context.getCurrentElement()).getTargetVertex().getNodeStatus().equals(NodeStatus.FAILED)){
        //Do nothing, as we are only double checking that we truly left the previous node to retry this failed node
        //which may produce an exception on this edge, but we still want it to try execute the failed node again
        //so we set execution status to executing
        context.setExecutionStatus(ExecutionStatus.EXECUTING);
      }
    }
    else {
      //Has this node failed previously? if so stop the execution of the test
      if (((Vertex.RuntimeVertex) context.getCurrentElement()).getNodeStatus().equals(NodeStatus.FAILED)) {
        context.setExecutionStatus(ExecutionStatus.FAILED);
        throw exception;
      }

      //set Failed node to NodeStatus.FAILED, so we can check if it fails again.
      ((Vertex.RuntimeVertex) context.getCurrentElement()).setNodeStatus(NodeStatus.FAILED);

      //Previous element from a node is an Edge
      Edge.RuntimeEdge nextEdge = (RuntimeEdge) context.getLastElement();
      //The source vertex of the edge would be the previous node from the failed node
      Vertex.RuntimeVertex vertex = nextEdge.getSourceVertex();

      //Set execution status to Executing so the test doesn't stop running
      //Set current element to the previous node
      //Set next element to be the edge connecting the previous node and the failed node
      context.setExecutionStatus(ExecutionStatus.EXECUTING);
      machine.getCurrentContext().setCurrentElement(vertex);
      machine.getCurrentContext().setNextEdgeTryAgain(nextEdge);
    }
  }


}
