package OwnTest;

import java.util.Random;

import Lists.ArrayList;
import Polynomialmplementation.PolynomialImp;
import Polynomialmplementation.Term;
import Polynomialmplementation.TermImp;
 

class ownTest { // own test of ArrayList implememntation

	public static void main(String[] args) {
		// Polynomial doesnt need to be in order of descing powers
		PolynomialImp test = new PolynomialImp("x^2+x^-1");
		PolynomialImp test1 = new PolynomialImp("-1x^2+-1x^-2");
		
		System.out.println("Test Class");
		System.out.println();
		
		System.out.println(test1.add(test));
		System.out.println();
		
		System.out.println(test1);
		System.out.println();
		
		System.out.println(test1.indefiniteIntegral().multiply(new PolynomialImp("0")));
		System.out.println();
		
		System.out.println(test.derivative());
		System.out.println();
		
		System.out.println(test.derivative().indefiniteIntegral());
		System.out.println();
		
		PolynomialImp testImp = new PolynomialImp("1x^2+2x");
		System.out.println("Original Polinomial: " + testImp);
		System.out.println();
		
		System.out.println("Integral: " + testImp.indefiniteIntegral());
		System.out.println();
		
		System.out.println("DefiniteIntegral: "+testImp.definiteIntegral(0, 2));
		System.out.println();
		
		System.out.println("WolframAlpha result: 20/3 = " + (double)20/3);
		System.out.println();

		
		PolynomialImp P1 = new PolynomialImp("8x^2+1");
		PolynomialImp P2 = new PolynomialImp("4x^2+2");
		PolynomialImp P3 = new PolynomialImp("");
		PolynomialImp p1 = new PolynomialImp("x^2");
		PolynomialImp p2 = new PolynomialImp("0x^2+x+1");
		PolynomialImp p3 = new PolynomialImp("x+x^3+1+3x^2+x^4+0");
		PolynomialImp p4 = new PolynomialImp("0");
		PolynomialImp p5 = new PolynomialImp("x+-8x^2+-1");
		PolynomialImp p6 = new PolynomialImp("x+-1");
		PolynomialImp p7 = new PolynomialImp("1");
		PolynomialImp p8 = new PolynomialImp("0x+0+23x^3");
		PolynomialImp p9 = new PolynomialImp("0x+0+23x^3");
		
		System.out.println("p1 = " + p1.toString());
		System.out.println();
		
		System.out.println("p2 = " + p2.toString());
		System.out.println();
		
		System.out.println("p3 = " + p3.toString());
		System.out.println();
		
		System.out.println("p4 = " + p4.toString());
		System.out.println();
		
		System.out.println("p5 = " + p5.toString());
		System.out.println();
		 
		System.out.println("p6 = " + p6.toString());
		System.out.println();
		
		System.out.println("p7 = " + p7.toString());
		System.out.println();
		
		System.out.println("p8 = " + p8.toString());
		System.out.println();
		
		System.out.println("p4 degree = " + p4.degree());
		System.out.println();
		
		System.out.println("p9 derivative = " + p9.derivative());
		System.out.println();
		
		System.out.println("p1 multiply p2 = " + p1.multiply(p2));
		System.out.println();
		
		System.out.println("Definite integral of p4 from 4->6 = " + p4.indefiniteIntegral().definiteIntegral(4, 6));
		System.out.println();
		
		System.out.println("Indefinite integral p6 = " + p6.indefiniteIntegral());
		System.out.println();
		
		System.out.println("P3 =" + P3.toString());
		System.out.println();
		
		System.out.println("P1 indefinite integral = " + P1.indefiniteIntegral());
		System.out.println();
		
		System.out.println("p7 degree = " + p7.degree());
		System.out.println();
		
		System.out.println("p1 evaluated in 5 = " + p1.evaluate(5));
		System.out.println();
		
		System.out.println("p2 evaluated in 3 = " + p2.evaluate(3));
		System.out.println();
		
		System.out.println("p6 equals p4? = " + p6.equals(p4));
		System.out.println();
		
		System.out.println("p8 equals p9? = " + p8.equals(p9));
		System.out.println();
		
		System.out.println("p5 added to p8 = " + p8.add(p5));
		System.out.println();
		
		System.out.println("p4 added to p2 = " + p2.add(p4));
		System.out.println();
		
		System.out.println("p1 added to p6 = " + p6.add(p1));
		System.out.println();
		
		System.out.println("P3 - p2 =" + P3.subtract(p2));
		System.out.println();
		
		
		System.out.println("p3 - P1 =" +  p3.subtract(P1));
		System.out.println();
		
		Random rand = new Random();
		double coefficient = rand.nextDouble()*rand.nextInt();
		double exponent  = rand.nextInt(999);
		ArrayList<Term> terms = new ArrayList<Term>(2); 


		String temp = "";
		int top = 2;
		for (int i = 0; i < top; i++){
			coefficient = rand.nextDouble()*rand.nextInt();
			exponent  = rand.nextInt(rand.nextInt(9999));
			if(!(i==top-1))
				temp+= coefficient+"x^"+(int) exponent+"+";
			else {
				temp+= coefficient+"x^"+(int) exponent;
			}
			terms.add(new TermImp(coefficient, (int) exponent));
		}
		System.out.println("temp = " + temp); 
		System.out.println();
		
		System.out.println("p3 toString = " + p3.toString());
		
	}

}
