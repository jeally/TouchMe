package com.touchme.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Shorty {
	public static boolean isVoid(String string) {
		return string == null || string.length() == 0;
	}

	public static boolean isVoid(Integer integer) {
		return integer == null || integer == 0;
	}

	public static <T extends Collection<?>> boolean isVoid(T collection) {
		return collection == null || collection.size() == 0;
	}

	public static String avoidNull(String s) {
		return isVoid(s) ? "" : s;
	}

	public static <T extends Collection<?>> T avoidNull(T collection,
			T emptyCollections) {
		return isVoid(collection) ? emptyCollections : collection;
	}

	public static <E> Set<E> oneElementSet(E element) {
		final Set<E> result = new HashSet<E>();
		result.add(element);
		return result;
	}

	@SuppressWarnings({ "unchecked" })
	public static <T> T[] concat(T[]... arrays) {
		int resultLength = 0;
		for (T[] array : arrays) {
			resultLength += array.length;
		}

		T[] result = (T[]) new Object[resultLength];

		int pos = 0;
		for (T[] array : arrays) {
			System.arraycopy(array, 0, result, pos, array.length);
			pos += array.length;
		}

		return result;
	}

	public static <T> T[] concatWith(T[] arrays, T... elements) {
		return concat(arrays, elements);
	}
}
