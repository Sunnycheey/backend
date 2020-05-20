package dblab.bit.backend.utils.converter;

import com.alibaba.fastjson.JSON;
import dblab.bit.backend.models.NodeEntity.AuthorDetail.AuthorDetail;
import org.neo4j.ogm.typeconversion.AttributeConverter;

import java.util.List;

/**
 * @program: backend
 * @description: convert for author detail
 * @author: lihuichao
 * @create: 2020-05-20
 **/

public class AuthorDetailConverter implements AttributeConverter<List<AuthorDetail>, String> {

    @Override
    public String toGraphProperty(List<AuthorDetail> authorDetails) {
        return JSON.toJSONString(authorDetails);
    }

    @Override
    public List<AuthorDetail> toEntityAttribute(String s) {
        return JSON.parseArray(s, AuthorDetail.class);
    }
}