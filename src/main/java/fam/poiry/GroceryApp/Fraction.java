package fam.poiry.GroceryApp;

public class Fraction extends Number {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8185700612481962121L;
	private int whole = 0;
	private int numerator;
    private int denominator;

    public Fraction(int whole, int numerator, int denominator) {
    	if(denominator == 0) {
            throw new IllegalArgumentException("denominator is zero");
        }
    	
        if(denominator < 0 || whole < 0) {
            whole *= -1;
        	numerator *= -1;
            denominator *= -1;
        }
        
        this.whole = whole;
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public Fraction(int numerator, int denominator) {
        if(denominator == 0) {
            throw new IllegalArgumentException("denominator is zero");
        }
        
        if(denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }
    
    public void normalizeFraction() {
    	if (whole != 0) {
    		numerator = numerator + (whole * denominator);
    		whole = 0;
    	}
    }
    
    public void denormalizeFraction() {
    	if (numerator > denominator) {
    		whole += numerator / denominator;
    		numerator = numerator % denominator;
    	}
    }
    
    public int getWhole() {
    	return this.whole;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public byte byteValue() {
        return (byte) this.doubleValue();
    }

    public double doubleValue() {
        return ((double) numerator)/((double) denominator);
    }

    public float floatValue() {
        return (float) this.doubleValue();
    }

    public int intValue() {
        return (int) this.doubleValue();
    }

    public long longValue() {
        return (long) this.doubleValue();
    }

    public short shortValue() {
        return (short) this.doubleValue();
    }

    public boolean equals(Fraction frac) {
        return this.compareTo(frac) == 0;
    }

    public int compareTo(Fraction frac) {
    	normalizeFraction();
    	frac.normalizeFraction();
    	
        long t = this.getNumerator() * frac.getDenominator();
        long f = frac.getNumerator() * this.getDenominator();
        int result = 0;
        if(t>f) {
            result = 1;
        }
        else if(f>t) {
            result = -1;
        }
        return result;
    }
    
    public String toString() {
    	if (whole == 0) {
    		return numerator + "/" + denominator;
    	} else if (denominator == 1) { 
    		return new Integer(numerator).toString();
    	} else {
    		return whole + " " + numerator + "/" + denominator;
    	}
    }
}