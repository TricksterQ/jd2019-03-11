package by.it.bolotko.calc;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    private static Parser parser;

    @BeforeClass
    public static void createParser(){
        parser = new Parser();
    }

    @Test
    public void simpleExpressionCalc() throws Exception {
        Var var = parser.calc("2+2*2");
        double expected = 6.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("OK");
    }
    @Test

    public void createVarCalc() throws Exception {
        parser.calc("A=2+2*2");
        Var var=Var.createVar("A");
        double expected = 6.0;
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-6);
        System.out.println("OK");
    }
}