package Polynomialmplementation;

import java.util.Iterator;
import java.util.StringTokenizer;

import Lists.ArrayList;

public class PolynomialImp implements Polynomial
{
    public ArrayList<Term> polynomial;
    
    
    public PolynomialImp(String strP4) {
    	 
    	polynomial = new ArrayList<Term>(3);
    	PolyFromStrToVal(strP4);
		
    }
    
    private void PolyFromStrToVal(String strP4) { 
    	
		StringTokenizer token = new StringTokenizer(strP4,"+");
		String nextStringtok = null;
		Term nextTerm = null;
		this.polynomial.clear();
		
		while(token.hasMoreElements()) {
			nextStringtok = (String) token.nextElement();
			nextTerm = TermImp.TermFromStrToVal(nextStringtok);
			this.addTerm(nextTerm);
		}
	}
    
    private void addTerm(Term nextTerm){ //Terminado
    	
    	if(nextTerm.getCoefficient() != 0) {
    		
    		if(this.polynomial.isEmpty()) {this.polynomial.add(nextTerm);}
    		else {
    			boolean target = true;
    			for(int i = 0; i < this.polynomial.size();++i) {
    				if(nextTerm.getExponent() > this.polynomial.get(i).getExponent()) {
    					this.polynomial.add(i,nextTerm);
    					target = false;
    					break;
    				}
    			}
    			if(target){this.polynomial.add(nextTerm);}
    		}
    		
    	}

    	else {
    		if(this.polynomial.isEmpty() && nextTerm.getExponent() == 0) {this.polynomial.add(nextTerm);}
    	}
    	
    }
    
    @Override
	public Iterator<Term> iterator(){ //Terminado
        return this.polynomial.iterator();
    }
    
    public Polynomial add(Polynomial P2) {
        PolynomialImp result = new PolynomialImp("");
        
        for(Term poly: this.polynomial) {
        	
        	boolean target = false;
        	for(Term poly2: P2) {
        		
        		if(poly.getExponent() == poly2.getExponent()) {
        			
        			target = true;
        			TermImp term = new TermImp(poly.getCoefficient() + poly2.getCoefficient(), poly.getExponent());
        			result.addTerm(term);
        			break;
        				
        		}
        	}
        	
        	if(!target) {
        		
        		TermImp term = new TermImp(poly.getCoefficient(),poly.getExponent());
        		result.addTerm(term);
        	}
        }
        
        for(Term term1: P2) {
        	
        	boolean target = true;
        	for(Term term2: this.polynomial) {
        		
        		if(term1.getExponent() == term2.getExponent()) {
        			target = false;
        		}
        	}
        	
        	if(target) {
        		
        		TermImp term = new TermImp(term1.getCoefficient(),term1.getExponent());
        		result.addTerm(term);
        				
        	}
 
        }
        return result;
    }
    
    public Polynomial subtract(Polynomial P2) { //Terminado
        return this.add(P2.multiply(-1));
    }
    
    public Polynomial multiply(Polynomial P2) { // Terminado
    	ArrayList<PolynomialImp> onlyPoly = new ArrayList<PolynomialImp>(3);
    	
    	for(Term poly: this.polynomial) {
    		PolynomialImp result = new PolynomialImp("");
    		
    		for(Term poly2: P2) {
    			TermImp newTerm = new TermImp(poly.getCoefficient() * poly2.getCoefficient(),poly.getExponent() + poly2.getExponent());
				result.addTerm(newTerm);
    		}
    		
    		onlyPoly.add(result);
    	}
    	
    	for(int i = 0;i < onlyPoly.size()-1;i++){
			
			onlyPoly.set(0,(PolynomialImp) onlyPoly.get(0).add(onlyPoly.get(i + 1)));
		}
        return onlyPoly.get(0);
    }
    
    public Polynomial multiply(double c) { //Terminado
    	PolynomialImp result = new PolynomialImp("");
    	
    	if(c == 0) {
    		result.addTerm(new TermImp(0,0));
    		return result;
    	}
    	
    	for(Term term: this.polynomial) {
    		TermImp target = new TermImp(term.getCoefficient()*c, term.getExponent());
    		result.addTerm(target);
    	}
        return result;
    }
    
    public Polynomial derivative() { // Terminado
    	PolynomialImp result = new PolynomialImp("");
    	
    	for(Term term: this.polynomial) {
    		if(term.getExponent() != 0) {
    			TermImp target = new TermImp(term.getCoefficient()*term.getExponent(),term.getExponent()-1);
    			result.addTerm(target);
    		}
    	}
        return result;
    }
    
    public Polynomial indefiniteIntegral() { //Terminado
        PolynomialImp result = new PolynomialImp("");
        
        for(Term poly: this.polynomial) {
        	TermImp term = new TermImp((poly.getCoefficient())/(poly.getExponent()+1),poly.getExponent()+1);
        	result.addTerm(term);
        }
        
        result.addTerm(new TermImp(1,0)); // Add constant 1 to the polynomial
        return result;
    }
    
    public double definiteIntegral(double a, double b) { //Terminado
        return this.indefiniteIntegral().evaluate(b) - this.indefiniteIntegral().evaluate(a);
    }
    
    public int degree() { //Terminado
        return this.polynomial.firstElement().getExponent();
    }
    
    public double evaluate(double x) { // Terminado
    	
    	double result = 0;
    	for(Term eval: this.polynomial) { result += eval.evaluate(x);}
    	
        return result;
    }
    
    @Override
    public String toString() { // Terminado
		String result = "";
		if(this.polynomial.isEmpty()){
			return "0.00";
		}
		for(int i = 0; i < this.polynomial.size(); i++){
			result += this.polynomial.get(i).ToString() + "+";
		}
		return result.substring(0,result.length() - 1);
	}

	@Override
	public boolean equals(Polynomial P) {
		return this.toString().equals(P.toString());
	}
}