package com.pros;

import java.util.ArrayList;
import java.util.List;

public class ImmutableDemo {

    public static void main(String[] args) {
        ImmutablePerson ip = new ImmutablePerson("Divija", List.of("Reading", "Cricket", "foodt Ball", "Cooking"));
        System.out.println(ip.getHobbies());
        try {
            ImmutablePerson.class.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

final class ImmutablePerson {
    private final String name;
    private final List<String> hobbies;

    public ImmutablePerson(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = new ArrayList<>(hobbies);
    }

    public String getName() {
        return name;
    }

    public List<String> getHobbies() {
        return new ArrayList<>(hobbies);
    }
}
