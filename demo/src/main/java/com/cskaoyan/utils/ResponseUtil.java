package com.cskaoyan.utils;

import com.github.pagehelper.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 错误码：
 * - 0，成功
 * - 4xx，前端错误，说明前端开发者需要重新了解后端接口使用规范：
 *
 * - 401，参数错误，即前端没有传递后端需要的参数；
 *
 *
 *
 * @version 1.0 2019/7/4
 * @author Wei
 */
public class ResponseUtil {

    /**
     * 返回无数据的正确信息
     * @return
     */
    public static Object ok() {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", 0);
        obj.put("errmsg", "成功");
        return obj;
    }

    /**
     * 返回有数据的正确信息
     * @param data 数据
     * @return
     */
    public static Object ok(Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", 0);
        obj.put("errmsg", "成功");
        obj.put("data", data);
        return obj;
    }

    public static Object okList(List list) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("items", list);

        if (list instanceof Page) {
            Page page = (Page) list;
            data.put("total", page.getTotal());
//            data.put("page", page.getPageNum());
//            data.put("limit", page.getPageSize());
//            data.put("pages", page.getPages());
        } else {
            data.put("total", list.size());
//            data.put("page", 1);
//            data.put("limit", list.size());
//            data.put("pages", 1);
        }

        return ok(data);
    }


    public static Object fail(int errno, String errmsg) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", errno);
        obj.put("errmsg", errmsg);
        return obj;
    }

    public static Object badArgument() {
        return fail(401, "参数不对");
    }


    public static Object updatedDataFailed() {
        return null;
    }
}
