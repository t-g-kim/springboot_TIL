package com.example.elasticsearch.index;

import lombok.Builder;
import lombok.Data;
import org.elasticsearch.common.geo.GeoPoint;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

@Data
@Document(indexName = "reservation")
@Setting(settingPath = "elastic-setting.json")
public class ReservationIndex {
    /* id */
    @Id
    @Field(type = FieldType.Long)
    private int reservationId;

    /* 서비스구분 */
    @Field(type = FieldType.Keyword)
    private String type;

    /* 서비스ID */
    @Field(type = FieldType.Keyword)
    private String serviceId;

    /* 장소 X 좌표, Y 좌 */
    @GeoPointField
    private GeoPoint location; // X, Y

    /* 서비스개시시작일시 */
    @Field(type = FieldType.Date)
    private String startDate;
}