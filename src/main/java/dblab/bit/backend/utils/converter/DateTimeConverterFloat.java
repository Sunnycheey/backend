package dblab.bit.backend.utils.converter;

import org.neo4j.ogm.typeconversion.AttributeConverter;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @program: backend
 * @description: convert float type date to date
 * @author: lihuichao
 * @create: 2020-05-20
 **/
public class DateTimeConverterFloat implements AttributeConverter<Date, Double> {
    @Override
    public Double toGraphProperty(Date date) {
        long time = date.getTime();
        double val = time / 1000;
        return val;
    }

    @Override
    public Date toEntityAttribute(Double aDouble) {
        Double tmp = aDouble * 1000;
        long time = tmp.longValue();
        Timestamp timestamp = new Timestamp(time);
        Date date = new Date(timestamp.getTime());
        return date;
    }
}
