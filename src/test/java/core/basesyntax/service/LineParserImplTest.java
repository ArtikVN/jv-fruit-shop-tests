package core.basesyntax.service;

import core.basesyntax.model.ParseLine;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import service.LineParser;

public class LineParserImplTest {
    private static List<String> input;
    private static LineParser parser;
    private static List<ParseLine> expected;
    private List<ParseLine> actual;

    @BeforeClass
    public static void init() {
        input = new ArrayList<>();
        expected = new ArrayList<>();
        parser = new LineParserImpl();
    }

    @Test
    public void parser_ok() {

        input.add("type,fruit,quantity");
        input.add("b,banana,20");
        input.add("b,apple,100");

        expected.add(new ParseLine("b", "banana", 20));
        expected.add(new ParseLine("b", "apple", 100));

        actual = parser.lineParcer(input);
        Assert.assertEquals(expected, actual);
    }
}
