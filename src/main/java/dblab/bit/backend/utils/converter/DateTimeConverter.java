package dblab.bit.backend.utils.converter;

import org.neo4j.ogm.typeconversion.AttributeConverter;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @program: backend
 * @description: convert time from type string to type date
 * @author: lihuichao
 * @create: 2020-05-03
 **/
public class DateTimeConverter implements AttributeConverter<Date, String> {


    @Override
    public String toGraphProperty(Date date) {
        long time = date.getTime();
        float val = time / 1000;
        return String.valueOf(val);
    }

    @Override
    public Date toEntityAttribute(String s) {
        long time = (long) Float.parseFloat(s) * 1000;
        Timestamp timestamp = new Timestamp(time);
        Date date = new Date(timestamp.getTime());
        return date;
    }
}
