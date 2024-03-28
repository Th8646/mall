package com.wpt.furns.test;
/**
 * @author wpt@onlying.cn
 * @date 2024/3/27 16:41
 */

import com.wpt.furns.dao.MemberDAO;
import com.wpt.furns.dao.impl.MemberDAOImpl;
import com.wpt.furns.entity.Member;

import org.junit.jupiter.api.Test;

/**
 * @projectName: jiaju_mall
 * @package: com.wpt.furns.test
 * @className: MemberDAOTest
 * @author: wpt
 * @description: TODO
 * @date: 2024/3/27 16:41
 * @version: 1.0
 */
public class MemberDAOTest {

    private MemberDAOImpl memberDAO = new MemberDAOImpl();


    @Test
    public void queryMemberByName() {
        if (memberDAO.queryMemberByName("admin1") == null) {
            System.out.println("用戶不存在");
        } else {
            System.out.println("用戶名存在");
        }
    }

    @Test
    public void saveMember() {
        Member member = new Member(null, "king5", "king", "king@sohu.com");
        if (memberDAO.saveMember(member) == 1) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失敗");
        }
    }

    @Test
    public void  queryMemberByUsernameAndPassword(){
        Member member = memberDAO.queryMemberByUsernameAndPassword("admin", "admin");
        System.out.println(member);
    }
}
