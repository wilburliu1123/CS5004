# Builder pattern
1. Options class:
Builder pattern in Options class allows us to apply some check on the data used to initialize the object. For example, we can set the value of a field based on whether the value itself is valid. Once the valuse is set, we don't change the field and only access its value through getters.
2. Todo class:
Builder pattern in Todo class adds readability of code. It also creates immutable objects. Users can't change fields once initialized, except for few that are allowed to change through setters. Having builders also reduces the code used to initialize the different kind of Todo object based on the type of input that's been provided. For example we can easily factory a Todo object by a given Option object or a list of string.

# Decorator pattern
1. Decorators and display:
Decorators in view allow us to wrap addition function in order to extend the behavior of the default display, without permanently modifying it. The default display will show all the todo objects that are provided by the users. With different type of decorators, we can add specific instruction on top of the default, such as sort and filter. Decorators also avoid the several serious caveats that inheitance has. For example inheritance is static, we can only replace the whole object with another subclass. Using decorators, IDisplay can use the behavior of various kind of display. It also allows client to easily add different kinds of requirements. The client code would only need to wrap a new decorator that matches with the preference. The resulting objects will be structured as a stack.

# Facade pattern 
1. Facade calss in controller:
Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system. This type of design pattern comes under structural pattern as this pattern adds an interface to existing system to hide its complexities. In our design, Facade takes IReader, IWriter, ITodo, IDisplay and provides simplified methods required by client and delegates calls to methods of existing system classes. User's input are passed into Facade through an Option object. Then Facade acts as a remote controll for all other functionalities based on the fields of the Option object that's been parsed from command line input. This structure also helps us to minimize the effort of upgrading to future versions of the framework or replacing it with another one. The only thing we’d need to change in would be the implementation of the facade’s methods.

# Factory pattern
1. TodoGenerator class:
Using Factory pattern, we create a Todo object without exposing the creation logic to the client and refer to newly created object using static methods. Factory pattern encapsulates object creation logic which makes it easy to change it later. For example when we want to change how object gets created or we can even introduce new object with just change in one class or one method.

