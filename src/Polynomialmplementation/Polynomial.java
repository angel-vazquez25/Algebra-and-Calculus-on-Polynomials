package Polynomialmplementation;

public interface Polynomial extends Iterable<Term> { // Polynomial interface of methods to apply in polynomial implementation
	
	public Polynomial add(Polynomial P2);
	
	public double definiteIntegral(double a, double b);
	
	public int degree();
	
	public Polynomial derivative();

	boolean equals(Polynomial P);
	
	public double evaluate(double x);
	
	public Polynomial indefiniteIntegral();
	
	public Polynomial multiply(double c);
	
	public Polynomial multiply(Polynomial P2);
	
	public Polynomial subtract(Polynomial P2);
	
	public String toString();

}
