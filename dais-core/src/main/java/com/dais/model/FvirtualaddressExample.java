package com.dais.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FvirtualaddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FvirtualaddressExample() {
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

        public Criteria andFviFidIsNull() {
            addCriterion("fVi_fId is null");
            return (Criteria) this;
        }

        public Criteria andFviFidIsNotNull() {
            addCriterion("fVi_fId is not null");
            return (Criteria) this;
        }

        public Criteria andFviFidEqualTo(Integer value) {
            addCriterion("fVi_fId =", value, "fviFid");
            return (Criteria) this;
        }

        public Criteria andFviFidNotEqualTo(Integer value) {
            addCriterion("fVi_fId <>", value, "fviFid");
            return (Criteria) this;
        }

        public Criteria andFviFidGreaterThan(Integer value) {
            addCriterion("fVi_fId >", value, "fviFid");
            return (Criteria) this;
        }

        public Criteria andFviFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fVi_fId >=", value, "fviFid");
            return (Criteria) this;
        }

        public Criteria andFviFidLessThan(Integer value) {
            addCriterion("fVi_fId <", value, "fviFid");
            return (Criteria) this;
        }

        public Criteria andFviFidLessThanOrEqualTo(Integer value) {
            addCriterion("fVi_fId <=", value, "fviFid");
            return (Criteria) this;
        }

        public Criteria andFviFidIn(List<Integer> values) {
            addCriterion("fVi_fId in", values, "fviFid");
            return (Criteria) this;
        }

        public Criteria andFviFidNotIn(List<Integer> values) {
            addCriterion("fVi_fId not in", values, "fviFid");
            return (Criteria) this;
        }

        public Criteria andFviFidBetween(Integer value1, Integer value2) {
            addCriterion("fVi_fId between", value1, value2, "fviFid");
            return (Criteria) this;
        }

        public Criteria andFviFidNotBetween(Integer value1, Integer value2) {
            addCriterion("fVi_fId not between", value1, value2, "fviFid");
            return (Criteria) this;
        }

        public Criteria andFadderessIsNull() {
            addCriterion("fAdderess is null");
            return (Criteria) this;
        }

        public Criteria andFadderessIsNotNull() {
            addCriterion("fAdderess is not null");
            return (Criteria) this;
        }

        public Criteria andFadderessEqualTo(String value) {
            addCriterion("fAdderess =", value, "fadderess");
            return (Criteria) this;
        }

        public Criteria andFadderessNotEqualTo(String value) {
            addCriterion("fAdderess <>", value, "fadderess");
            return (Criteria) this;
        }

        public Criteria andFadderessGreaterThan(String value) {
            addCriterion("fAdderess >", value, "fadderess");
            return (Criteria) this;
        }

        public Criteria andFadderessGreaterThanOrEqualTo(String value) {
            addCriterion("fAdderess >=", value, "fadderess");
            return (Criteria) this;
        }

        public Criteria andFadderessLessThan(String value) {
            addCriterion("fAdderess <", value, "fadderess");
            return (Criteria) this;
        }

        public Criteria andFadderessLessThanOrEqualTo(String value) {
            addCriterion("fAdderess <=", value, "fadderess");
            return (Criteria) this;
        }

        public Criteria andFadderessLike(String value) {
            addCriterion("fAdderess like", value, "fadderess");
            return (Criteria) this;
        }

        public Criteria andFadderessNotLike(String value) {
            addCriterion("fAdderess not like", value, "fadderess");
            return (Criteria) this;
        }

        public Criteria andFadderessIn(List<String> values) {
            addCriterion("fAdderess in", values, "fadderess");
            return (Criteria) this;
        }

        public Criteria andFadderessNotIn(List<String> values) {
            addCriterion("fAdderess not in", values, "fadderess");
            return (Criteria) this;
        }

        public Criteria andFadderessBetween(String value1, String value2) {
            addCriterion("fAdderess between", value1, value2, "fadderess");
            return (Criteria) this;
        }

        public Criteria andFadderessNotBetween(String value1, String value2) {
            addCriterion("fAdderess not between", value1, value2, "fadderess");
            return (Criteria) this;
        }

        public Criteria andFuidIsNull() {
            addCriterion("fuid is null");
            return (Criteria) this;
        }

        public Criteria andFuidIsNotNull() {
            addCriterion("fuid is not null");
            return (Criteria) this;
        }

        public Criteria andFuidEqualTo(Integer value) {
            addCriterion("fuid =", value, "fuid");
            return (Criteria) this;
        }

        public Criteria andFuidNotEqualTo(Integer value) {
            addCriterion("fuid <>", value, "fuid");
            return (Criteria) this;
        }

        public Criteria andFuidGreaterThan(Integer value) {
            addCriterion("fuid >", value, "fuid");
            return (Criteria) this;
        }

        public Criteria andFuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fuid >=", value, "fuid");
            return (Criteria) this;
        }

        public Criteria andFuidLessThan(Integer value) {
            addCriterion("fuid <", value, "fuid");
            return (Criteria) this;
        }

        public Criteria andFuidLessThanOrEqualTo(Integer value) {
            addCriterion("fuid <=", value, "fuid");
            return (Criteria) this;
        }

        public Criteria andFuidIn(List<Integer> values) {
            addCriterion("fuid in", values, "fuid");
            return (Criteria) this;
        }

        public Criteria andFuidNotIn(List<Integer> values) {
            addCriterion("fuid not in", values, "fuid");
            return (Criteria) this;
        }

        public Criteria andFuidBetween(Integer value1, Integer value2) {
            addCriterion("fuid between", value1, value2, "fuid");
            return (Criteria) this;
        }

        public Criteria andFuidNotBetween(Integer value1, Integer value2) {
            addCriterion("fuid not between", value1, value2, "fuid");
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

        public Criteria andFnameIsNull() {
            addCriterion("fname is null");
            return (Criteria) this;
        }

        public Criteria andFnameIsNotNull() {
            addCriterion("fname is not null");
            return (Criteria) this;
        }

        public Criteria andFnameEqualTo(String value) {
            addCriterion("fname =", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotEqualTo(String value) {
            addCriterion("fname <>", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThan(String value) {
            addCriterion("fname >", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThanOrEqualTo(String value) {
            addCriterion("fname >=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThan(String value) {
            addCriterion("fname <", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThanOrEqualTo(String value) {
            addCriterion("fname <=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLike(String value) {
            addCriterion("fname like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotLike(String value) {
            addCriterion("fname not like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameIn(List<String> values) {
            addCriterion("fname in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotIn(List<String> values) {
            addCriterion("fname not in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameBetween(String value1, String value2) {
            addCriterion("fname between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotBetween(String value1, String value2) {
            addCriterion("fname not between", value1, value2, "fname");
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