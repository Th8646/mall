package com.wpt.furns.dao;

import com.wpt.furns.entity.Member;

/**
 * @author wpt@onlying.cn
 * @date 2024/3/27 16:26
 */
public interface MemberDAO {
    //通过用户名，返回对应的mmber
    public Member queryMemberByName(String username);

    //将Member对象，保存到数据库
    public int saveMember(Member member);//1表示保存成功  -1表示失败

    //根据用户名和密码返回Member对象
    public Member queryMemberByUsernameAndPassword(String username,String password);
}
