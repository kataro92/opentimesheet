package com.kat.opentimesheet.repository.impl;

import com.kat.opentimesheet.common.model.TsUserEntity;
import com.kat.opentimesheet.common.model.TsUserEntity_;
import com.kat.opentimesheet.repository.interfaces.UserRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public TsUserEntity getUserByUsernameAndPassword(String username, String md5_password) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TsUserEntity> criteriaQuery = builder.createQuery(TsUserEntity.class);
        Root<TsUserEntity> root = criteriaQuery.from(TsUserEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.isNotNull(root.get(TsUserEntity_.userId)));
        predicates.add(builder.equal(root.get(TsUserEntity_.userName), username));
        predicates.add(builder.equal(root.get(TsUserEntity_.password), md5_password));
        criteriaQuery.select(root).where(predicates.stream().toArray(Predicate[]::new));
        final TypedQuery<TsUserEntity> query = entityManager.createQuery(criteriaQuery);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
