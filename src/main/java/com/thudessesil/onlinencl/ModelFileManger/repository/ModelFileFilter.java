package com.thudessesil.onlinencl.ModelFileManger.repository;

import java.util.List;

// 3 ways of dynamic query

// 1. ExampleMatcher: Requires to extend JpaRepository, but need to define a new entity(@MappedSuperClass for example) as
// a view of the properties you want, or it will return all fields
//public interface ModelFileFilter extends JpaRepository<String, Long>
//
// 2. JpaSpecificationExecutor to perform complicated query (multiple criteria, pageable, etc)
// use findAll(Specification) method to get wanted result, the Specification is defined by user, but you can only control the "where" part of in a DB query
// therefore you have to either use criteria builder or use query derivation with projections and the very limited native query support
// (https://stackoverflow.com/questions/22171822/spring-data-jpa-specification-to-select-specific-columns)
// see https://blog.csdn.net/qq_30054997/article/details/79420141
// https://blog.csdn.net/snailisBigbull/article/details/99698123
// https://dimitr.im/writing-dynamic-queries-with-spring-data-jpa
// https://www.jianshu.com/p/86da78fd14f2
// public interface ModelFileFilter extends JpaRepository<String, Long>, JpaSpecificationExecutor<String> {
//
// 3. (this method) CriteriaBuilder to control all parts of a query. Jpa Specification is an abstraction on top of this JPA Criteria API
// see https://stackoverflow.com/a/30436524
// returns a list of distinct values of one field defined in ModelFileFilterSpec specs
public interface ModelFileFilter {
    List<String> findOneColumnByModelFileFilter(String Column, String model, String startTime, String variableName);
}
