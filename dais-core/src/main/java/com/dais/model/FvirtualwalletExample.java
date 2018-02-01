package com.dais.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FvirtualwalletExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FvirtualwalletExample() {
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

        public Criteria andFtotalIsNull() {
            addCriterion("fTotal is null");
            return (Criteria) this;
        }

        public Criteria andFtotalIsNotNull() {
            addCriterion("fTotal is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalEqualTo(BigDecimal value) {
            addCriterion("fTotal =", value, "ftotal");
            return (Criteria) this;
        }

        public Criteria andFtotalNotEqualTo(BigDecimal value) {
            addCriterion("fTotal <>", value, "ftotal");
            return (Criteria) this;
        }

        public Criteria andFtotalGreaterThan(BigDecimal value) {
            addCriterion("fTotal >", value, "ftotal");
            return (Criteria) this;
        }

        public Criteria andFtotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fTotal >=", value, "ftotal");
            return (Criteria) this;
        }

        public Criteria andFtotalLessThan(BigDecimal value) {
            addCriterion("fTotal <", value, "ftotal");
            return (Criteria) this;
        }

        public Criteria andFtotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fTotal <=", value, "ftotal");
            return (Criteria) this;
        }

        public Criteria andFtotalIn(List<BigDecimal> values) {
            addCriterion("fTotal in", values, "ftotal");
            return (Criteria) this;
        }

        public Criteria andFtotalNotIn(List<BigDecimal> values) {
            addCriterion("fTotal not in", values, "ftotal");
            return (Criteria) this;
        }

        public Criteria andFtotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fTotal between", value1, value2, "ftotal");
            return (Criteria) this;
        }

        public Criteria andFtotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fTotal not between", value1, value2, "ftotal");
            return (Criteria) this;
        }

        public Criteria andFfrozenIsNull() {
            addCriterion("fFrozen is null");
            return (Criteria) this;
        }

        public Criteria andFfrozenIsNotNull() {
            addCriterion("fFrozen is not null");
            return (Criteria) this;
        }

        public Criteria andFfrozenEqualTo(BigDecimal value) {
            addCriterion("fFrozen =", value, "ffrozen");
            return (Criteria) this;
        }

        public Criteria andFfrozenNotEqualTo(BigDecimal value) {
            addCriterion("fFrozen <>", value, "ffrozen");
            return (Criteria) this;
        }

        public Criteria andFfrozenGreaterThan(BigDecimal value) {
            addCriterion("fFrozen >", value, "ffrozen");
            return (Criteria) this;
        }

        public Criteria andFfrozenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fFrozen >=", value, "ffrozen");
            return (Criteria) this;
        }

        public Criteria andFfrozenLessThan(BigDecimal value) {
            addCriterion("fFrozen <", value, "ffrozen");
            return (Criteria) this;
        }

        public Criteria andFfrozenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fFrozen <=", value, "ffrozen");
            return (Criteria) this;
        }

        public Criteria andFfrozenIn(List<BigDecimal> values) {
            addCriterion("fFrozen in", values, "ffrozen");
            return (Criteria) this;
        }

        public Criteria andFfrozenNotIn(List<BigDecimal> values) {
            addCriterion("fFrozen not in", values, "ffrozen");
            return (Criteria) this;
        }

        public Criteria andFfrozenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fFrozen between", value1, value2, "ffrozen");
            return (Criteria) this;
        }

        public Criteria andFfrozenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fFrozen not between", value1, value2, "ffrozen");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeIsNull() {
            addCriterion("fLastUpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeIsNotNull() {
            addCriterion("fLastUpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeEqualTo(Date value) {
            addCriterion("fLastUpdateTime =", value, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeNotEqualTo(Date value) {
            addCriterion("fLastUpdateTime <>", value, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeGreaterThan(Date value) {
            addCriterion("fLastUpdateTime >", value, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fLastUpdateTime >=", value, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeLessThan(Date value) {
            addCriterion("fLastUpdateTime <", value, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("fLastUpdateTime <=", value, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeIn(List<Date> values) {
            addCriterion("fLastUpdateTime in", values, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeNotIn(List<Date> values) {
            addCriterion("fLastUpdateTime not in", values, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeBetween(Date value1, Date value2) {
            addCriterion("fLastUpdateTime between", value1, value2, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("fLastUpdateTime not between", value1, value2, "flastupdatetime");
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

        public Criteria andFborrowbtcIsNull() {
            addCriterion("fBorrowBtc is null");
            return (Criteria) this;
        }

        public Criteria andFborrowbtcIsNotNull() {
            addCriterion("fBorrowBtc is not null");
            return (Criteria) this;
        }

        public Criteria andFborrowbtcEqualTo(BigDecimal value) {
            addCriterion("fBorrowBtc =", value, "fborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFborrowbtcNotEqualTo(BigDecimal value) {
            addCriterion("fBorrowBtc <>", value, "fborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFborrowbtcGreaterThan(BigDecimal value) {
            addCriterion("fBorrowBtc >", value, "fborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFborrowbtcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fBorrowBtc >=", value, "fborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFborrowbtcLessThan(BigDecimal value) {
            addCriterion("fBorrowBtc <", value, "fborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFborrowbtcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fBorrowBtc <=", value, "fborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFborrowbtcIn(List<BigDecimal> values) {
            addCriterion("fBorrowBtc in", values, "fborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFborrowbtcNotIn(List<BigDecimal> values) {
            addCriterion("fBorrowBtc not in", values, "fborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFborrowbtcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fBorrowBtc between", value1, value2, "fborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFborrowbtcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fBorrowBtc not between", value1, value2, "fborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFcanlendbtcIsNull() {
            addCriterion("fCanlendBtc is null");
            return (Criteria) this;
        }

        public Criteria andFcanlendbtcIsNotNull() {
            addCriterion("fCanlendBtc is not null");
            return (Criteria) this;
        }

        public Criteria andFcanlendbtcEqualTo(BigDecimal value) {
            addCriterion("fCanlendBtc =", value, "fcanlendbtc");
            return (Criteria) this;
        }

        public Criteria andFcanlendbtcNotEqualTo(BigDecimal value) {
            addCriterion("fCanlendBtc <>", value, "fcanlendbtc");
            return (Criteria) this;
        }

        public Criteria andFcanlendbtcGreaterThan(BigDecimal value) {
            addCriterion("fCanlendBtc >", value, "fcanlendbtc");
            return (Criteria) this;
        }

        public Criteria andFcanlendbtcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fCanlendBtc >=", value, "fcanlendbtc");
            return (Criteria) this;
        }

        public Criteria andFcanlendbtcLessThan(BigDecimal value) {
            addCriterion("fCanlendBtc <", value, "fcanlendbtc");
            return (Criteria) this;
        }

        public Criteria andFcanlendbtcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fCanlendBtc <=", value, "fcanlendbtc");
            return (Criteria) this;
        }

        public Criteria andFcanlendbtcIn(List<BigDecimal> values) {
            addCriterion("fCanlendBtc in", values, "fcanlendbtc");
            return (Criteria) this;
        }

        public Criteria andFcanlendbtcNotIn(List<BigDecimal> values) {
            addCriterion("fCanlendBtc not in", values, "fcanlendbtc");
            return (Criteria) this;
        }

        public Criteria andFcanlendbtcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fCanlendBtc between", value1, value2, "fcanlendbtc");
            return (Criteria) this;
        }

        public Criteria andFcanlendbtcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fCanlendBtc not between", value1, value2, "fcanlendbtc");
            return (Criteria) this;
        }

        public Criteria andFfrozenlendbtcIsNull() {
            addCriterion("fFrozenLendBtc is null");
            return (Criteria) this;
        }

        public Criteria andFfrozenlendbtcIsNotNull() {
            addCriterion("fFrozenLendBtc is not null");
            return (Criteria) this;
        }

        public Criteria andFfrozenlendbtcEqualTo(BigDecimal value) {
            addCriterion("fFrozenLendBtc =", value, "ffrozenlendbtc");
            return (Criteria) this;
        }

        public Criteria andFfrozenlendbtcNotEqualTo(BigDecimal value) {
            addCriterion("fFrozenLendBtc <>", value, "ffrozenlendbtc");
            return (Criteria) this;
        }

        public Criteria andFfrozenlendbtcGreaterThan(BigDecimal value) {
            addCriterion("fFrozenLendBtc >", value, "ffrozenlendbtc");
            return (Criteria) this;
        }

        public Criteria andFfrozenlendbtcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fFrozenLendBtc >=", value, "ffrozenlendbtc");
            return (Criteria) this;
        }

        public Criteria andFfrozenlendbtcLessThan(BigDecimal value) {
            addCriterion("fFrozenLendBtc <", value, "ffrozenlendbtc");
            return (Criteria) this;
        }

        public Criteria andFfrozenlendbtcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fFrozenLendBtc <=", value, "ffrozenlendbtc");
            return (Criteria) this;
        }

        public Criteria andFfrozenlendbtcIn(List<BigDecimal> values) {
            addCriterion("fFrozenLendBtc in", values, "ffrozenlendbtc");
            return (Criteria) this;
        }

        public Criteria andFfrozenlendbtcNotIn(List<BigDecimal> values) {
            addCriterion("fFrozenLendBtc not in", values, "ffrozenlendbtc");
            return (Criteria) this;
        }

        public Criteria andFfrozenlendbtcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fFrozenLendBtc between", value1, value2, "ffrozenlendbtc");
            return (Criteria) this;
        }

        public Criteria andFfrozenlendbtcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fFrozenLendBtc not between", value1, value2, "ffrozenlendbtc");
            return (Criteria) this;
        }

        public Criteria andFalreadylendbtcIsNull() {
            addCriterion("fAlreadyLendBtc is null");
            return (Criteria) this;
        }

        public Criteria andFalreadylendbtcIsNotNull() {
            addCriterion("fAlreadyLendBtc is not null");
            return (Criteria) this;
        }

        public Criteria andFalreadylendbtcEqualTo(BigDecimal value) {
            addCriterion("fAlreadyLendBtc =", value, "falreadylendbtc");
            return (Criteria) this;
        }

        public Criteria andFalreadylendbtcNotEqualTo(BigDecimal value) {
            addCriterion("fAlreadyLendBtc <>", value, "falreadylendbtc");
            return (Criteria) this;
        }

        public Criteria andFalreadylendbtcGreaterThan(BigDecimal value) {
            addCriterion("fAlreadyLendBtc >", value, "falreadylendbtc");
            return (Criteria) this;
        }

        public Criteria andFalreadylendbtcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fAlreadyLendBtc >=", value, "falreadylendbtc");
            return (Criteria) this;
        }

        public Criteria andFalreadylendbtcLessThan(BigDecimal value) {
            addCriterion("fAlreadyLendBtc <", value, "falreadylendbtc");
            return (Criteria) this;
        }

        public Criteria andFalreadylendbtcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fAlreadyLendBtc <=", value, "falreadylendbtc");
            return (Criteria) this;
        }

        public Criteria andFalreadylendbtcIn(List<BigDecimal> values) {
            addCriterion("fAlreadyLendBtc in", values, "falreadylendbtc");
            return (Criteria) this;
        }

        public Criteria andFalreadylendbtcNotIn(List<BigDecimal> values) {
            addCriterion("fAlreadyLendBtc not in", values, "falreadylendbtc");
            return (Criteria) this;
        }

        public Criteria andFalreadylendbtcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fAlreadyLendBtc between", value1, value2, "falreadylendbtc");
            return (Criteria) this;
        }

        public Criteria andFalreadylendbtcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fAlreadyLendBtc not between", value1, value2, "falreadylendbtc");
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

        public Criteria andFhaveappointborrowbtcIsNull() {
            addCriterion("fHaveAppointBorrowBtc is null");
            return (Criteria) this;
        }

        public Criteria andFhaveappointborrowbtcIsNotNull() {
            addCriterion("fHaveAppointBorrowBtc is not null");
            return (Criteria) this;
        }

        public Criteria andFhaveappointborrowbtcEqualTo(BigDecimal value) {
            addCriterion("fHaveAppointBorrowBtc =", value, "fhaveappointborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFhaveappointborrowbtcNotEqualTo(BigDecimal value) {
            addCriterion("fHaveAppointBorrowBtc <>", value, "fhaveappointborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFhaveappointborrowbtcGreaterThan(BigDecimal value) {
            addCriterion("fHaveAppointBorrowBtc >", value, "fhaveappointborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFhaveappointborrowbtcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fHaveAppointBorrowBtc >=", value, "fhaveappointborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFhaveappointborrowbtcLessThan(BigDecimal value) {
            addCriterion("fHaveAppointBorrowBtc <", value, "fhaveappointborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFhaveappointborrowbtcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fHaveAppointBorrowBtc <=", value, "fhaveappointborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFhaveappointborrowbtcIn(List<BigDecimal> values) {
            addCriterion("fHaveAppointBorrowBtc in", values, "fhaveappointborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFhaveappointborrowbtcNotIn(List<BigDecimal> values) {
            addCriterion("fHaveAppointBorrowBtc not in", values, "fhaveappointborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFhaveappointborrowbtcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fHaveAppointBorrowBtc between", value1, value2, "fhaveappointborrowbtc");
            return (Criteria) this;
        }

        public Criteria andFhaveappointborrowbtcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fHaveAppointBorrowBtc not between", value1, value2, "fhaveappointborrowbtc");
            return (Criteria) this;
        }

        public Criteria andIshowIsNull() {
            addCriterion("ishow is null");
            return (Criteria) this;
        }

        public Criteria andIshowIsNotNull() {
            addCriterion("ishow is not null");
            return (Criteria) this;
        }

        public Criteria andIshowEqualTo(Boolean value) {
            addCriterion("ishow =", value, "ishow");
            return (Criteria) this;
        }

        public Criteria andIshowNotEqualTo(Boolean value) {
            addCriterion("ishow <>", value, "ishow");
            return (Criteria) this;
        }

        public Criteria andIshowGreaterThan(Boolean value) {
            addCriterion("ishow >", value, "ishow");
            return (Criteria) this;
        }

        public Criteria andIshowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ishow >=", value, "ishow");
            return (Criteria) this;
        }

        public Criteria andIshowLessThan(Boolean value) {
            addCriterion("ishow <", value, "ishow");
            return (Criteria) this;
        }

        public Criteria andIshowLessThanOrEqualTo(Boolean value) {
            addCriterion("ishow <=", value, "ishow");
            return (Criteria) this;
        }

        public Criteria andIshowIn(List<Boolean> values) {
            addCriterion("ishow in", values, "ishow");
            return (Criteria) this;
        }

        public Criteria andIshowNotIn(List<Boolean> values) {
            addCriterion("ishow not in", values, "ishow");
            return (Criteria) this;
        }

        public Criteria andIshowBetween(Boolean value1, Boolean value2) {
            addCriterion("ishow between", value1, value2, "ishow");
            return (Criteria) this;
        }

        public Criteria andIshowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ishow not between", value1, value2, "ishow");
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