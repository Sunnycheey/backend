package dblab.bit.backend.services;

import dblab.bit.backend.models.RelationEntity.RelationOverTopics.ContributeTo;

/**
 * @program: backend
 * @description: service for relation search
 * @author: lihuichao
 * @create: 2020-04-24
 **/
public interface RelationService {
    ContributeTo getContributoById(long id);
}
