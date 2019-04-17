package com.kkk.demos.gisdemo.services;

import com.google.common.collect.Lists;
import com.kkk.demos.gisdemo.entity.SysRoute;
import com.kkk.demos.gisdemo.repos.SysRouteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRouteService {

    @Autowired
    private SysRouteRepo sysRouteRepo;

    public SysRoute save(SysRoute sysRoute) {
        return sysRouteRepo.save(sysRoute);
    }

    public SysRoute findFirst() {
        List<SysRoute> all = Lists.newArrayList(sysRouteRepo.findAll());
        return all.stream().findFirst().orElse(null);
    }
}
