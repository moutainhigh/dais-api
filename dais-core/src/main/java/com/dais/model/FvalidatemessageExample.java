package com.dais.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FvalidatemessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FvalidatemessageExample() {
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

        public Criteria andFusFidIsNull() {
            addCriterion("FUs_fId is null");
            return (Criteria) this;
        }

        public Criteria andFusFidIsNotNull() {
            addCriterion("FUs_fId is not null");
            return (Criteria) this;
        }

        public Criteria andFusFidEqualTo(Integer value) {
            addCriterion("FUs_fId =", value, "fusFid");
            return (Criteria) this;
        }

        public Criteria andFusFidNotEqualTo(Integer value) {
            addCriterion("FUs_fId <>", value, "fusFid");
            return (Criteria) this;
        }

        public Criteria andFusFidGreaterThan(Integer value) {
            addCriterion("FUs_fId >", value, "fusFid");
            return (Criteria) this;
        }

        public Criteria andFusFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FUs_fId >=", value, "fusFid");
            return (Criteria) this;
        }

        public Criteria andFusFidLessThan(Integer value) {
            addCriterion("FUs_fId <", value, "fusFid");
            return (Criteria) this;
        }

        public Criteria andFusFidLessThanOrEqualTo(Integer value) {
            addCriterion("FUs_fId <=", value, "fusFid");
            return (Criteria) this;
        }

        public Criteria andFusFidIn(List<Integer> values) {
            addCriterion("FUs_fId in", values, "fusFid");
            return (Criteria) this;
        }

        public Criteria andFusFidNotIn(List<Integer> values) {
            addCriterion("FUs_fId not in", values, "fusFid");
            return (Criteria) this;
        }

        public Criteria andFusFidBetween(Integer value1, Integer value2) {
            addCriterion("FUs_fId between", value1, value2, "fusFid");
            return (Criteria) this;
        }

        public Criteria andFusFidNotBetween(Integer value1, Integer value2) {
            addCriterion("FUs_fId not between", value1, value2, "fusFid");
            return (Criteria) this;
        }

        public Criteria andFphoneIsNull() {
            addCriterion("fPhone is null");
            return (Criteria) this;
        }

        public Criteria andFphoneIsNotNull() {
            addCriterion("fPhone is not null");
            return (Criteria) this;
        }

        public Criteria andFphoneEqualTo(String value) {
            addCriterion("fPhone =", value, "fphone");
            return (Criteria) this;
        }

        public Criteria andFphoneNotEqualTo(String value) {
            addCriterion("fPhone <>", value, "fphone");
            return (Criteria) this;
        }

        public Criteria andFphoneGreaterThan(String value) {
            addCriterion("fPhone >", value, "fphone");
            return (Criteria) this;
        }

        public Criteria andFphoneGreaterThanOrEqualTo(String value) {
            addCriterion("fPhone >=", value, "fphone");
            return (Criteria) this;
        }

        public Criteria andFphoneLessThan(String value) {
            addCriterion("fPhone <", value, "fphone");
            return (Criteria) this;
        }

        public Criteria andFphoneLessThanOrEqualTo(String value) {
            addCriterion("fPhone <=", value, "fphone");
            return (Criteria) this;
        }

        public Criteria andFphoneLike(String value) {
            addCriterion("fPhone like", value, "fphone");
            return (Criteria) this;
        }

        public Criteria andFphoneNotLike(String value) {
            addCriterion("fPhone not like", value, "fphone");
            return (Criteria) this;
        }

        public Criteria andFphoneIn(List<String> values) {
            addCriterion("fPhone in", values, "fphone");
            return (Criteria) this;
        }

        public Criteria andFphoneNotIn(List<String> values) {
            addCriterion("fPhone not in", values, "fphone");
            return (Criteria) this;
        }

        public Criteria andFphoneBetween(String value1, String value2) {
            addCriterion("fPhone between", value1, value2, "fphone");
            return (Criteria) this;
        }

        public Criteria andFphoneNotBetween(String value1, String value2) {
            addCriterion("fPhone not between", value1, value2, "fphone");
            return (Criteria) this;
        }

        public Criteria andFstatusIsNull() {
            addCriterion("fStatus is null");
            return (Criteria) this;
        }

        public Criteria andFstatusIsNotNull() {
            addCriterion("fStatus is not null");
            return (Criteria) this;
        }

        public Criteria andFstatusEqualTo(Integer value) {
            addCriterion("fStatus =", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotEqualTo(Integer value) {
            addCriterion("fStatus <>", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThan(Integer value) {
            addCriterion("fStatus >", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("fStatus >=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThan(Integer value) {
            addCriterion("fStatus <", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThanOrEqualTo(Integer value) {
            addCriterion("fStatus <=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusIn(List<Integer> values) {
            addCriterion("fStatus in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotIn(List<Integer> values) {
            addCriterion("fStatus not in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusBetween(Integer value1, Integer value2) {
            addCriterion("fStatus between", value1, value2, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("fStatus not between", value1, value2, "fstatus");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andFsendtimeIsNull() {
            addCriterion("fSendTime is null");
            return (Criteria) this;
        }

        public Criteria andFsendtimeIsNotNull() {
            addCriterion("fSendTime is not null");
            return (Criteria) this;
        }

        public Criteria andFsendtimeEqualTo(Date value) {
            addCriterion("fSendTime =", value, "fsendtime");
            return (Criteria) this;
        }

        public Criteria andFsendtimeNotEqualTo(Date value) {
            addCriterion("fSendTime <>", value, "fsendtime");
            return (Criteria) this;
        }

        public Criteria andFsendtimeGreaterThan(Date value) {
            addCriterion("fSendTime >", value, "fsendtime");
            return (Criteria) this;
        }

        public Criteria andFsendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fSendTime >=", value, "fsendtime");
            return (Criteria) this;
        }

        public Criteria andFsendtimeLessThan(Date value) {
            addCriterion("fSendTime <", value, "fsendtime");
            return (Criteria) this;
        }

        public Criteria andFsendtimeLessThanOrEqualTo(Date value) {
            addCriterion("fSendTime <=", value, "fsendtime");
            return (Criteria) this;
        }

        public Criteria andFsendtimeIn(List<Date> values) {
            addCriterion("fSendTime in", values, "fsendtime");
            return (Criteria) this;
        }

        public Criteria andFsendtimeNotIn(List<Date> values) {
            addCriterion("fSendTime not in", values, "fsendtime");
            return (Criteria) this;
        }

        public Criteria andFsendtimeBetween(Date value1, Date value2) {
            addCriterion("fSendTime between", value1, value2, "fsendtime");
            return (Criteria) this;
        }

        public Criteria andFsendtimeNotBetween(Date value1, Date value2) {
            addCriterion("fSendTime not between", value1, value2, "fsendtime");
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