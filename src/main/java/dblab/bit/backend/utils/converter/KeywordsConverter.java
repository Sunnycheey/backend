package dblab.bit.backend.utils.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.neo4j.ogm.typeconversion.AttributeConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: backend
 * @description: convert keywords from string in graph to list<string> in node
 * @author: lihuichao
 * @create: 2020-05-21
 **/
public class KeywordsConverter implements AttributeConverter<List<String>, String> {
    private static final Logger logger = LogManager.getLogger(KeywordsConverter.class);

    @Override
    public String toGraphProperty(List<String> strings) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (String string : strings) {
            sb.append("'");
            sb.append(string);
            sb.append(";");
        }
        sb.append(']');
        return sb.toString();
    }

    @Override
    public List<String> toEntityAttribute(String s) {
        List<String> ret = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        String[] strings = s.split(",");
        for (String tmp : strings) {
            try {
                ret.add(tmp.substring(tmp.indexOf("'") + 1, tmp.lastIndexOf("'") - 1));
            } catch (java.lang.StringIndexOutOfBoundsException e) {
                logger.warn("current string is {}\n".format(tmp));
            }
        }
        return ret;
    }
}
