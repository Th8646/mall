package com.wpt.furns.dao.impl;/**
 * @author wpt@onlying.cn
 * @date 2024/3/27 16:29
 */

import com.wpt.furns.dao.BasicDAO;
import com.wpt.furns.dao.MemberDAO;
import com.wpt.furns.entity.Member;

import java.sql.SQLException;

/**
 * @projectName: jiaju_mall
 * @package: com.wpt.furns.dao.impl
 * @className: MemberDAOImpl
 * @author: wpt
 * @description: TODO
 * @date: 2024/3/27 16:29
 * @version: 1.0
 */
public class MemberDAOImpl extends BasicDAO<Member> implements MemberDAO {

    @Override
    public Member queryMemberByName(String username) {
        // 在navicat测试通过
        String sql = "SELECT `id`,username,`password`,email FROM member WHERE username =?";

        return (Member) querySingle(sql, Member.class, username);
    }

    @Override
    public int saveMember(Member member) {
        String sql = "INSERT INTO `member`(`username`,`password`,`email`) VALUES(?,MD5(?), ?)";
//        System.out.println(member.getUsername());
//        System.out.println(member.getPassword());
//        System.out.println(member.getEmail());
        return update(sql, member.getUsername(),
                member.getPassword(), member.getEmail());
    }

    @Override
    public Member queryMemberByUsernameAndPassword(String username, String password) {
        String sql = "SELECT `id`,username,`password`,email FROM member " +
                "WHERE username =? and `password`=MD5(?)";
        return querySingle(sql, Member.class, username, password);
    }


}
