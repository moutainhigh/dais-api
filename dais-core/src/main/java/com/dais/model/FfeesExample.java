package com.dais.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FfeesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FfeesExample() {
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

        public Criteria andFfeeIsNull() {
            addCriterion("ffee is null");
            return (Criteria) this;
        }

        public Criteria andFfeeIsNotNull() {
            addCriterion("ffee is not null");
            return (Criteria) this;
        }

        public Criteria andFfeeEqualTo(BigDecimal value) {
            addCriterion("ffee =", value, "ffee");
            return (Criteria) this;
        }

        public Criteria andFfeeNotEqualTo(BigDecimal value) {
            addCriterion("ffee <>", value, "ffee");
            return (Criteria) this;
        }

        public Criteria andFfeeGreaterThan(BigDecimal value) {
            addCriterion("ffee >", value, "ffee");
            return (Criteria) this;
        }

        public Criteria andFfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ffee >=", value, "ffee");
            return (Criteria) this;
        }

        public Criteria andFfeeLessThan(BigDecimal value) {
            addCriterion("ffee <", value, "ffee");
            return (Criteria) this;
        }

        public Criteria andFfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ffee <=", value, "ffee");
            return (Criteria) this;
        }

        public Criteria andFfeeIn(List<BigDecimal> values) {
            addCriterion("ffee in", values, "ffee");
            return (Criteria) this;
        }

        public Criteria andFfeeNotIn(List<BigDecimal> values) {
            addCriterion("ffee not in", values, "ffee");
            return (Criteria) this;
        }

        public Criteria andFfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ffee between", value1, value2, "ffee");
            return (Criteria) this;
        }

        public Criteria andFfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ffee not between", value1, value2, "ffee");
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

        public Criteria andWithdrawIsNull() {
            addCriterion("withdraw is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawIsNotNull() {
            addCriterion("withdraw is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawEqualTo(BigDecimal value) {
            addCriterion("withdraw =", value, "withdraw");
            return (Criteria) this;
        }

        public Criteria andWithdrawNotEqualTo(BigDecimal value) {
            addCriterion("withdraw <>", value, "withdraw");
            return (Criteria) this;
        }

        public Criteria andWithdrawGreaterThan(BigDecimal value) {
            addCriterion("withdraw >", value, "withdraw");
            return (Criteria) this;
        }

        public Criteria andWithdrawGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("withdraw >=", value, "withdraw");
            return (Criteria) this;
        }

        public Criteria andWithdrawLessThan(BigDecimal value) {
            addCriterion("withdraw <", value, "withdraw");
            return (Criteria) this;
        }

        public Criteria andWithdrawLessThanOrEqualTo(BigDecimal value) {
            addCriterion("withdraw <=", value, "withdraw");
            return (Criteria) this;
        }

        public Criteria andWithdrawIn(List<BigDecimal> values) {
            addCriterion("withdraw in", values, "withdraw");
            return (Criteria) this;
        }

        public Criteria andWithdrawNotIn(List<BigDecimal> values) {
            addCriterion("withdraw not in", values, "withdraw");
            return (Criteria) this;
        }

        public Criteria andWithdrawBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdraw between", value1, value2, "withdraw");
            return (Criteria) this;
        }

        public Criteria andWithdrawNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdraw not between", value1, value2, "withdraw");
            return (Criteria) this;
        }

        public Criteria andFvirIdIsNull() {
            addCriterion("fvir_id is null");
            return (Criteria) this;
        }

        public Criteria andFvirIdIsNotNull() {
            addCriterion("fvir_id is not null");
            return (Criteria) this;
        }

        public Criteria andFvirIdEqualTo(Integer value) {
            addCriterion("fvir_id =", value, "fvirId");
            return (Criteria) this;
        }

        public Criteria andFvirIdNotEqualTo(Integer value) {
            addCriterion("fvir_id <>", value, "fvirId");
            return (Criteria) this;
        }

        public Criteria andFvirIdGreaterThan(Integer value) {
            addCriterion("fvir_id >", value, "fvirId");
            return (Criteria) this;
        }

        public Criteria andFvirIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fvir_id >=", value, "fvirId");
            return (Criteria) this;
        }

        public Criteria andFvirIdLessThan(Integer value) {
            addCriterion("fvir_id <", value, "fvirId");
            return (Criteria) this;
        }

        public Criteria andFvirIdLessThanOrEqualTo(Integer value) {
            addCriterion("fvir_id <=", value, "fvirId");
            return (Criteria) this;
        }

        public Criteria andFvirIdIn(List<Integer> values) {
            addCriterion("fvir_id in", values, "fvirId");
            return (Criteria) this;
        }

        public Criteria andFvirIdNotIn(List<Integer> values) {
            addCriterion("fvir_id not in", values, "fvirId");
            return (Criteria) this;
        }

        public Criteria andFvirIdBetween(Integer value1, Integer value2) {
            addCriterion("fvir_id between", value1, value2, "fvirId");
            return (Criteria) this;
        }

        public Criteria andFvirIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fvir_id not between", value1, value2, "fvirId");
            return (Criteria) this;
        }

        public Criteria andFlevelIsNull() {
            addCriterion("flevel is null");
            return (Criteria) this;
        }

        public Criteria andFlevelIsNotNull() {
            addCriterion("flevel is not null");
            return (Criteria) this;
        }

        public Criteria andFlevelEqualTo(Integer value) {
            addCriterion("flevel =", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelNotEqualTo(Integer value) {
            addCriterion("flevel <>", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelGreaterThan(Integer value) {
            addCriterion("flevel >", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("flevel >=", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelLessThan(Integer value) {
            addCriterion("flevel <", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelLessThanOrEqualTo(Integer value) {
            addCriterion("flevel <=", value, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelIn(List<Integer> values) {
            addCriterion("flevel in", values, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelNotIn(List<Integer> values) {
            addCriterion("flevel not in", values, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelBetween(Integer value1, Integer value2) {
            addCriterion("flevel between", value1, value2, "flevel");
            return (Criteria) this;
        }

        public Criteria andFlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("flevel not between", value1, value2, "flevel");
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