package calc_engine;


import java.util.Stack;
import calc_gui.CalculatorGui;


public class Operand implements OperandInt {
	private int val = 0;
	public static CalculatorGui cg;
	public static Stack<Double> S1;
	
	public void addDigit(char a){
		this.val = val*10 + Character.getNumericValue(a);
		cg.display.setText(String.valueOf(this.val));	
	}
	
	public void complete(){
		S1.push(Double.valueOf(this.val));
		this.val = 0;
		cg.display.setText(String.valueOf(val));
	}
	
	public void deleteLastDigit(){
		this.val /= 10;		
		cg.display.setText(String.valueOf(val));
	}
	
	public void reset(){
		this.val = 0;
		Calc.st.removeAllElements();
		cg.display.setText("Cleared All");
	}

	public void setCalculatorGui(CalculatorGui cg) {
		Operand.cg = cg;
	}

	public void setStack(Stack<Double> S1) {
		Operand.S1 = S1;
	}
	
	public void operate() {}
	
}