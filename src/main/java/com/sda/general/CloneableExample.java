package com.sda.general;

import java.util.HashMap;

public class CloneableExample {

    public static class Entry implements Cloneable {
        public int mAge;
        public String mAddress;

        public Entry(String address, int age) {
            mAddress = address;
            mAge = age;
        }

        /**
         * This method overrides clone() from Object class.
         * If one calls clone() without implementing it, default
         * implementation from Object will be called and
         * CloneNotSupportedException will be thrown.
         *
         * @return new instance of class Entry containg the same values as
         *          reference object.
         */
        public Entry clone() {
            // If it is required clone each cloneable component of class Entry
            // instead of passing the reference.
            return new Entry(mAddress, mAge);
        }

        public String toString() {
            return "Adres: " + mAddress + ", wiek: " + mAge;
        }
    }

    public static void hashMapWithCloneableExample() {
        HashMap<String, Entry> map = new HashMap<>();
        map.put("jasiu", new Entry("Szczecin", 20));
        map.put("kasia", new Entry("Warszawa", 25));
        map.put("romek", new Entry("Berlin", 28));

        String key = "jasiu";

        Entry test = map.get(key).clone();
        test.mAge = 99;
        System.out.println(key + ":\n\t" + map.get(key).toString());
        Entry test2 = map.get(key);
        test2.mAge = 99;
        System.out.println(key + ":\n\t" + map.get(key).toString());

        if (map.containsKey(key)) {
            System.out.println(key + " istnieje w mapie");
        }
    }
}
