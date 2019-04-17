package com.kkk.demos.gisdemo.vos;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Point;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.geolatte.geom.jts.JTS;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadDataVO {

    private Double longitude;
    private Double latitude;
    private Long time;

    public Point getPoint() {
        return JTS.geometryFactory().createPoint(new Coordinate(latitude, longitude));
    }
}
