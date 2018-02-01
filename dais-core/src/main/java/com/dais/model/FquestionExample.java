package com.dais.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FquestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FquestionExample() {
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
            addCriterion("fid is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("fid is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("fid =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("fid <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("fid >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fid >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("fid <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("fid <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("fid in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("fid not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("fid between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("fid not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFtypeIsNull() {
            addCriterion("ftype is null");
            return (Criteria) this;
        }

        public Criteria andFtypeIsNotNull() {
            addCriterion("ftype is not null");
            return (Criteria) this;
        }

        public Criteria andFtypeEqualTo(Integer value) {
            addCriterion("ftype =", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotEqualTo(Integer value) {
            addCriterion("ftype <>", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeGreaterThan(Integer value) {
            addCriterion("ftype >", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ftype >=", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLessThan(Integer value) {
            addCriterion("ftype <", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLessThanOrEqualTo(Integer value) {
            addCriterion("ftype <=", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeIn(List<Integer> values) {
            addCriterion("ftype in", values, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotIn(List<Integer> values) {
            addCriterion("ftype not in", values, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeBetween(Integer value1, Integer value2) {
            addCriterion("ftype between", value1, value2, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ftype not between", value1, value2, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtelephoneIsNull() {
            addCriterion("ftelephone is null");
            return (Criteria) this;
        }

        public Criteria andFtelephoneIsNotNull() {
            addCriterion("ftelephone is not null");
            return (Criteria) this;
        }

        public Criteria andFtelephoneEqualTo(String value) {
            addCriterion("ftelephone =", value, "ftelephone");
            return (Criteria) this;
        }

        public Criteria andFtelephoneNotEqualTo(String value) {
            addCriterion("ftelephone <>", value, "ftelephone");
            return (Criteria) this;
        }

        public Criteria andFtelephoneGreaterThan(String value) {
            addCriterion("ftelephone >", value, "ftelephone");
            return (Criteria) this;
        }

        public Criteria andFtelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("ftelephone >=", value, "ftelephone");
            return (Criteria) this;
        }

        public Criteria andFtelephoneLessThan(String value) {
            addCriterion("ftelephone <", value, "ftelephone");
            return (Criteria) this;
        }

        public Criteria andFtelephoneLessThanOrEqualTo(String value) {
            addCriterion("ftelephone <=", value, "ftelephone");
            return (Criteria) this;
        }

        public Criteria andFtelephoneLike(String value) {
            addCriterion("ftelephone like", value, "ftelephone");
            return (Criteria) this;
        }

        public Criteria andFtelephoneNotLike(String value) {
            addCriterion("ftelephone not like", value, "ftelephone");
            return (Criteria) this;
        }

        public Criteria andFtelephoneIn(List<String> values) {
            addCriterion("ftelephone in", values, "ftelephone");
            return (Criteria) this;
        }

        public Criteria andFtelephoneNotIn(List<String> values) {
            addCriterion("ftelephone not in", values, "ftelephone");
            return (Criteria) this;
        }

        public Criteria andFtelephoneBetween(String value1, String value2) {
            addCriterion("ftelephone between", value1, value2, "ftelephone");
            return (Criteria) this;
        }

        public Criteria andFtelephoneNotBetween(String value1, String value2) {
            addCriterion("ftelephone not between", value1, value2, "ftelephone");
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

        public Criteria andFstatusIsNull() {
            addCriterion("fstatus is null");
            return (Criteria) this;
        }

        public Criteria andFstatusIsNotNull() {
            addCriterion("fstatus is not null");
            return (Criteria) this;
        }

        public Criteria andFstatusEqualTo(Integer value) {
            addCriterion("fstatus =", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotEqualTo(Integer value) {
            addCriterion("fstatus <>", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThan(Integer value) {
            addCriterion("fstatus >", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("fstatus >=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThan(Integer value) {
            addCriterion("fstatus <", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusLessThanOrEqualTo(Integer value) {
            addCriterion("fstatus <=", value, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusIn(List<Integer> values) {
            addCriterion("fstatus in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotIn(List<Integer> values) {
            addCriterion("fstatus not in", values, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusBetween(Integer value1, Integer value2) {
            addCriterion("fstatus between", value1, value2, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("fstatus not between", value1, value2, "fstatus");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeIsNull() {
            addCriterion("fcreateTime is null");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeIsNotNull() {
            addCriterion("fcreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeEqualTo(Date value) {
            addCriterion("fcreateTime =", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeNotEqualTo(Date value) {
            addCriterion("fcreateTime <>", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeGreaterThan(Date value) {
            addCriterion("fcreateTime >", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fcreateTime >=", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeLessThan(Date value) {
            addCriterion("fcreateTime <", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("fcreateTime <=", value, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeIn(List<Date> values) {
            addCriterion("fcreateTime in", values, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeNotIn(List<Date> values) {
            addCriterion("fcreateTime not in", values, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeBetween(Date value1, Date value2) {
            addCriterion("fcreateTime between", value1, value2, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFcreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("fcreateTime not between", value1, value2, "fcreatetime");
            return (Criteria) this;
        }

        public Criteria andFsolvetimeIsNull() {
            addCriterion("fsolveTime is null");
            return (Criteria) this;
        }

        public Criteria andFsolvetimeIsNotNull() {
            addCriterion("fsolveTime is not null");
            return (Criteria) this;
        }

        public Criteria andFsolvetimeEqualTo(Date value) {
            addCriterion("fsolveTime =", value, "fsolvetime");
            return (Criteria) this;
        }

        public Criteria andFsolvetimeNotEqualTo(Date value) {
            addCriterion("fsolveTime <>", value, "fsolvetime");
            return (Criteria) this;
        }

        public Criteria andFsolvetimeGreaterThan(Date value) {
            addCriterion("fsolveTime >", value, "fsolvetime");
            return (Criteria) this;
        }

        public Criteria andFsolvetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fsolveTime >=", value, "fsolvetime");
            return (Criteria) this;
        }

        public Criteria andFsolvetimeLessThan(Date value) {
            addCriterion("fsolveTime <", value, "fsolvetime");
            return (Criteria) this;
        }

        public Criteria andFsolvetimeLessThanOrEqualTo(Date value) {
            addCriterion("fsolveTime <=", value, "fsolvetime");
            return (Criteria) this;
        }

        public Criteria andFsolvetimeIn(List<Date> values) {
            addCriterion("fsolveTime in", values, "fsolvetime");
            return (Criteria) this;
        }

        public Criteria andFsolvetimeNotIn(List<Date> values) {
            addCriterion("fsolveTime not in", values, "fsolvetime");
            return (Criteria) this;
        }

        public Criteria andFsolvetimeBetween(Date value1, Date value2) {
            addCriterion("fsolveTime between", value1, value2, "fsolvetime");
            return (Criteria) this;
        }

        public Criteria andFsolvetimeNotBetween(Date value1, Date value2) {
            addCriterion("fsolveTime not between", value1, value2, "fsolvetime");
            return (Criteria) this;
        }

        public Criteria andFaidIsNull() {
            addCriterion("faid is null");
            return (Criteria) this;
        }

        public Criteria andFaidIsNotNull() {
            addCriterion("faid is not null");
            return (Criteria) this;
        }

        public Criteria andFaidEqualTo(Integer value) {
            addCriterion("faid =", value, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidNotEqualTo(Integer value) {
            addCriterion("faid <>", value, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidGreaterThan(Integer value) {
            addCriterion("faid >", value, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("faid >=", value, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidLessThan(Integer value) {
            addCriterion("faid <", value, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidLessThanOrEqualTo(Integer value) {
            addCriterion("faid <=", value, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidIn(List<Integer> values) {
            addCriterion("faid in", values, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidNotIn(List<Integer> values) {
            addCriterion("faid not in", values, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidBetween(Integer value1, Integer value2) {
            addCriterion("faid between", value1, value2, "faid");
            return (Criteria) this;
        }

        public Criteria andFaidNotBetween(Integer value1, Integer value2) {
            addCriterion("faid not between", value1, value2, "faid");
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