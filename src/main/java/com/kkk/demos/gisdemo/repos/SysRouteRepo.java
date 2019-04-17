package com.kkk.demos.gisdemo.repos;

import com.kkk.demos.gisdemo.entity.SysRoute;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRouteRepo extends CrudRepository<SysRoute, Long> {

}
