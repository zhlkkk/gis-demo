package com.kkk.demos.gisdemo.services;

import com.google.common.collect.Lists;
import com.kkk.demos.gisdemo.entity.UserRoute;
import com.kkk.demos.gisdemo.repos.UserRouteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRouteService {

    @Autowired
    private UserRouteRepo userRouteRepo;

    public UserRoute save(UserRoute route) {
        return userRouteRepo.save(route);
    }

    public List<UserRoute> saveAll(List<UserRoute> routes) {
        return Lists.newArrayList(userRouteRepo.saveAll(routes));
    }

    public List<UserRoute> findIntersectsRoute(Long sysRouteId) {
        return userRouteRepo.findIntersectsRoute(sysRouteId);
    }
}
