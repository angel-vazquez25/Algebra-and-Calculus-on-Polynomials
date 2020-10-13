package Polynomialmplementation;

import java.util.StringTokenizer;

import Lists.ArrayList;
import Lists.List;

public class TermImp implements Term {
	
	private double coef;
	private int exp;
	
	public TermImp(double Coefficient, int Exponent) {
		
		this.coef = Coefficient;
		this.exp = Exponent;
		
	}

	@Override
	public double getCoefficient() {
		
		return this.coef;
		
	}

	@Override
	public int getExponent() {
		
		return this.exp;
		
	}

	@Override
	public double evaluate(double x) {
		
		return this.coef * Math.pow(x, this.exp);
		
	}

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
			
			StringTokenizer token = new StringTokenizer(temporary,"x^");
			List<String> newList = new ArrayList<String>(2);
			while(token.hasMoreElements()) {
				newList.add((String)token.nextElement());
			}
			
			if(newList.size() == 0) {throw new IllegalArgumentException("Illegal Format of Argument");}
			else if(newList.size() == 1) {
				Integer exponent = Integer.parseInt(newList.get(0));
				result = new TermImp(1,exponent);
			}else {
				Double coefficient = Double.parseDouble(newList.get(0));
				Integer exponent = Integer.parseInt(newList.get(1));
				result = new TermImp(coefficient, exponent);
			}
			
		}
		
		else if(temporary.contains("x")) {
			
			StringTokenizer token = new StringTokenizer(temporary,"x");
			List<String> newList = new ArrayList<String>(2); 
			while(token.hasMoreElements()) {
				newList.add((String)token.nextElement());
			}
			
			if(newList.size() == 0 ) {result = new TermImp(1.0,1);}
			else {
				Double coefficient = Double.parseDouble(newList.get(0));
				result = new TermImp(coefficient,1);
			}
			
		}
		
		else {
			
			result = new TermImp(Double.parseDouble(temporary),0);
			
		}
		
		return result; 
	}


}
