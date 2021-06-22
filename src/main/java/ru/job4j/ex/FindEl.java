package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
            /* цикл fori, поскольку нам надо найти индекс искомого элемента в массиве */
            for (int index = 0; index < value.length; index++) {
                if (value.equals(key)) {
                    rsl = index;
                    break;
                }
            }
            if (rsl == -1) {
                throw new ElementNotFoundException("Element not found");
            }
        return rsl;
    }
}