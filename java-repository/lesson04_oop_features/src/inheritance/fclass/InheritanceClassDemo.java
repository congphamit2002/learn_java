package inheritance.fclass;

public class InheritanceClassDemo {
	public static void main(String[] args) {
		// Parent: age, name, codingSkills
		// Child: age, name, codingSkills, playingGame
		InheritanceParent parent = new InheritanceParent();
		
		InheritanceChild child = new InheritanceChild();
		
//		InheritanceChild object = new InheritanceParent();
//		object.playingGame();
		
		// Parent & Child
		// Parent p = new Parent();
		// Parent p = new Child();
		// Child c = new Parent(); // not allowed
	}
}
