package by.clevertec;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Task17Test {
    @Test
    void testTask17ReturnsExpectedList() {
        List<String> expected = List.of("P-1", "C-2", "M-3", "C-4", "M-1", "C-3", "M-2", "P-3", "P-4", "C-1", "P-2");

        List<String> result = Main.task17();

        assertEquals(expected, result);
    }
}
