package Core_Java8_Features;

/*
 * Programming Styles :
 * 
 *  A) Imperative
 *  B) Declarative:
 *  C) Functional
 * 
 * 
 * 
 * 
 * Lambda expression : short block of code that accepts input as a parameter and return the result
 *   Point1 : It only acts as an implementation to functional interfaces.
 *   Point2 : we can pass it to the functions as an object and executes it on demand
 *   Point3 : we can functions which is not belonging to any class
 *   
 *  SYNTAX : (PARAMETERS)->{BODY}
 *   ()-> is optional when there are no parameters or single parameters
 *   {}-> are optional when there is only one statement
 * 
 *   ()->System.out.println("hello world");
 *   (int p)->System.out.println(p);
 *   p->system.out.println(p);
 *   (p1,p1)->{};
 * 
 * 
 * 
 * Method references :
 * Method reference is used to refer method of functional interface. 
 * It is compact and easy form of lambda expression.
 * a) Method reference to static method : className::methodName
 * b) Method reference to instance method : instanceVariableName::methodName
 * c) Constructor reference : Messageable hello = Message::new;  
 * 
 * 
 * 
 * Functional Interfaces : @FunctionalInterface
 *   -> Functional style of programming
 *  A) Contains only one abstract methods
 *  B) Can define any no of default and static methods
 *  C) Can declare object class methods
 *  D) annotation is optional, better to mention so that compiler will throw an error in case if we add any more
 *  E) A functional interface can extends any other interface with non abstract methods
 *  
 * 
 * 
 * Predefined Functional interfaces :
 * 
 * Java provides handful of predefined functional interfaces to deal with functional programming
 * by using lambda expressions and method references 
 * 
 */
@FunctionalInterface
interface Drawable {
	public void draw();
	// public void xyz();
}

@FunctionalInterface
interface Sayable {
	public String say();
}

@FunctionalInterface
interface Sayable2 {
	String say(String message);
}

public class FunctionalInterfacesAndLambdaExpressions {

	public static void main(String[] args) {

		// without lambda expressions
		Drawable draw = new Drawable() {
			public void draw() {
				System.out.println("Hell world");
			}
			// public void xyz() {}
		};
		draw.draw();

		// With lambda expressions
		Drawable d = () -> System.out.println("Hello world");
		d.draw();

		// no parameter lambda expression {} must necessary when returning
		Sayable s = () -> {
			return "I have nothing to say";
		};
		s.say();

		// You can pass multiple statements in lambda expression
		Sayable2 person = (message) -> {
			String str1 = "I would like to say, ";
			String str2 = str1 + message;
			return str2;
		};
		System.out.println(person.say("time is precious."));
		
		// PREDEFINED FUNCTIONAL INTERFACES
		
	}

}

//

