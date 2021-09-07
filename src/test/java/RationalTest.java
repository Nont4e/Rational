import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RationalTest {

    @Test
    public void testAdd() {
        Rational x = new Rational();
        Rational y = new Rational();
        // Have common GCD
        x.numerator = 1;
        x.denominator = 2;
        y.numerator = 1;
        y.denominator = 4;
        x.add(y);
        Assert.assertEquals(3,x.numerator);
        Assert.assertEquals(4,x.denominator);
        //Have no common GCD
        x.numerator = 1;
        x.denominator = 2;
        y.numerator = 1;
        y.denominator = 3;
        x.add(y);
        Assert.assertEquals(5,x.numerator);
        Assert.assertEquals(6,x.denominator);
    }

    @Test
    public void testSubtract() {
        Rational x = new Rational();
        Rational y = new Rational();
        // Have common GCD
        x.numerator = 1;
        x.denominator = 2;
        y.numerator = 1;
        y.denominator = 4;
        x.subtract(y);
        Assert.assertEquals(1,x.numerator);
        Assert.assertEquals(4,x.denominator);
        //Have no common GCD
        x.numerator = 1;
        x.denominator = 2;
        y.numerator = 1;
        y.denominator = 3;
        x.subtract(y);
        Assert.assertEquals(1,x.numerator);
        Assert.assertEquals(6,x.denominator);
    }

    @Test
    public void testMultiply() {
        Rational x = new Rational();
        Rational y = new Rational();
        x.numerator = 1;
        x.denominator = 2;
        y.numerator = 3;
        y.denominator = 4;
        x.multiply(y);
        Assert.assertEquals(3,x.numerator);
        Assert.assertEquals(8,x.denominator);
    }

    @Test
    public void testDivide() {
        Rational x = new Rational();
        Rational y = new Rational();
        // Have common GCD
        x.numerator = 1;
        x.denominator = 2;
        y.numerator = 1;
        y.denominator = 4;
        x.divide(y);
        Assert.assertEquals(2,x.numerator);
        Assert.assertEquals(1,x.denominator);
    }

    @Test
    public void testEqual(){
        Rational x = new Rational();
        Rational y = new Rational();
        // True
        x.numerator = 1;
        x.denominator = 2;
        y.numerator = 1;
        y.denominator = 2;
        Assert.assertTrue(x.equals(y));
        //False
        y.numerator = 1;
        y.denominator = 4;
        Assert.assertFalse(x.equals(y));
    }

    @Test
    public void testCompareTo(){
        Rational x = new Rational();
        Rational y = new Rational();
        x.numerator = 1;
        x.denominator = 2;
        y.numerator = 1;
        y.denominator = 4;
        Assert.assertEquals(1, x.compareTo(y));
        y.numerator = 1;
        y.denominator = 2;
        Assert.assertEquals(0,x.compareTo(y));
        y.numerator = 1;
        y.denominator = 1;
        Assert.assertEquals(-1,x.compareTo(y));
    }

    @Test
    public void testRational1(){
        try {
            Rational x = new Rational(1,2);
            Assert.assertEquals(1,x.numerator);
            Assert.assertEquals(2,x.denominator);
        } catch (Rational.Illegal illegal) {
        }
    }

    @Test
    public void testRational2(){
        try {
            Rational y = new Rational(1,0);
            Assert.fail("Must not be constructed");
        } catch (Rational.Illegal illegal) {
            Assert.assertFalse(illegal.reason.isEmpty());
        }

    }

    @Test
    public void testToString(){
        Rational x = new Rational();
        x.numerator = 1;
        x.denominator = 2;
        Assert.assertEquals("1/2", x.toString());
    }
}
