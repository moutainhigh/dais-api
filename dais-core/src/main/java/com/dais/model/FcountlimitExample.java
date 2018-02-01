package com.dais.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FcountlimitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FcountlimitExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
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

        public Criteria andFidIsNull() {
            addCriterion("fId is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("fId is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("fId =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("fId <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("fId >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fId >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("fId <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("fId <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("fId in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("fId not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("fId between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("fId not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFipIsNull() {
            addCriterion("fIp is null");
            return (Criteria) this;
        }

        public Criteria andFipIsNotNull() {
            addCriterion("fIp is not null");
            return (Criteria) this;
        }

        public Criteria andFipEqualTo(String value) {
            addCriterion("fIp =", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipNotEqualTo(String value) {
            addCriterion("fIp <>", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipGreaterThan(String value) {
            addCriterion("fIp >", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipGreaterThanOrEqualTo(String value) {
            addCriterion("fIp >=", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipLessThan(String value) {
            addCriterion("fIp <", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipLessThanOrEqualTo(String value) {
            addCriterion("fIp <=", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipLike(String value) {
            addCriterion("fIp like", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipNotLike(String value) {
            addCriterion("fIp not like", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipIn(List<String> values) {
            addCriterion("fIp in", values, "fip");
            return (Criteria) this;
        }

        public Criteria andFipNotIn(List<String> values) {
            addCriterion("fIp not in", values, "fip");
            return (Criteria) this;
        }

        public Criteria andFipBetween(String value1, String value2) {
            addCriterion("fIp between", value1, value2, "fip");
            return (Criteria) this;
        }

        public Criteria andFipNotBetween(String value1, String value2) {
            addCriterion("fIp not between", value1, value2, "fip");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeIsNull() {
            addCriterion("fCreateTime is null");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeIsNotNull() {
            addCriterion("fCreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeEqualTo(Date value) {
            addCriterion("fCreateTime =", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeNotEqualTo(Date value) {
            addCriterion("fCreateTime <>", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeGreaterThan(Date value) {
            addCriterion("fCreateTime >", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fCreateTime >=", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeLessThan(Date value) {
            addCriterion("fCreateTime <", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("fCreateTime <=", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeIn(List<Date> values) {
            addCriterion("fCreateTime in", values, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeNotIn(List<Date> values) {
            addCriterion("fCreateTime not in", values, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeBetween(Date value1, Date value2) {
            addCriterion("fCreateTime between", value1, value2, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("fCreateTime not between", value1, value2, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcountIsNull() {
            addCriterion("fCount is null");
            return (Criteria) this;
        }

        public Criteria andFcountIsNotNull() {
            addCriterion("fCount is not null");
            return (Criteria) this;
        }

        public Criteria andFcountEqualTo(Integer value) {
            addCriterion("fCount =", value, "fcount");
            return (Criteria) this;
        }

        public Criteria andFcountNotEqualTo(Integer value) {
            addCriterion("fCount <>", value, "fcount");
            return (Criteria) this;
        }

        public Criteria andFcountGreaterThan(Integer value) {
            addCriterion("fCount >", value, "fcount");
            return (Criteria) this;
        }

        public Criteria andFcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("fCount >=", value, "fcount");
            return (Criteria) this;
        }

        public Criteria andFcountLessThan(Integer value) {
            addCriterion("fCount <", value, "fcount");
            return (Criteria) this;
        }

        public Criteria andFcountLessThanOrEqualTo(Integer value) {
            addCriterion("fCount <=", value, "fcount");
            return (Criteria) this;
        }

        public Criteria andFcountIn(List<Integer> values) {
            addCriterion("fCount in", values, "fcount");
            return (Criteria) this;
        }

        public Criteria andFcountNotIn(List<Integer> values) {
            addCriterion("fCount not in", values, "fcount");
            return (Criteria) this;
        }

        public Criteria andFcountBetween(Integer value1, Integer value2) {
            addCriterion("fCount between", value1, value2, "fcount");
            return (Criteria) this;
        }

        public Criteria andFcountNotBetween(Integer value1, Integer value2) {
            addCriterion("fCount not between", value1, value2, "fcount");
            return (Criteria) this;
        }

        public Criteria andFtypeIsNull() {
            addCriterion("fType is null");
            return (Criteria) this;
        }

        public Criteria andFtypeIsNotNull() {
            addCriterion("fType is not null");
            return (Criteria) this;
        }

        public Criteria andFtypeEqualTo(Integer value) {
            addCriterion("fType =", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotEqualTo(Integer value) {
            addCriterion("fType <>", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeGreaterThan(Integer value) {
            addCriterion("fType >", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fType >=", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLessThan(Integer value) {
            addCriterion("fType <", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLessThanOrEqualTo(Integer value) {
            addCriterion("fType <=", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeIn(List<Integer> values) {
            addCriterion("fType in", values, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotIn(List<Integer> values) {
            addCriterion("fType not in", values, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeBetween(Integer value1, Integer value2) {
            addCriterion("fType between", value1, value2, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("fType not between", value1, value2, "ftype");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
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
    }
}