# Design patterns (GOF and another helpful patterns)
Divided into three groups

## Behavioral
## Creational
#### Builder (coming soon)

#### Factory Method
On this pattern I created based on log system which is able to put your log messages on different sort of output.\
Principal point of this implementation is on possibility that you can change implementation of logger and everything works normally.\
On this case I defined to use Scanner.in to get text message and after save this message on file (located on user home path).\
[link to simple implementation](https://github.com/marlonklc/design-patterns/blob/master/src/main/java/com/marlonklc/designpatterns/creational/FactoryMethod/FactoryMethodApp.java)


## Structural
#### Composite
On this pattern I created based on tree file system which is possible count total size on folder's tree.\
Principal point of this implementation is on possibility that you can count total all files without know a real concrete class, using abstraction of java class 'Path'.\
[link to simple implementation](https://github.com/marlonklc/design-patterns/blob/master/src/main/java/com/marlonklc/designpatterns/structural/Composite/CompositeApp.java)

BONUS: for this particular implementation I made a rudimentary console on System.in wich is possible to create folders, files and navigate between them. Check it out!\
[link for console](https://github.com/marlonklc/design-patterns/blob/master/src/main/java/com/marlonklc/designpatterns/structural/Composite/TerminalCompositeApp.java) \
`Just run this java main class and input in System.in some linux comands like as cd, mkdir, ls.`

## Extras (not necessarily from the GOF's book)
#### Combinator pattern (coming soon)