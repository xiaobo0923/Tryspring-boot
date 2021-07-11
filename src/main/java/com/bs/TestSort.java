package com.bs;/*
package bs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

*/
/**
 * <p>
 * Project: test
 * </p>
 *
 * <p>
 * Function: [功能模块：]
 * </p>
 *
 * <p>
 * Description: [功能描述：]
 * </p>
 *
 * <p>
 * Copyright: Copyright(c) 2013-2022 税友集团
 * </p>
 *
 * <p>
 * Company: 税友软件集团有限公司
 * </p>
 *
 * @author xbo
 * @version 1.0
 * @date 2020/10/26
 *//*


public class TestSort {

    private static List<User> initList(){
        List<User> list = new ArrayList<>();
        list.add(new User("lisa",23));
        list.add(new User("tom",19));
        list.add(new User("jack",22));
        list.add(new User("lucy",24));
        list.add(new User("mack",26));
        return list;
    }


    List<User> list = initList();
    //JDK8之前的排序
        Collections.sort(list, new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            return o1.getAge().compareTo(o2.getAge());
        }
    });

    //JDK8中 lambda排序，带类型参数
    list = initList();
        list.sort((User u1,User u2)->u1.getAge().compareTo(u2.getAge()));
        list.forEach(System.out::println);
        System.out.println();

    //JDK8中 lambda排序，不带类型参数
    list = initList();
        list.sort(( u1, u2)->u1.getAge().compareTo(u2.getAge()));
        list.forEach(System.out::println);
        System.out.println();

    //JDK8 升序排序， Comparator提供的静态方法
    list = initList();
    //  Collections.sort(list,Comparator.comparing(User::getAge));
        list.sort(Comparator.comparing(User::getAge));
        list.forEach(System.out::println);
        System.out.println();

    //JDK8 降序排序， Comparator提供的静态方法
    list = initList();
    //  Collections.sort(list,Comparator.comparing(User::getAge).reversed());
        list.sort(Comparator.comparing(User::getAge).reversed());
        list.forEach(System.out::println);
        System.out.println();

    //JDK8组合排序，先按年纪排序，年纪相同按名字排序
    list = initList();
    //    Collections.sort(list,Comparator.comparing(User::getAge).thenComparing(User::getUsername));
        list.sort(Comparator.comparing(User::getAge).thenComparing(User::getUsername));
        list.forEach(System.out::println);
        System.out.println();
}
*/
