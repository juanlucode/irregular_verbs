package io.github.juanlucode.commons;

import java.util.Random;

public class ArrayTools {
	public static <T> T[] shuffleArray(T[] array)
	{
	    int index;
	    T temp;
	    Random random = new Random();
	    for (int i = array.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = array[index];
	        array[index] = array[i];
	        array[i] = temp;
	    }
	    
	    return array;
	}
}
