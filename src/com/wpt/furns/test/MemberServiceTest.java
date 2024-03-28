package com.wpt.furns.test;/**
 * @author wpt@onlying.cn
 * @date 2024/3/28 15:32
 */

import com.wpt.furns.entity.Member;
import com.wpt.furns.service.MemberService;
import com.wpt.furns.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * @projectName: jiaju_mall
 * @package: com.wpt.furns.test
 * @className: MemberServiceTest
 * @author: wpt
 * @description: TODO
 * @date: 2024/3/28 15:32
 * @version: 1.0
 */
public class MemberServiceTest {
    private MemberService memberService = new MemberServiceImpl();
    @Test
    public void isExistUsername(){
        if (memberService.isExistMember("admi2n")){
            System.out.println("用户名存在");
        }else {
            System.out.println("用户名不存在");
        }
    }

    @Test
    public void registerMember(){
        Member member = new Member(null, "tom", "tom", "tom@sohu.com");
        if(memberService.registerMember(member)){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }
    }
}
