package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;
import java.security.InvalidParameterException;

public class RangeTest {
    private Range exampleRange;
    private Range expectedRange;
    private Range CompRange;

    @BeforeClass public static void setUpBeforeClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception { 
        exampleRange = new Range(-1, 1);
    }

    //equals() section

    @Test
    public void ShouldEqualtest() {
    	exampleRange = new Range(1, 1);
    	CompRange = new Range(1, 1);
        assertTrue("Comparing 1,1 to 1,1 should equal",
        exampleRange.equals(CompRange));
    }
    
    @Test
    public void LowerBoundSmall() {
    	exampleRange = new Range(1, 1);
    	CompRange = new Range(0, 1);
    	assertFalse("Comparing 1,1 to 0,1 should not equal", 
    	exampleRange.equals(CompRange));
    }
    
    @Test
    public void LowerBoundBig() {
    	CompRange = new Range(2, 2);
    	exampleRange = new Range(1, 2);
    	assertFalse("Comparing 1,2 to 2,2 should not equal",
    			exampleRange.equals(CompRange));
    }

    @Test
    public void HigherBoundSmall() {
    	exampleRange = new Range(4, 8);
    	CompRange = new Range(4, 7);
    	assertFalse("Comparing 4, 8 to 4, 7 should not equal",
    			exampleRange.equals(CompRange));
    }

    @Test
    public void HigherBoundBig() {
    	exampleRange = new Range(1, 1);
    	CompRange = new Range(1, 2);
    	assertFalse("Comparing 1,1 to 1,2 should not equal",
    			exampleRange.equals(CompRange));
    }

    @Test
    public void BothNonMatchingHigh() {
    	exampleRange = new Range(1,2);
    	CompRange = new Range(3,4);
    	assertFalse("1,2 should not equal 3,4",
    			exampleRange.equals(CompRange));
    }

    @Test
    public void BothNonMatchingLow() {
    	exampleRange = new Range(4,5);
    	CompRange = new Range(1,2);
    	assertFalse("4,5 should not equal 1,2",
    			exampleRange.equals(CompRange));
    }

    @Test
    public void ComparingNegativeNumbers() {
    	exampleRange = new Range(-2,-1);
    	CompRange = new Range(-2, -1);
    	assertTrue("-2,-1 and -2, -1 should equal",
    			exampleRange.equals(CompRange));
    }

    @Test
    public void ComparingNegativewithPositive() {
    	exampleRange = new Range(-2,3);
    	CompRange = new Range(-2,3);
    	assertTrue("-2, 3 and -2, 3 should equal",
    			exampleRange.equals(CompRange));
    }

    @Test
    public void ComparingMismatchSigns() {
    	exampleRange = new Range(2,3);
    	CompRange = new Range(-2,3);
    	assertFalse("2, 3 and -2, 3 should not equal",
    			exampleRange.equals(CompRange));
    }

    @Test
    public void ComparingToNull() {
    	assertFalse("Comparing -1,1 to Null should not equal",
    			exampleRange.equals(null));
    }
    
    //getLength() section
    
    @Test
    public void all0s() {
    	exampleRange = new Range(0, 0);
    	assertEquals("0, 0 should have a range of 0",
    			0, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void all1s() {
    	exampleRange = new Range(1, 1);
    	assertEquals("1, 1 should have a range of 0",
    			0, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void PositiveLength1() {
    	exampleRange = new Range(1, 2);
    	assertEquals("1, 2 should have a range of 1",
    			1, exampleRange.getLength(), .000000001d);
    }

    @Test
    public void NegativeLength1() {
    	exampleRange = new Range(-2, -1);
    	assertEquals("-2, -1 should have a range of 1",
    			1, exampleRange.getLength(), .000000001d);
    }
    
    @Test
    public void LengthAcross0() {
    	exampleRange = new Range(-1, 1);
    	assertEquals("-1, 1 should have a range of 2",
    			2, exampleRange.getLength(), .000000001d);
    }

    //constrian() section
    /**
     * Tests the constrain() method when the input value is within the range.
     */
    @Test
    public void testConstrainWithinRange() {
        assertEquals("A value within the range should return itself", 0.5, exampleRange.constrain(0.5), 0.000000001d);
    }

    /**
     * Tests the constrain() method when the input value is below the range.
     */
    @Test
    public void testConstrainBelowLowerBound() {
        assertEquals("A value below the lower bound should return the lower bound", -1, exampleRange.constrain(-2), 0.000000001d);
    }

    /**
     * Tests the constrain() method when the input value is above the range.
     */
    @Test
    public void testConstrainAboveUpperBound() {
        assertEquals("A value above the upper bound should return the upper bound", 1, exampleRange.constrain(2), 0.000000001d);
    }
    //Shift() section
     @Test
    public void testPositiveDeltaValueWithNoZeroCrossingAndZeroCrossingFalseForShift() {
    	expectedRange = new Range(0,2);
    	assertEquals("After shifting by 1 with no zero crossing the range -1,1 should become 0,2",expectedRange,Range.shift(exampleRange,1));
    }
    
    @Test
    public void testNegativeDeltaValueWithNoZeroCrossingAndZeroCrossingFalseForShift() {
    	expectedRange = new Range(-2,0);
    	assertEquals("After shifting by -1 with no zero crossing the range -1,1 should become -2,0",expectedRange,Range.shift(exampleRange, -1));
    }
    
    @Test
    public void testPositiveDeltaValueWithNoZeroCrossingAndZeroCrossingTrueForShift() {
    	expectedRange = new Range(0,2);
    	assertEquals("After shifting by 1 with zero crossing the range -1,1 should become 0,2",expectedRange,Range.shift(exampleRange,1,true));
    }
    
    @Test
    public void testNegativeDeltaValueWithNoZeroCrossingAndZeroCrossingTrueForShift() {
    	expectedRange = new Range(-2,0);
    	assertEquals("After shifting by -1 with zero crossing the range -1,1 should become -2,0",expectedRange,Range.shift(exampleRange, -1,true));
    }
    
    @Test
    public void testNegativeDeltaValueWithZeroCrossingFalseForShift() {
    	expectedRange = new Range(-3,0);
    	assertEquals("After shifting by -2 with no zero crossing the range -1,1 should become -3,0",expectedRange,Range.shift(exampleRange, -2));
    }
    
    @Test
    public void testPositiveDeltaValueWithZeroCrossingFalseForShift() {
    	expectedRange = new Range(0,3);
    	assertEquals("After shifting by 2 with no zero crossing the range -1,1 should become 0,3",expectedRange,Range.shift(exampleRange, 2));
    }
    
    @Test
    public void testPositiveDeltaValueWithZeroCrossingTrueForShift() {
    	expectedRange = new Range(1,3);
    	assertEquals("After shifting by 2 with zero crossing the range -1,1 should become 1,3",expectedRange,Range.shift(exampleRange, 2, true));
    }
    
    @Test
    public void testNegativeDeltaValueWithZeroCrossingTrueForShift() {
    	expectedRange = new Range(-3,-1);
    	assertEquals("After shifting by -2 with zero crossing the range -1,1 should become -3,-1",expectedRange,Range.shift(exampleRange, -2, true));
    }

    @Test
    public void testZeroDeltaValueWithZeroCrossingFalseForShift() {
    	expectedRange = new Range(-1,1);
    	assertEquals("After shiftingg by 0 with no zero crossing the range -1,1 should remain 1,1", expectedRange,Range.shift(exampleRange,0));
    }
    
    @Test
    public void testZeroDeltaValueWithZeroCrossingTrueForShift() {
    	expectedRange = new Range(-1,1);
    	assertEquals("After shiftingg by 0 with zero crossing the range -1,1 should remain 1,1", expectedRange,Range.shift(exampleRange,0));
    }
    
    @Test
    public void testExceptionWhenNullRangePassedForShift() {
    	try {
    		Range.shift(null, 1);
    	}catch(InvalidParameterException e) {
    		
    	}catch(Exception e){
    		fail("When passed a null shift should throw a InvalidParameterError but instead throws:" + e.getMessage());
    	}
    }

    //Expand Section()
    @Test
    public void testLowerAndUpperBoundWithPercentage() {
    	expectedRange = new Range(-2,2);
    	assertEquals("After expanding the range -1,1 by 0.5,0.5 the returned range should be -2,2",expectedRange,Range.expand(exampleRange, 0.5, 0.5));
    }
    @Test
    public void testZeroLowerMarginForExpand() {
    	expectedRange = new Range(-1,2);
    	assertEquals("After expanding the range -1,1 by 0,0.5 the returned range should be -1,2",expectedRange,Range.expand(exampleRange, 0, 0.5));
    }
    
    @Test
    public void testZeroUpperMarginForExpand() {
    	expectedRange = new Range(-2,1);
    	assertEquals("After expanding the range -1,1 by 0.5,0 the returned range should be -2,1",expectedRange,Range.expand(exampleRange, 0.5, 0));
    }
    
    @Test
    public void testZeroLowerMarginAndUpperMarginForExpand() {
    	expectedRange = new Range(-1,1);
    	assertEquals("After expanding the range -1,1 by 0,0 the returned range should be -1,1",expectedRange,Range.expand(exampleRange, 0, 0));
    }
    
    @Test
    public void testLowerMarginGreaterThanOne() {
    	expectedRange = new Range(-5,2);
    	assertEquals("After expanding the range -1,1 by 2,0.5 the returned range should be -5,2",expectedRange,Range.expand(exampleRange, 2, 0.5));
    }
    
    @Test
    public void testUpperMarginGreaterThanOne() {
    	expectedRange = new Range(-2,5);
    	assertEquals("After expanding the range -1,1 by 0.5,2 the returned range should be -2,5",expectedRange,Range.expand(exampleRange, 0.5, 2));
    }
    
    @Test
    public void testLowerAndUpperMarginGreaterThanOne() {
    	expectedRange = new Range(-5,5);
    	assertEquals("After expanding the range -1,1 by 2,2 the returned range should be -5,5",expectedRange,Range.expand(exampleRange, 2, 2));
    }
    
    @Test
    public void testExceptionWhenNullRangePassedForExpand() {
    	try {
    		Range.expand(null, 1,1);
    	}catch(InvalidParameterException e) {
    		
    	}catch(Exception e){
    		fail("When passed a null shift should throw a InvalidParameterError but instead throws:" + e.getMessage());
    	}
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
