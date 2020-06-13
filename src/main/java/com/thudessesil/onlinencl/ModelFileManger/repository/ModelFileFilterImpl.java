package com.thudessesil.onlinencl.ModelFileManger.repository;

import com.thudessesil.onlinencl.ModelFileManger.model.ModelFile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.text.MessageFormat;
import java.util.List;

@Repository
public class ModelFileFilterImpl implements ModelFileFilter{
    @PersistenceContext
    private EntityManager entityManager;

    // helper function
    private static String contains(String expression) {
        return MessageFormat.format("%{0}%", expression);
    }

    @Override
    public List<String> findOneColumnByModelFileFilter(String columnName, String model, String startTime, String variableName) {
        // select columnName from ModelFile where model LIKE "" and startTime LIKE "" and variableName LIKE ""
        // 3 LIKE parameters will be overlooked if null
        // builder of criteria
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        // table/Entity to query: ModelFile
        CriteriaQuery q = cb.createQuery();
        // root to query in this criteria
        Root<ModelFile> modelFile = q.from(ModelFile.class);

        // path of the column to select
        Path<String> columnPath = modelFile.get(columnName);

        Predicate p1 = (model == null ? null : cb.like(modelFile.get("model"), contains(model)));
        Predicate p2 = (model == null ? null : cb.like(modelFile.get("startTime"), contains(startTime)));
        Predicate p3 = (model == null ? null : cb.like(modelFile.get("variableName"), contains(variableName)));

        // config the column to select, and find distinct value
        q.select(cb.construct(String.class, modelFile.get(columnName)));
        // use "and" to link those critera
        q.where(cb.and(p1,p2,p3));
        // select distinct value
        q.distinct(true);

        return entityManager.createQuery(q).getResultList();
    }
}
