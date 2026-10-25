package com.portfolio.utilities;

import java.util.*;

/** Small reusable utilities for working with collections and text. */
public final class CollectionUtils {
    private CollectionUtils() {}

    public static <T> List<T> distinctPreservingOrder(Collection<T> values) {
        Objects.requireNonNull(values, "values must not be null");
        return new ArrayList<>(new LinkedHashSet<>(values));
    }

    public static OptionalInt secondLargestDistinct(int[] values) {
        Objects.requireNonNull(values, "values must not be null");
        Integer largest = null, second = null;
        for (int value : values) {
            if (largest == null || value > largest) {
                if (largest != null && value != largest) second = largest;
                largest = value;
            } else if (value != largest && (second == null || value > second)) {
                second = value;
            }
        }
        return second == null ? OptionalInt.empty() : OptionalInt.of(second);
    }

    public static String normalizeWhitespace(String input) {
        Objects.requireNonNull(input, "input must not be null");
        return input.trim().replaceAll("\\s+", " ");
    }
}
