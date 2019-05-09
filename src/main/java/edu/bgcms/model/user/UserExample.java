package edu.bgcms.model.user;

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

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andRolerIsNull() {
            addCriterion("roler is null");
            return (Criteria) this;
        }

        public Criteria andRolerIsNotNull() {
            addCriterion("roler is not null");
            return (Criteria) this;
        }

        public Criteria andRolerEqualTo(String value) {
            addCriterion("roler =", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerNotEqualTo(String value) {
            addCriterion("roler <>", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerGreaterThan(String value) {
            addCriterion("roler >", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerGreaterThanOrEqualTo(String value) {
            addCriterion("roler >=", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerLessThan(String value) {
            addCriterion("roler <", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerLessThanOrEqualTo(String value) {
            addCriterion("roler <=", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerLike(String value) {
            addCriterion("roler like", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerNotLike(String value) {
            addCriterion("roler not like", value, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerIn(List<String> values) {
            addCriterion("roler in", values, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerNotIn(List<String> values) {
            addCriterion("roler not in", values, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerBetween(String value1, String value2) {
            addCriterion("roler between", value1, value2, "roler");
            return (Criteria) this;
        }

        public Criteria andRolerNotBetween(String value1, String value2) {
            addCriterion("roler not between", value1, value2, "roler");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNull() {
            addCriterion("experience is null");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNotNull() {
            addCriterion("experience is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceEqualTo(Double value) {
            addCriterion("experience =", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotEqualTo(Double value) {
            addCriterion("experience <>", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThan(Double value) {
            addCriterion("experience >", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThanOrEqualTo(Double value) {
            addCriterion("experience >=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThan(Double value) {
            addCriterion("experience <", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThanOrEqualTo(Double value) {
            addCriterion("experience <=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceIn(List<Double> values) {
            addCriterion("experience in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotIn(List<Double> values) {
            addCriterion("experience not in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceBetween(Double value1, Double value2) {
            addCriterion("experience between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotBetween(Double value1, Double value2) {
            addCriterion("experience not between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andMailIsNull() {
            addCriterion("mail is null");
            return (Criteria) this;
        }

        public Criteria andMailIsNotNull() {
            addCriterion("mail is not null");
            return (Criteria) this;
        }

        public Criteria andMailEqualTo(String value) {
            addCriterion("mail =", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotEqualTo(String value) {
            addCriterion("mail <>", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThan(String value) {
            addCriterion("mail >", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThanOrEqualTo(String value) {
            addCriterion("mail >=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThan(String value) {
            addCriterion("mail <", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThanOrEqualTo(String value) {
            addCriterion("mail <=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLike(String value) {
            addCriterion("mail like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotLike(String value) {
            addCriterion("mail not like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailIn(List<String> values) {
            addCriterion("mail in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotIn(List<String> values) {
            addCriterion("mail not in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailBetween(String value1, String value2) {
            addCriterion("mail between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotBetween(String value1, String value2) {
            addCriterion("mail not between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNull() {
            addCriterion("college is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNotNull() {
            addCriterion("college is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeEqualTo(String value) {
            addCriterion("college =", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotEqualTo(String value) {
            addCriterion("college <>", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThan(String value) {
            addCriterion("college >", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThanOrEqualTo(String value) {
            addCriterion("college >=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThan(String value) {
            addCriterion("college <", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThanOrEqualTo(String value) {
            addCriterion("college <=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLike(String value) {
            addCriterion("college like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotLike(String value) {
            addCriterion("college not like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeIn(List<String> values) {
            addCriterion("college in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotIn(List<String> values) {
            addCriterion("college not in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeBetween(String value1, String value2) {
            addCriterion("college between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotBetween(String value1, String value2) {
            addCriterion("college not between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andMottoIsNull() {
            addCriterion("motto is null");
            return (Criteria) this;
        }

        public Criteria andMottoIsNotNull() {
            addCriterion("motto is not null");
            return (Criteria) this;
        }

        public Criteria andMottoEqualTo(String value) {
            addCriterion("motto =", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoNotEqualTo(String value) {
            addCriterion("motto <>", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoGreaterThan(String value) {
            addCriterion("motto >", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoGreaterThanOrEqualTo(String value) {
            addCriterion("motto >=", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoLessThan(String value) {
            addCriterion("motto <", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoLessThanOrEqualTo(String value) {
            addCriterion("motto <=", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoLike(String value) {
            addCriterion("motto like", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoNotLike(String value) {
            addCriterion("motto not like", value, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoIn(List<String> values) {
            addCriterion("motto in", values, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoNotIn(List<String> values) {
            addCriterion("motto not in", values, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoBetween(String value1, String value2) {
            addCriterion("motto between", value1, value2, "motto");
            return (Criteria) this;
        }

        public Criteria andMottoNotBetween(String value1, String value2) {
            addCriterion("motto not between", value1, value2, "motto");
            return (Criteria) this;
        }

        public Criteria andMessagenumeberIsNull() {
            addCriterion("messageNumeber is null");
            return (Criteria) this;
        }

        public Criteria andMessagenumeberIsNotNull() {
            addCriterion("messageNumeber is not null");
            return (Criteria) this;
        }

        public Criteria andMessagenumeberEqualTo(Integer value) {
            addCriterion("messageNumeber =", value, "messagenumeber");
            return (Criteria) this;
        }

        public Criteria andMessagenumeberNotEqualTo(Integer value) {
            addCriterion("messageNumeber <>", value, "messagenumeber");
            return (Criteria) this;
        }

        public Criteria andMessagenumeberGreaterThan(Integer value) {
            addCriterion("messageNumeber >", value, "messagenumeber");
            return (Criteria) this;
        }

        public Criteria andMessagenumeberGreaterThanOrEqualTo(Integer value) {
            addCriterion("messageNumeber >=", value, "messagenumeber");
            return (Criteria) this;
        }

        public Criteria andMessagenumeberLessThan(Integer value) {
            addCriterion("messageNumeber <", value, "messagenumeber");
            return (Criteria) this;
        }

        public Criteria andMessagenumeberLessThanOrEqualTo(Integer value) {
            addCriterion("messageNumeber <=", value, "messagenumeber");
            return (Criteria) this;
        }

        public Criteria andMessagenumeberIn(List<Integer> values) {
            addCriterion("messageNumeber in", values, "messagenumeber");
            return (Criteria) this;
        }

        public Criteria andMessagenumeberNotIn(List<Integer> values) {
            addCriterion("messageNumeber not in", values, "messagenumeber");
            return (Criteria) this;
        }

        public Criteria andMessagenumeberBetween(Integer value1, Integer value2) {
            addCriterion("messageNumeber between", value1, value2, "messagenumeber");
            return (Criteria) this;
        }

        public Criteria andMessagenumeberNotBetween(Integer value1, Integer value2) {
            addCriterion("messageNumeber not between", value1, value2, "messagenumeber");
            return (Criteria) this;
        }

        public Criteria andDenyIsNull() {
            addCriterion("deny is null");
            return (Criteria) this;
        }

        public Criteria andDenyIsNotNull() {
            addCriterion("deny is not null");
            return (Criteria) this;
        }

        public Criteria andDenyEqualTo(Integer value) {
            addCriterion("deny =", value, "deny");
            return (Criteria) this;
        }

        public Criteria andDenyNotEqualTo(Integer value) {
            addCriterion("deny <>", value, "deny");
            return (Criteria) this;
        }

        public Criteria andDenyGreaterThan(Integer value) {
            addCriterion("deny >", value, "deny");
            return (Criteria) this;
        }

        public Criteria andDenyGreaterThanOrEqualTo(Integer value) {
            addCriterion("deny >=", value, "deny");
            return (Criteria) this;
        }

        public Criteria andDenyLessThan(Integer value) {
            addCriterion("deny <", value, "deny");
            return (Criteria) this;
        }

        public Criteria andDenyLessThanOrEqualTo(Integer value) {
            addCriterion("deny <=", value, "deny");
            return (Criteria) this;
        }

        public Criteria andDenyIn(List<Integer> values) {
            addCriterion("deny in", values, "deny");
            return (Criteria) this;
        }

        public Criteria andDenyNotIn(List<Integer> values) {
            addCriterion("deny not in", values, "deny");
            return (Criteria) this;
        }

        public Criteria andDenyBetween(Integer value1, Integer value2) {
            addCriterion("deny between", value1, value2, "deny");
            return (Criteria) this;
        }

        public Criteria andDenyNotBetween(Integer value1, Integer value2) {
            addCriterion("deny not between", value1, value2, "deny");
            return (Criteria) this;
        }

        public Criteria andShowpersonIsNull() {
            addCriterion("showPerson is null");
            return (Criteria) this;
        }

        public Criteria andShowpersonIsNotNull() {
            addCriterion("showPerson is not null");
            return (Criteria) this;
        }

        public Criteria andShowpersonEqualTo(Integer value) {
            addCriterion("showPerson =", value, "showperson");
            return (Criteria) this;
        }

        public Criteria andShowpersonNotEqualTo(Integer value) {
            addCriterion("showPerson <>", value, "showperson");
            return (Criteria) this;
        }

        public Criteria andShowpersonGreaterThan(Integer value) {
            addCriterion("showPerson >", value, "showperson");
            return (Criteria) this;
        }

        public Criteria andShowpersonGreaterThanOrEqualTo(Integer value) {
            addCriterion("showPerson >=", value, "showperson");
            return (Criteria) this;
        }

        public Criteria andShowpersonLessThan(Integer value) {
            addCriterion("showPerson <", value, "showperson");
            return (Criteria) this;
        }

        public Criteria andShowpersonLessThanOrEqualTo(Integer value) {
            addCriterion("showPerson <=", value, "showperson");
            return (Criteria) this;
        }

        public Criteria andShowpersonIn(List<Integer> values) {
            addCriterion("showPerson in", values, "showperson");
            return (Criteria) this;
        }

        public Criteria andShowpersonNotIn(List<Integer> values) {
            addCriterion("showPerson not in", values, "showperson");
            return (Criteria) this;
        }

        public Criteria andShowpersonBetween(Integer value1, Integer value2) {
            addCriterion("showPerson between", value1, value2, "showperson");
            return (Criteria) this;
        }

        public Criteria andShowpersonNotBetween(Integer value1, Integer value2) {
            addCriterion("showPerson not between", value1, value2, "showperson");
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