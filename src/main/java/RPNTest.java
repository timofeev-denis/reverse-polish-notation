import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Author: timofeevdv
 * Date: 06.02.2017
 */
public class RPNTest {
    @Test
    public void testSimpleOperation() {
        assertEquals("12+", RPN.make("1+2"));
    }

    @Test
    public void testTwoOperations() {
        assertEquals("12+3+", RPN.make("1+2+3"));
    }

    @Test
    public void testOperationPriority() {
        assertEquals("234*+", RPN.make("2+3*4"));
    }

    @Test
    public void testBrackets() {
        assertEquals("23+4*", RPN.make("(2+3)*4"));
    }
}
