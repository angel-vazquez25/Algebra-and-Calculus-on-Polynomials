package Polynomialmplementation;

import java.util.Iterator;
import java.util.StringTokenizer;

import Lists.ArrayList;

public class PolynomialImp implements Polynomial
{
    public ArrayList<Term> polynomial;

	/**
	 * Constructor for the cration of polynomial which receives a string
	 * @param strP4 Polynomial string form
	 */

	public PolynomialImp(String strP4) { //Polynomial Constructor
    	 
    	polynomial = new ArrayList<Term>(3);
    	PolyFromStrToVal(strP4);
		
    }

	/**
	 * Conversion of string polynomial to term polynomial
	 * @param strP4 = string polynomial form
	 */

	private void PolyFromStrToVal(String strP4) {
    	
		StringTokenizer token = new StringTokenizer(strP4,"+"); // create tokens using + as delimeter, example: 2x^2
		String nextStringtok = null;
		Term nextTerm = null;
		this.polynomial.clear();
		
		while(token.hasMoreElements()) { // while token has another element
			nextStringtok = (String) token.nextElement(); // change next token to string
			nextTerm = TermImp.TermFromStrToVal(nextStringtok); // create next term
			this.addTerm(nextTerm); // add term to this
		}
	}

	/**
	 * Addition of new term to current polynmial and rearrangement of terms in corresponding order
	 * @param nextterm
	 */
	private void addTerm(Term nextterm){
		// Rearrange polynomial in correct descending order

    	//Don't add terms with coefficient == 0
    	if(nextterm.getCoefficient() != 0) {
    		
    		if(this.polynomial.isEmpty()) {this.polynomial.add(nextterm);} //add 0 if polynomial is empty
    		else {
    			boolean target = true;
    			for(int i = 0; i < this.polynomial.size();++i) {
    				if(nextterm.getExponent() > this.polynomial.get(i).getExponent()) {
    					this.polynomial.add(i,nextterm);
    					target = false;
    					break;
    				}
    			}
    			if(target){this.polynomial.add(nextterm);}
    		}
    		
    	}

    	else {
    		if(this.polynomial.isEmpty() && nextterm.getExponent() == 0) {this.polynomial.add(nextterm);}
    	}
    	
    }
    
    @Override
	public Iterator<Term> iterator(){ //Terminado
        return this.polynomial.iterator();
    }

	/**
	 * add method between 2 polynomials
	 * @param P2 = polynomial to be added
	 * @return new polynomial result created after addition
	 */
	public Polynomial add(Polynomial P2) {
        PolynomialImp result = new PolynomialImp("");
        
        for(Term poly: this.polynomial) {
        	
        	boolean target = false;
        	for(Term poly2: P2) {
        		
        		if(poly.getExponent() == poly2.getExponent()) { // sum if 2nd term  is equal to the 1st term, then reak
        			
        			target = true;
        			TermImp term = new TermImp(poly.getCoefficient() + poly2.getCoefficient(), poly.getExponent());
        			result.addTerm(term);
        			break;
        				
        		}
        	}
        	
        	if(!target) { // if no term with same exponent, add at the end
        		
        		TermImp term = new TermImp(poly.getCoefficient(),poly.getExponent());
        		result.addTerm(term);
        	}
        }
        
        for(Term term1: P2) { // take care of non added terms in 2nd polynomial
        	
        	boolean target = true;
        	for(Term term2: this.polynomial) {
        		
        		if(term1.getExponent() == term2.getExponent()) {
        			target = false;
        		}
        	}
        	
        	if(target) { // if exponent is not found, add to result
        		
        		TermImp term = new TermImp(term1.getCoefficient(),term1.getExponent());
        		result.addTerm(term);
        				
        	}
 
        }
        return result;
    }

	/**
	 * substraction method of 2 polynomials
	 * @param P2 = polynomial to be substracted
	 * @return new polynomial after the substraction
	 */
	public Polynomial subtract(Polynomial P2) { //Terminado
        return this.add(P2.multiply(-1));
    }

	/**
	 *
	 * @param P2 polynomial to be multiplied
	 * @return resulting polynomial after multiplication
	 */
	public Polynomial multiply(Polynomial P2) { // Terminado
    	ArrayList<PolynomialImp> onlyPoly = new ArrayList<PolynomialImp>(3); // arraylist to save each polynomial after multiplication of terms
    	
    	for(Term poly: this.polynomial) {
    		PolynomialImp result = new PolynomialImp("");
    		
    		for(Term poly2: P2) {
    			TermImp newTerm = new TermImp(poly.getCoefficient() * poly2.getCoefficient(),poly.getExponent() + poly2.getExponent());
				result.addTerm(newTerm);
    		}
    		
    		onlyPoly.add(result); // add polynomial to arraylist
    	}
    	// sum all the polynomials
    	for(int i = 0;i < onlyPoly.size()-1;i++){
			
			onlyPoly.set(0,(PolynomialImp) onlyPoly.get(0).add(onlyPoly.get(i + 1)));
		}
        return onlyPoly.get(0); // resulting polynomial is at position 0
    }

	/**
	 * Scalar Multiplication
	 * @param c value to be multiply in polynomial
	 * @return new resulting polynomial
	 */
	public Polynomial multiply(double c) {
    	PolynomialImp result = new PolynomialImp("");
    	
    	if(c == 0) { // if c = 0, return a polynomial 0
    		result.addTerm(new TermImp(0,0));
    		return result;
    	}
    	
    	for(Term term: this.polynomial) {
    		TermImp target = new TermImp(term.getCoefficient()*c, term.getExponent());
    		result.addTerm(target);
    	}
        return result;
    }

	/**
	 *Derivation method
	 * @return derivatived polynomial
	 */
	public Polynomial derivative() {
    	PolynomialImp result = new PolynomialImp("");
    	
    	for(Term term: this.polynomial) {
    		if(term.getExponent() != 0) {
    			TermImp target = new TermImp(term.getCoefficient()*term.getExponent(),term.getExponent()-1);
    			result.addTerm(target);
    		}
    	}
        return result;
    }

	/**
	 * Indefinite integral method
	 * @return indefinite integral of current polynomial as resultant polynomial
	 */
	public Polynomial indefiniteIntegral() { //Terminado
        PolynomialImp result = new PolynomialImp("");
        
        for(Term poly: this.polynomial) {
        	TermImp term = new TermImp((poly.getCoefficient())/(poly.getExponent()+1),poly.getExponent()+1);
        	result.addTerm(term);
        }
        
        result.addTerm(new TermImp(1,0)); // Add constant 1 to the polynomial in substitution of constant C
        return result;
    }

	/**
	 * Evaluation of polynomial's integral
	 * @param a integrals lower bound or limit
	 * @param b integrals upper bound or limit
	 * @return
	 */
	public double definiteIntegral(double a, double b) {
        return this.indefiniteIntegral().evaluate(b) - this.indefiniteIntegral().evaluate(a);
    }

	/**
	 * Degree method
	 * @return polynomial's degree
	 */
	public int degree() { //Terminado
        return this.polynomial.firstElement().getExponent();
    }

	/**
	 * Evaluation of polynomial method
	 * @param x value to be evaluated at polynomial
	 * @return double result of evaluation
	 */
	public double evaluate(double x) { // Terminado
    	
    	double result = 0;
    	for(Term eval: this.polynomial) { result += eval.evaluate(x);}
    	
        return result;
    }

	/**
	 * Conversion of polynomial to string form polynomial
	 * @return resultant polynomial
	 */
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

	/**
	 * check if polynomials are equal
	 * @param P polynomial to be compared to this
	 * @return true if polynomials are equal
	 */
	@Override
	public boolean equals(Polynomial P) {
		return this.toString().equals(P.toString());
	}
}