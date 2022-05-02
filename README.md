GraphWalker fault tolerant heuristic implementations.

Addition code made soley by me:
glenfinalyearproject-graphwalker-project-4.3.1-graphwalker-core-src-main-java-org-graphwalker-core-machine:
BlackListStrategy.java, TryAgainStrategy.java, NodeStatus.java

Classes I added onto that were already there:
SimpleMachine.java, ExecutionContext.java
as well as glenfinalyearproject-graphwalker-project-4.3.1-graphwalker-core-src-main-java-org-graphwalker-core-model:
Vertex.java

Slight changes in:
Context.java and MachineBase.java

How to use TryAgainStrategy:
In MachineBase.java set the exceptionStrategy as:
private ExceptionStrategy exceptionStrategy = new TryAgainStrategy();

How to use BlackListStrategy:
In MachineBase.java set the exceptionStrategy as:
private ExceptionStrategy exceptionStrategy = new BlackListStrategy();


You can look at the original implementation over at https://github.com/GraphWalker/graphwalker-project/tree/master/graphwalker-core/src/main/java/org/graphwalker/core
