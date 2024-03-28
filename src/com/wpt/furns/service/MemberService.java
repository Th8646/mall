package com.wpt.furns.service;

import com.wpt.furns.entity.Member;

/**
 * @author wpt@onlying.cn
 * @date 2024/3/28 15:19
 */
public interface MemberService {
    //注册用户
    public boolean registerMember(Member member);
    //判断用户是否存在
    public boolean isExistMember(String username);
    //根据传入的Member信息，返回数据库中对应的Member对象
    public Member login(Member member);

}
