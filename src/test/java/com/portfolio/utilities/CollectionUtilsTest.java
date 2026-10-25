package com.portfolio.utilities;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.OptionalInt;
import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilsTest {
    @Test void removesDuplicatesAndPreservesOrder() {
        assertEquals(List.of("a", "b", "c"), CollectionUtils.distinctPreservingOrder(List.of("a", "b", "a", "c", "b")));
    }
    @Test void handlesEmptyCollection() { assertEquals(List.of(), CollectionUtils.distinctPreservingOrder(List.of())); }
    @Test void rejectsNullCollection() { assertThrows(NullPointerException.class, () -> CollectionUtils.distinctPreservingOrder(null)); }
    @Test void findsSecondLargestDistinctValue() { assertEquals(OptionalInt.of(7), CollectionUtils.secondLargestDistinct(new int[]{7, 10, 10, 3, 7})); }
    @Test void returnsEmptyWhenNoSecondDistinctValueExists() { assertEquals(OptionalInt.empty(), CollectionUtils.secondLargestDistinct(new int[]{4, 4, 4})); }
    @Test void supportsNegativeValues() { assertEquals(OptionalInt.of(-5), CollectionUtils.secondLargestDistinct(new int[]{-9, -5, -2})); }
    @Test void normalizesWhitespace() { assertEquals("hello world", CollectionUtils.normalizeWhitespace("  hello\n   world  ")); }
    @Test void rejectsNullText() { assertThrows(NullPointerException.class, () -> CollectionUtils.normalizeWhitespace(null)); }
}
