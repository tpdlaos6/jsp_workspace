package ch07;

public class Calculator {
	private int n1;
	private int n2;
	public int getN1() {
		return n1;
	}
	public void setN1(int n1) {
		this.n1 = n1;
	}
	public int getN2() {
		return n2;
	}
	public void setN2(int n2) {
		this.n2 = n2;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	private String op;
	
	
	public long calc() { // JSP Model1 Architecture. 모델만 분리된 방식. 모델로 클래스를 만듬.
		long result = 0;
		switch(op){
		case "+":result = n1+n2; break;
		case "-":result = n1-n2; break;
		case "/":result = n1/n2; break;
		case "*":result = n1*n2; break;
		}
		return result;
	}
}
