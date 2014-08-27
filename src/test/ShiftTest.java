package test;

import static org.junit.Assert.*;

import org.junit.Test;

import stub.LineStorageStub;
import core.CircularShift;
import core.LineStorage;
import core.AlphabeticShift;

// Unit test for alphabetic and circular shift
// @author: A0099324X

public class ShiftTest {
	@Test
	public void testCircularShift(){
		LineStorage ls = new LineStorageStub();
		CircularShift cs = new CircularShift(ls);
		assertEquals(cs.getNumShiftedLines(), 0);
		cs.addData();
		assertEquals(cs.getNumShiftedLines(), 0);
		cs.circularShift();
		assertEquals(cs.getNumShiftedLines(), 10);
		assertEquals(cs.getShiftedLines(0), "THE day after tomorrow");
		assertEquals(cs.getShiftedLines(1), "DAY after tomorrow the");
	}
	@Test
	public void testAlphabeticShift(){
		LineStorage ls = new LineStorageStub();
		CircularShift cs = new CircularShift(ls);
		String[] noise = {"is", "the", "of", "and", "as", "a", "after"};
		cs.addNoise(noise);
		cs.addData();
		cs.circularShift();
		AlphabeticShift as = new AlphabeticShift(cs);
		as.alpha();
		assertEquals(as.getNumLines(), 6);
		assertEquals("DAY after tomorrow the", as.ith(0));
		assertEquals("FAST and furious", as.ith(1));
	}
}
