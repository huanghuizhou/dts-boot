package com.hhz.demo.util;

import com.hhz.demo.model.MongoPage;
import org.springframework.data.mongodb.core.query.Query;

/**
 * <p class="detail">
 * 功能：mongo查询工具
 * </p>
 */
public class MongoUtil {


    public static Query getPageQuery(Query query, MongoPage page) {
        if (query == null) {
            query = new Query();
        }
        if (page == null) {
            page = new MongoPage();
        }
        query.skip((page.getPageNum() - 1) * page.getPageSize());
        query.limit(page.getPageSize());
        return query;
    }


    public static String fuzzyQuery(String key) {
        return String.format(".*%s.*", key);
    }
}

