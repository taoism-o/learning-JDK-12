package xin.kevincheng.java.lang.reflect;

import xin.kevincheng.java.consts.ArrayLearningClassConsts;
import xin.kevincheng.java.enums.ArrayLearningClassEnum;
import xin.kevincheng.java.pojo.Person;

import java.lang.reflect.Array;

/**
 * @author kc
 * @title
 * @description The class ArrayLearningClass is for learning Array
 * @date Create in 16:47 2019/11/20
 */
public class ArrayLearningClass {

    // array using to test different types of arrays
    static Object array;

    /**
     * @Author k5068
     * @Date 2019/11/20 17:49
     * @Description get an array that is primitive types from Array class.
     * @Param []
     * @Return java.lang.Object
     * @Since
     */
    static Object getNormalPrimitiveTypeArray() {
        array = Array.newInstance(String.class, 10);
        return array;
    }

    /**
     * @Author k5068
     * @Date 2019/11/20 17:50
     * @Description get an array that is self-defined types from Array class.
     * @Param []
     * @Return java.lang.Object
     * @Since
     */
    static Object getNormalDefinedTypeArray() {
        array = Array.newInstance(Person.class, 10);
        return array;
    }

    /**
     * @Author k5068
     * @Date 2019/11/20 17:50
     * @Description test getClassLoader() from primitiveTypeArray
     * @Param []
     * @Return void
     * @Since
     */
    static void testGetClassLoaderNormalPrimitiveTypeArray() {
        getNormalPrimitiveTypeArray();
        System.out.println(array.getClass().equals(String[].class));

        if (array.getClass().equals(String[].class)) {
            String[] strings = (String[]) array;
            StringBuilder sb;
            for (int i = 0; i < strings.length; i++) {
                sb = new StringBuilder("strings").append(i);
                strings[i] = sb.toString();
            }

            for (String s: strings) {
                System.out.println(s);
            }
        }

        for (int i = 0; i < Array.getLength(array); i++) {
            System.out.println(Array.get(array, i).getClass());
            System.out.println(Array.get(array, i).getClass().getClassLoader());
        }
    }

    /**
     * @Author k5068
     * @Date 2019/11/20 17:52
     * @Description test getClassLoader() from self-defined types of arrays
     * @Param []
     * @Return void
     * @Since
     */
    static void testGetClassLoaderNormalDefinedTypeArray() {
        getNormalDefinedTypeArray();
        System.out.println(array.getClass().equals(Person[].class));

        if (array.getClass().equals(Person[].class)) {
            Person[] persons = (Person[]) array;
            StringBuilder sb;
            for (int i = 0; i < persons.length; i++) {
                sb = new StringBuilder("name").append(i);
                Person p = new Person();
                p.setName(sb.toString());
                persons[i] = p;
            }

            for (Person p: persons) {
                System.out.println(p.getName());
            }
        }

        for (int i = 0; i < Array.getLength(array); i++) {
            System.out.println(Array.get(array, i).getClass());
            System.out.println(Array.get(array, i).getClass().getClassLoader());
        }
    }

    /**
     * @Author k5068
     * @Date 2019/11/20 23:45
     * @Description using enum parameter to judge which method to use for testing
     * @Param [arrayLearningClassEnum]
     * @Return void
     * @Since
     */
    static void test(ArrayLearningClassEnum arrayLearningClassEnum) {
        if (arrayLearningClassEnum.getType().equals(ArrayLearningClassConsts.NORMAL_PRIMITIVE_TYPE)) {
            testGetClassLoaderNormalPrimitiveTypeArray();
        }
        if (arrayLearningClassEnum.getType().equals(ArrayLearningClassConsts.NORMAL_DEFINED_TYPE)) {
            testGetClassLoaderNormalDefinedTypeArray();
        }
    }

    public static void main(String[] args) {
        test(ArrayLearningClassEnum.NORMAL_PRIMITIVE_TYPE);
    }
}
