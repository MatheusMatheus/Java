package com.tdd;

import java.util.stream.LongStream;

public class Matherator implements Subtractor, Adder{

	@Override
	public long add(long... operands) {
		return LongStream.of(operands).sum();
	}

	@Override
	public long subtract(long... operands) {
		return LongStream.of(operands).reduce((x, y) -> x - y).getAsLong();
	}
}
