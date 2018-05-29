package volkov.GSONTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Александр on 24.05.2018.
 */
public class Test {

    private static  final Gson  gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        Person person = new Person("Коля", 30, Arrays.asList("Москва", "Берлин", "Дубай"));

        String json = gson.toJson(person);
        System.out.println(json);

        Person person1 = gson.fromJson(json, Person.class);
        System.out.println(person1.getName() +" "+ person1.getAge() + " " +person1.getGeoHistory());
    }
}


class Person{
    private String name;
    private Integer age;
    @SerializedName ("geo")
    private List<String> geoHistory = new ArrayList<>();

    public Person(String name, Integer age, List<String> geoHistory) {
        this.name = name;
        this.age = age;
        this.geoHistory = geoHistory;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public List<String> getGeoHistory() {
        return geoHistory;
    }
}
























