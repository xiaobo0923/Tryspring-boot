package com.bs;

import java.util.Comparator;

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
 */

public class User implements Comparator<User> {
        private String username;
        private Integer age;

        @Override
        public int compare(User o1, User o2) {
            return o1.getAge()-o2.getAge();
        }

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "age "+getAge()+"\tname "+getUsername();
        }

}
