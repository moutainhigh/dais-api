package com.dais.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CaptualOperationSyncExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CaptualOperationSyncExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCoinNameIsNull() {
            addCriterion("coin_name is null");
            return (Criteria) this;
        }

        public Criteria andCoinNameIsNotNull() {
            addCriterion("coin_name is not null");
            return (Criteria) this;
        }

        public Criteria andCoinNameEqualTo(String value) {
            addCriterion("coin_name =", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameNotEqualTo(String value) {
            addCriterion("coin_name <>", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameGreaterThan(String value) {
            addCriterion("coin_name >", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameGreaterThanOrEqualTo(String value) {
            addCriterion("coin_name >=", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameLessThan(String value) {
            addCriterion("coin_name <", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameLessThanOrEqualTo(String value) {
            addCriterion("coin_name <=", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameLike(String value) {
            addCriterion("coin_name like", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameNotLike(String value) {
            addCriterion("coin_name not like", value, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameIn(List<String> values) {
            addCriterion("coin_name in", values, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameNotIn(List<String> values) {
            addCriterion("coin_name not in", values, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameBetween(String value1, String value2) {
            addCriterion("coin_name between", value1, value2, "coinName");
            return (Criteria) this;
        }

        public Criteria andCoinNameNotBetween(String value1, String value2) {
            addCriterion("coin_name not between", value1, value2, "coinName");
            return (Criteria) this;
        }

        public Criteria andOperationIdIsNull() {
            addCriterion("operation_id is null");
            return (Criteria) this;
        }

        public Criteria andOperationIdIsNotNull() {
            addCriterion("operation_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperationIdEqualTo(Integer value) {
            addCriterion("operation_id =", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotEqualTo(Integer value) {
            addCriterion("operation_id <>", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdGreaterThan(Integer value) {
            addCriterion("operation_id >", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operation_id >=", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdLessThan(Integer value) {
            addCriterion("operation_id <", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdLessThanOrEqualTo(Integer value) {
            addCriterion("operation_id <=", value, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdIn(List<Integer> values) {
            addCriterion("operation_id in", values, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotIn(List<Integer> values) {
            addCriterion("operation_id not in", values, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdBetween(Integer value1, Integer value2) {
            addCriterion("operation_id between", value1, value2, "operationId");
            return (Criteria) this;
        }

        public Criteria andOperationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operation_id not between", value1, value2, "operationId");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andSymbolIsNull() {
            addCriterion("symbol is null");
            return (Criteria) this;
        }

        public Criteria andSymbolIsNotNull() {
            addCriterion("symbol is not null");
            return (Criteria) this;
        }

        public Criteria andSymbolEqualTo(Integer value) {
            addCriterion("symbol =", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotEqualTo(Integer value) {
            addCriterion("symbol <>", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolGreaterThan(Integer value) {
            addCriterion("symbol >", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolGreaterThanOrEqualTo(Integer value) {
            addCriterion("symbol >=", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolLessThan(Integer value) {
            addCriterion("symbol <", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolLessThanOrEqualTo(Integer value) {
            addCriterion("symbol <=", value, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolIn(List<Integer> values) {
            addCriterion("symbol in", values, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotIn(List<Integer> values) {
            addCriterion("symbol not in", values, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolBetween(Integer value1, Integer value2) {
            addCriterion("symbol between", value1, value2, "symbol");
            return (Criteria) this;
        }

        public Criteria andSymbolNotBetween(Integer value1, Integer value2) {
            addCriterion("symbol not between", value1, value2, "symbol");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andFeesIsNull() {
            addCriterion("fees is null");
            return (Criteria) this;
        }

        public Criteria andFeesIsNotNull() {
            addCriterion("fees is not null");
            return (Criteria) this;
        }

        public Criteria andFeesEqualTo(BigDecimal value) {
            addCriterion("fees =", value, "fees");
            return (Criteria) this;
        }

        public Criteria andFeesNotEqualTo(BigDecimal value) {
            addCriterion("fees <>", value, "fees");
            return (Criteria) this;
        }

        public Criteria andFeesGreaterThan(BigDecimal value) {
            addCriterion("fees >", value, "fees");
            return (Criteria) this;
        }

        public Criteria andFeesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fees >=", value, "fees");
            return (Criteria) this;
        }

        public Criteria andFeesLessThan(BigDecimal value) {
            addCriterion("fees <", value, "fees");
            return (Criteria) this;
        }

        public Criteria andFeesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fees <=", value, "fees");
            return (Criteria) this;
        }

        public Criteria andFeesIn(List<BigDecimal> values) {
            addCriterion("fees in", values, "fees");
            return (Criteria) this;
        }

        public Criteria andFeesNotIn(List<BigDecimal> values) {
            addCriterion("fees not in", values, "fees");
            return (Criteria) this;
        }

        public Criteria andFeesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fees between", value1, value2, "fees");
            return (Criteria) this;
        }

        public Criteria andFeesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fees not between", value1, value2, "fees");
            return (Criteria) this;
        }

        public Criteria andOpertionTypeIsNull() {
            addCriterion("opertion_type is null");
            return (Criteria) this;
        }

        public Criteria andOpertionTypeIsNotNull() {
            addCriterion("opertion_type is not null");
            return (Criteria) this;
        }

        public Criteria andOpertionTypeEqualTo(Integer value) {
            addCriterion("opertion_type =", value, "opertionType");
            return (Criteria) this;
        }

        public Criteria andOpertionTypeNotEqualTo(Integer value) {
            addCriterion("opertion_type <>", value, "opertionType");
            return (Criteria) this;
        }

        public Criteria andOpertionTypeGreaterThan(Integer value) {
            addCriterion("opertion_type >", value, "opertionType");
            return (Criteria) this;
        }

        public Criteria andOpertionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("opertion_type >=", value, "opertionType");
            return (Criteria) this;
        }

        public Criteria andOpertionTypeLessThan(Integer value) {
            addCriterion("opertion_type <", value, "opertionType");
            return (Criteria) this;
        }

        public Criteria andOpertionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("opertion_type <=", value, "opertionType");
            return (Criteria) this;
        }

        public Criteria andOpertionTypeIn(List<Integer> values) {
            addCriterion("opertion_type in", values, "opertionType");
            return (Criteria) this;
        }

        public Criteria andOpertionTypeNotIn(List<Integer> values) {
            addCriterion("opertion_type not in", values, "opertionType");
            return (Criteria) this;
        }

        public Criteria andOpertionTypeBetween(Integer value1, Integer value2) {
            addCriterion("opertion_type between", value1, value2, "opertionType");
            return (Criteria) this;
        }

        public Criteria andOpertionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("opertion_type not between", value1, value2, "opertionType");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeIsNull() {
            addCriterion("last_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeIsNotNull() {
            addCriterion("last_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeEqualTo(Date value) {
            addCriterion("last_updatetime =", value, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeNotEqualTo(Date value) {
            addCriterion("last_updatetime <>", value, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeGreaterThan(Date value) {
            addCriterion("last_updatetime >", value, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_updatetime >=", value, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeLessThan(Date value) {
            addCriterion("last_updatetime <", value, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("last_updatetime <=", value, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeIn(List<Date> values) {
            addCriterion("last_updatetime in", values, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeNotIn(List<Date> values) {
            addCriterion("last_updatetime not in", values, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("last_updatetime between", value1, value2, "lastUpdatetime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("last_updatetime not between", value1, value2, "lastUpdatetime");
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "userPhone");
            return (Criteria) this;
        }

        public Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "userPhone");
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