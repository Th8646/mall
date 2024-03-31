package com.wpt.furns.entity;/**
 * @author wpt@onlying.cn
 * @date 2024/3/27 16:01
 */

/**
 * @projectName: jiaju_mall
 * @package: com.wpt.furns.entity
 * @className: Member
 * @author: wpt
 * @description: TODO
 * @date: 2024/3/27 16:01
 * @version: 1.0
 */
public class Member {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String role;


    public Member() {//用于反射创建对象
    }

    public Member(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
