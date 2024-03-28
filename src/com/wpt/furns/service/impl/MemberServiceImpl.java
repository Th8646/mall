package com.wpt.furns.service.impl;/**
 * @author wpt@onlying.cn
 * @date 2024/3/28 15:22
 */

import com.wpt.furns.dao.MemberDAO;
import com.wpt.furns.dao.impl.MemberDAOImpl;
import com.wpt.furns.entity.Member;
import com.wpt.furns.service.MemberService;

/**
 * @projectName: jiaju_mall
 * @package: com.wpt.furns.service.impl
 * @className: MemberServiceImpl
 * @author: wpt
 * @description: TODO
 * @date: 2024/3/28 15:22
 * @version: 1.0
 */
public class MemberServiceImpl implements MemberService {
    //定义MemberDao
    private MemberDAO memberDAO = new MemberDAOImpl();

    @Override
    public boolean registerMember(Member member) {
        return memberDAO.saveMember(member) == 1 ? true : false;
    }

    @Override
    public boolean isExistMember(String username) {
        return memberDAO.queryMemberByName(username) == null ? false : true;

    }

    @Override
    public Member login(Member member) {
        //返回对象
        return memberDAO.queryMemberByUsernameAndPassword(member.getUsername(),member.getPassword());
    }


}
