

import java.math.BigInteger;
import java.util.Iterator;


public class iteratorExample {

	/**
	 * 
	 */
	public static void main(String[] args) {
		FibonacciSequence seq = new FibonacciSequence( new BigInteger("100000000") );
		int sz = 1;
		for (BigInteger f: seq) {
			System.out.print(sz++ + ":");
			System.out.println(f);
		}
	}
}

/*
 * This is a collection of all Fibonacci numbers less than 
 * {@code maximal}
 */
class FibonacciSequence implements Iterable<BigInteger> {
	BigInteger maximal;
	
	public FibonacciSequence(BigInteger maximal) {
		super();
		this.maximal = maximal;
	}
	
	public FibonacciSequence(long maximal) {
		super();
		this.maximal = BigInteger.valueOf(maximal);
	}
	/*
	 * @see java.lang.Iterable#iterator()
	 * 
	 */
	@Override
	public Iterator<BigInteger> iterator() {
		return new fiboIterator(this);
	}
	
	public BigInteger getMaximal() {
		return maximal;
	}
}

class fiboIterator implements Iterator<BigInteger> {
	FibonacciSequence sequence;
	BigInteger currentFibonacciNumber;
	BigInteger nextFibonacciNumber;
	public fiboIterator(FibonacciSequence sequence) {
		this.currentFibonacciNumber = BigInteger.ZERO;
		this.nextFibonacciNumber = BigInteger.ONE;
		this.sequence = sequence;
	}
	
	@Override
	public boolean hasNext() {
		return nextFibonacciNumber.compareTo(this.sequence.maximal) <= 0;
	}

	@Override
	public BigInteger next() {
		BigInteger aux = nextFibonacciNumber;
		nextFibonacciNumber = nextFibonacciNumber.add(currentFibonacciNumber);
		currentFibonacciNumber = aux;
		return currentFibonacciNumber;
	}

	@Override
	public void remove() {
	}
	
}
