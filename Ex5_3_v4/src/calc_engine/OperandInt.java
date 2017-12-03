package calc_engine;

import java.util.Stack;

import calc_gui.CalculatorGui;

public interface OperandInt {
	 public void addDigit(char ch);
	 public void deleteLastDigit();
	 public void reset();
	 public void complete();
	 public void setCalculatorGui(CalculatorGui cg);
	 public void setStack(Stack<Double> S1);
	} 