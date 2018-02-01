package com.dais.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FvirtualcaptualoperationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FvirtualcaptualoperationExample() {
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

        public Criteria andFusFid2IsNull() {
            addCriterion("FUs_fId2 is null");
            return (Criteria) this;
        }

        public Criteria andFusFid2IsNotNull() {
            addCriterion("FUs_fId2 is not null");
            return (Criteria) this;
        }

        public Criteria andFusFid2EqualTo(Integer value) {
            addCriterion("FUs_fId2 =", value, "fusFid2");
            return (Criteria) this;
        }

        public Criteria andFusFid2NotEqualTo(Integer value) {
            addCriterion("FUs_fId2 <>", value, "fusFid2");
            return (Criteria) this;
        }

        public Criteria andFusFid2GreaterThan(Integer value) {
            addCriterion("FUs_fId2 >", value, "fusFid2");
            return (Criteria) this;
        }

        public Criteria andFusFid2GreaterThanOrEqualTo(Integer value) {
            addCriterion("FUs_fId2 >=", value, "fusFid2");
            return (Criteria) this;
        }

        public Criteria andFusFid2LessThan(Integer value) {
            addCriterion("FUs_fId2 <", value, "fusFid2");
            return (Criteria) this;
        }

        public Criteria andFusFid2LessThanOrEqualTo(Integer value) {
            addCriterion("FUs_fId2 <=", value, "fusFid2");
            return (Criteria) this;
        }

        public Criteria andFusFid2In(List<Integer> values) {
            addCriterion("FUs_fId2 in", values, "fusFid2");
            return (Criteria) this;
        }

        public Criteria andFusFid2NotIn(List<Integer> values) {
            addCriterion("FUs_fId2 not in", values, "fusFid2");
            return (Criteria) this;
        }

        public Criteria andFusFid2Between(Integer value1, Integer value2) {
            addCriterion("FUs_fId2 between", value1, value2, "fusFid2");
            return (Criteria) this;
        }

        public Criteria andFusFid2NotBetween(Integer value1, Integer value2) {
            addCriterion("FUs_fId2 not between", value1, value2, "fusFid2");
            return (Criteria) this;
        }

        public Criteria andFviFid2IsNull() {
            addCriterion("fVi_fId2 is null");
            return (Criteria) this;
        }

        public Criteria andFviFid2IsNotNull() {
            addCriterion("fVi_fId2 is not null");
            return (Criteria) this;
        }

        public Criteria andFviFid2EqualTo(Integer value) {
            addCriterion("fVi_fId2 =", value, "fviFid2");
            return (Criteria) this;
        }

        public Criteria andFviFid2NotEqualTo(Integer value) {
            addCriterion("fVi_fId2 <>", value, "fviFid2");
            return (Criteria) this;
        }

        public Criteria andFviFid2GreaterThan(Integer value) {
            addCriterion("fVi_fId2 >", value, "fviFid2");
            return (Criteria) this;
        }

        public Criteria andFviFid2GreaterThanOrEqualTo(Integer value) {
            addCriterion("fVi_fId2 >=", value, "fviFid2");
            return (Criteria) this;
        }

        public Criteria andFviFid2LessThan(Integer value) {
            addCriterion("fVi_fId2 <", value, "fviFid2");
            return (Criteria) this;
        }

        public Criteria andFviFid2LessThanOrEqualTo(Integer value) {
            addCriterion("fVi_fId2 <=", value, "fviFid2");
            return (Criteria) this;
        }

        public Criteria andFviFid2In(List<Integer> values) {
            addCriterion("fVi_fId2 in", values, "fviFid2");
            return (Criteria) this;
        }

        public Criteria andFviFid2NotIn(List<Integer> values) {
            addCriterion("fVi_fId2 not in", values, "fviFid2");
            return (Criteria) this;
        }

        public Criteria andFviFid2Between(Integer value1, Integer value2) {
            addCriterion("fVi_fId2 between", value1, value2, "fviFid2");
            return (Criteria) this;
        }

        public Criteria andFviFid2NotBetween(Integer value1, Integer value2) {
            addCriterion("fVi_fId2 not between", value1, value2, "fviFid2");
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

        public Criteria andFamountIsNull() {
            addCriterion("fAmount is null");
            return (Criteria) this;
        }

        public Criteria andFamountIsNotNull() {
            addCriterion("fAmount is not null");
            return (Criteria) this;
        }

        public Criteria andFamountEqualTo(BigDecimal value) {
            addCriterion("fAmount =", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountNotEqualTo(BigDecimal value) {
            addCriterion("fAmount <>", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountGreaterThan(BigDecimal value) {
            addCriterion("fAmount >", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fAmount >=", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountLessThan(BigDecimal value) {
            addCriterion("fAmount <", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fAmount <=", value, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountIn(List<BigDecimal> values) {
            addCriterion("fAmount in", values, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountNotIn(List<BigDecimal> values) {
            addCriterion("fAmount not in", values, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fAmount between", value1, value2, "famount");
            return (Criteria) this;
        }

        public Criteria andFamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fAmount not between", value1, value2, "famount");
            return (Criteria) this;
        }

        public Criteria andFfeesIsNull() {
            addCriterion("ffees is null");
            return (Criteria) this;
        }

        public Criteria andFfeesIsNotNull() {
            addCriterion("ffees is not null");
            return (Criteria) this;
        }

        public Criteria andFfeesEqualTo(BigDecimal value) {
            addCriterion("ffees =", value, "ffees");
            return (Criteria) this;
        }

        public Criteria andFfeesNotEqualTo(BigDecimal value) {
            addCriterion("ffees <>", value, "ffees");
            return (Criteria) this;
        }

        public Criteria andFfeesGreaterThan(BigDecimal value) {
            addCriterion("ffees >", value, "ffees");
            return (Criteria) this;
        }

        public Criteria andFfeesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ffees >=", value, "ffees");
            return (Criteria) this;
        }

        public Criteria andFfeesLessThan(BigDecimal value) {
            addCriterion("ffees <", value, "ffees");
            return (Criteria) this;
        }

        public Criteria andFfeesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ffees <=", value, "ffees");
            return (Criteria) this;
        }

        public Criteria andFfeesIn(List<BigDecimal> values) {
            addCriterion("ffees in", values, "ffees");
            return (Criteria) this;
        }

        public Criteria andFfeesNotIn(List<BigDecimal> values) {
            addCriterion("ffees not in", values, "ffees");
            return (Criteria) this;
        }

        public Criteria andFfeesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ffees between", value1, value2, "ffees");
            return (Criteria) this;
        }

        public Criteria andFfeesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ffees not between", value1, value2, "ffees");
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

        public Criteria andFlastupdatetimeIsNull() {
            addCriterion("flastUpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeIsNotNull() {
            addCriterion("flastUpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeEqualTo(Date value) {
            addCriterion("flastUpdateTime =", value, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeNotEqualTo(Date value) {
            addCriterion("flastUpdateTime <>", value, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeGreaterThan(Date value) {
            addCriterion("flastUpdateTime >", value, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("flastUpdateTime >=", value, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeLessThan(Date value) {
            addCriterion("flastUpdateTime <", value, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("flastUpdateTime <=", value, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeIn(List<Date> values) {
            addCriterion("flastUpdateTime in", values, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeNotIn(List<Date> values) {
            addCriterion("flastUpdateTime not in", values, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeBetween(Date value1, Date value2) {
            addCriterion("flastUpdateTime between", value1, value2, "flastupdatetime");
            return (Criteria) this;
        }

        public Criteria andFlastupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("flastUpdateTime not between", value1, value2, "flastupdatetime");
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

        public Criteria andWithdrawVirtualAddressIsNull() {
            addCriterion("withdraw_virtual_address is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawVirtualAddressIsNotNull() {
            addCriterion("withdraw_virtual_address is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawVirtualAddressEqualTo(String value) {
            addCriterion("withdraw_virtual_address =", value, "withdrawVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andWithdrawVirtualAddressNotEqualTo(String value) {
            addCriterion("withdraw_virtual_address <>", value, "withdrawVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andWithdrawVirtualAddressGreaterThan(String value) {
            addCriterion("withdraw_virtual_address >", value, "withdrawVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andWithdrawVirtualAddressGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_virtual_address >=", value, "withdrawVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andWithdrawVirtualAddressLessThan(String value) {
            addCriterion("withdraw_virtual_address <", value, "withdrawVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andWithdrawVirtualAddressLessThanOrEqualTo(String value) {
            addCriterion("withdraw_virtual_address <=", value, "withdrawVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andWithdrawVirtualAddressLike(String value) {
            addCriterion("withdraw_virtual_address like", value, "withdrawVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andWithdrawVirtualAddressNotLike(String value) {
            addCriterion("withdraw_virtual_address not like", value, "withdrawVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andWithdrawVirtualAddressIn(List<String> values) {
            addCriterion("withdraw_virtual_address in", values, "withdrawVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andWithdrawVirtualAddressNotIn(List<String> values) {
            addCriterion("withdraw_virtual_address not in", values, "withdrawVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andWithdrawVirtualAddressBetween(String value1, String value2) {
            addCriterion("withdraw_virtual_address between", value1, value2, "withdrawVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andWithdrawVirtualAddressNotBetween(String value1, String value2) {
            addCriterion("withdraw_virtual_address not between", value1, value2, "withdrawVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andRechargeVirtualAddressIsNull() {
            addCriterion("recharge_virtual_address is null");
            return (Criteria) this;
        }

        public Criteria andRechargeVirtualAddressIsNotNull() {
            addCriterion("recharge_virtual_address is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeVirtualAddressEqualTo(String value) {
            addCriterion("recharge_virtual_address =", value, "rechargeVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andRechargeVirtualAddressNotEqualTo(String value) {
            addCriterion("recharge_virtual_address <>", value, "rechargeVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andRechargeVirtualAddressGreaterThan(String value) {
            addCriterion("recharge_virtual_address >", value, "rechargeVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andRechargeVirtualAddressGreaterThanOrEqualTo(String value) {
            addCriterion("recharge_virtual_address >=", value, "rechargeVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andRechargeVirtualAddressLessThan(String value) {
            addCriterion("recharge_virtual_address <", value, "rechargeVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andRechargeVirtualAddressLessThanOrEqualTo(String value) {
            addCriterion("recharge_virtual_address <=", value, "rechargeVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andRechargeVirtualAddressLike(String value) {
            addCriterion("recharge_virtual_address like", value, "rechargeVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andRechargeVirtualAddressNotLike(String value) {
            addCriterion("recharge_virtual_address not like", value, "rechargeVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andRechargeVirtualAddressIn(List<String> values) {
            addCriterion("recharge_virtual_address in", values, "rechargeVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andRechargeVirtualAddressNotIn(List<String> values) {
            addCriterion("recharge_virtual_address not in", values, "rechargeVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andRechargeVirtualAddressBetween(String value1, String value2) {
            addCriterion("recharge_virtual_address between", value1, value2, "rechargeVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andRechargeVirtualAddressNotBetween(String value1, String value2) {
            addCriterion("recharge_virtual_address not between", value1, value2, "rechargeVirtualAddress");
            return (Criteria) this;
        }

        public Criteria andFtradeuniquenumberIsNull() {
            addCriterion("ftradeUniqueNumber is null");
            return (Criteria) this;
        }

        public Criteria andFtradeuniquenumberIsNotNull() {
            addCriterion("ftradeUniqueNumber is not null");
            return (Criteria) this;
        }

        public Criteria andFtradeuniquenumberEqualTo(String value) {
            addCriterion("ftradeUniqueNumber =", value, "ftradeuniquenumber");
            return (Criteria) this;
        }

        public Criteria andFtradeuniquenumberNotEqualTo(String value) {
            addCriterion("ftradeUniqueNumber <>", value, "ftradeuniquenumber");
            return (Criteria) this;
        }

        public Criteria andFtradeuniquenumberGreaterThan(String value) {
            addCriterion("ftradeUniqueNumber >", value, "ftradeuniquenumber");
            return (Criteria) this;
        }

        public Criteria andFtradeuniquenumberGreaterThanOrEqualTo(String value) {
            addCriterion("ftradeUniqueNumber >=", value, "ftradeuniquenumber");
            return (Criteria) this;
        }

        public Criteria andFtradeuniquenumberLessThan(String value) {
            addCriterion("ftradeUniqueNumber <", value, "ftradeuniquenumber");
            return (Criteria) this;
        }

        public Criteria andFtradeuniquenumberLessThanOrEqualTo(String value) {
            addCriterion("ftradeUniqueNumber <=", value, "ftradeuniquenumber");
            return (Criteria) this;
        }

        public Criteria andFtradeuniquenumberLike(String value) {
            addCriterion("ftradeUniqueNumber like", value, "ftradeuniquenumber");
            return (Criteria) this;
        }

        public Criteria andFtradeuniquenumberNotLike(String value) {
            addCriterion("ftradeUniqueNumber not like", value, "ftradeuniquenumber");
            return (Criteria) this;
        }

        public Criteria andFtradeuniquenumberIn(List<String> values) {
            addCriterion("ftradeUniqueNumber in", values, "ftradeuniquenumber");
            return (Criteria) this;
        }

        public Criteria andFtradeuniquenumberNotIn(List<String> values) {
            addCriterion("ftradeUniqueNumber not in", values, "ftradeuniquenumber");
            return (Criteria) this;
        }

        public Criteria andFtradeuniquenumberBetween(String value1, String value2) {
            addCriterion("ftradeUniqueNumber between", value1, value2, "ftradeuniquenumber");
            return (Criteria) this;
        }

        public Criteria andFtradeuniquenumberNotBetween(String value1, String value2) {
            addCriterion("ftradeUniqueNumber not between", value1, value2, "ftradeuniquenumber");
            return (Criteria) this;
        }

        public Criteria andFconfirmationsIsNull() {
            addCriterion("fconfirmations is null");
            return (Criteria) this;
        }

        public Criteria andFconfirmationsIsNotNull() {
            addCriterion("fconfirmations is not null");
            return (Criteria) this;
        }

        public Criteria andFconfirmationsEqualTo(Integer value) {
            addCriterion("fconfirmations =", value, "fconfirmations");
            return (Criteria) this;
        }

        public Criteria andFconfirmationsNotEqualTo(Integer value) {
            addCriterion("fconfirmations <>", value, "fconfirmations");
            return (Criteria) this;
        }

        public Criteria andFconfirmationsGreaterThan(Integer value) {
            addCriterion("fconfirmations >", value, "fconfirmations");
            return (Criteria) this;
        }

        public Criteria andFconfirmationsGreaterThanOrEqualTo(Integer value) {
            addCriterion("fconfirmations >=", value, "fconfirmations");
            return (Criteria) this;
        }

        public Criteria andFconfirmationsLessThan(Integer value) {
            addCriterion("fconfirmations <", value, "fconfirmations");
            return (Criteria) this;
        }

        public Criteria andFconfirmationsLessThanOrEqualTo(Integer value) {
            addCriterion("fconfirmations <=", value, "fconfirmations");
            return (Criteria) this;
        }

        public Criteria andFconfirmationsIn(List<Integer> values) {
            addCriterion("fconfirmations in", values, "fconfirmations");
            return (Criteria) this;
        }

        public Criteria andFconfirmationsNotIn(List<Integer> values) {
            addCriterion("fconfirmations not in", values, "fconfirmations");
            return (Criteria) this;
        }

        public Criteria andFconfirmationsBetween(Integer value1, Integer value2) {
            addCriterion("fconfirmations between", value1, value2, "fconfirmations");
            return (Criteria) this;
        }

        public Criteria andFconfirmationsNotBetween(Integer value1, Integer value2) {
            addCriterion("fconfirmations not between", value1, value2, "fconfirmations");
            return (Criteria) this;
        }

        public Criteria andFhasownerIsNull() {
            addCriterion("fhasOwner is null");
            return (Criteria) this;
        }

        public Criteria andFhasownerIsNotNull() {
            addCriterion("fhasOwner is not null");
            return (Criteria) this;
        }

        public Criteria andFhasownerEqualTo(Boolean value) {
            addCriterion("fhasOwner =", value, "fhasowner");
            return (Criteria) this;
        }

        public Criteria andFhasownerNotEqualTo(Boolean value) {
            addCriterion("fhasOwner <>", value, "fhasowner");
            return (Criteria) this;
        }

        public Criteria andFhasownerGreaterThan(Boolean value) {
            addCriterion("fhasOwner >", value, "fhasowner");
            return (Criteria) this;
        }

        public Criteria andFhasownerGreaterThanOrEqualTo(Boolean value) {
            addCriterion("fhasOwner >=", value, "fhasowner");
            return (Criteria) this;
        }

        public Criteria andFhasownerLessThan(Boolean value) {
            addCriterion("fhasOwner <", value, "fhasowner");
            return (Criteria) this;
        }

        public Criteria andFhasownerLessThanOrEqualTo(Boolean value) {
            addCriterion("fhasOwner <=", value, "fhasowner");
            return (Criteria) this;
        }

        public Criteria andFhasownerIn(List<Boolean> values) {
            addCriterion("fhasOwner in", values, "fhasowner");
            return (Criteria) this;
        }

        public Criteria andFhasownerNotIn(List<Boolean> values) {
            addCriterion("fhasOwner not in", values, "fhasowner");
            return (Criteria) this;
        }

        public Criteria andFhasownerBetween(Boolean value1, Boolean value2) {
            addCriterion("fhasOwner between", value1, value2, "fhasowner");
            return (Criteria) this;
        }

        public Criteria andFhasownerNotBetween(Boolean value1, Boolean value2) {
            addCriterion("fhasOwner not between", value1, value2, "fhasowner");
            return (Criteria) this;
        }

        public Criteria andIshomeshowIsNull() {
            addCriterion("ishomeshow is null");
            return (Criteria) this;
        }

        public Criteria andIshomeshowIsNotNull() {
            addCriterion("ishomeshow is not null");
            return (Criteria) this;
        }

        public Criteria andIshomeshowEqualTo(Boolean value) {
            addCriterion("ishomeshow =", value, "ishomeshow");
            return (Criteria) this;
        }

        public Criteria andIshomeshowNotEqualTo(Boolean value) {
            addCriterion("ishomeshow <>", value, "ishomeshow");
            return (Criteria) this;
        }

        public Criteria andIshomeshowGreaterThan(Boolean value) {
            addCriterion("ishomeshow >", value, "ishomeshow");
            return (Criteria) this;
        }

        public Criteria andIshomeshowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ishomeshow >=", value, "ishomeshow");
            return (Criteria) this;
        }

        public Criteria andIshomeshowLessThan(Boolean value) {
            addCriterion("ishomeshow <", value, "ishomeshow");
            return (Criteria) this;
        }

        public Criteria andIshomeshowLessThanOrEqualTo(Boolean value) {
            addCriterion("ishomeshow <=", value, "ishomeshow");
            return (Criteria) this;
        }

        public Criteria andIshomeshowIn(List<Boolean> values) {
            addCriterion("ishomeshow in", values, "ishomeshow");
            return (Criteria) this;
        }

        public Criteria andIshomeshowNotIn(List<Boolean> values) {
            addCriterion("ishomeshow not in", values, "ishomeshow");
            return (Criteria) this;
        }

        public Criteria andIshomeshowBetween(Boolean value1, Boolean value2) {
            addCriterion("ishomeshow between", value1, value2, "ishomeshow");
            return (Criteria) this;
        }

        public Criteria andIshomeshowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ishomeshow not between", value1, value2, "ishomeshow");
            return (Criteria) this;
        }

        public Criteria andBlockindexIsNull() {
            addCriterion("blockindex is null");
            return (Criteria) this;
        }

        public Criteria andBlockindexIsNotNull() {
            addCriterion("blockindex is not null");
            return (Criteria) this;
        }

        public Criteria andBlockindexEqualTo(Integer value) {
            addCriterion("blockindex =", value, "blockindex");
            return (Criteria) this;
        }

        public Criteria andBlockindexNotEqualTo(Integer value) {
            addCriterion("blockindex <>", value, "blockindex");
            return (Criteria) this;
        }

        public Criteria andBlockindexGreaterThan(Integer value) {
            addCriterion("blockindex >", value, "blockindex");
            return (Criteria) this;
        }

        public Criteria andBlockindexGreaterThanOrEqualTo(Integer value) {
            addCriterion("blockindex >=", value, "blockindex");
            return (Criteria) this;
        }

        public Criteria andBlockindexLessThan(Integer value) {
            addCriterion("blockindex <", value, "blockindex");
            return (Criteria) this;
        }

        public Criteria andBlockindexLessThanOrEqualTo(Integer value) {
            addCriterion("blockindex <=", value, "blockindex");
            return (Criteria) this;
        }

        public Criteria andBlockindexIn(List<Integer> values) {
            addCriterion("blockindex in", values, "blockindex");
            return (Criteria) this;
        }

        public Criteria andBlockindexNotIn(List<Integer> values) {
            addCriterion("blockindex not in", values, "blockindex");
            return (Criteria) this;
        }

        public Criteria andBlockindexBetween(Integer value1, Integer value2) {
            addCriterion("blockindex between", value1, value2, "blockindex");
            return (Criteria) this;
        }

        public Criteria andBlockindexNotBetween(Integer value1, Integer value2) {
            addCriterion("blockindex not between", value1, value2, "blockindex");
            return (Criteria) this;
        }

        public Criteria andIsSystemAccountIsNull() {
            addCriterion("is_system_account is null");
            return (Criteria) this;
        }

        public Criteria andIsSystemAccountIsNotNull() {
            addCriterion("is_system_account is not null");
            return (Criteria) this;
        }

        public Criteria andIsSystemAccountEqualTo(Boolean value) {
            addCriterion("is_system_account =", value, "isSystemAccount");
            return (Criteria) this;
        }

        public Criteria andIsSystemAccountNotEqualTo(Boolean value) {
            addCriterion("is_system_account <>", value, "isSystemAccount");
            return (Criteria) this;
        }

        public Criteria andIsSystemAccountGreaterThan(Boolean value) {
            addCriterion("is_system_account >", value, "isSystemAccount");
            return (Criteria) this;
        }

        public Criteria andIsSystemAccountGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_system_account >=", value, "isSystemAccount");
            return (Criteria) this;
        }

        public Criteria andIsSystemAccountLessThan(Boolean value) {
            addCriterion("is_system_account <", value, "isSystemAccount");
            return (Criteria) this;
        }

        public Criteria andIsSystemAccountLessThanOrEqualTo(Boolean value) {
            addCriterion("is_system_account <=", value, "isSystemAccount");
            return (Criteria) this;
        }

        public Criteria andIsSystemAccountIn(List<Boolean> values) {
            addCriterion("is_system_account in", values, "isSystemAccount");
            return (Criteria) this;
        }

        public Criteria andIsSystemAccountNotIn(List<Boolean> values) {
            addCriterion("is_system_account not in", values, "isSystemAccount");
            return (Criteria) this;
        }

        public Criteria andIsSystemAccountBetween(Boolean value1, Boolean value2) {
            addCriterion("is_system_account between", value1, value2, "isSystemAccount");
            return (Criteria) this;
        }

        public Criteria andIsSystemAccountNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_system_account not between", value1, value2, "isSystemAccount");
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