package com.hhz.demo.service;

import com.hhz.demo.model.MongoPage;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


/**
 * <p class="detail">
 * 功能:
 * </p>
 *
 * @author huangHuizhou
 * @ClassName Mongo db service.
 * @Version V1.0.
 * @date 2019.06.04 13:41:14
 */
public interface MongoDBService {
    /**
     * <p class="detail">
     * 功能：创建对象
     * </p>
     *
     * @param collectionName :
     * @author huanghuizhou
     * @date 2019.06.04 13:41:14
     */
    public void createCollection(String collectionName);

    /**
     * <p class="detail">
     * 功能：查询
     * </p>
     *
     * @param <T>            the type parameter
     * @param id             :
     * @param entityClass    :
     * @param collectionName :
     * @return object
     * @author huanghuizhou
     * @date 2019.06.04 13:41:14
     */
    public <T> Object findById(Object id, Class<T> entityClass, String collectionName);

    /**
     * <p class="detail">
     * 功能：根据mongoDB _id 更新数据
     * </p>
     *
     * @param <T>            the type parameter
     * @param id             :
     * @param entityClass    :
     * @param collectionName :
     * @param object         :
     * @return object
     * @author huanghuizhou
     * @date 2019.06.04 13:41:15
     */
    public <T> Object updateById(Object id, Class<T> entityClass, String collectionName, Object object);


    /**
     * <p class="detail">
     * 功能：删除
     * </p>
     *
     * @param query          :
     * @param collectionName :
     * @author huanghuizhou
     * @date 2019.06.04 13:41:15
     */
    public void remove(Query query, String collectionName);

    /**
     * <p class="detail">
     * 功能：删除
     * </p>
     *
     * @param object         :
     * @param collectionName :
     * @author huanghuizhou
     * @date 2019.06.04 13:41:15
     */
    public void remove(Object object, String collectionName);

    /**
     * <p class="detail">
     * 功能：添加
     * </p>
     *
     * @param objectToSave   :
     * @param collectionName :
     * @author huanghuizhou
     * @date 2019.06.04 13:41:15
     */
    public void insert(Object objectToSave, String collectionName);

    /**
     * <p class="detail">
     * 功能：是否存在对象
     * </p>
     *
     * @param collectionName :
     * @return boolean
     * @author huanghuizhou
     * @date 2019.06.04 13:41:15
     */
    public boolean collectionExists(String collectionName);

    /**
     * <p class="detail">
     * 功能：根据条件进行查询
     * </p>
     *
     * @param <T>            the type parameter
     * @param query          :
     * @param entityClass    :
     * @param collectionName :
     * @return
     * @author huanghuizhou
     * @date 2019.06.04 13:41:15
     */
    public <T> List<T> findByCondition(Query query, Class<T> entityClass, String collectionName);

    /**
     * <p class="detail">
     * 功能: 根据Query分页查询
     * </p>
     *
     * @param <T>        the type parameter
     * @param query      :
     * @param page       :
     * @param clazz      :
     * @param collection :
     * @return mongo page
     * @author huanghuizhou
     * @date 2019.06.04 13:41:15
     */
    <T> MongoPage<T> findPage(Query query, MongoPage<T> page, Class<T> clazz, String collection);


}
