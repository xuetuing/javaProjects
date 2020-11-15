package com.company.jdk8chacracter.stream;

import java.rmi.MarshalledObject;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7,6,9,3,8,2,1);

        // filter,find,forEach,match
        list.stream().filter(x -> x > 6).forEach(System.out::println);

        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();

        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();

        boolean anyMathch = list.stream().anyMatch(x -> x > 9);

//        System.out.println("匹配的第一个值：" + findFirst.get());
//        System.out.println("匹配任意一个值：" + findAny.get());
//        System.out.println("是否存在大于6的值：" + anyMathch);

        //过滤对象
        List<Person> personList = new ArrayList<Person>();

        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        List<String> filterList = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName)
                .collect(Collectors.toList());

//        System.out.println("高于8000的员工姓名：" + filterList);

        //max, min, count
        List<String> list1 = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");

        Optional<String> max = list1.stream().max(Comparator.comparing(String::length));
//        System.out.println("最长字符串：" + max.get());

        Optional<Integer> max2 = list.stream().max(Integer::compareTo);
        Optional<Integer> max3 = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        Optional<Person> max4 = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        long count = list.stream().filter(x -> x > 6).count();
//        System.out.println("自然排序最大值：" + max2.get());
//        System.out.println("自定义排序最大值：" + max3.get());
//        System.out.println("员工工资最高者：" + max4.get().getName() + " " + max4.get().getSalary() + "元");
//        System.out.println("list中大于6元素个数：" + count);

        //map,flatMap
        String[] strArr = {"abcd", "bcdd", "defde", "fTr"};
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        List<Integer> intListNew = list.stream().map(x -> x + 3).collect(Collectors.toList());
//        System.out.println("每个元素大写：" + strList);
//        System.out.println("每个元素+3：" + intListNew);
        List<String> list2 = Arrays.asList("m,k,l,a,", "1,3,5,7");
        List<String> list2New = list2.stream().flatMap(s -> {
            String [] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());

//        System.out.println("处理前的集合：" + list2);
//        System.out.println("处理后的集合：" + list2New);

        // reduce, Integer集合元素之和，乘积和最大值
//        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
//        Optional<Integer> sum = list.stream().reduce(Integer::sum);
//        Integer sum = list.stream().reduce(0, Integer::sum);

        // collect，依赖Collectors类内置的静态方法
        /**
         * toList/toSet/toMap
         * count/averaging
         * 分组partitioningBy/groupingBy
         * joining
         * reducing
         */
        Map<?, Person> map = personList.stream().filter(p -> p.getSalary() > 8000)
                .collect(Collectors.toMap(Person::getName, p -> p));
//        System.out.println("toMap:" + map);

        Long count1 = personList.stream().collect(Collectors.counting());
        Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        Optional<Integer> max1 = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        Integer sum = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));
//        System.out.println("员工工资所有统计:" + collect);

        //分区和分组
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000 ));
        Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        Map<String, Map<String, List<Person>>> group2 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));

//        System.out.println("员工按工资分区:" + part);
//        System.out.println("员工按性别分组:" + group);
//        System.out.println("员工按性别，地区分组:" + group2);

        List<String> striList = Arrays.asList(strArr);
        String str = striList.stream().collect(Collectors.joining(","));
        System.out.println("拼接后的字符串：" + str);

        //distinct,skip, limit










    }

}

class Person{

    private String name;

    private int salary;

    private int age;

    private String sex;

    private String area;

    public Person(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getArea() {
        return area;
    }
}





