package com.kat.opentimesheet.repository.impl;

import com.kat.opentimesheet.common.model.TsUserEntity;
import com.kat.opentimesheet.common.model.TsUserEntity_;
import com.kat.opentimesheet.repository.interfaces.UserRepo;
import com.kat.opentimesheet.service.impl.BeanUtil;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {
    private EntityManager entityManager;
    @Override
    public TsUserEntity getUserByUsernameAndPassword(String username, String md5_password) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<TsUserEntity> criteriaQuery = builder.createQuery(TsUserEntity.class);
        Root<TsUserEntity> root = criteriaQuery.from(TsUserEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.isNotNull(root.get(TsUserEntity_.userId)));
        predicates.add(builder.equal(root.get(TsUserEntity_.userName), username));
        predicates.add(builder.equal(root.get(TsUserEntity_.password), md5_password));
        criteriaQuery.select(root).where(predicates.stream().toArray(Predicate[]::new));
        final TypedQuery<TsUserEntity> query = getEntityManager().createQuery(criteriaQuery);
        try {
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public EntityManager getEntityManager() {
        if(entityManager == null){
            entityManager = BeanUtil.getBean(EntityManager.class);
        }
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
