package Advanced;

import java.lang.reflect.Method;
import java.util.Arrays;

public class JavaReflection {
    public static void main(String[] args) {
        firstReflectionMethod();
        System.out.println();
        secondReflectionMethod();
        System.out.println();
        thirdReflectionMethod();
    }

    private static void thirdReflectionMethod() {
        Class student = Student.class;
        Method[] methodsName = student.getDeclaredMethods();
        String[] names = new String[methodsName.length];
        int index = 0;
        for(Method m : methodsName) {
            names[index] = m.getName();
            index++;
        }
        Arrays.sort(names);
        for (String s : names) {
            System.out.println(s);
        }
    }

    private static void secondReflectionMethod() {
        try {
            Class<?> c = Class.forName("Advanced.Student");
            Method[] methodsName = c.getDeclaredMethods();
            String[] names = new String[methodsName.length];
            int index = 0;
            for (Method m : methodsName) {
                names[index] = m.getName();
                index++;
            }
            Arrays.sort(names);
            for (String s : names) {
                System.out.println(s);
            }
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class name wasn't found");
        }
    }

    private static void firstReflectionMethod() {
        Student st = new Student();
        Method[] methodsName = st.getClass().getMethods();
        String[] names = new String[methodsName.length];
        int index = 0;
        for (Method m : methodsName) {
        names[index] = m.getName();
        index++;
        }
        Arrays.sort(names);
        for(String s : names) {
        System.out.println(s);
        }
    }
}

class Student {

    private String name;
    private String id;
    private String email;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("name: %s\n id:%s\n email:%s", name, id, email);
    }
}
