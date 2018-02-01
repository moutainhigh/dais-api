package com.dais.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FvirtualcointypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FvirtualcointypeExample() {
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

        public Criteria andParentidIsNull() {
            addCriterion("parentid is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentid is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("parentid =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("parentid <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("parentid >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentid >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("parentid <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("parentid <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("parentid in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("parentid not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("parentid between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentid not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andFnameIsNull() {
            addCriterion("fName is null");
            return (Criteria) this;
        }

        public Criteria andFnameIsNotNull() {
            addCriterion("fName is not null");
            return (Criteria) this;
        }

        public Criteria andFnameEqualTo(String value) {
            addCriterion("fName =", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotEqualTo(String value) {
            addCriterion("fName <>", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThan(String value) {
            addCriterion("fName >", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThanOrEqualTo(String value) {
            addCriterion("fName >=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThan(String value) {
            addCriterion("fName <", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThanOrEqualTo(String value) {
            addCriterion("fName <=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLike(String value) {
            addCriterion("fName like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotLike(String value) {
            addCriterion("fName not like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameIn(List<String> values) {
            addCriterion("fName in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotIn(List<String> values) {
            addCriterion("fName not in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameBetween(String value1, String value2) {
            addCriterion("fName between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotBetween(String value1, String value2) {
            addCriterion("fName not between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFshortnameIsNull() {
            addCriterion("fShortName is null");
            return (Criteria) this;
        }

        public Criteria andFshortnameIsNotNull() {
            addCriterion("fShortName is not null");
            return (Criteria) this;
        }

        public Criteria andFshortnameEqualTo(String value) {
            addCriterion("fShortName =", value, "fshortname");
            return (Criteria) this;
        }

        public Criteria andFshortnameNotEqualTo(String value) {
            addCriterion("fShortName <>", value, "fshortname");
            return (Criteria) this;
        }

        public Criteria andFshortnameGreaterThan(String value) {
            addCriterion("fShortName >", value, "fshortname");
            return (Criteria) this;
        }

        public Criteria andFshortnameGreaterThanOrEqualTo(String value) {
            addCriterion("fShortName >=", value, "fshortname");
            return (Criteria) this;
        }

        public Criteria andFshortnameLessThan(String value) {
            addCriterion("fShortName <", value, "fshortname");
            return (Criteria) this;
        }

        public Criteria andFshortnameLessThanOrEqualTo(String value) {
            addCriterion("fShortName <=", value, "fshortname");
            return (Criteria) this;
        }

        public Criteria andFshortnameLike(String value) {
            addCriterion("fShortName like", value, "fshortname");
            return (Criteria) this;
        }

        public Criteria andFshortnameNotLike(String value) {
            addCriterion("fShortName not like", value, "fshortname");
            return (Criteria) this;
        }

        public Criteria andFshortnameIn(List<String> values) {
            addCriterion("fShortName in", values, "fshortname");
            return (Criteria) this;
        }

        public Criteria andFshortnameNotIn(List<String> values) {
            addCriterion("fShortName not in", values, "fshortname");
            return (Criteria) this;
        }

        public Criteria andFshortnameBetween(String value1, String value2) {
            addCriterion("fShortName between", value1, value2, "fshortname");
            return (Criteria) this;
        }

        public Criteria andFshortnameNotBetween(String value1, String value2) {
            addCriterion("fShortName not between", value1, value2, "fshortname");
            return (Criteria) this;
        }

        public Criteria andFdescriptionIsNull() {
            addCriterion("fDescription is null");
            return (Criteria) this;
        }

        public Criteria andFdescriptionIsNotNull() {
            addCriterion("fDescription is not null");
            return (Criteria) this;
        }

        public Criteria andFdescriptionEqualTo(String value) {
            addCriterion("fDescription =", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionNotEqualTo(String value) {
            addCriterion("fDescription <>", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionGreaterThan(String value) {
            addCriterion("fDescription >", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("fDescription >=", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionLessThan(String value) {
            addCriterion("fDescription <", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionLessThanOrEqualTo(String value) {
            addCriterion("fDescription <=", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionLike(String value) {
            addCriterion("fDescription like", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionNotLike(String value) {
            addCriterion("fDescription not like", value, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionIn(List<String> values) {
            addCriterion("fDescription in", values, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionNotIn(List<String> values) {
            addCriterion("fDescription not in", values, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionBetween(String value1, String value2) {
            addCriterion("fDescription between", value1, value2, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFdescriptionNotBetween(String value1, String value2) {
            addCriterion("fDescription not between", value1, value2, "fdescription");
            return (Criteria) this;
        }

        public Criteria andFaddtimeIsNull() {
            addCriterion("fAddTime is null");
            return (Criteria) this;
        }

        public Criteria andFaddtimeIsNotNull() {
            addCriterion("fAddTime is not null");
            return (Criteria) this;
        }

        public Criteria andFaddtimeEqualTo(Date value) {
            addCriterion("fAddTime =", value, "faddtime");
            return (Criteria) this;
        }

        public Criteria andFaddtimeNotEqualTo(Date value) {
            addCriterion("fAddTime <>", value, "faddtime");
            return (Criteria) this;
        }

        public Criteria andFaddtimeGreaterThan(Date value) {
            addCriterion("fAddTime >", value, "faddtime");
            return (Criteria) this;
        }

        public Criteria andFaddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fAddTime >=", value, "faddtime");
            return (Criteria) this;
        }

        public Criteria andFaddtimeLessThan(Date value) {
            addCriterion("fAddTime <", value, "faddtime");
            return (Criteria) this;
        }

        public Criteria andFaddtimeLessThanOrEqualTo(Date value) {
            addCriterion("fAddTime <=", value, "faddtime");
            return (Criteria) this;
        }

        public Criteria andFaddtimeIn(List<Date> values) {
            addCriterion("fAddTime in", values, "faddtime");
            return (Criteria) this;
        }

        public Criteria andFaddtimeNotIn(List<Date> values) {
            addCriterion("fAddTime not in", values, "faddtime");
            return (Criteria) this;
        }

        public Criteria andFaddtimeBetween(Date value1, Date value2) {
            addCriterion("fAddTime between", value1, value2, "faddtime");
            return (Criteria) this;
        }

        public Criteria andFaddtimeNotBetween(Date value1, Date value2) {
            addCriterion("fAddTime not between", value1, value2, "faddtime");
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

        public Criteria andFsymbolIsNull() {
            addCriterion("fSymbol is null");
            return (Criteria) this;
        }

        public Criteria andFsymbolIsNotNull() {
            addCriterion("fSymbol is not null");
            return (Criteria) this;
        }

        public Criteria andFsymbolEqualTo(String value) {
            addCriterion("fSymbol =", value, "fsymbol");
            return (Criteria) this;
        }

        public Criteria andFsymbolNotEqualTo(String value) {
            addCriterion("fSymbol <>", value, "fsymbol");
            return (Criteria) this;
        }

        public Criteria andFsymbolGreaterThan(String value) {
            addCriterion("fSymbol >", value, "fsymbol");
            return (Criteria) this;
        }

        public Criteria andFsymbolGreaterThanOrEqualTo(String value) {
            addCriterion("fSymbol >=", value, "fsymbol");
            return (Criteria) this;
        }

        public Criteria andFsymbolLessThan(String value) {
            addCriterion("fSymbol <", value, "fsymbol");
            return (Criteria) this;
        }

        public Criteria andFsymbolLessThanOrEqualTo(String value) {
            addCriterion("fSymbol <=", value, "fsymbol");
            return (Criteria) this;
        }

        public Criteria andFsymbolLike(String value) {
            addCriterion("fSymbol like", value, "fsymbol");
            return (Criteria) this;
        }

        public Criteria andFsymbolNotLike(String value) {
            addCriterion("fSymbol not like", value, "fsymbol");
            return (Criteria) this;
        }

        public Criteria andFsymbolIn(List<String> values) {
            addCriterion("fSymbol in", values, "fsymbol");
            return (Criteria) this;
        }

        public Criteria andFsymbolNotIn(List<String> values) {
            addCriterion("fSymbol not in", values, "fsymbol");
            return (Criteria) this;
        }

        public Criteria andFsymbolBetween(String value1, String value2) {
            addCriterion("fSymbol between", value1, value2, "fsymbol");
            return (Criteria) this;
        }

        public Criteria andFsymbolNotBetween(String value1, String value2) {
            addCriterion("fSymbol not between", value1, value2, "fsymbol");
            return (Criteria) this;
        }

        public Criteria andFaccessKeyIsNull() {
            addCriterion("faccess_key is null");
            return (Criteria) this;
        }

        public Criteria andFaccessKeyIsNotNull() {
            addCriterion("faccess_key is not null");
            return (Criteria) this;
        }

        public Criteria andFaccessKeyEqualTo(String value) {
            addCriterion("faccess_key =", value, "faccessKey");
            return (Criteria) this;
        }

        public Criteria andFaccessKeyNotEqualTo(String value) {
            addCriterion("faccess_key <>", value, "faccessKey");
            return (Criteria) this;
        }

        public Criteria andFaccessKeyGreaterThan(String value) {
            addCriterion("faccess_key >", value, "faccessKey");
            return (Criteria) this;
        }

        public Criteria andFaccessKeyGreaterThanOrEqualTo(String value) {
            addCriterion("faccess_key >=", value, "faccessKey");
            return (Criteria) this;
        }

        public Criteria andFaccessKeyLessThan(String value) {
            addCriterion("faccess_key <", value, "faccessKey");
            return (Criteria) this;
        }

        public Criteria andFaccessKeyLessThanOrEqualTo(String value) {
            addCriterion("faccess_key <=", value, "faccessKey");
            return (Criteria) this;
        }

        public Criteria andFaccessKeyLike(String value) {
            addCriterion("faccess_key like", value, "faccessKey");
            return (Criteria) this;
        }

        public Criteria andFaccessKeyNotLike(String value) {
            addCriterion("faccess_key not like", value, "faccessKey");
            return (Criteria) this;
        }

        public Criteria andFaccessKeyIn(List<String> values) {
            addCriterion("faccess_key in", values, "faccessKey");
            return (Criteria) this;
        }

        public Criteria andFaccessKeyNotIn(List<String> values) {
            addCriterion("faccess_key not in", values, "faccessKey");
            return (Criteria) this;
        }

        public Criteria andFaccessKeyBetween(String value1, String value2) {
            addCriterion("faccess_key between", value1, value2, "faccessKey");
            return (Criteria) this;
        }

        public Criteria andFaccessKeyNotBetween(String value1, String value2) {
            addCriterion("faccess_key not between", value1, value2, "faccessKey");
            return (Criteria) this;
        }

        public Criteria andFsecrtKeyIsNull() {
            addCriterion("fsecrt_key is null");
            return (Criteria) this;
        }

        public Criteria andFsecrtKeyIsNotNull() {
            addCriterion("fsecrt_key is not null");
            return (Criteria) this;
        }

        public Criteria andFsecrtKeyEqualTo(String value) {
            addCriterion("fsecrt_key =", value, "fsecrtKey");
            return (Criteria) this;
        }

        public Criteria andFsecrtKeyNotEqualTo(String value) {
            addCriterion("fsecrt_key <>", value, "fsecrtKey");
            return (Criteria) this;
        }

        public Criteria andFsecrtKeyGreaterThan(String value) {
            addCriterion("fsecrt_key >", value, "fsecrtKey");
            return (Criteria) this;
        }

        public Criteria andFsecrtKeyGreaterThanOrEqualTo(String value) {
            addCriterion("fsecrt_key >=", value, "fsecrtKey");
            return (Criteria) this;
        }

        public Criteria andFsecrtKeyLessThan(String value) {
            addCriterion("fsecrt_key <", value, "fsecrtKey");
            return (Criteria) this;
        }

        public Criteria andFsecrtKeyLessThanOrEqualTo(String value) {
            addCriterion("fsecrt_key <=", value, "fsecrtKey");
            return (Criteria) this;
        }

        public Criteria andFsecrtKeyLike(String value) {
            addCriterion("fsecrt_key like", value, "fsecrtKey");
            return (Criteria) this;
        }

        public Criteria andFsecrtKeyNotLike(String value) {
            addCriterion("fsecrt_key not like", value, "fsecrtKey");
            return (Criteria) this;
        }

        public Criteria andFsecrtKeyIn(List<String> values) {
            addCriterion("fsecrt_key in", values, "fsecrtKey");
            return (Criteria) this;
        }

        public Criteria andFsecrtKeyNotIn(List<String> values) {
            addCriterion("fsecrt_key not in", values, "fsecrtKey");
            return (Criteria) this;
        }

        public Criteria andFsecrtKeyBetween(String value1, String value2) {
            addCriterion("fsecrt_key between", value1, value2, "fsecrtKey");
            return (Criteria) this;
        }

        public Criteria andFsecrtKeyNotBetween(String value1, String value2) {
            addCriterion("fsecrt_key not between", value1, value2, "fsecrtKey");
            return (Criteria) this;
        }

        public Criteria andFipIsNull() {
            addCriterion("fip is null");
            return (Criteria) this;
        }

        public Criteria andFipIsNotNull() {
            addCriterion("fip is not null");
            return (Criteria) this;
        }

        public Criteria andFipEqualTo(String value) {
            addCriterion("fip =", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipNotEqualTo(String value) {
            addCriterion("fip <>", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipGreaterThan(String value) {
            addCriterion("fip >", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipGreaterThanOrEqualTo(String value) {
            addCriterion("fip >=", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipLessThan(String value) {
            addCriterion("fip <", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipLessThanOrEqualTo(String value) {
            addCriterion("fip <=", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipLike(String value) {
            addCriterion("fip like", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipNotLike(String value) {
            addCriterion("fip not like", value, "fip");
            return (Criteria) this;
        }

        public Criteria andFipIn(List<String> values) {
            addCriterion("fip in", values, "fip");
            return (Criteria) this;
        }

        public Criteria andFipNotIn(List<String> values) {
            addCriterion("fip not in", values, "fip");
            return (Criteria) this;
        }

        public Criteria andFipBetween(String value1, String value2) {
            addCriterion("fip between", value1, value2, "fip");
            return (Criteria) this;
        }

        public Criteria andFipNotBetween(String value1, String value2) {
            addCriterion("fip not between", value1, value2, "fip");
            return (Criteria) this;
        }

        public Criteria andFportIsNull() {
            addCriterion("fport is null");
            return (Criteria) this;
        }

        public Criteria andFportIsNotNull() {
            addCriterion("fport is not null");
            return (Criteria) this;
        }

        public Criteria andFportEqualTo(String value) {
            addCriterion("fport =", value, "fport");
            return (Criteria) this;
        }

        public Criteria andFportNotEqualTo(String value) {
            addCriterion("fport <>", value, "fport");
            return (Criteria) this;
        }

        public Criteria andFportGreaterThan(String value) {
            addCriterion("fport >", value, "fport");
            return (Criteria) this;
        }

        public Criteria andFportGreaterThanOrEqualTo(String value) {
            addCriterion("fport >=", value, "fport");
            return (Criteria) this;
        }

        public Criteria andFportLessThan(String value) {
            addCriterion("fport <", value, "fport");
            return (Criteria) this;
        }

        public Criteria andFportLessThanOrEqualTo(String value) {
            addCriterion("fport <=", value, "fport");
            return (Criteria) this;
        }

        public Criteria andFportLike(String value) {
            addCriterion("fport like", value, "fport");
            return (Criteria) this;
        }

        public Criteria andFportNotLike(String value) {
            addCriterion("fport not like", value, "fport");
            return (Criteria) this;
        }

        public Criteria andFportIn(List<String> values) {
            addCriterion("fport in", values, "fport");
            return (Criteria) this;
        }

        public Criteria andFportNotIn(List<String> values) {
            addCriterion("fport not in", values, "fport");
            return (Criteria) this;
        }

        public Criteria andFportBetween(String value1, String value2) {
            addCriterion("fport between", value1, value2, "fport");
            return (Criteria) this;
        }

        public Criteria andFportNotBetween(String value1, String value2) {
            addCriterion("fport not between", value1, value2, "fport");
            return (Criteria) this;
        }

        public Criteria andFisshareIsNull() {
            addCriterion("FIsShare is null");
            return (Criteria) this;
        }

        public Criteria andFisshareIsNotNull() {
            addCriterion("FIsShare is not null");
            return (Criteria) this;
        }

        public Criteria andFisshareEqualTo(Boolean value) {
            addCriterion("FIsShare =", value, "fisshare");
            return (Criteria) this;
        }

        public Criteria andFisshareNotEqualTo(Boolean value) {
            addCriterion("FIsShare <>", value, "fisshare");
            return (Criteria) this;
        }

        public Criteria andFisshareGreaterThan(Boolean value) {
            addCriterion("FIsShare >", value, "fisshare");
            return (Criteria) this;
        }

        public Criteria andFisshareGreaterThanOrEqualTo(Boolean value) {
            addCriterion("FIsShare >=", value, "fisshare");
            return (Criteria) this;
        }

        public Criteria andFisshareLessThan(Boolean value) {
            addCriterion("FIsShare <", value, "fisshare");
            return (Criteria) this;
        }

        public Criteria andFisshareLessThanOrEqualTo(Boolean value) {
            addCriterion("FIsShare <=", value, "fisshare");
            return (Criteria) this;
        }

        public Criteria andFisshareIn(List<Boolean> values) {
            addCriterion("FIsShare in", values, "fisshare");
            return (Criteria) this;
        }

        public Criteria andFisshareNotIn(List<Boolean> values) {
            addCriterion("FIsShare not in", values, "fisshare");
            return (Criteria) this;
        }

        public Criteria andFisshareBetween(Boolean value1, Boolean value2) {
            addCriterion("FIsShare between", value1, value2, "fisshare");
            return (Criteria) this;
        }

        public Criteria andFisshareNotBetween(Boolean value1, Boolean value2) {
            addCriterion("FIsShare not between", value1, value2, "fisshare");
            return (Criteria) this;
        }

        public Criteria andFiswithdrawIsNull() {
            addCriterion("FIsWithDraw is null");
            return (Criteria) this;
        }

        public Criteria andFiswithdrawIsNotNull() {
            addCriterion("FIsWithDraw is not null");
            return (Criteria) this;
        }

        public Criteria andFiswithdrawEqualTo(Boolean value) {
            addCriterion("FIsWithDraw =", value, "fiswithdraw");
            return (Criteria) this;
        }

        public Criteria andFiswithdrawNotEqualTo(Boolean value) {
            addCriterion("FIsWithDraw <>", value, "fiswithdraw");
            return (Criteria) this;
        }

        public Criteria andFiswithdrawGreaterThan(Boolean value) {
            addCriterion("FIsWithDraw >", value, "fiswithdraw");
            return (Criteria) this;
        }

        public Criteria andFiswithdrawGreaterThanOrEqualTo(Boolean value) {
            addCriterion("FIsWithDraw >=", value, "fiswithdraw");
            return (Criteria) this;
        }

        public Criteria andFiswithdrawLessThan(Boolean value) {
            addCriterion("FIsWithDraw <", value, "fiswithdraw");
            return (Criteria) this;
        }

        public Criteria andFiswithdrawLessThanOrEqualTo(Boolean value) {
            addCriterion("FIsWithDraw <=", value, "fiswithdraw");
            return (Criteria) this;
        }

        public Criteria andFiswithdrawIn(List<Boolean> values) {
            addCriterion("FIsWithDraw in", values, "fiswithdraw");
            return (Criteria) this;
        }

        public Criteria andFiswithdrawNotIn(List<Boolean> values) {
            addCriterion("FIsWithDraw not in", values, "fiswithdraw");
            return (Criteria) this;
        }

        public Criteria andFiswithdrawBetween(Boolean value1, Boolean value2) {
            addCriterion("FIsWithDraw between", value1, value2, "fiswithdraw");
            return (Criteria) this;
        }

        public Criteria andFiswithdrawNotBetween(Boolean value1, Boolean value2) {
            addCriterion("FIsWithDraw not between", value1, value2, "fiswithdraw");
            return (Criteria) this;
        }

        public Criteria andFurlIsNull() {
            addCriterion("furl is null");
            return (Criteria) this;
        }

        public Criteria andFurlIsNotNull() {
            addCriterion("furl is not null");
            return (Criteria) this;
        }

        public Criteria andFurlEqualTo(String value) {
            addCriterion("furl =", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlNotEqualTo(String value) {
            addCriterion("furl <>", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlGreaterThan(String value) {
            addCriterion("furl >", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlGreaterThanOrEqualTo(String value) {
            addCriterion("furl >=", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlLessThan(String value) {
            addCriterion("furl <", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlLessThanOrEqualTo(String value) {
            addCriterion("furl <=", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlLike(String value) {
            addCriterion("furl like", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlNotLike(String value) {
            addCriterion("furl not like", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlIn(List<String> values) {
            addCriterion("furl in", values, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlNotIn(List<String> values) {
            addCriterion("furl not in", values, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlBetween(String value1, String value2) {
            addCriterion("furl between", value1, value2, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlNotBetween(String value1, String value2) {
            addCriterion("furl not between", value1, value2, "furl");
            return (Criteria) this;
        }

        public Criteria andFintrourlIsNull() {
            addCriterion("fintroUrl is null");
            return (Criteria) this;
        }

        public Criteria andFintrourlIsNotNull() {
            addCriterion("fintroUrl is not null");
            return (Criteria) this;
        }

        public Criteria andFintrourlEqualTo(String value) {
            addCriterion("fintroUrl =", value, "fintrourl");
            return (Criteria) this;
        }

        public Criteria andFintrourlNotEqualTo(String value) {
            addCriterion("fintroUrl <>", value, "fintrourl");
            return (Criteria) this;
        }

        public Criteria andFintrourlGreaterThan(String value) {
            addCriterion("fintroUrl >", value, "fintrourl");
            return (Criteria) this;
        }

        public Criteria andFintrourlGreaterThanOrEqualTo(String value) {
            addCriterion("fintroUrl >=", value, "fintrourl");
            return (Criteria) this;
        }

        public Criteria andFintrourlLessThan(String value) {
            addCriterion("fintroUrl <", value, "fintrourl");
            return (Criteria) this;
        }

        public Criteria andFintrourlLessThanOrEqualTo(String value) {
            addCriterion("fintroUrl <=", value, "fintrourl");
            return (Criteria) this;
        }

        public Criteria andFintrourlLike(String value) {
            addCriterion("fintroUrl like", value, "fintrourl");
            return (Criteria) this;
        }

        public Criteria andFintrourlNotLike(String value) {
            addCriterion("fintroUrl not like", value, "fintrourl");
            return (Criteria) this;
        }

        public Criteria andFintrourlIn(List<String> values) {
            addCriterion("fintroUrl in", values, "fintrourl");
            return (Criteria) this;
        }

        public Criteria andFintrourlNotIn(List<String> values) {
            addCriterion("fintroUrl not in", values, "fintrourl");
            return (Criteria) this;
        }

        public Criteria andFintrourlBetween(String value1, String value2) {
            addCriterion("fintroUrl between", value1, value2, "fintrourl");
            return (Criteria) this;
        }

        public Criteria andFintrourlNotBetween(String value1, String value2) {
            addCriterion("fintroUrl not between", value1, value2, "fintrourl");
            return (Criteria) this;
        }

        public Criteria andFopenpriceIsNull() {
            addCriterion("fopenPrice is null");
            return (Criteria) this;
        }

        public Criteria andFopenpriceIsNotNull() {
            addCriterion("fopenPrice is not null");
            return (Criteria) this;
        }

        public Criteria andFopenpriceEqualTo(BigDecimal value) {
            addCriterion("fopenPrice =", value, "fopenprice");
            return (Criteria) this;
        }

        public Criteria andFopenpriceNotEqualTo(BigDecimal value) {
            addCriterion("fopenPrice <>", value, "fopenprice");
            return (Criteria) this;
        }

        public Criteria andFopenpriceGreaterThan(BigDecimal value) {
            addCriterion("fopenPrice >", value, "fopenprice");
            return (Criteria) this;
        }

        public Criteria andFopenpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fopenPrice >=", value, "fopenprice");
            return (Criteria) this;
        }

        public Criteria andFopenpriceLessThan(BigDecimal value) {
            addCriterion("fopenPrice <", value, "fopenprice");
            return (Criteria) this;
        }

        public Criteria andFopenpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fopenPrice <=", value, "fopenprice");
            return (Criteria) this;
        }

        public Criteria andFopenpriceIn(List<BigDecimal> values) {
            addCriterion("fopenPrice in", values, "fopenprice");
            return (Criteria) this;
        }

        public Criteria andFopenpriceNotIn(List<BigDecimal> values) {
            addCriterion("fopenPrice not in", values, "fopenprice");
            return (Criteria) this;
        }

        public Criteria andFopenpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fopenPrice between", value1, value2, "fopenprice");
            return (Criteria) this;
        }

        public Criteria andFopenpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fopenPrice not between", value1, value2, "fopenprice");
            return (Criteria) this;
        }

        public Criteria andFtotalamountIsNull() {
            addCriterion("ftotalAmount is null");
            return (Criteria) this;
        }

        public Criteria andFtotalamountIsNotNull() {
            addCriterion("ftotalAmount is not null");
            return (Criteria) this;
        }

        public Criteria andFtotalamountEqualTo(BigDecimal value) {
            addCriterion("ftotalAmount =", value, "ftotalamount");
            return (Criteria) this;
        }

        public Criteria andFtotalamountNotEqualTo(BigDecimal value) {
            addCriterion("ftotalAmount <>", value, "ftotalamount");
            return (Criteria) this;
        }

        public Criteria andFtotalamountGreaterThan(BigDecimal value) {
            addCriterion("ftotalAmount >", value, "ftotalamount");
            return (Criteria) this;
        }

        public Criteria andFtotalamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotalAmount >=", value, "ftotalamount");
            return (Criteria) this;
        }

        public Criteria andFtotalamountLessThan(BigDecimal value) {
            addCriterion("ftotalAmount <", value, "ftotalamount");
            return (Criteria) this;
        }

        public Criteria andFtotalamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ftotalAmount <=", value, "ftotalamount");
            return (Criteria) this;
        }

        public Criteria andFtotalamountIn(List<BigDecimal> values) {
            addCriterion("ftotalAmount in", values, "ftotalamount");
            return (Criteria) this;
        }

        public Criteria andFtotalamountNotIn(List<BigDecimal> values) {
            addCriterion("ftotalAmount not in", values, "ftotalamount");
            return (Criteria) this;
        }

        public Criteria andFtotalamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotalAmount between", value1, value2, "ftotalamount");
            return (Criteria) this;
        }

        public Criteria andFtotalamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ftotalAmount not between", value1, value2, "ftotalamount");
            return (Criteria) this;
        }

        public Criteria andEquitytypeIsNull() {
            addCriterion("equityType is null");
            return (Criteria) this;
        }

        public Criteria andEquitytypeIsNotNull() {
            addCriterion("equityType is not null");
            return (Criteria) this;
        }

        public Criteria andEquitytypeEqualTo(Boolean value) {
            addCriterion("equityType =", value, "equitytype");
            return (Criteria) this;
        }

        public Criteria andEquitytypeNotEqualTo(Boolean value) {
            addCriterion("equityType <>", value, "equitytype");
            return (Criteria) this;
        }

        public Criteria andEquitytypeGreaterThan(Boolean value) {
            addCriterion("equityType >", value, "equitytype");
            return (Criteria) this;
        }

        public Criteria andEquitytypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("equityType >=", value, "equitytype");
            return (Criteria) this;
        }

        public Criteria andEquitytypeLessThan(Boolean value) {
            addCriterion("equityType <", value, "equitytype");
            return (Criteria) this;
        }

        public Criteria andEquitytypeLessThanOrEqualTo(Boolean value) {
            addCriterion("equityType <=", value, "equitytype");
            return (Criteria) this;
        }

        public Criteria andEquitytypeIn(List<Boolean> values) {
            addCriterion("equityType in", values, "equitytype");
            return (Criteria) this;
        }

        public Criteria andEquitytypeNotIn(List<Boolean> values) {
            addCriterion("equityType not in", values, "equitytype");
            return (Criteria) this;
        }

        public Criteria andEquitytypeBetween(Boolean value1, Boolean value2) {
            addCriterion("equityType between", value1, value2, "equitytype");
            return (Criteria) this;
        }

        public Criteria andEquitytypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("equityType not between", value1, value2, "equitytype");
            return (Criteria) this;
        }

        public Criteria andHomeshowIsNull() {
            addCriterion("homeShow is null");
            return (Criteria) this;
        }

        public Criteria andHomeshowIsNotNull() {
            addCriterion("homeShow is not null");
            return (Criteria) this;
        }

        public Criteria andHomeshowEqualTo(Boolean value) {
            addCriterion("homeShow =", value, "homeshow");
            return (Criteria) this;
        }

        public Criteria andHomeshowNotEqualTo(Boolean value) {
            addCriterion("homeShow <>", value, "homeshow");
            return (Criteria) this;
        }

        public Criteria andHomeshowGreaterThan(Boolean value) {
            addCriterion("homeShow >", value, "homeshow");
            return (Criteria) this;
        }

        public Criteria andHomeshowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("homeShow >=", value, "homeshow");
            return (Criteria) this;
        }

        public Criteria andHomeshowLessThan(Boolean value) {
            addCriterion("homeShow <", value, "homeshow");
            return (Criteria) this;
        }

        public Criteria andHomeshowLessThanOrEqualTo(Boolean value) {
            addCriterion("homeShow <=", value, "homeshow");
            return (Criteria) this;
        }

        public Criteria andHomeshowIn(List<Boolean> values) {
            addCriterion("homeShow in", values, "homeshow");
            return (Criteria) this;
        }

        public Criteria andHomeshowNotIn(List<Boolean> values) {
            addCriterion("homeShow not in", values, "homeshow");
            return (Criteria) this;
        }

        public Criteria andHomeshowBetween(Boolean value1, Boolean value2) {
            addCriterion("homeShow between", value1, value2, "homeshow");
            return (Criteria) this;
        }

        public Criteria andHomeshowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("homeShow not between", value1, value2, "homeshow");
            return (Criteria) this;
        }

        public Criteria andHomeorderIsNull() {
            addCriterion("homeOrder is null");
            return (Criteria) this;
        }

        public Criteria andHomeorderIsNotNull() {
            addCriterion("homeOrder is not null");
            return (Criteria) this;
        }

        public Criteria andHomeorderEqualTo(Byte value) {
            addCriterion("homeOrder =", value, "homeorder");
            return (Criteria) this;
        }

        public Criteria andHomeorderNotEqualTo(Byte value) {
            addCriterion("homeOrder <>", value, "homeorder");
            return (Criteria) this;
        }

        public Criteria andHomeorderGreaterThan(Byte value) {
            addCriterion("homeOrder >", value, "homeorder");
            return (Criteria) this;
        }

        public Criteria andHomeorderGreaterThanOrEqualTo(Byte value) {
            addCriterion("homeOrder >=", value, "homeorder");
            return (Criteria) this;
        }

        public Criteria andHomeorderLessThan(Byte value) {
            addCriterion("homeOrder <", value, "homeorder");
            return (Criteria) this;
        }

        public Criteria andHomeorderLessThanOrEqualTo(Byte value) {
            addCriterion("homeOrder <=", value, "homeorder");
            return (Criteria) this;
        }

        public Criteria andHomeorderIn(List<Byte> values) {
            addCriterion("homeOrder in", values, "homeorder");
            return (Criteria) this;
        }

        public Criteria andHomeorderNotIn(List<Byte> values) {
            addCriterion("homeOrder not in", values, "homeorder");
            return (Criteria) this;
        }

        public Criteria andHomeorderBetween(Byte value1, Byte value2) {
            addCriterion("homeOrder between", value1, value2, "homeorder");
            return (Criteria) this;
        }

        public Criteria andHomeorderNotBetween(Byte value1, Byte value2) {
            addCriterion("homeOrder not between", value1, value2, "homeorder");
            return (Criteria) this;
        }

        public Criteria andTypeorderIsNull() {
            addCriterion("typeOrder is null");
            return (Criteria) this;
        }

        public Criteria andTypeorderIsNotNull() {
            addCriterion("typeOrder is not null");
            return (Criteria) this;
        }

        public Criteria andTypeorderEqualTo(Byte value) {
            addCriterion("typeOrder =", value, "typeorder");
            return (Criteria) this;
        }

        public Criteria andTypeorderNotEqualTo(Byte value) {
            addCriterion("typeOrder <>", value, "typeorder");
            return (Criteria) this;
        }

        public Criteria andTypeorderGreaterThan(Byte value) {
            addCriterion("typeOrder >", value, "typeorder");
            return (Criteria) this;
        }

        public Criteria andTypeorderGreaterThanOrEqualTo(Byte value) {
            addCriterion("typeOrder >=", value, "typeorder");
            return (Criteria) this;
        }

        public Criteria andTypeorderLessThan(Byte value) {
            addCriterion("typeOrder <", value, "typeorder");
            return (Criteria) this;
        }

        public Criteria andTypeorderLessThanOrEqualTo(Byte value) {
            addCriterion("typeOrder <=", value, "typeorder");
            return (Criteria) this;
        }

        public Criteria andTypeorderIn(List<Byte> values) {
            addCriterion("typeOrder in", values, "typeorder");
            return (Criteria) this;
        }

        public Criteria andTypeorderNotIn(List<Byte> values) {
            addCriterion("typeOrder not in", values, "typeorder");
            return (Criteria) this;
        }

        public Criteria andTypeorderBetween(Byte value1, Byte value2) {
            addCriterion("typeOrder between", value1, value2, "typeorder");
            return (Criteria) this;
        }

        public Criteria andTypeorderNotBetween(Byte value1, Byte value2) {
            addCriterion("typeOrder not between", value1, value2, "typeorder");
            return (Criteria) this;
        }

        public Criteria andTotalorderIsNull() {
            addCriterion("totalOrder is null");
            return (Criteria) this;
        }

        public Criteria andTotalorderIsNotNull() {
            addCriterion("totalOrder is not null");
            return (Criteria) this;
        }

        public Criteria andTotalorderEqualTo(Byte value) {
            addCriterion("totalOrder =", value, "totalorder");
            return (Criteria) this;
        }

        public Criteria andTotalorderNotEqualTo(Byte value) {
            addCriterion("totalOrder <>", value, "totalorder");
            return (Criteria) this;
        }

        public Criteria andTotalorderGreaterThan(Byte value) {
            addCriterion("totalOrder >", value, "totalorder");
            return (Criteria) this;
        }

        public Criteria andTotalorderGreaterThanOrEqualTo(Byte value) {
            addCriterion("totalOrder >=", value, "totalorder");
            return (Criteria) this;
        }

        public Criteria andTotalorderLessThan(Byte value) {
            addCriterion("totalOrder <", value, "totalorder");
            return (Criteria) this;
        }

        public Criteria andTotalorderLessThanOrEqualTo(Byte value) {
            addCriterion("totalOrder <=", value, "totalorder");
            return (Criteria) this;
        }

        public Criteria andTotalorderIn(List<Byte> values) {
            addCriterion("totalOrder in", values, "totalorder");
            return (Criteria) this;
        }

        public Criteria andTotalorderNotIn(List<Byte> values) {
            addCriterion("totalOrder not in", values, "totalorder");
            return (Criteria) this;
        }

        public Criteria andTotalorderBetween(Byte value1, Byte value2) {
            addCriterion("totalOrder between", value1, value2, "totalorder");
            return (Criteria) this;
        }

        public Criteria andTotalorderNotBetween(Byte value1, Byte value2) {
            addCriterion("totalOrder not between", value1, value2, "totalorder");
            return (Criteria) this;
        }

        public Criteria andIsstartingIsNull() {
            addCriterion("isStarting is null");
            return (Criteria) this;
        }

        public Criteria andIsstartingIsNotNull() {
            addCriterion("isStarting is not null");
            return (Criteria) this;
        }

        public Criteria andIsstartingEqualTo(Boolean value) {
            addCriterion("isStarting =", value, "isstarting");
            return (Criteria) this;
        }

        public Criteria andIsstartingNotEqualTo(Boolean value) {
            addCriterion("isStarting <>", value, "isstarting");
            return (Criteria) this;
        }

        public Criteria andIsstartingGreaterThan(Boolean value) {
            addCriterion("isStarting >", value, "isstarting");
            return (Criteria) this;
        }

        public Criteria andIsstartingGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isStarting >=", value, "isstarting");
            return (Criteria) this;
        }

        public Criteria andIsstartingLessThan(Boolean value) {
            addCriterion("isStarting <", value, "isstarting");
            return (Criteria) this;
        }

        public Criteria andIsstartingLessThanOrEqualTo(Boolean value) {
            addCriterion("isStarting <=", value, "isstarting");
            return (Criteria) this;
        }

        public Criteria andIsstartingIn(List<Boolean> values) {
            addCriterion("isStarting in", values, "isstarting");
            return (Criteria) this;
        }

        public Criteria andIsstartingNotIn(List<Boolean> values) {
            addCriterion("isStarting not in", values, "isstarting");
            return (Criteria) this;
        }

        public Criteria andIsstartingBetween(Boolean value1, Boolean value2) {
            addCriterion("isStarting between", value1, value2, "isstarting");
            return (Criteria) this;
        }

        public Criteria andIsstartingNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isStarting not between", value1, value2, "isstarting");
            return (Criteria) this;
        }

        public Criteria andConfirmTimesIsNull() {
            addCriterion("confirm_times is null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimesIsNotNull() {
            addCriterion("confirm_times is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimesEqualTo(Integer value) {
            addCriterion("confirm_times =", value, "confirmTimes");
            return (Criteria) this;
        }

        public Criteria andConfirmTimesNotEqualTo(Integer value) {
            addCriterion("confirm_times <>", value, "confirmTimes");
            return (Criteria) this;
        }

        public Criteria andConfirmTimesGreaterThan(Integer value) {
            addCriterion("confirm_times >", value, "confirmTimes");
            return (Criteria) this;
        }

        public Criteria andConfirmTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("confirm_times >=", value, "confirmTimes");
            return (Criteria) this;
        }

        public Criteria andConfirmTimesLessThan(Integer value) {
            addCriterion("confirm_times <", value, "confirmTimes");
            return (Criteria) this;
        }

        public Criteria andConfirmTimesLessThanOrEqualTo(Integer value) {
            addCriterion("confirm_times <=", value, "confirmTimes");
            return (Criteria) this;
        }

        public Criteria andConfirmTimesIn(List<Integer> values) {
            addCriterion("confirm_times in", values, "confirmTimes");
            return (Criteria) this;
        }

        public Criteria andConfirmTimesNotIn(List<Integer> values) {
            addCriterion("confirm_times not in", values, "confirmTimes");
            return (Criteria) this;
        }

        public Criteria andConfirmTimesBetween(Integer value1, Integer value2) {
            addCriterion("confirm_times between", value1, value2, "confirmTimes");
            return (Criteria) this;
        }

        public Criteria andConfirmTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("confirm_times not between", value1, value2, "confirmTimes");
            return (Criteria) this;
        }

        public Criteria andContractAddressIsNull() {
            addCriterion("contract_address is null");
            return (Criteria) this;
        }

        public Criteria andContractAddressIsNotNull() {
            addCriterion("contract_address is not null");
            return (Criteria) this;
        }

        public Criteria andContractAddressEqualTo(String value) {
            addCriterion("contract_address =", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressNotEqualTo(String value) {
            addCriterion("contract_address <>", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressGreaterThan(String value) {
            addCriterion("contract_address >", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressGreaterThanOrEqualTo(String value) {
            addCriterion("contract_address >=", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressLessThan(String value) {
            addCriterion("contract_address <", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressLessThanOrEqualTo(String value) {
            addCriterion("contract_address <=", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressLike(String value) {
            addCriterion("contract_address like", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressNotLike(String value) {
            addCriterion("contract_address not like", value, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressIn(List<String> values) {
            addCriterion("contract_address in", values, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressNotIn(List<String> values) {
            addCriterion("contract_address not in", values, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressBetween(String value1, String value2) {
            addCriterion("contract_address between", value1, value2, "contractAddress");
            return (Criteria) this;
        }

        public Criteria andContractAddressNotBetween(String value1, String value2) {
            addCriterion("contract_address not between", value1, value2, "contractAddress");
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