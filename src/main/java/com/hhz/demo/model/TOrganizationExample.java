package com.hhz.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TOrganizationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOrganizationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameIsNull() {
            addCriterion("organization_name is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameIsNotNull() {
            addCriterion("organization_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameEqualTo(String value) {
            addCriterion("organization_name =", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameNotEqualTo(String value) {
            addCriterion("organization_name <>", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameGreaterThan(String value) {
            addCriterion("organization_name >", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameGreaterThanOrEqualTo(String value) {
            addCriterion("organization_name >=", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameLessThan(String value) {
            addCriterion("organization_name <", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameLessThanOrEqualTo(String value) {
            addCriterion("organization_name <=", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameLike(String value) {
            addCriterion("organization_name like", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameNotLike(String value) {
            addCriterion("organization_name not like", value, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameIn(List<String> values) {
            addCriterion("organization_name in", values, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameNotIn(List<String> values) {
            addCriterion("organization_name not in", values, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameBetween(String value1, String value2) {
            addCriterion("organization_name between", value1, value2, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationNameNotBetween(String value1, String value2) {
            addCriterion("organization_name not between", value1, value2, "organizationName");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeIsNull() {
            addCriterion("organization_type is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeIsNotNull() {
            addCriterion("organization_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeEqualTo(Byte value) {
            addCriterion("organization_type =", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeNotEqualTo(Byte value) {
            addCriterion("organization_type <>", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeGreaterThan(Byte value) {
            addCriterion("organization_type >", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("organization_type >=", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeLessThan(Byte value) {
            addCriterion("organization_type <", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeLessThanOrEqualTo(Byte value) {
            addCriterion("organization_type <=", value, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeIn(List<Byte> values) {
            addCriterion("organization_type in", values, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeNotIn(List<Byte> values) {
            addCriterion("organization_type not in", values, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeBetween(Byte value1, Byte value2) {
            addCriterion("organization_type between", value1, value2, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("organization_type not between", value1, value2, "organizationType");
            return (Criteria) this;
        }

        public Criteria andOrganizationOwnerIsNull() {
            addCriterion("organization_owner is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationOwnerIsNotNull() {
            addCriterion("organization_owner is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationOwnerEqualTo(Long value) {
            addCriterion("organization_owner =", value, "organizationOwner");
            return (Criteria) this;
        }

        public Criteria andOrganizationOwnerNotEqualTo(Long value) {
            addCriterion("organization_owner <>", value, "organizationOwner");
            return (Criteria) this;
        }

        public Criteria andOrganizationOwnerGreaterThan(Long value) {
            addCriterion("organization_owner >", value, "organizationOwner");
            return (Criteria) this;
        }

        public Criteria andOrganizationOwnerGreaterThanOrEqualTo(Long value) {
            addCriterion("organization_owner >=", value, "organizationOwner");
            return (Criteria) this;
        }

        public Criteria andOrganizationOwnerLessThan(Long value) {
            addCriterion("organization_owner <", value, "organizationOwner");
            return (Criteria) this;
        }

        public Criteria andOrganizationOwnerLessThanOrEqualTo(Long value) {
            addCriterion("organization_owner <=", value, "organizationOwner");
            return (Criteria) this;
        }

        public Criteria andOrganizationOwnerIn(List<Long> values) {
            addCriterion("organization_owner in", values, "organizationOwner");
            return (Criteria) this;
        }

        public Criteria andOrganizationOwnerNotIn(List<Long> values) {
            addCriterion("organization_owner not in", values, "organizationOwner");
            return (Criteria) this;
        }

        public Criteria andOrganizationOwnerBetween(Long value1, Long value2) {
            addCriterion("organization_owner between", value1, value2, "organizationOwner");
            return (Criteria) this;
        }

        public Criteria andOrganizationOwnerNotBetween(Long value1, Long value2) {
            addCriterion("organization_owner not between", value1, value2, "organizationOwner");
            return (Criteria) this;
        }

        public Criteria andOrganizationPhotoIsNull() {
            addCriterion("organization_photo is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationPhotoIsNotNull() {
            addCriterion("organization_photo is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationPhotoEqualTo(String value) {
            addCriterion("organization_photo =", value, "organizationPhoto");
            return (Criteria) this;
        }

        public Criteria andOrganizationPhotoNotEqualTo(String value) {
            addCriterion("organization_photo <>", value, "organizationPhoto");
            return (Criteria) this;
        }

        public Criteria andOrganizationPhotoGreaterThan(String value) {
            addCriterion("organization_photo >", value, "organizationPhoto");
            return (Criteria) this;
        }

        public Criteria andOrganizationPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("organization_photo >=", value, "organizationPhoto");
            return (Criteria) this;
        }

        public Criteria andOrganizationPhotoLessThan(String value) {
            addCriterion("organization_photo <", value, "organizationPhoto");
            return (Criteria) this;
        }

        public Criteria andOrganizationPhotoLessThanOrEqualTo(String value) {
            addCriterion("organization_photo <=", value, "organizationPhoto");
            return (Criteria) this;
        }

        public Criteria andOrganizationPhotoLike(String value) {
            addCriterion("organization_photo like", value, "organizationPhoto");
            return (Criteria) this;
        }

        public Criteria andOrganizationPhotoNotLike(String value) {
            addCriterion("organization_photo not like", value, "organizationPhoto");
            return (Criteria) this;
        }

        public Criteria andOrganizationPhotoIn(List<String> values) {
            addCriterion("organization_photo in", values, "organizationPhoto");
            return (Criteria) this;
        }

        public Criteria andOrganizationPhotoNotIn(List<String> values) {
            addCriterion("organization_photo not in", values, "organizationPhoto");
            return (Criteria) this;
        }

        public Criteria andOrganizationPhotoBetween(String value1, String value2) {
            addCriterion("organization_photo between", value1, value2, "organizationPhoto");
            return (Criteria) this;
        }

        public Criteria andOrganizationPhotoNotBetween(String value1, String value2) {
            addCriterion("organization_photo not between", value1, value2, "organizationPhoto");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }
    }
}