package core.basesyntax.service.operationimpl;

import core.basesyntax.bd.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.ParseLine;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import service.OperationService;
import service.operationimpl.MinusOperation;

public class MinusOperationTest {
    private static OperationService operationService;
    private ParseLine parseLine;
    private Fruit actual;
    private Fruit expected;

    @BeforeClass
    public static void init() {
        operationService = new MinusOperation();
    }

    @Test
    public void minus_option_ok() {
        Storage.storage.add(new Fruit("banana", 50));
        parseLine = new ParseLine("p", "banana", 25);
        operationService.operation(parseLine);
        actual = new Fruit("banana", 25);
        expected = Storage.storage.get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minus_option_storage_fruit_quantity_less() {
        Storage.storage.add(new Fruit("banana", 20));
        parseLine = new ParseLine("p", "banana", 25);
        try {
            operationService.operation(parseLine);
        } catch (RuntimeException e) {
            Assert.assertEquals("You cannot sell that many banana", e.getMessage());
        }
    }

    @AfterClass
    public static void storage_clear() {
        Storage.storage.clear();
    }
}
