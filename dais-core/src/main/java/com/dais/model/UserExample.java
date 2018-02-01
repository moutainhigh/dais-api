package com.dais.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andFnickNameIsNull() {
            addCriterion("fnick_name is null");
            return (Criteria) this;
        }

        public Criteria andFnickNameIsNotNull() {
            addCriterion("fnick_name is not null");
            return (Criteria) this;
        }

        public Criteria andFnickNameEqualTo(String value) {
            addCriterion("fnick_name =", value, "fnickName");
            return (Criteria) this;
        }

        public Criteria andFnickNameNotEqualTo(String value) {
            addCriterion("fnick_name <>", value, "fnickName");
            return (Criteria) this;
        }

        public Criteria andFnickNameGreaterThan(String value) {
            addCriterion("fnick_name >", value, "fnickName");
            return (Criteria) this;
        }

        public Criteria andFnickNameGreaterThanOrEqualTo(String value) {
            addCriterion("fnick_name >=", value, "fnickName");
            return (Criteria) this;
        }

        public Criteria andFnickNameLessThan(String value) {
            addCriterion("fnick_name <", value, "fnickName");
            return (Criteria) this;
        }

        public Criteria andFnickNameLessThanOrEqualTo(String value) {
            addCriterion("fnick_name <=", value, "fnickName");
            return (Criteria) this;
        }

        public Criteria andFnickNameLike(String value) {
            addCriterion("fnick_name like", value, "fnickName");
            return (Criteria) this;
        }

        public Criteria andFnickNameNotLike(String value) {
            addCriterion("fnick_name not like", value, "fnickName");
            return (Criteria) this;
        }

        public Criteria andFnickNameIn(List<String> values) {
            addCriterion("fnick_name in", values, "fnickName");
            return (Criteria) this;
        }

        public Criteria andFnickNameNotIn(List<String> values) {
            addCriterion("fnick_name not in", values, "fnickName");
            return (Criteria) this;
        }

        public Criteria andFnickNameBetween(String value1, String value2) {
            addCriterion("fnick_name between", value1, value2, "fnickName");
            return (Criteria) this;
        }

        public Criteria andFnickNameNotBetween(String value1, String value2) {
            addCriterion("fnick_name not between", value1, value2, "fnickName");
            return (Criteria) this;
        }

        public Criteria andFrealNameIsNull() {
            addCriterion("freal_name is null");
            return (Criteria) this;
        }

        public Criteria andFrealNameIsNotNull() {
            addCriterion("freal_name is not null");
            return (Criteria) this;
        }

        public Criteria andFrealNameEqualTo(String value) {
            addCriterion("freal_name =", value, "frealName");
            return (Criteria) this;
        }

        public Criteria andFrealNameNotEqualTo(String value) {
            addCriterion("freal_name <>", value, "frealName");
            return (Criteria) this;
        }

        public Criteria andFrealNameGreaterThan(String value) {
            addCriterion("freal_name >", value, "frealName");
            return (Criteria) this;
        }

        public Criteria andFrealNameGreaterThanOrEqualTo(String value) {
            addCriterion("freal_name >=", value, "frealName");
            return (Criteria) this;
        }

        public Criteria andFrealNameLessThan(String value) {
            addCriterion("freal_name <", value, "frealName");
            return (Criteria) this;
        }

        public Criteria andFrealNameLessThanOrEqualTo(String value) {
            addCriterion("freal_name <=", value, "frealName");
            return (Criteria) this;
        }

        public Criteria andFrealNameLike(String value) {
            addCriterion("freal_name like", value, "frealName");
            return (Criteria) this;
        }

        public Criteria andFrealNameNotLike(String value) {
            addCriterion("freal_name not like", value, "frealName");
            return (Criteria) this;
        }

        public Criteria andFrealNameIn(List<String> values) {
            addCriterion("freal_name in", values, "frealName");
            return (Criteria) this;
        }

        public Criteria andFrealNameNotIn(List<String> values) {
            addCriterion("freal_name not in", values, "frealName");
            return (Criteria) this;
        }

        public Criteria andFrealNameBetween(String value1, String value2) {
            addCriterion("freal_name between", value1, value2, "frealName");
            return (Criteria) this;
        }

        public Criteria andFrealNameNotBetween(String value1, String value2) {
            addCriterion("freal_name not between", value1, value2, "frealName");
            return (Criteria) this;
        }

        public Criteria andFtelePhoneIsNull() {
            addCriterion("ftele_phone is null");
            return (Criteria) this;
        }

        public Criteria andFtelePhoneIsNotNull() {
            addCriterion("ftele_phone is not null");
            return (Criteria) this;
        }

        public Criteria andFtelePhoneEqualTo(String value) {
            addCriterion("ftele_phone =", value, "ftelePhone");
            return (Criteria) this;
        }

        public Criteria andFtelePhoneNotEqualTo(String value) {
            addCriterion("ftele_phone <>", value, "ftelePhone");
            return (Criteria) this;
        }

        public Criteria andFtelePhoneGreaterThan(String value) {
            addCriterion("ftele_phone >", value, "ftelePhone");
            return (Criteria) this;
        }

        public Criteria andFtelePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("ftele_phone >=", value, "ftelePhone");
            return (Criteria) this;
        }

        public Criteria andFtelePhoneLessThan(String value) {
            addCriterion("ftele_phone <", value, "ftelePhone");
            return (Criteria) this;
        }

        public Criteria andFtelePhoneLessThanOrEqualTo(String value) {
            addCriterion("ftele_phone <=", value, "ftelePhone");
            return (Criteria) this;
        }

        public Criteria andFtelePhoneLike(String value) {
            addCriterion("ftele_phone like", value, "ftelePhone");
            return (Criteria) this;
        }

        public Criteria andFtelePhoneNotLike(String value) {
            addCriterion("ftele_phone not like", value, "ftelePhone");
            return (Criteria) this;
        }

        public Criteria andFtelePhoneIn(List<String> values) {
            addCriterion("ftele_phone in", values, "ftelePhone");
            return (Criteria) this;
        }

        public Criteria andFtelePhoneNotIn(List<String> values) {
            addCriterion("ftele_phone not in", values, "ftelePhone");
            return (Criteria) this;
        }

        public Criteria andFtelePhoneBetween(String value1, String value2) {
            addCriterion("ftele_phone between", value1, value2, "ftelePhone");
            return (Criteria) this;
        }

        public Criteria andFtelePhoneNotBetween(String value1, String value2) {
            addCriterion("ftele_phone not between", value1, value2, "ftelePhone");
            return (Criteria) this;
        }

        public Criteria andFemailIsNull() {
            addCriterion("femail is null");
            return (Criteria) this;
        }

        public Criteria andFemailIsNotNull() {
            addCriterion("femail is not null");
            return (Criteria) this;
        }

        public Criteria andFemailEqualTo(String value) {
            addCriterion("femail =", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailNotEqualTo(String value) {
            addCriterion("femail <>", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailGreaterThan(String value) {
            addCriterion("femail >", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailGreaterThanOrEqualTo(String value) {
            addCriterion("femail >=", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailLessThan(String value) {
            addCriterion("femail <", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailLessThanOrEqualTo(String value) {
            addCriterion("femail <=", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailLike(String value) {
            addCriterion("femail like", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailNotLike(String value) {
            addCriterion("femail not like", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailIn(List<String> values) {
            addCriterion("femail in", values, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailNotIn(List<String> values) {
            addCriterion("femail not in", values, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailBetween(String value1, String value2) {
            addCriterion("femail between", value1, value2, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailNotBetween(String value1, String value2) {
            addCriterion("femail not between", value1, value2, "femail");
            return (Criteria) this;
        }

        public Criteria andFloginPasswordIsNull() {
            addCriterion("flogin_password is null");
            return (Criteria) this;
        }

        public Criteria andFloginPasswordIsNotNull() {
            addCriterion("flogin_password is not null");
            return (Criteria) this;
        }

        public Criteria andFloginPasswordEqualTo(String value) {
            addCriterion("flogin_password =", value, "floginPassword");
            return (Criteria) this;
        }

        public Criteria andFloginPasswordNotEqualTo(String value) {
            addCriterion("flogin_password <>", value, "floginPassword");
            return (Criteria) this;
        }

        public Criteria andFloginPasswordGreaterThan(String value) {
            addCriterion("flogin_password >", value, "floginPassword");
            return (Criteria) this;
        }

        public Criteria andFloginPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("flogin_password >=", value, "floginPassword");
            return (Criteria) this;
        }

        public Criteria andFloginPasswordLessThan(String value) {
            addCriterion("flogin_password <", value, "floginPassword");
            return (Criteria) this;
        }

        public Criteria andFloginPasswordLessThanOrEqualTo(String value) {
            addCriterion("flogin_password <=", value, "floginPassword");
            return (Criteria) this;
        }

        public Criteria andFloginPasswordLike(String value) {
            addCriterion("flogin_password like", value, "floginPassword");
            return (Criteria) this;
        }

        public Criteria andFloginPasswordNotLike(String value) {
            addCriterion("flogin_password not like", value, "floginPassword");
            return (Criteria) this;
        }

        public Criteria andFloginPasswordIn(List<String> values) {
            addCriterion("flogin_password in", values, "floginPassword");
            return (Criteria) this;
        }

        public Criteria andFloginPasswordNotIn(List<String> values) {
            addCriterion("flogin_password not in", values, "floginPassword");
            return (Criteria) this;
        }

        public Criteria andFloginPasswordBetween(String value1, String value2) {
            addCriterion("flogin_password between", value1, value2, "floginPassword");
            return (Criteria) this;
        }

        public Criteria andFloginPasswordNotBetween(String value1, String value2) {
            addCriterion("flogin_password not between", value1, value2, "floginPassword");
            return (Criteria) this;
        }

        public Criteria andFtradePasswordIsNull() {
            addCriterion("ftrade_password is null");
            return (Criteria) this;
        }

        public Criteria andFtradePasswordIsNotNull() {
            addCriterion("ftrade_password is not null");
            return (Criteria) this;
        }

        public Criteria andFtradePasswordEqualTo(String value) {
            addCriterion("ftrade_password =", value, "ftradePassword");
            return (Criteria) this;
        }

        public Criteria andFtradePasswordNotEqualTo(String value) {
            addCriterion("ftrade_password <>", value, "ftradePassword");
            return (Criteria) this;
        }

        public Criteria andFtradePasswordGreaterThan(String value) {
            addCriterion("ftrade_password >", value, "ftradePassword");
            return (Criteria) this;
        }

        public Criteria andFtradePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("ftrade_password >=", value, "ftradePassword");
            return (Criteria) this;
        }

        public Criteria andFtradePasswordLessThan(String value) {
            addCriterion("ftrade_password <", value, "ftradePassword");
            return (Criteria) this;
        }

        public Criteria andFtradePasswordLessThanOrEqualTo(String value) {
            addCriterion("ftrade_password <=", value, "ftradePassword");
            return (Criteria) this;
        }

        public Criteria andFtradePasswordLike(String value) {
            addCriterion("ftrade_password like", value, "ftradePassword");
            return (Criteria) this;
        }

        public Criteria andFtradePasswordNotLike(String value) {
            addCriterion("ftrade_password not like", value, "ftradePassword");
            return (Criteria) this;
        }

        public Criteria andFtradePasswordIn(List<String> values) {
            addCriterion("ftrade_password in", values, "ftradePassword");
            return (Criteria) this;
        }

        public Criteria andFtradePasswordNotIn(List<String> values) {
            addCriterion("ftrade_password not in", values, "ftradePassword");
            return (Criteria) this;
        }

        public Criteria andFtradePasswordBetween(String value1, String value2) {
            addCriterion("ftrade_password between", value1, value2, "ftradePassword");
            return (Criteria) this;
        }

        public Criteria andFtradePasswordNotBetween(String value1, String value2) {
            addCriterion("ftrade_password not between", value1, value2, "ftradePassword");
            return (Criteria) this;
        }

        public Criteria andFloginNameIsNull() {
            addCriterion("flogin_name is null");
            return (Criteria) this;
        }

        public Criteria andFloginNameIsNotNull() {
            addCriterion("flogin_name is not null");
            return (Criteria) this;
        }

        public Criteria andFloginNameEqualTo(String value) {
            addCriterion("flogin_name =", value, "floginName");
            return (Criteria) this;
        }

        public Criteria andFloginNameNotEqualTo(String value) {
            addCriterion("flogin_name <>", value, "floginName");
            return (Criteria) this;
        }

        public Criteria andFloginNameGreaterThan(String value) {
            addCriterion("flogin_name >", value, "floginName");
            return (Criteria) this;
        }

        public Criteria andFloginNameGreaterThanOrEqualTo(String value) {
            addCriterion("flogin_name >=", value, "floginName");
            return (Criteria) this;
        }

        public Criteria andFloginNameLessThan(String value) {
            addCriterion("flogin_name <", value, "floginName");
            return (Criteria) this;
        }

        public Criteria andFloginNameLessThanOrEqualTo(String value) {
            addCriterion("flogin_name <=", value, "floginName");
            return (Criteria) this;
        }

        public Criteria andFloginNameLike(String value) {
            addCriterion("flogin_name like", value, "floginName");
            return (Criteria) this;
        }

        public Criteria andFloginNameNotLike(String value) {
            addCriterion("flogin_name not like", value, "floginName");
            return (Criteria) this;
        }

        public Criteria andFloginNameIn(List<String> values) {
            addCriterion("flogin_name in", values, "floginName");
            return (Criteria) this;
        }

        public Criteria andFloginNameNotIn(List<String> values) {
            addCriterion("flogin_name not in", values, "floginName");
            return (Criteria) this;
        }

        public Criteria andFloginNameBetween(String value1, String value2) {
            addCriterion("flogin_name between", value1, value2, "floginName");
            return (Criteria) this;
        }

        public Criteria andFloginNameNotBetween(String value1, String value2) {
            addCriterion("flogin_name not between", value1, value2, "floginName");
            return (Criteria) this;
        }

        public Criteria andFoldLoginNameIsNull() {
            addCriterion("fold_login_name is null");
            return (Criteria) this;
        }

        public Criteria andFoldLoginNameIsNotNull() {
            addCriterion("fold_login_name is not null");
            return (Criteria) this;
        }

        public Criteria andFoldLoginNameEqualTo(String value) {
            addCriterion("fold_login_name =", value, "foldLoginName");
            return (Criteria) this;
        }

        public Criteria andFoldLoginNameNotEqualTo(String value) {
            addCriterion("fold_login_name <>", value, "foldLoginName");
            return (Criteria) this;
        }

        public Criteria andFoldLoginNameGreaterThan(String value) {
            addCriterion("fold_login_name >", value, "foldLoginName");
            return (Criteria) this;
        }

        public Criteria andFoldLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("fold_login_name >=", value, "foldLoginName");
            return (Criteria) this;
        }

        public Criteria andFoldLoginNameLessThan(String value) {
            addCriterion("fold_login_name <", value, "foldLoginName");
            return (Criteria) this;
        }

        public Criteria andFoldLoginNameLessThanOrEqualTo(String value) {
            addCriterion("fold_login_name <=", value, "foldLoginName");
            return (Criteria) this;
        }

        public Criteria andFoldLoginNameLike(String value) {
            addCriterion("fold_login_name like", value, "foldLoginName");
            return (Criteria) this;
        }

        public Criteria andFoldLoginNameNotLike(String value) {
            addCriterion("fold_login_name not like", value, "foldLoginName");
            return (Criteria) this;
        }

        public Criteria andFoldLoginNameIn(List<String> values) {
            addCriterion("fold_login_name in", values, "foldLoginName");
            return (Criteria) this;
        }

        public Criteria andFoldLoginNameNotIn(List<String> values) {
            addCriterion("fold_login_name not in", values, "foldLoginName");
            return (Criteria) this;
        }

        public Criteria andFoldLoginNameBetween(String value1, String value2) {
            addCriterion("fold_login_name between", value1, value2, "foldLoginName");
            return (Criteria) this;
        }

        public Criteria andFoldLoginNameNotBetween(String value1, String value2) {
            addCriterion("fold_login_name not between", value1, value2, "foldLoginName");
            return (Criteria) this;
        }

        public Criteria andFidentityNoIsNull() {
            addCriterion("fidentity_no is null");
            return (Criteria) this;
        }

        public Criteria andFidentityNoIsNotNull() {
            addCriterion("fidentity_no is not null");
            return (Criteria) this;
        }

        public Criteria andFidentityNoEqualTo(String value) {
            addCriterion("fidentity_no =", value, "fidentityNo");
            return (Criteria) this;
        }

        public Criteria andFidentityNoNotEqualTo(String value) {
            addCriterion("fidentity_no <>", value, "fidentityNo");
            return (Criteria) this;
        }

        public Criteria andFidentityNoGreaterThan(String value) {
            addCriterion("fidentity_no >", value, "fidentityNo");
            return (Criteria) this;
        }

        public Criteria andFidentityNoGreaterThanOrEqualTo(String value) {
            addCriterion("fidentity_no >=", value, "fidentityNo");
            return (Criteria) this;
        }

        public Criteria andFidentityNoLessThan(String value) {
            addCriterion("fidentity_no <", value, "fidentityNo");
            return (Criteria) this;
        }

        public Criteria andFidentityNoLessThanOrEqualTo(String value) {
            addCriterion("fidentity_no <=", value, "fidentityNo");
            return (Criteria) this;
        }

        public Criteria andFidentityNoLike(String value) {
            addCriterion("fidentity_no like", value, "fidentityNo");
            return (Criteria) this;
        }

        public Criteria andFidentityNoNotLike(String value) {
            addCriterion("fidentity_no not like", value, "fidentityNo");
            return (Criteria) this;
        }

        public Criteria andFidentityNoIn(List<String> values) {
            addCriterion("fidentity_no in", values, "fidentityNo");
            return (Criteria) this;
        }

        public Criteria andFidentityNoNotIn(List<String> values) {
            addCriterion("fidentity_no not in", values, "fidentityNo");
            return (Criteria) this;
        }

        public Criteria andFidentityNoBetween(String value1, String value2) {
            addCriterion("fidentity_no between", value1, value2, "fidentityNo");
            return (Criteria) this;
        }

        public Criteria andFidentityNoNotBetween(String value1, String value2) {
            addCriterion("fidentity_no not between", value1, value2, "fidentityNo");
            return (Criteria) this;
        }

        public Criteria andFidentityTypeIsNull() {
            addCriterion("fidentity_type is null");
            return (Criteria) this;
        }

        public Criteria andFidentityTypeIsNotNull() {
            addCriterion("fidentity_type is not null");
            return (Criteria) this;
        }

        public Criteria andFidentityTypeEqualTo(Integer value) {
            addCriterion("fidentity_type =", value, "fidentityType");
            return (Criteria) this;
        }

        public Criteria andFidentityTypeNotEqualTo(Integer value) {
            addCriterion("fidentity_type <>", value, "fidentityType");
            return (Criteria) this;
        }

        public Criteria andFidentityTypeGreaterThan(Integer value) {
            addCriterion("fidentity_type >", value, "fidentityType");
            return (Criteria) this;
        }

        public Criteria andFidentityTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fidentity_type >=", value, "fidentityType");
            return (Criteria) this;
        }

        public Criteria andFidentityTypeLessThan(Integer value) {
            addCriterion("fidentity_type <", value, "fidentityType");
            return (Criteria) this;
        }

        public Criteria andFidentityTypeLessThanOrEqualTo(Integer value) {
            addCriterion("fidentity_type <=", value, "fidentityType");
            return (Criteria) this;
        }

        public Criteria andFidentityTypeIn(List<Integer> values) {
            addCriterion("fidentity_type in", values, "fidentityType");
            return (Criteria) this;
        }

        public Criteria andFidentityTypeNotIn(List<Integer> values) {
            addCriterion("fidentity_type not in", values, "fidentityType");
            return (Criteria) this;
        }

        public Criteria andFidentityTypeBetween(Integer value1, Integer value2) {
            addCriterion("fidentity_type between", value1, value2, "fidentityType");
            return (Criteria) this;
        }

        public Criteria andFidentityTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("fidentity_type not between", value1, value2, "fidentityType");
            return (Criteria) this;
        }

        public Criteria andFregisterTimeIsNull() {
            addCriterion("fregister_time is null");
            return (Criteria) this;
        }

        public Criteria andFregisterTimeIsNotNull() {
            addCriterion("fregister_time is not null");
            return (Criteria) this;
        }

        public Criteria andFregisterTimeEqualTo(Date value) {
            addCriterion("fregister_time =", value, "fregisterTime");
            return (Criteria) this;
        }

        public Criteria andFregisterTimeNotEqualTo(Date value) {
            addCriterion("fregister_time <>", value, "fregisterTime");
            return (Criteria) this;
        }

        public Criteria andFregisterTimeGreaterThan(Date value) {
            addCriterion("fregister_time >", value, "fregisterTime");
            return (Criteria) this;
        }

        public Criteria andFregisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fregister_time >=", value, "fregisterTime");
            return (Criteria) this;
        }

        public Criteria andFregisterTimeLessThan(Date value) {
            addCriterion("fregister_time <", value, "fregisterTime");
            return (Criteria) this;
        }

        public Criteria andFregisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("fregister_time <=", value, "fregisterTime");
            return (Criteria) this;
        }

        public Criteria andFregisterTimeIn(List<Date> values) {
            addCriterion("fregister_time in", values, "fregisterTime");
            return (Criteria) this;
        }

        public Criteria andFregisterTimeNotIn(List<Date> values) {
            addCriterion("fregister_time not in", values, "fregisterTime");
            return (Criteria) this;
        }

        public Criteria andFregisterTimeBetween(Date value1, Date value2) {
            addCriterion("fregister_time between", value1, value2, "fregisterTime");
            return (Criteria) this;
        }

        public Criteria andFregisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("fregister_time not between", value1, value2, "fregisterTime");
            return (Criteria) this;
        }

        public Criteria andFlastLoginTimeIsNull() {
            addCriterion("flast_login_time is null");
            return (Criteria) this;
        }

        public Criteria andFlastLoginTimeIsNotNull() {
            addCriterion("flast_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andFlastLoginTimeEqualTo(Date value) {
            addCriterion("flast_login_time =", value, "flastLoginTime");
            return (Criteria) this;
        }

        public Criteria andFlastLoginTimeNotEqualTo(Date value) {
            addCriterion("flast_login_time <>", value, "flastLoginTime");
            return (Criteria) this;
        }

        public Criteria andFlastLoginTimeGreaterThan(Date value) {
            addCriterion("flast_login_time >", value, "flastLoginTime");
            return (Criteria) this;
        }

        public Criteria andFlastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("flast_login_time >=", value, "flastLoginTime");
            return (Criteria) this;
        }

        public Criteria andFlastLoginTimeLessThan(Date value) {
            addCriterion("flast_login_time <", value, "flastLoginTime");
            return (Criteria) this;
        }

        public Criteria andFlastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("flast_login_time <=", value, "flastLoginTime");
            return (Criteria) this;
        }

        public Criteria andFlastLoginTimeIn(List<Date> values) {
            addCriterion("flast_login_time in", values, "flastLoginTime");
            return (Criteria) this;
        }

        public Criteria andFlastLoginTimeNotIn(List<Date> values) {
            addCriterion("flast_login_time not in", values, "flastLoginTime");
            return (Criteria) this;
        }

        public Criteria andFlastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("flast_login_time between", value1, value2, "flastLoginTime");
            return (Criteria) this;
        }

        public Criteria andFlastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("flast_login_time not between", value1, value2, "flastLoginTime");
            return (Criteria) this;
        }

        public Criteria andFlastUpdateTimeIsNull() {
            addCriterion("flast_update_time is null");
            return (Criteria) this;
        }

        public Criteria andFlastUpdateTimeIsNotNull() {
            addCriterion("flast_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andFlastUpdateTimeEqualTo(Date value) {
            addCriterion("flast_update_time =", value, "flastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFlastUpdateTimeNotEqualTo(Date value) {
            addCriterion("flast_update_time <>", value, "flastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFlastUpdateTimeGreaterThan(Date value) {
            addCriterion("flast_update_time >", value, "flastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFlastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("flast_update_time >=", value, "flastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFlastUpdateTimeLessThan(Date value) {
            addCriterion("flast_update_time <", value, "flastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFlastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("flast_update_time <=", value, "flastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFlastUpdateTimeIn(List<Date> values) {
            addCriterion("flast_update_time in", values, "flastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFlastUpdateTimeNotIn(List<Date> values) {
            addCriterion("flast_update_time not in", values, "flastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFlastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("flast_update_time between", value1, value2, "flastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFlastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("flast_update_time not between", value1, value2, "flastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateIsNull() {
            addCriterion("fhas_real_validate is null");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateIsNotNull() {
            addCriterion("fhas_real_validate is not null");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateEqualTo(Boolean value) {
            addCriterion("fhas_real_validate =", value, "fhasRealValidate");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateNotEqualTo(Boolean value) {
            addCriterion("fhas_real_validate <>", value, "fhasRealValidate");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateGreaterThan(Boolean value) {
            addCriterion("fhas_real_validate >", value, "fhasRealValidate");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("fhas_real_validate >=", value, "fhasRealValidate");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateLessThan(Boolean value) {
            addCriterion("fhas_real_validate <", value, "fhasRealValidate");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateLessThanOrEqualTo(Boolean value) {
            addCriterion("fhas_real_validate <=", value, "fhasRealValidate");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateIn(List<Boolean> values) {
            addCriterion("fhas_real_validate in", values, "fhasRealValidate");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateNotIn(List<Boolean> values) {
            addCriterion("fhas_real_validate not in", values, "fhasRealValidate");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateBetween(Boolean value1, Boolean value2) {
            addCriterion("fhas_real_validate between", value1, value2, "fhasRealValidate");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("fhas_real_validate not between", value1, value2, "fhasRealValidate");
            return (Criteria) this;
        }

        public Criteria andFisTelephoneBindIsNull() {
            addCriterion("fis_telephone_bind is null");
            return (Criteria) this;
        }

        public Criteria andFisTelephoneBindIsNotNull() {
            addCriterion("fis_telephone_bind is not null");
            return (Criteria) this;
        }

        public Criteria andFisTelephoneBindEqualTo(Boolean value) {
            addCriterion("fis_telephone_bind =", value, "fisTelephoneBind");
            return (Criteria) this;
        }

        public Criteria andFisTelephoneBindNotEqualTo(Boolean value) {
            addCriterion("fis_telephone_bind <>", value, "fisTelephoneBind");
            return (Criteria) this;
        }

        public Criteria andFisTelephoneBindGreaterThan(Boolean value) {
            addCriterion("fis_telephone_bind >", value, "fisTelephoneBind");
            return (Criteria) this;
        }

        public Criteria andFisTelephoneBindGreaterThanOrEqualTo(Boolean value) {
            addCriterion("fis_telephone_bind >=", value, "fisTelephoneBind");
            return (Criteria) this;
        }

        public Criteria andFisTelephoneBindLessThan(Boolean value) {
            addCriterion("fis_telephone_bind <", value, "fisTelephoneBind");
            return (Criteria) this;
        }

        public Criteria andFisTelephoneBindLessThanOrEqualTo(Boolean value) {
            addCriterion("fis_telephone_bind <=", value, "fisTelephoneBind");
            return (Criteria) this;
        }

        public Criteria andFisTelephoneBindIn(List<Boolean> values) {
            addCriterion("fis_telephone_bind in", values, "fisTelephoneBind");
            return (Criteria) this;
        }

        public Criteria andFisTelephoneBindNotIn(List<Boolean> values) {
            addCriterion("fis_telephone_bind not in", values, "fisTelephoneBind");
            return (Criteria) this;
        }

        public Criteria andFisTelephoneBindBetween(Boolean value1, Boolean value2) {
            addCriterion("fis_telephone_bind between", value1, value2, "fisTelephoneBind");
            return (Criteria) this;
        }

        public Criteria andFisTelephoneBindNotBetween(Boolean value1, Boolean value2) {
            addCriterion("fis_telephone_bind not between", value1, value2, "fisTelephoneBind");
            return (Criteria) this;
        }

        public Criteria andFisMailValidateIsNull() {
            addCriterion("fis_mail_validate is null");
            return (Criteria) this;
        }

        public Criteria andFisMailValidateIsNotNull() {
            addCriterion("fis_mail_validate is not null");
            return (Criteria) this;
        }

        public Criteria andFisMailValidateEqualTo(Boolean value) {
            addCriterion("fis_mail_validate =", value, "fisMailValidate");
            return (Criteria) this;
        }

        public Criteria andFisMailValidateNotEqualTo(Boolean value) {
            addCriterion("fis_mail_validate <>", value, "fisMailValidate");
            return (Criteria) this;
        }

        public Criteria andFisMailValidateGreaterThan(Boolean value) {
            addCriterion("fis_mail_validate >", value, "fisMailValidate");
            return (Criteria) this;
        }

        public Criteria andFisMailValidateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("fis_mail_validate >=", value, "fisMailValidate");
            return (Criteria) this;
        }

        public Criteria andFisMailValidateLessThan(Boolean value) {
            addCriterion("fis_mail_validate <", value, "fisMailValidate");
            return (Criteria) this;
        }

        public Criteria andFisMailValidateLessThanOrEqualTo(Boolean value) {
            addCriterion("fis_mail_validate <=", value, "fisMailValidate");
            return (Criteria) this;
        }

        public Criteria andFisMailValidateIn(List<Boolean> values) {
            addCriterion("fis_mail_validate in", values, "fisMailValidate");
            return (Criteria) this;
        }

        public Criteria andFisMailValidateNotIn(List<Boolean> values) {
            addCriterion("fis_mail_validate not in", values, "fisMailValidate");
            return (Criteria) this;
        }

        public Criteria andFisMailValidateBetween(Boolean value1, Boolean value2) {
            addCriterion("fis_mail_validate between", value1, value2, "fisMailValidate");
            return (Criteria) this;
        }

        public Criteria andFisMailValidateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("fis_mail_validate not between", value1, value2, "fisMailValidate");
            return (Criteria) this;
        }

        public Criteria andFpostRealValidateIsNull() {
            addCriterion("fpost_real_validate is null");
            return (Criteria) this;
        }

        public Criteria andFpostRealValidateIsNotNull() {
            addCriterion("fpost_real_validate is not null");
            return (Criteria) this;
        }

        public Criteria andFpostRealValidateEqualTo(Boolean value) {
            addCriterion("fpost_real_validate =", value, "fpostRealValidate");
            return (Criteria) this;
        }

        public Criteria andFpostRealValidateNotEqualTo(Boolean value) {
            addCriterion("fpost_real_validate <>", value, "fpostRealValidate");
            return (Criteria) this;
        }

        public Criteria andFpostRealValidateGreaterThan(Boolean value) {
            addCriterion("fpost_real_validate >", value, "fpostRealValidate");
            return (Criteria) this;
        }

        public Criteria andFpostRealValidateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("fpost_real_validate >=", value, "fpostRealValidate");
            return (Criteria) this;
        }

        public Criteria andFpostRealValidateLessThan(Boolean value) {
            addCriterion("fpost_real_validate <", value, "fpostRealValidate");
            return (Criteria) this;
        }

        public Criteria andFpostRealValidateLessThanOrEqualTo(Boolean value) {
            addCriterion("fpost_real_validate <=", value, "fpostRealValidate");
            return (Criteria) this;
        }

        public Criteria andFpostRealValidateIn(List<Boolean> values) {
            addCriterion("fpost_real_validate in", values, "fpostRealValidate");
            return (Criteria) this;
        }

        public Criteria andFpostRealValidateNotIn(List<Boolean> values) {
            addCriterion("fpost_real_validate not in", values, "fpostRealValidate");
            return (Criteria) this;
        }

        public Criteria andFpostRealValidateBetween(Boolean value1, Boolean value2) {
            addCriterion("fpost_real_validate between", value1, value2, "fpostRealValidate");
            return (Criteria) this;
        }

        public Criteria andFpostRealValidateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("fpost_real_validate not between", value1, value2, "fpostRealValidate");
            return (Criteria) this;
        }

        public Criteria andHasPayPwdIsNull() {
            addCriterion("has_pay_pwd is null");
            return (Criteria) this;
        }

        public Criteria andHasPayPwdIsNotNull() {
            addCriterion("has_pay_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andHasPayPwdEqualTo(Boolean value) {
            addCriterion("has_pay_pwd =", value, "hasPayPwd");
            return (Criteria) this;
        }

        public Criteria andHasPayPwdNotEqualTo(Boolean value) {
            addCriterion("has_pay_pwd <>", value, "hasPayPwd");
            return (Criteria) this;
        }

        public Criteria andHasPayPwdGreaterThan(Boolean value) {
            addCriterion("has_pay_pwd >", value, "hasPayPwd");
            return (Criteria) this;
        }

        public Criteria andHasPayPwdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("has_pay_pwd >=", value, "hasPayPwd");
            return (Criteria) this;
        }

        public Criteria andHasPayPwdLessThan(Boolean value) {
            addCriterion("has_pay_pwd <", value, "hasPayPwd");
            return (Criteria) this;
        }

        public Criteria andHasPayPwdLessThanOrEqualTo(Boolean value) {
            addCriterion("has_pay_pwd <=", value, "hasPayPwd");
            return (Criteria) this;
        }

        public Criteria andHasPayPwdIn(List<Boolean> values) {
            addCriterion("has_pay_pwd in", values, "hasPayPwd");
            return (Criteria) this;
        }

        public Criteria andHasPayPwdNotIn(List<Boolean> values) {
            addCriterion("has_pay_pwd not in", values, "hasPayPwd");
            return (Criteria) this;
        }

        public Criteria andHasPayPwdBetween(Boolean value1, Boolean value2) {
            addCriterion("has_pay_pwd between", value1, value2, "hasPayPwd");
            return (Criteria) this;
        }

        public Criteria andHasPayPwdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("has_pay_pwd not between", value1, value2, "hasPayPwd");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateTimeIsNull() {
            addCriterion("fhas_real_validate_time is null");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateTimeIsNotNull() {
            addCriterion("fhas_real_validate_time is not null");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateTimeEqualTo(Date value) {
            addCriterion("fhas_real_validate_time =", value, "fhasRealValidateTime");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateTimeNotEqualTo(Date value) {
            addCriterion("fhas_real_validate_time <>", value, "fhasRealValidateTime");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateTimeGreaterThan(Date value) {
            addCriterion("fhas_real_validate_time >", value, "fhasRealValidateTime");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fhas_real_validate_time >=", value, "fhasRealValidateTime");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateTimeLessThan(Date value) {
            addCriterion("fhas_real_validate_time <", value, "fhasRealValidateTime");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateTimeLessThanOrEqualTo(Date value) {
            addCriterion("fhas_real_validate_time <=", value, "fhasRealValidateTime");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateTimeIn(List<Date> values) {
            addCriterion("fhas_real_validate_time in", values, "fhasRealValidateTime");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateTimeNotIn(List<Date> values) {
            addCriterion("fhas_real_validate_time not in", values, "fhasRealValidateTime");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateTimeBetween(Date value1, Date value2) {
            addCriterion("fhas_real_validate_time between", value1, value2, "fhasRealValidateTime");
            return (Criteria) this;
        }

        public Criteria andFhasRealValidateTimeNotBetween(Date value1, Date value2) {
            addCriterion("fhas_real_validate_time not between", value1, value2, "fhasRealValidateTime");
            return (Criteria) this;
        }

        public Criteria andAuthStatusIsNull() {
            addCriterion("auth_status is null");
            return (Criteria) this;
        }

        public Criteria andAuthStatusIsNotNull() {
            addCriterion("auth_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuthStatusEqualTo(Integer value) {
            addCriterion("auth_status =", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusNotEqualTo(Integer value) {
            addCriterion("auth_status <>", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusGreaterThan(Integer value) {
            addCriterion("auth_status >", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("auth_status >=", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusLessThan(Integer value) {
            addCriterion("auth_status <", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusLessThanOrEqualTo(Integer value) {
            addCriterion("auth_status <=", value, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusIn(List<Integer> values) {
            addCriterion("auth_status in", values, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusNotIn(List<Integer> values) {
            addCriterion("auth_status not in", values, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusBetween(Integer value1, Integer value2) {
            addCriterion("auth_status between", value1, value2, "authStatus");
            return (Criteria) this;
        }

        public Criteria andAuthStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("auth_status not between", value1, value2, "authStatus");
            return (Criteria) this;
        }

        public Criteria andFidentityStatusIsNull() {
            addCriterion("fidentity_status is null");
            return (Criteria) this;
        }

        public Criteria andFidentityStatusIsNotNull() {
            addCriterion("fidentity_status is not null");
            return (Criteria) this;
        }

        public Criteria andFidentityStatusEqualTo(Integer value) {
            addCriterion("fidentity_status =", value, "fidentityStatus");
            return (Criteria) this;
        }

        public Criteria andFidentityStatusNotEqualTo(Integer value) {
            addCriterion("fidentity_status <>", value, "fidentityStatus");
            return (Criteria) this;
        }

        public Criteria andFidentityStatusGreaterThan(Integer value) {
            addCriterion("fidentity_status >", value, "fidentityStatus");
            return (Criteria) this;
        }

        public Criteria andFidentityStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("fidentity_status >=", value, "fidentityStatus");
            return (Criteria) this;
        }

        public Criteria andFidentityStatusLessThan(Integer value) {
            addCriterion("fidentity_status <", value, "fidentityStatus");
            return (Criteria) this;
        }

        public Criteria andFidentityStatusLessThanOrEqualTo(Integer value) {
            addCriterion("fidentity_status <=", value, "fidentityStatus");
            return (Criteria) this;
        }

        public Criteria andFidentityStatusIn(List<Integer> values) {
            addCriterion("fidentity_status in", values, "fidentityStatus");
            return (Criteria) this;
        }

        public Criteria andFidentityStatusNotIn(List<Integer> values) {
            addCriterion("fidentity_status not in", values, "fidentityStatus");
            return (Criteria) this;
        }

        public Criteria andFidentityStatusBetween(Integer value1, Integer value2) {
            addCriterion("fidentity_status between", value1, value2, "fidentityStatus");
            return (Criteria) this;
        }

        public Criteria andFidentityStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("fidentity_status not between", value1, value2, "fidentityStatus");
            return (Criteria) this;
        }

        public Criteria andFidentityPathIsNull() {
            addCriterion("fidentity_path is null");
            return (Criteria) this;
        }

        public Criteria andFidentityPathIsNotNull() {
            addCriterion("fidentity_path is not null");
            return (Criteria) this;
        }

        public Criteria andFidentityPathEqualTo(String value) {
            addCriterion("fidentity_path =", value, "fidentityPath");
            return (Criteria) this;
        }

        public Criteria andFidentityPathNotEqualTo(String value) {
            addCriterion("fidentity_path <>", value, "fidentityPath");
            return (Criteria) this;
        }

        public Criteria andFidentityPathGreaterThan(String value) {
            addCriterion("fidentity_path >", value, "fidentityPath");
            return (Criteria) this;
        }

        public Criteria andFidentityPathGreaterThanOrEqualTo(String value) {
            addCriterion("fidentity_path >=", value, "fidentityPath");
            return (Criteria) this;
        }

        public Criteria andFidentityPathLessThan(String value) {
            addCriterion("fidentity_path <", value, "fidentityPath");
            return (Criteria) this;
        }

        public Criteria andFidentityPathLessThanOrEqualTo(String value) {
            addCriterion("fidentity_path <=", value, "fidentityPath");
            return (Criteria) this;
        }

        public Criteria andFidentityPathLike(String value) {
            addCriterion("fidentity_path like", value, "fidentityPath");
            return (Criteria) this;
        }

        public Criteria andFidentityPathNotLike(String value) {
            addCriterion("fidentity_path not like", value, "fidentityPath");
            return (Criteria) this;
        }

        public Criteria andFidentityPathIn(List<String> values) {
            addCriterion("fidentity_path in", values, "fidentityPath");
            return (Criteria) this;
        }

        public Criteria andFidentityPathNotIn(List<String> values) {
            addCriterion("fidentity_path not in", values, "fidentityPath");
            return (Criteria) this;
        }

        public Criteria andFidentityPathBetween(String value1, String value2) {
            addCriterion("fidentity_path between", value1, value2, "fidentityPath");
            return (Criteria) this;
        }

        public Criteria andFidentityPathNotBetween(String value1, String value2) {
            addCriterion("fidentity_path not between", value1, value2, "fidentityPath");
            return (Criteria) this;
        }

        public Criteria andFidentityPath2IsNull() {
            addCriterion("fidentity_path2 is null");
            return (Criteria) this;
        }

        public Criteria andFidentityPath2IsNotNull() {
            addCriterion("fidentity_path2 is not null");
            return (Criteria) this;
        }

        public Criteria andFidentityPath2EqualTo(String value) {
            addCriterion("fidentity_path2 =", value, "fidentityPath2");
            return (Criteria) this;
        }

        public Criteria andFidentityPath2NotEqualTo(String value) {
            addCriterion("fidentity_path2 <>", value, "fidentityPath2");
            return (Criteria) this;
        }

        public Criteria andFidentityPath2GreaterThan(String value) {
            addCriterion("fidentity_path2 >", value, "fidentityPath2");
            return (Criteria) this;
        }

        public Criteria andFidentityPath2GreaterThanOrEqualTo(String value) {
            addCriterion("fidentity_path2 >=", value, "fidentityPath2");
            return (Criteria) this;
        }

        public Criteria andFidentityPath2LessThan(String value) {
            addCriterion("fidentity_path2 <", value, "fidentityPath2");
            return (Criteria) this;
        }

        public Criteria andFidentityPath2LessThanOrEqualTo(String value) {
            addCriterion("fidentity_path2 <=", value, "fidentityPath2");
            return (Criteria) this;
        }

        public Criteria andFidentityPath2Like(String value) {
            addCriterion("fidentity_path2 like", value, "fidentityPath2");
            return (Criteria) this;
        }

        public Criteria andFidentityPath2NotLike(String value) {
            addCriterion("fidentity_path2 not like", value, "fidentityPath2");
            return (Criteria) this;
        }

        public Criteria andFidentityPath2In(List<String> values) {
            addCriterion("fidentity_path2 in", values, "fidentityPath2");
            return (Criteria) this;
        }

        public Criteria andFidentityPath2NotIn(List<String> values) {
            addCriterion("fidentity_path2 not in", values, "fidentityPath2");
            return (Criteria) this;
        }

        public Criteria andFidentityPath2Between(String value1, String value2) {
            addCriterion("fidentity_path2 between", value1, value2, "fidentityPath2");
            return (Criteria) this;
        }

        public Criteria andFidentityPath2NotBetween(String value1, String value2) {
            addCriterion("fidentity_path2 not between", value1, value2, "fidentityPath2");
            return (Criteria) this;
        }

        public Criteria andFidentityPath3IsNull() {
            addCriterion("fidentity_path3 is null");
            return (Criteria) this;
        }

        public Criteria andFidentityPath3IsNotNull() {
            addCriterion("fidentity_path3 is not null");
            return (Criteria) this;
        }

        public Criteria andFidentityPath3EqualTo(String value) {
            addCriterion("fidentity_path3 =", value, "fidentityPath3");
            return (Criteria) this;
        }

        public Criteria andFidentityPath3NotEqualTo(String value) {
            addCriterion("fidentity_path3 <>", value, "fidentityPath3");
            return (Criteria) this;
        }

        public Criteria andFidentityPath3GreaterThan(String value) {
            addCriterion("fidentity_path3 >", value, "fidentityPath3");
            return (Criteria) this;
        }

        public Criteria andFidentityPath3GreaterThanOrEqualTo(String value) {
            addCriterion("fidentity_path3 >=", value, "fidentityPath3");
            return (Criteria) this;
        }

        public Criteria andFidentityPath3LessThan(String value) {
            addCriterion("fidentity_path3 <", value, "fidentityPath3");
            return (Criteria) this;
        }

        public Criteria andFidentityPath3LessThanOrEqualTo(String value) {
            addCriterion("fidentity_path3 <=", value, "fidentityPath3");
            return (Criteria) this;
        }

        public Criteria andFidentityPath3Like(String value) {
            addCriterion("fidentity_path3 like", value, "fidentityPath3");
            return (Criteria) this;
        }

        public Criteria andFidentityPath3NotLike(String value) {
            addCriterion("fidentity_path3 not like", value, "fidentityPath3");
            return (Criteria) this;
        }

        public Criteria andFidentityPath3In(List<String> values) {
            addCriterion("fidentity_path3 in", values, "fidentityPath3");
            return (Criteria) this;
        }

        public Criteria andFidentityPath3NotIn(List<String> values) {
            addCriterion("fidentity_path3 not in", values, "fidentityPath3");
            return (Criteria) this;
        }

        public Criteria andFidentityPath3Between(String value1, String value2) {
            addCriterion("fidentity_path3 between", value1, value2, "fidentityPath3");
            return (Criteria) this;
        }

        public Criteria andFidentityPath3NotBetween(String value1, String value2) {
            addCriterion("fidentity_path3 not between", value1, value2, "fidentityPath3");
            return (Criteria) this;
        }

        public Criteria andMemWordsIsNull() {
            addCriterion("mem_words is null");
            return (Criteria) this;
        }

        public Criteria andMemWordsIsNotNull() {
            addCriterion("mem_words is not null");
            return (Criteria) this;
        }

        public Criteria andMemWordsEqualTo(String value) {
            addCriterion("mem_words =", value, "memWords");
            return (Criteria) this;
        }

        public Criteria andMemWordsNotEqualTo(String value) {
            addCriterion("mem_words <>", value, "memWords");
            return (Criteria) this;
        }

        public Criteria andMemWordsGreaterThan(String value) {
            addCriterion("mem_words >", value, "memWords");
            return (Criteria) this;
        }

        public Criteria andMemWordsGreaterThanOrEqualTo(String value) {
            addCriterion("mem_words >=", value, "memWords");
            return (Criteria) this;
        }

        public Criteria andMemWordsLessThan(String value) {
            addCriterion("mem_words <", value, "memWords");
            return (Criteria) this;
        }

        public Criteria andMemWordsLessThanOrEqualTo(String value) {
            addCriterion("mem_words <=", value, "memWords");
            return (Criteria) this;
        }

        public Criteria andMemWordsLike(String value) {
            addCriterion("mem_words like", value, "memWords");
            return (Criteria) this;
        }

        public Criteria andMemWordsNotLike(String value) {
            addCriterion("mem_words not like", value, "memWords");
            return (Criteria) this;
        }

        public Criteria andMemWordsIn(List<String> values) {
            addCriterion("mem_words in", values, "memWords");
            return (Criteria) this;
        }

        public Criteria andMemWordsNotIn(List<String> values) {
            addCriterion("mem_words not in", values, "memWords");
            return (Criteria) this;
        }

        public Criteria andMemWordsBetween(String value1, String value2) {
            addCriterion("mem_words between", value1, value2, "memWords");
            return (Criteria) this;
        }

        public Criteria andMemWordsNotBetween(String value1, String value2) {
            addCriterion("mem_words not between", value1, value2, "memWords");
            return (Criteria) this;
        }

        public Criteria andFheadImgUrlIsNull() {
            addCriterion("fhead_img_url is null");
            return (Criteria) this;
        }

        public Criteria andFheadImgUrlIsNotNull() {
            addCriterion("fhead_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andFheadImgUrlEqualTo(String value) {
            addCriterion("fhead_img_url =", value, "fheadImgUrl");
            return (Criteria) this;
        }

        public Criteria andFheadImgUrlNotEqualTo(String value) {
            addCriterion("fhead_img_url <>", value, "fheadImgUrl");
            return (Criteria) this;
        }

        public Criteria andFheadImgUrlGreaterThan(String value) {
            addCriterion("fhead_img_url >", value, "fheadImgUrl");
            return (Criteria) this;
        }

        public Criteria andFheadImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("fhead_img_url >=", value, "fheadImgUrl");
            return (Criteria) this;
        }

        public Criteria andFheadImgUrlLessThan(String value) {
            addCriterion("fhead_img_url <", value, "fheadImgUrl");
            return (Criteria) this;
        }

        public Criteria andFheadImgUrlLessThanOrEqualTo(String value) {
            addCriterion("fhead_img_url <=", value, "fheadImgUrl");
            return (Criteria) this;
        }

        public Criteria andFheadImgUrlLike(String value) {
            addCriterion("fhead_img_url like", value, "fheadImgUrl");
            return (Criteria) this;
        }

        public Criteria andFheadImgUrlNotLike(String value) {
            addCriterion("fhead_img_url not like", value, "fheadImgUrl");
            return (Criteria) this;
        }

        public Criteria andFheadImgUrlIn(List<String> values) {
            addCriterion("fhead_img_url in", values, "fheadImgUrl");
            return (Criteria) this;
        }

        public Criteria andFheadImgUrlNotIn(List<String> values) {
            addCriterion("fhead_img_url not in", values, "fheadImgUrl");
            return (Criteria) this;
        }

        public Criteria andFheadImgUrlBetween(String value1, String value2) {
            addCriterion("fhead_img_url between", value1, value2, "fheadImgUrl");
            return (Criteria) this;
        }

        public Criteria andFheadImgUrlNotBetween(String value1, String value2) {
            addCriterion("fhead_img_url not between", value1, value2, "fheadImgUrl");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andGagTimeIsNull() {
            addCriterion("gag_time is null");
            return (Criteria) this;
        }

        public Criteria andGagTimeIsNotNull() {
            addCriterion("gag_time is not null");
            return (Criteria) this;
        }

        public Criteria andGagTimeEqualTo(Date value) {
            addCriterion("gag_time =", value, "gagTime");
            return (Criteria) this;
        }

        public Criteria andGagTimeNotEqualTo(Date value) {
            addCriterion("gag_time <>", value, "gagTime");
            return (Criteria) this;
        }

        public Criteria andGagTimeGreaterThan(Date value) {
            addCriterion("gag_time >", value, "gagTime");
            return (Criteria) this;
        }

        public Criteria andGagTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gag_time >=", value, "gagTime");
            return (Criteria) this;
        }

        public Criteria andGagTimeLessThan(Date value) {
            addCriterion("gag_time <", value, "gagTime");
            return (Criteria) this;
        }

        public Criteria andGagTimeLessThanOrEqualTo(Date value) {
            addCriterion("gag_time <=", value, "gagTime");
            return (Criteria) this;
        }

        public Criteria andGagTimeIn(List<Date> values) {
            addCriterion("gag_time in", values, "gagTime");
            return (Criteria) this;
        }

        public Criteria andGagTimeNotIn(List<Date> values) {
            addCriterion("gag_time not in", values, "gagTime");
            return (Criteria) this;
        }

        public Criteria andGagTimeBetween(Date value1, Date value2) {
            addCriterion("gag_time between", value1, value2, "gagTime");
            return (Criteria) this;
        }

        public Criteria andGagTimeNotBetween(Date value1, Date value2) {
            addCriterion("gag_time not between", value1, value2, "gagTime");
            return (Criteria) this;
        }

        public Criteria andWalletStatusIsNull() {
            addCriterion("wallet_status is null");
            return (Criteria) this;
        }

        public Criteria andWalletStatusIsNotNull() {
            addCriterion("wallet_status is not null");
            return (Criteria) this;
        }

        public Criteria andWalletStatusEqualTo(Integer value) {
            addCriterion("wallet_status =", value, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusNotEqualTo(Integer value) {
            addCriterion("wallet_status <>", value, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusGreaterThan(Integer value) {
            addCriterion("wallet_status >", value, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("wallet_status >=", value, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusLessThan(Integer value) {
            addCriterion("wallet_status <", value, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusLessThanOrEqualTo(Integer value) {
            addCriterion("wallet_status <=", value, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusIn(List<Integer> values) {
            addCriterion("wallet_status in", values, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusNotIn(List<Integer> values) {
            addCriterion("wallet_status not in", values, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusBetween(Integer value1, Integer value2) {
            addCriterion("wallet_status between", value1, value2, "walletStatus");
            return (Criteria) this;
        }

        public Criteria andWalletStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("wallet_status not between", value1, value2, "walletStatus");
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