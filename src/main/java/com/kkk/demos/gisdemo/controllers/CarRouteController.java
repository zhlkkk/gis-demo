package com.kkk.demos.gisdemo.controllers;

import com.kkk.demos.gisdemo.entity.UserRoute;
import com.kkk.demos.gisdemo.services.UserRouteService;
import com.kkk.demos.gisdemo.vos.UploadDataVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.ZoneId;

@RestController
@RequestMapping("/route")
public class CarRouteController {

    @Autowired
    private UserRouteService userRouteService;

    @PostMapping("/upload")
    public ResponseEntity<Boolean> upload(@RequestBody UploadDataVO vo) {
        UserRoute userRoute = new UserRoute();
//        userRoute.setRoute(vo.getRoute());
        userRoute.setUploadTime(Instant.ofEpochMilli(vo.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime());
        userRouteService.save(userRoute);
        return ResponseEntity.ok(true);
    }
}
