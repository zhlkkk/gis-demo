package com.kkk.demos.gisdemo.repos;

import com.kkk.demos.gisdemo.entity.UserRoute;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRouteRepo extends CrudRepository<UserRoute, Long> {

    @Query(nativeQuery = true, value =
        "SELECT u.* from sys_route s, user_route u where s.id=1 and ST_Intersects(s.route, u.route)= ?1 ")
    List<UserRoute> findIntersectsRoute(Long sysRouteId);

}
