GraphWalker fault tolerant heuristic implementations.
(1) when the assertion in a model node fails, go back from the node to the previous node and go the failed node again; 
(2) when the assertion in a model node fails, walk back from the node to the previous node and continue the MBT execution from there to other nodes.

Additional code made soley by me:
glenfinalyearproject-graphwalker-project-4.3.1-graphwalker-core-src-main-java-org-graphwalker-core-machine:
BlackListStrategy.java, TryAgainStrategy.java, NodeStatus.java

Classes I added onto that were already there:
SimpleMachine.java, ExecutionContext.java
as well as glenfinalyearproject-graphwalker-project-4.3.1-graphwalker-core-src-main-java-org-graphwalker-core-model:
Vertex.java

Slight changes made in:
Context.java and MachineBase.java

How to use TryAgainStrategy:
In MachineBase.java set the exceptionStrategy as:
private ExceptionStrategy exceptionStrategy = new TryAgainStrategy();

How to use BlackListStrategy:
In MachineBase.java set the exceptionStrategy as:
private ExceptionStrategy exceptionStrategy = new BlackListStrategy();


You can look at the original implementation over at https://github.com/GraphWalker/graphwalker-project/tree/master/graphwalker-core/src/main/java/org/graphwalker/core

Github of the testing models https://github.com/vgarousi/MBTofTestinium
