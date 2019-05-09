package edu.bgcms.model.boardGame;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardGameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BoardGameExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andInformationIsNull() {
            addCriterion("information is null");
            return (Criteria) this;
        }

        public Criteria andInformationIsNotNull() {
            addCriterion("information is not null");
            return (Criteria) this;
        }

        public Criteria andInformationEqualTo(String value) {
            addCriterion("information =", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotEqualTo(String value) {
            addCriterion("information <>", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationGreaterThan(String value) {
            addCriterion("information >", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationGreaterThanOrEqualTo(String value) {
            addCriterion("information >=", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationLessThan(String value) {
            addCriterion("information <", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationLessThanOrEqualTo(String value) {
            addCriterion("information <=", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationLike(String value) {
            addCriterion("information like", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotLike(String value) {
            addCriterion("information not like", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationIn(List<String> values) {
            addCriterion("information in", values, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotIn(List<String> values) {
            addCriterion("information not in", values, "information");
            return (Criteria) this;
        }

        public Criteria andInformationBetween(String value1, String value2) {
            addCriterion("information between", value1, value2, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotBetween(String value1, String value2) {
            addCriterion("information not between", value1, value2, "information");
            return (Criteria) this;
        }

        public Criteria andMaxplayersIsNull() {
            addCriterion("maxPlayers is null");
            return (Criteria) this;
        }

        public Criteria andMaxplayersIsNotNull() {
            addCriterion("maxPlayers is not null");
            return (Criteria) this;
        }

        public Criteria andMaxplayersEqualTo(Integer value) {
            addCriterion("maxPlayers =", value, "maxplayers");
            return (Criteria) this;
        }

        public Criteria andMaxplayersNotEqualTo(Integer value) {
            addCriterion("maxPlayers <>", value, "maxplayers");
            return (Criteria) this;
        }

        public Criteria andMaxplayersGreaterThan(Integer value) {
            addCriterion("maxPlayers >", value, "maxplayers");
            return (Criteria) this;
        }

        public Criteria andMaxplayersGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxPlayers >=", value, "maxplayers");
            return (Criteria) this;
        }

        public Criteria andMaxplayersLessThan(Integer value) {
            addCriterion("maxPlayers <", value, "maxplayers");
            return (Criteria) this;
        }

        public Criteria andMaxplayersLessThanOrEqualTo(Integer value) {
            addCriterion("maxPlayers <=", value, "maxplayers");
            return (Criteria) this;
        }

        public Criteria andMaxplayersIn(List<Integer> values) {
            addCriterion("maxPlayers in", values, "maxplayers");
            return (Criteria) this;
        }

        public Criteria andMaxplayersNotIn(List<Integer> values) {
            addCriterion("maxPlayers not in", values, "maxplayers");
            return (Criteria) this;
        }

        public Criteria andMaxplayersBetween(Integer value1, Integer value2) {
            addCriterion("maxPlayers between", value1, value2, "maxplayers");
            return (Criteria) this;
        }

        public Criteria andMaxplayersNotBetween(Integer value1, Integer value2) {
            addCriterion("maxPlayers not between", value1, value2, "maxplayers");
            return (Criteria) this;
        }

        public Criteria andBuytimeIsNull() {
            addCriterion("buytime is null");
            return (Criteria) this;
        }

        public Criteria andBuytimeIsNotNull() {
            addCriterion("buytime is not null");
            return (Criteria) this;
        }

        public Criteria andBuytimeEqualTo(String value) {
            addCriterion("buytime =", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeNotEqualTo(String value) {
            addCriterion("buytime <>", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeGreaterThan(String value) {
            addCriterion("buytime >", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeGreaterThanOrEqualTo(String value) {
            addCriterion("buytime >=", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeLessThan(String value) {
            addCriterion("buytime <", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeLessThanOrEqualTo(String value) {
            addCriterion("buytime <=", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeLike(String value) {
            addCriterion("buytime like", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeNotLike(String value) {
            addCriterion("buytime not like", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeIn(List<String> values) {
            addCriterion("buytime in", values, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeNotIn(List<String> values) {
            addCriterion("buytime not in", values, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeBetween(String value1, String value2) {
            addCriterion("buytime between", value1, value2, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeNotBetween(String value1, String value2) {
            addCriterion("buytime not between", value1, value2, "buytime");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNull() {
            addCriterion("applicant is null");
            return (Criteria) this;
        }

        public Criteria andApplicantIsNotNull() {
            addCriterion("applicant is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantEqualTo(String value) {
            addCriterion("applicant =", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotEqualTo(String value) {
            addCriterion("applicant <>", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThan(String value) {
            addCriterion("applicant >", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantGreaterThanOrEqualTo(String value) {
            addCriterion("applicant >=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThan(String value) {
            addCriterion("applicant <", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLessThanOrEqualTo(String value) {
            addCriterion("applicant <=", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantLike(String value) {
            addCriterion("applicant like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotLike(String value) {
            addCriterion("applicant not like", value, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantIn(List<String> values) {
            addCriterion("applicant in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotIn(List<String> values) {
            addCriterion("applicant not in", values, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantBetween(String value1, String value2) {
            addCriterion("applicant between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantNotBetween(String value1, String value2) {
            addCriterion("applicant not between", value1, value2, "applicant");
            return (Criteria) this;
        }

        public Criteria andApplicantiontimeIsNull() {
            addCriterion("applicantiontime is null");
            return (Criteria) this;
        }

        public Criteria andApplicantiontimeIsNotNull() {
            addCriterion("applicantiontime is not null");
            return (Criteria) this;
        }

        public Criteria andApplicantiontimeEqualTo(Date value) {
            addCriterion("applicantiontime =", value, "applicantiontime");
            return (Criteria) this;
        }

        public Criteria andApplicantiontimeNotEqualTo(Date value) {
            addCriterion("applicantiontime <>", value, "applicantiontime");
            return (Criteria) this;
        }

        public Criteria andApplicantiontimeGreaterThan(Date value) {
            addCriterion("applicantiontime >", value, "applicantiontime");
            return (Criteria) this;
        }

        public Criteria andApplicantiontimeGreaterThanOrEqualTo(Date value) {
            addCriterion("applicantiontime >=", value, "applicantiontime");
            return (Criteria) this;
        }

        public Criteria andApplicantiontimeLessThan(Date value) {
            addCriterion("applicantiontime <", value, "applicantiontime");
            return (Criteria) this;
        }

        public Criteria andApplicantiontimeLessThanOrEqualTo(Date value) {
            addCriterion("applicantiontime <=", value, "applicantiontime");
            return (Criteria) this;
        }

        public Criteria andApplicantiontimeIn(List<Date> values) {
            addCriterion("applicantiontime in", values, "applicantiontime");
            return (Criteria) this;
        }

        public Criteria andApplicantiontimeNotIn(List<Date> values) {
            addCriterion("applicantiontime not in", values, "applicantiontime");
            return (Criteria) this;
        }

        public Criteria andApplicantiontimeBetween(Date value1, Date value2) {
            addCriterion("applicantiontime between", value1, value2, "applicantiontime");
            return (Criteria) this;
        }

        public Criteria andApplicantiontimeNotBetween(Date value1, Date value2) {
            addCriterion("applicantiontime not between", value1, value2, "applicantiontime");
            return (Criteria) this;
        }

        public Criteria andCurrentuserIsNull() {
            addCriterion("currentUser is null");
            return (Criteria) this;
        }

        public Criteria andCurrentuserIsNotNull() {
            addCriterion("currentUser is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentuserEqualTo(String value) {
            addCriterion("currentUser =", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserNotEqualTo(String value) {
            addCriterion("currentUser <>", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserGreaterThan(String value) {
            addCriterion("currentUser >", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserGreaterThanOrEqualTo(String value) {
            addCriterion("currentUser >=", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserLessThan(String value) {
            addCriterion("currentUser <", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserLessThanOrEqualTo(String value) {
            addCriterion("currentUser <=", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserLike(String value) {
            addCriterion("currentUser like", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserNotLike(String value) {
            addCriterion("currentUser not like", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserIn(List<String> values) {
            addCriterion("currentUser in", values, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserNotIn(List<String> values) {
            addCriterion("currentUser not in", values, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserBetween(String value1, String value2) {
            addCriterion("currentUser between", value1, value2, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserNotBetween(String value1, String value2) {
            addCriterion("currentUser not between", value1, value2, "currentuser");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andViewsIsNull() {
            addCriterion("views is null");
            return (Criteria) this;
        }

        public Criteria andViewsIsNotNull() {
            addCriterion("views is not null");
            return (Criteria) this;
        }

        public Criteria andViewsEqualTo(Integer value) {
            addCriterion("views =", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotEqualTo(Integer value) {
            addCriterion("views <>", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsGreaterThan(Integer value) {
            addCriterion("views >", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsGreaterThanOrEqualTo(Integer value) {
            addCriterion("views >=", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsLessThan(Integer value) {
            addCriterion("views <", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsLessThanOrEqualTo(Integer value) {
            addCriterion("views <=", value, "views");
            return (Criteria) this;
        }

        public Criteria andViewsIn(List<Integer> values) {
            addCriterion("views in", values, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotIn(List<Integer> values) {
            addCriterion("views not in", values, "views");
            return (Criteria) this;
        }

        public Criteria andViewsBetween(Integer value1, Integer value2) {
            addCriterion("views between", value1, value2, "views");
            return (Criteria) this;
        }

        public Criteria andViewsNotBetween(Integer value1, Integer value2) {
            addCriterion("views not between", value1, value2, "views");
            return (Criteria) this;
        }

        public Criteria andLendsIsNull() {
            addCriterion("lends is null");
            return (Criteria) this;
        }

        public Criteria andLendsIsNotNull() {
            addCriterion("lends is not null");
            return (Criteria) this;
        }

        public Criteria andLendsEqualTo(Integer value) {
            addCriterion("lends =", value, "lends");
            return (Criteria) this;
        }

        public Criteria andLendsNotEqualTo(Integer value) {
            addCriterion("lends <>", value, "lends");
            return (Criteria) this;
        }

        public Criteria andLendsGreaterThan(Integer value) {
            addCriterion("lends >", value, "lends");
            return (Criteria) this;
        }

        public Criteria andLendsGreaterThanOrEqualTo(Integer value) {
            addCriterion("lends >=", value, "lends");
            return (Criteria) this;
        }

        public Criteria andLendsLessThan(Integer value) {
            addCriterion("lends <", value, "lends");
            return (Criteria) this;
        }

        public Criteria andLendsLessThanOrEqualTo(Integer value) {
            addCriterion("lends <=", value, "lends");
            return (Criteria) this;
        }

        public Criteria andLendsIn(List<Integer> values) {
            addCriterion("lends in", values, "lends");
            return (Criteria) this;
        }

        public Criteria andLendsNotIn(List<Integer> values) {
            addCriterion("lends not in", values, "lends");
            return (Criteria) this;
        }

        public Criteria andLendsBetween(Integer value1, Integer value2) {
            addCriterion("lends between", value1, value2, "lends");
            return (Criteria) this;
        }

        public Criteria andLendsNotBetween(Integer value1, Integer value2) {
            addCriterion("lends not between", value1, value2, "lends");
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