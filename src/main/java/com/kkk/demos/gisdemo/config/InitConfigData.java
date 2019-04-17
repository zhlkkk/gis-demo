package com.kkk.demos.gisdemo.config;

import com.google.common.collect.Lists;
import com.kkk.demos.gisdemo.entity.SysRoute;
import com.kkk.demos.gisdemo.entity.UserRoute;
import com.kkk.demos.gisdemo.services.SysRouteService;
import com.kkk.demos.gisdemo.services.UserRouteService;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiLineString;

import lombok.extern.slf4j.Slf4j;

import org.geolatte.geom.jts.JTS;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class InitConfigData implements InitializingBean {

    @Autowired
    private SysRouteService sysRouteService;
    @Autowired
    private UserRouteService userRouteService;

    @Override
    public void afterPropertiesSet() {
        this.addSysRoute();
        this.addUserRoute();

        SysRoute route = sysRouteService.findFirst();
        userRouteService.findIntersectsRoute(route.getId()).forEach(r -> {
            log.info("相交的路线对象：" + r);
        });
    }

    private void addSysRoute() {
        SysRoute sysRoute = new SysRoute();
        /*
          116.309578,40.059019
          116.310962,40.056148
          116.305769,40.055002
          116.308392,40.050583
          116.301278,40.047988
         */
        LineString ls1 = JTS
            .geometryFactory().createLineString(new Coordinate[]{new Coordinate(40.059019, 116.309578), new Coordinate(40.056148, 116.310962)});
        LineString ls2 = JTS.geometryFactory().createLineString(new Coordinate[]{new Coordinate(40.056148, 116.310962), new Coordinate(40.055002, 116.305769)});
        LineString ls3 = JTS.geometryFactory().createLineString(new Coordinate[]{new Coordinate(40.055002, 116.305769), new Coordinate(40.050583, 116.308392)});
        LineString ls4 = JTS.geometryFactory().createLineString(new Coordinate[]{new Coordinate(40.059019, 116.308392), new Coordinate(40.047988, 116.301278)});

        MultiLineString mls = JTS.geometryFactory().createMultiLineString(new LineString[]{ls1, ls2, ls3, ls4});
        sysRoute.setRoute(mls);
        sysRouteService.save(sysRoute);
    }

    private void addUserRoute() {
        /*
          116.304027,40.060483
          116.305679,40.054933
          116.312686,40.056507
         */

        LineString ls1 = JTS.geometryFactory().createLineString(new Coordinate[]{new Coordinate(40.060483, 116.304027), new Coordinate(40.054933, 116.305679)});
        LineString ls2 = JTS.geometryFactory().createLineString(new Coordinate[]{new Coordinate(40.054933, 116.305679), new Coordinate(40.056507, 116.312686)});

        UserRoute userRoute1 = new UserRoute();
        userRoute1.setRoute(ls1);
        userRoute1.setUploadTime(LocalDateTime.now());

        UserRoute userRoute2 = new UserRoute();
        userRoute2.setRoute(ls2);
        userRoute2.setUploadTime(LocalDateTime.now());

        userRouteService.saveAll(Lists.newArrayList(userRoute1, userRoute2));
    }
}
