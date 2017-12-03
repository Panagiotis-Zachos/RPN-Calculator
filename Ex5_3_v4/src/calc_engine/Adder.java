package calc_engine;

public class Adder extends Operand{
	public void operate(){
		try {
			Calc.st.push(Operand.S1.pop() + Operand.S1.pop());
		}
		catch(java.util.EmptyStackException e){
			System.out.println("Error: Not enough elements in stack");
		}
	}
}
