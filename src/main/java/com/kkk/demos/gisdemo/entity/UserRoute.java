package com.kkk.demos.gisdemo.entity;

import com.vividsolutions.jts.geom.LineString;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class UserRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LineString route;
    private LocalDateTime uploadTime;
    private LocalDateTime created;
    private LocalDateTime updated;

}
