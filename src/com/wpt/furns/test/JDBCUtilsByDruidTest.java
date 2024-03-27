package com.wpt.furns.test;/**
 * @author wpt@onlying.cn
 * @date 2024/3/27 16:20
 */

import com.wpt.furns.utils.JDBCUtilsByDruid;
import org.junit.Test;

import java.sql.Connection;

/**
 * @projectName: jiaju_mall
 * @package: com.wpt.furns.test
 * @className: JDBCUtilsByDruidTest
 * @author: wpt
 * @description: TODO
 * @date: 2024/3/27 16:20
 * @version: 1.0
 */
public class JDBCUtilsByDruidTest {
    @Test
    public void getConnection() {
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println("connection = " + connection);

        JDBCUtilsByDruid.close(null,null,connection);
    }
}
