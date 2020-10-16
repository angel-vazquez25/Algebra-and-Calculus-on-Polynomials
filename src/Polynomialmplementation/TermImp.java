package Polynomialmplementation;

import java.util.StringTokenizer;

import Lists.ArrayList;
import Lists.List;

public class TermImp implements Term {
	
	private double coef;
	private int exp;

	/**
	 * Term constructor
	 * @param Coefficient
	 * @param Exponent
	 */
	public TermImp(double Coefficient, int Exponent) {
		
		this.coef = Coefficient;
		this.exp = Exponent;
		
	}

	/**
	 * @return term's coefficient
	 */
	@Override
	public double getCoefficient() {
		
		return this.coef;
		
	}

	/**
	 * @return term's exponent
	 */
	@Override
	public int getExponent() {
		
		return this.exp;
		
	}

	/**
	 * Evaluation of given value in term
	 * @param x value to be evaluated
	 * @return resultant after evaluation
	 */
	@Override
	public double evaluate(double x) {
		
		return this.coef * Math.pow(x, this.exp);
		
	}

	/**
	 * Conversion of term to string form term
	 * @return term's string
	 */
	@Override
	public String ToString() {
		if(this.exp == 0) {
			
			return String.format("%.2f", this.coef);
			
		}
		else if(this.exp == 1) {
			
			return String.format("%.2fx", this.coef);
			
		}
		else {
			
			return String.format("%.2fx^%d", this.coef, this.exp);
			
		}
	}

	public static Term TermFromStrToVal(String nextStringtok) {
		String temporary = new String(nextStringtok);
		TermImp result = null;
		
		if(temporary.contains("x^")){
			
			StringTokenizer token = new StringTokenizer(temporary,"x^");// term aX^n
			List<String> newList = new ArrayList<String>(2);
			while(token.hasMoreElements()) {
				newList.add((String)token.nextElement());
			}
			
			if(newList.size() == 0) {throw new IllegalArgumentException("Illegal Format of Argument");}
			else if(newList.size() == 1) { // term X^n
				Integer exponent = Integer.parseInt(newList.get(0));
				result = new TermImp(1,exponent);
			}else { // term aX^n, where a is coefficient and n is exponent and a!= 1
				Double coefficient = Double.parseDouble(newList.get(0));
				Integer exponent = Integer.parseInt(newList.get(1));
				result = new TermImp(coefficient, exponent);
			}
			
		}
		
		else if(temporary.contains("x")) { // exponent of value 1
			
			StringTokenizer token = new StringTokenizer(temporary,"x");
			List<String> newList = new ArrayList<String>(2); 
			while(token.hasMoreElements()) {
				newList.add((String)token.nextElement());
			}
			
			if(newList.size() == 0 ) {result = new TermImp(1.0,1);} // term of form x, coefficient = 1 and exponent = 1
			else {// term of form aX, coefficient = a and exponent = 1
				Double coefficient = Double.parseDouble(newList.get(0));
				result = new TermImp(coefficient,1);
			}
			
		}
		
		else { // numeric value
			
			result = new TermImp(Double.parseDouble(temporary),0);
			
		}
		
		return result; 
	}


}
