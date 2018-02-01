package com.dais.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FvitualCoinTradeRankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FvitualCoinTradeRankExample() {
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

        public Criteria andHighestBidIsNull() {
            addCriterion("highest_bid is null");
            return (Criteria) this;
        }

        public Criteria andHighestBidIsNotNull() {
            addCriterion("highest_bid is not null");
            return (Criteria) this;
        }

        public Criteria andHighestBidEqualTo(BigDecimal value) {
            addCriterion("highest_bid =", value, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidNotEqualTo(BigDecimal value) {
            addCriterion("highest_bid <>", value, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidGreaterThan(BigDecimal value) {
            addCriterion("highest_bid >", value, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("highest_bid >=", value, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidLessThan(BigDecimal value) {
            addCriterion("highest_bid <", value, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("highest_bid <=", value, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidIn(List<BigDecimal> values) {
            addCriterion("highest_bid in", values, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidNotIn(List<BigDecimal> values) {
            addCriterion("highest_bid not in", values, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("highest_bid between", value1, value2, "highestBid");
            return (Criteria) this;
        }

        public Criteria andHighestBidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("highest_bid not between", value1, value2, "highestBid");
            return (Criteria) this;
        }

        public Criteria andLowestAskIsNull() {
            addCriterion("lowest_ask is null");
            return (Criteria) this;
        }

        public Criteria andLowestAskIsNotNull() {
            addCriterion("lowest_ask is not null");
            return (Criteria) this;
        }

        public Criteria andLowestAskEqualTo(BigDecimal value) {
            addCriterion("lowest_ask =", value, "lowestAsk");
            return (Criteria) this;
        }

        public Criteria andLowestAskNotEqualTo(BigDecimal value) {
            addCriterion("lowest_ask <>", value, "lowestAsk");
            return (Criteria) this;
        }

        public Criteria andLowestAskGreaterThan(BigDecimal value) {
            addCriterion("lowest_ask >", value, "lowestAsk");
            return (Criteria) this;
        }

        public Criteria andLowestAskGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lowest_ask >=", value, "lowestAsk");
            return (Criteria) this;
        }

        public Criteria andLowestAskLessThan(BigDecimal value) {
            addCriterion("lowest_ask <", value, "lowestAsk");
            return (Criteria) this;
        }

        public Criteria andLowestAskLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lowest_ask <=", value, "lowestAsk");
            return (Criteria) this;
        }

        public Criteria andLowestAskIn(List<BigDecimal> values) {
            addCriterion("lowest_ask in", values, "lowestAsk");
            return (Criteria) this;
        }

        public Criteria andLowestAskNotIn(List<BigDecimal> values) {
            addCriterion("lowest_ask not in", values, "lowestAsk");
            return (Criteria) this;
        }

        public Criteria andLowestAskBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lowest_ask between", value1, value2, "lowestAsk");
            return (Criteria) this;
        }

        public Criteria andLowestAskNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lowest_ask not between", value1, value2, "lowestAsk");
            return (Criteria) this;
        }

        public Criteria andLastIsNull() {
            addCriterion("last is null");
            return (Criteria) this;
        }

        public Criteria andLastIsNotNull() {
            addCriterion("last is not null");
            return (Criteria) this;
        }

        public Criteria andLastEqualTo(BigDecimal value) {
            addCriterion("last =", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotEqualTo(BigDecimal value) {
            addCriterion("last <>", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastGreaterThan(BigDecimal value) {
            addCriterion("last >", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("last >=", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastLessThan(BigDecimal value) {
            addCriterion("last <", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastLessThanOrEqualTo(BigDecimal value) {
            addCriterion("last <=", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastIn(List<BigDecimal> values) {
            addCriterion("last in", values, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotIn(List<BigDecimal> values) {
            addCriterion("last not in", values, "last");
            return (Criteria) this;
        }

        public Criteria andLastBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last between", value1, value2, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("last not between", value1, value2, "last");
            return (Criteria) this;
        }

        public Criteria andQuotevolumeIsNull() {
            addCriterion("quoteVolume is null");
            return (Criteria) this;
        }

        public Criteria andQuotevolumeIsNotNull() {
            addCriterion("quoteVolume is not null");
            return (Criteria) this;
        }

        public Criteria andQuotevolumeEqualTo(BigDecimal value) {
            addCriterion("quoteVolume =", value, "quotevolume");
            return (Criteria) this;
        }

        public Criteria andQuotevolumeNotEqualTo(BigDecimal value) {
            addCriterion("quoteVolume <>", value, "quotevolume");
            return (Criteria) this;
        }

        public Criteria andQuotevolumeGreaterThan(BigDecimal value) {
            addCriterion("quoteVolume >", value, "quotevolume");
            return (Criteria) this;
        }

        public Criteria andQuotevolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("quoteVolume >=", value, "quotevolume");
            return (Criteria) this;
        }

        public Criteria andQuotevolumeLessThan(BigDecimal value) {
            addCriterion("quoteVolume <", value, "quotevolume");
            return (Criteria) this;
        }

        public Criteria andQuotevolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("quoteVolume <=", value, "quotevolume");
            return (Criteria) this;
        }

        public Criteria andQuotevolumeIn(List<BigDecimal> values) {
            addCriterion("quoteVolume in", values, "quotevolume");
            return (Criteria) this;
        }

        public Criteria andQuotevolumeNotIn(List<BigDecimal> values) {
            addCriterion("quoteVolume not in", values, "quotevolume");
            return (Criteria) this;
        }

        public Criteria andQuotevolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("quoteVolume between", value1, value2, "quotevolume");
            return (Criteria) this;
        }

        public Criteria andQuotevolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("quoteVolume not between", value1, value2, "quotevolume");
            return (Criteria) this;
        }

        public Criteria andBasevolumeIsNull() {
            addCriterion("baseVolume is null");
            return (Criteria) this;
        }

        public Criteria andBasevolumeIsNotNull() {
            addCriterion("baseVolume is not null");
            return (Criteria) this;
        }

        public Criteria andBasevolumeEqualTo(BigDecimal value) {
            addCriterion("baseVolume =", value, "basevolume");
            return (Criteria) this;
        }

        public Criteria andBasevolumeNotEqualTo(BigDecimal value) {
            addCriterion("baseVolume <>", value, "basevolume");
            return (Criteria) this;
        }

        public Criteria andBasevolumeGreaterThan(BigDecimal value) {
            addCriterion("baseVolume >", value, "basevolume");
            return (Criteria) this;
        }

        public Criteria andBasevolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("baseVolume >=", value, "basevolume");
            return (Criteria) this;
        }

        public Criteria andBasevolumeLessThan(BigDecimal value) {
            addCriterion("baseVolume <", value, "basevolume");
            return (Criteria) this;
        }

        public Criteria andBasevolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("baseVolume <=", value, "basevolume");
            return (Criteria) this;
        }

        public Criteria andBasevolumeIn(List<BigDecimal> values) {
            addCriterion("baseVolume in", values, "basevolume");
            return (Criteria) this;
        }

        public Criteria andBasevolumeNotIn(List<BigDecimal> values) {
            addCriterion("baseVolume not in", values, "basevolume");
            return (Criteria) this;
        }

        public Criteria andBasevolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("baseVolume between", value1, value2, "basevolume");
            return (Criteria) this;
        }

        public Criteria andBasevolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("baseVolume not between", value1, value2, "basevolume");
            return (Criteria) this;
        }

        public Criteria andLow24hrIsNull() {
            addCriterion("low24hr is null");
            return (Criteria) this;
        }

        public Criteria andLow24hrIsNotNull() {
            addCriterion("low24hr is not null");
            return (Criteria) this;
        }

        public Criteria andLow24hrEqualTo(BigDecimal value) {
            addCriterion("low24hr =", value, "low24hr");
            return (Criteria) this;
        }

        public Criteria andLow24hrNotEqualTo(BigDecimal value) {
            addCriterion("low24hr <>", value, "low24hr");
            return (Criteria) this;
        }

        public Criteria andLow24hrGreaterThan(BigDecimal value) {
            addCriterion("low24hr >", value, "low24hr");
            return (Criteria) this;
        }

        public Criteria andLow24hrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("low24hr >=", value, "low24hr");
            return (Criteria) this;
        }

        public Criteria andLow24hrLessThan(BigDecimal value) {
            addCriterion("low24hr <", value, "low24hr");
            return (Criteria) this;
        }

        public Criteria andLow24hrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("low24hr <=", value, "low24hr");
            return (Criteria) this;
        }

        public Criteria andLow24hrIn(List<BigDecimal> values) {
            addCriterion("low24hr in", values, "low24hr");
            return (Criteria) this;
        }

        public Criteria andLow24hrNotIn(List<BigDecimal> values) {
            addCriterion("low24hr not in", values, "low24hr");
            return (Criteria) this;
        }

        public Criteria andLow24hrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("low24hr between", value1, value2, "low24hr");
            return (Criteria) this;
        }

        public Criteria andLow24hrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("low24hr not between", value1, value2, "low24hr");
            return (Criteria) this;
        }

        public Criteria andHigh24hrIsNull() {
            addCriterion("high24hr is null");
            return (Criteria) this;
        }

        public Criteria andHigh24hrIsNotNull() {
            addCriterion("high24hr is not null");
            return (Criteria) this;
        }

        public Criteria andHigh24hrEqualTo(BigDecimal value) {
            addCriterion("high24hr =", value, "high24hr");
            return (Criteria) this;
        }

        public Criteria andHigh24hrNotEqualTo(BigDecimal value) {
            addCriterion("high24hr <>", value, "high24hr");
            return (Criteria) this;
        }

        public Criteria andHigh24hrGreaterThan(BigDecimal value) {
            addCriterion("high24hr >", value, "high24hr");
            return (Criteria) this;
        }

        public Criteria andHigh24hrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("high24hr >=", value, "high24hr");
            return (Criteria) this;
        }

        public Criteria andHigh24hrLessThan(BigDecimal value) {
            addCriterion("high24hr <", value, "high24hr");
            return (Criteria) this;
        }

        public Criteria andHigh24hrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("high24hr <=", value, "high24hr");
            return (Criteria) this;
        }

        public Criteria andHigh24hrIn(List<BigDecimal> values) {
            addCriterion("high24hr in", values, "high24hr");
            return (Criteria) this;
        }

        public Criteria andHigh24hrNotIn(List<BigDecimal> values) {
            addCriterion("high24hr not in", values, "high24hr");
            return (Criteria) this;
        }

        public Criteria andHigh24hrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("high24hr between", value1, value2, "high24hr");
            return (Criteria) this;
        }

        public Criteria andHigh24hrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("high24hr not between", value1, value2, "high24hr");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNull() {
            addCriterion("trade_time is null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIsNotNull() {
            addCriterion("trade_time is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTimeEqualTo(Integer value) {
            addCriterion("trade_time =", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotEqualTo(Integer value) {
            addCriterion("trade_time <>", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThan(Integer value) {
            addCriterion("trade_time >", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("trade_time >=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThan(Integer value) {
            addCriterion("trade_time <", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeLessThanOrEqualTo(Integer value) {
            addCriterion("trade_time <=", value, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeIn(List<Integer> values) {
            addCriterion("trade_time in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotIn(List<Integer> values) {
            addCriterion("trade_time not in", values, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeBetween(Integer value1, Integer value2) {
            addCriterion("trade_time between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andTradeTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("trade_time not between", value1, value2, "tradeTime");
            return (Criteria) this;
        }

        public Criteria andPercentChangeIsNull() {
            addCriterion("percent_change is null");
            return (Criteria) this;
        }

        public Criteria andPercentChangeIsNotNull() {
            addCriterion("percent_change is not null");
            return (Criteria) this;
        }

        public Criteria andPercentChangeEqualTo(BigDecimal value) {
            addCriterion("percent_change =", value, "percentChange");
            return (Criteria) this;
        }

        public Criteria andPercentChangeNotEqualTo(BigDecimal value) {
            addCriterion("percent_change <>", value, "percentChange");
            return (Criteria) this;
        }

        public Criteria andPercentChangeGreaterThan(BigDecimal value) {
            addCriterion("percent_change >", value, "percentChange");
            return (Criteria) this;
        }

        public Criteria andPercentChangeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("percent_change >=", value, "percentChange");
            return (Criteria) this;
        }

        public Criteria andPercentChangeLessThan(BigDecimal value) {
            addCriterion("percent_change <", value, "percentChange");
            return (Criteria) this;
        }

        public Criteria andPercentChangeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("percent_change <=", value, "percentChange");
            return (Criteria) this;
        }

        public Criteria andPercentChangeIn(List<BigDecimal> values) {
            addCriterion("percent_change in", values, "percentChange");
            return (Criteria) this;
        }

        public Criteria andPercentChangeNotIn(List<BigDecimal> values) {
            addCriterion("percent_change not in", values, "percentChange");
            return (Criteria) this;
        }

        public Criteria andPercentChangeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("percent_change between", value1, value2, "percentChange");
            return (Criteria) this;
        }

        public Criteria andPercentChangeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("percent_change not between", value1, value2, "percentChange");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIsNull() {
            addCriterion("coin_type is null");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIsNotNull() {
            addCriterion("coin_type is not null");
            return (Criteria) this;
        }

        public Criteria andCoinTypeEqualTo(String value) {
            addCriterion("coin_type =", value, "coinType");
            return (Criteria) this;
        }

        public Criteria andCoinTypeNotEqualTo(String value) {
            addCriterion("coin_type <>", value, "coinType");
            return (Criteria) this;
        }

        public Criteria andCoinTypeGreaterThan(String value) {
            addCriterion("coin_type >", value, "coinType");
            return (Criteria) this;
        }

        public Criteria andCoinTypeGreaterThanOrEqualTo(String value) {
            addCriterion("coin_type >=", value, "coinType");
            return (Criteria) this;
        }

        public Criteria andCoinTypeLessThan(String value) {
            addCriterion("coin_type <", value, "coinType");
            return (Criteria) this;
        }

        public Criteria andCoinTypeLessThanOrEqualTo(String value) {
            addCriterion("coin_type <=", value, "coinType");
            return (Criteria) this;
        }

        public Criteria andCoinTypeLike(String value) {
            addCriterion("coin_type like", value, "coinType");
            return (Criteria) this;
        }

        public Criteria andCoinTypeNotLike(String value) {
            addCriterion("coin_type not like", value, "coinType");
            return (Criteria) this;
        }

        public Criteria andCoinTypeIn(List<String> values) {
            addCriterion("coin_type in", values, "coinType");
            return (Criteria) this;
        }

        public Criteria andCoinTypeNotIn(List<String> values) {
            addCriterion("coin_type not in", values, "coinType");
            return (Criteria) this;
        }

        public Criteria andCoinTypeBetween(String value1, String value2) {
            addCriterion("coin_type between", value1, value2, "coinType");
            return (Criteria) this;
        }

        public Criteria andCoinTypeNotBetween(String value1, String value2) {
            addCriterion("coin_type not between", value1, value2, "coinType");
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