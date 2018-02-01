package com.dais.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FmessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FmessageExample() {
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
            addCriterion("FId is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("FId is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("FId =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("FId <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("FId >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FId >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("FId <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("FId <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("FId in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("FId not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("FId between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("FId not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFstatusIsNull() {
            addCriterion("FStatus is null");
            return (Criteria) this;
        }

        public Criteria andFstatusIsNotNull() {
            addCriterion("FStatus is not null");
            return (Criteria) this;
        }

        public Criteria andFstatusEqualTo(Integer value) {
            addCriterion("FStatus =", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotEqualTo(Integer value) {
            addCriterion("FStatus <>", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThan(Integer value) {
            addCriterion("FStatus >", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("FStatus >=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThan(Integer value) {
            addCriterion("FStatus <", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThanOrEqualTo(Integer value) {
            addCriterion("FStatus <=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusIn(List<Integer> values) {
            addCriterion("FStatus in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotIn(List<Integer> values) {
            addCriterion("FStatus not in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusBetween(Integer value1, Integer value2) {
            addCriterion("FStatus between", value1, value2, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("FStatus not between", value1, value2, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFtitleIsNull() {
            addCriterion("FTitle is null");
            return (Criteria) this;
        }

        public Criteria andFtitleIsNotNull() {
            addCriterion("FTitle is not null");
            return (Criteria) this;
        }

        public Criteria andFtitleEqualTo(String value) {
            addCriterion("FTitle =", value, "ftitle");
            return (Criteria) this;
        }

        public Criteria andFtitleNotEqualTo(String value) {
            addCriterion("FTitle <>", value, "ftitle");
            return (Criteria) this;
        }

        public Criteria andFtitleGreaterThan(String value) {
            addCriterion("FTitle >", value, "ftitle");
            return (Criteria) this;
        }

        public Criteria andFtitleGreaterThanOrEqualTo(String value) {
            addCriterion("FTitle >=", value, "ftitle");
            return (Criteria) this;
        }

        public Criteria andFtitleLessThan(String value) {
            addCriterion("FTitle <", value, "ftitle");
            return (Criteria) this;
        }

        public Criteria andFtitleLessThanOrEqualTo(String value) {
            addCriterion("FTitle <=", value, "ftitle");
            return (Criteria) this;
        }

        public Criteria andFtitleLike(String value) {
            addCriterion("FTitle like", value, "ftitle");
            return (Criteria) this;
        }

        public Criteria andFtitleNotLike(String value) {
            addCriterion("FTitle not like", value, "ftitle");
            return (Criteria) this;
        }

        public Criteria andFtitleIn(List<String> values) {
            addCriterion("FTitle in", values, "ftitle");
            return (Criteria) this;
        }

        public Criteria andFtitleNotIn(List<String> values) {
            addCriterion("FTitle not in", values, "ftitle");
            return (Criteria) this;
        }

        public Criteria andFtitleBetween(String value1, String value2) {
            addCriterion("FTitle between", value1, value2, "ftitle");
            return (Criteria) this;
        }

        public Criteria andFtitleNotBetween(String value1, String value2) {
            addCriterion("FTitle not between", value1, value2, "ftitle");
            return (Criteria) this;
        }

        public Criteria andFcontentIsNull() {
            addCriterion("FContent is null");
            return (Criteria) this;
        }

        public Criteria andFcontentIsNotNull() {
            addCriterion("FContent is not null");
            return (Criteria) this;
        }

        public Criteria andFcontentEqualTo(String value) {
            addCriterion("FContent =", value, "fcontent");
            return (Criteria) this;
        }

        public Criteria andFcontentNotEqualTo(String value) {
            addCriterion("FContent <>", value, "fcontent");
            return (Criteria) this;
        }

        public Criteria andFcontentGreaterThan(String value) {
            addCriterion("FContent >", value, "fcontent");
            return (Criteria) this;
        }

        public Criteria andFcontentGreaterThanOrEqualTo(String value) {
            addCriterion("FContent >=", value, "fcontent");
            return (Criteria) this;
        }

        public Criteria andFcontentLessThan(String value) {
            addCriterion("FContent <", value, "fcontent");
            return (Criteria) this;
        }

        public Criteria andFcontentLessThanOrEqualTo(String value) {
            addCriterion("FContent <=", value, "fcontent");
            return (Criteria) this;
        }

        public Criteria andFcontentLike(String value) {
            addCriterion("FContent like", value, "fcontent");
            return (Criteria) this;
        }

        public Criteria andFcontentNotLike(String value) {
            addCriterion("FContent not like", value, "fcontent");
            return (Criteria) this;
        }

        public Criteria andFcontentIn(List<String> values) {
            addCriterion("FContent in", values, "fcontent");
            return (Criteria) this;
        }

        public Criteria andFcontentNotIn(List<String> values) {
            addCriterion("FContent not in", values, "fcontent");
            return (Criteria) this;
        }

        public Criteria andFcontentBetween(String value1, String value2) {
            addCriterion("FContent between", value1, value2, "fcontent");
            return (Criteria) this;
        }

        public Criteria andFcontentNotBetween(String value1, String value2) {
            addCriterion("FContent not between", value1, value2, "fcontent");
            return (Criteria) this;
        }

        public Criteria andFreceiveridIsNull() {
            addCriterion("FReceiverId is null");
            return (Criteria) this;
        }

        public Criteria andFreceiveridIsNotNull() {
            addCriterion("FReceiverId is not null");
            return (Criteria) this;
        }

        public Criteria andFreceiveridEqualTo(Integer value) {
            addCriterion("FReceiverId =", value, "freceiverid");
            return (Criteria) this;
        }

        public Criteria andFreceiveridNotEqualTo(Integer value) {
            addCriterion("FReceiverId <>", value, "freceiverid");
            return (Criteria) this;
        }

        public Criteria andFreceiveridGreaterThan(Integer value) {
            addCriterion("FReceiverId >", value, "freceiverid");
            return (Criteria) this;
        }

        public Criteria andFreceiveridGreaterThanOrEqualTo(Integer value) {
            addCriterion("FReceiverId >=", value, "freceiverid");
            return (Criteria) this;
        }

        public Criteria andFreceiveridLessThan(Integer value) {
            addCriterion("FReceiverId <", value, "freceiverid");
            return (Criteria) this;
        }

        public Criteria andFreceiveridLessThanOrEqualTo(Integer value) {
            addCriterion("FReceiverId <=", value, "freceiverid");
            return (Criteria) this;
        }

        public Criteria andFreceiveridIn(List<Integer> values) {
            addCriterion("FReceiverId in", values, "freceiverid");
            return (Criteria) this;
        }

        public Criteria andFreceiveridNotIn(List<Integer> values) {
            addCriterion("FReceiverId not in", values, "freceiverid");
            return (Criteria) this;
        }

        public Criteria andFreceiveridBetween(Integer value1, Integer value2) {
            addCriterion("FReceiverId between", value1, value2, "freceiverid");
            return (Criteria) this;
        }

        public Criteria andFreceiveridNotBetween(Integer value1, Integer value2) {
            addCriterion("FReceiverId not between", value1, value2, "freceiverid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridIsNull() {
            addCriterion("FCreatorId is null");
            return (Criteria) this;
        }

        public Criteria andFcreatoridIsNotNull() {
            addCriterion("FCreatorId is not null");
            return (Criteria) this;
        }

        public Criteria andFcreatoridEqualTo(Integer value) {
            addCriterion("FCreatorId =", value, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridNotEqualTo(Integer value) {
            addCriterion("FCreatorId <>", value, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridGreaterThan(Integer value) {
            addCriterion("FCreatorId >", value, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("FCreatorId >=", value, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridLessThan(Integer value) {
            addCriterion("FCreatorId <", value, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridLessThanOrEqualTo(Integer value) {
            addCriterion("FCreatorId <=", value, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridIn(List<Integer> values) {
            addCriterion("FCreatorId in", values, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridNotIn(List<Integer> values) {
            addCriterion("FCreatorId not in", values, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridBetween(Integer value1, Integer value2) {
            addCriterion("FCreatorId between", value1, value2, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatoridNotBetween(Integer value1, Integer value2) {
            addCriterion("FCreatorId not between", value1, value2, "fcreatorid");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeIsNull() {
            addCriterion("FCreateTime is null");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeIsNotNull() {
            addCriterion("FCreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeEqualTo(Date value) {
            addCriterion("FCreateTime =", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeNotEqualTo(Date value) {
            addCriterion("FCreateTime <>", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeGreaterThan(Date value) {
            addCriterion("FCreateTime >", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FCreateTime >=", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeLessThan(Date value) {
            addCriterion("FCreateTime <", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("FCreateTime <=", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeIn(List<Date> values) {
            addCriterion("FCreateTime in", values, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeNotIn(List<Date> values) {
            addCriterion("FCreateTime not in", values, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeBetween(Date value1, Date value2) {
            addCriterion("FCreateTime between", value1, value2, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("FCreateTime not between", value1, value2, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andOperationidIsNull() {
            addCriterion("operationid is null");
            return (Criteria) this;
        }

        public Criteria andOperationidIsNotNull() {
            addCriterion("operationid is not null");
            return (Criteria) this;
        }

        public Criteria andOperationidEqualTo(String value) {
            addCriterion("operationid =", value, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidNotEqualTo(String value) {
            addCriterion("operationid <>", value, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidGreaterThan(String value) {
            addCriterion("operationid >", value, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidGreaterThanOrEqualTo(String value) {
            addCriterion("operationid >=", value, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidLessThan(String value) {
            addCriterion("operationid <", value, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidLessThanOrEqualTo(String value) {
            addCriterion("operationid <=", value, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidLike(String value) {
            addCriterion("operationid like", value, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidNotLike(String value) {
            addCriterion("operationid not like", value, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidIn(List<String> values) {
            addCriterion("operationid in", values, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidNotIn(List<String> values) {
            addCriterion("operationid not in", values, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidBetween(String value1, String value2) {
            addCriterion("operationid between", value1, value2, "operationid");
            return (Criteria) this;
        }

        public Criteria andOperationidNotBetween(String value1, String value2) {
            addCriterion("operationid not between", value1, value2, "operationid");
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