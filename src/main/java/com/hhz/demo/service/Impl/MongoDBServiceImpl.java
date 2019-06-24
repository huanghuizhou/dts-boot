package com.hhz.demo.service.Impl;

import com.hhz.demo.model.MongoPage;
import com.hhz.demo.service.MongoDBService;
import com.hhz.demo.util.MongoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class MongoDBServiceImpl implements MongoDBService {
    private static final Logger logger = LoggerFactory.getLogger(MongoDBServiceImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * <p class="detail">
     * 功能：查询
     * </p>
     *
     * @author <a href="mailto:renl@financegt.com">renling</a>
     * @date 2014-10-27
     */
    @Override
    public <T> Object findById(Object id, Class<T> entityClass, String collectionName) {
        return mongoTemplate.findById(id, entityClass, collectionName);
    }

    /**
     * <p class="detail">
     * 功能：根据mongoDB _id 更新数据
     * </p>
     *
     * @author wuhongyong
     * @date 2016-11-2
     */
    @Override
    public <T> Object updateById(Object id, Class<T> entityClass, String collectionName, Object object) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            // 获取属性的名字
            String name = field.getName();
            // 将属性的首字符大写，方便构造get，set方法
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            // 获取属性的类型
            String type = field.getGenericType().toString();
            Method m = null;
            Object value = null;
            try {
                m = object.getClass().getMethod("get" + name);
                // 调用getter方法获取属性值
                value = m.invoke(object);
            } catch (NoSuchMethodException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
            if (value != null && !value.equals("")) {
                update.set(field.getName().trim(), value);
            }
        }
        return mongoTemplate.updateFirst(query, update, entityClass, collectionName);
    }

    /**
     * <p class="detail">
     * 功能：删除
     * </p>
     *
     * @author <a href="mailto:renl@financegt.com">renling</a>
     * @date 2014-10-27
     */
    @Override
    public void remove(Query query, String collectionName) {
        mongoTemplate.remove(query, collectionName);
    }


    @Override
    public void insert(Object objectToSave, String collectionName) {
        mongoTemplate.insert(objectToSave, collectionName);
    }

    @Override
    public boolean collectionExists(String collectionName) {
        return mongoTemplate.collectionExists(collectionName);
    }

    @Override
    public void createCollection(String collectionName) {
        mongoTemplate.createCollection(collectionName);

    }

    @Override
    public <T> List<T> findByCondition(Query query, Class<T> entityClass, String collectionName) {
        return mongoTemplate.find(query, entityClass, collectionName);
    }

    @Override
    public <T> MongoPage<T> findPage(Query query, MongoPage<T> page, Class<T> clazz, String collection) {
        page.setTotal(mongoTemplate.count(query, clazz, collection));
        query = MongoUtil.getPageQuery(query, page);
        page.setList(mongoTemplate.find(query, clazz, collection));
        return page;
    }


    @Override
    public void remove(Object object, String collectionName) {
        mongoTemplate.remove(object, collectionName);
    }
}
