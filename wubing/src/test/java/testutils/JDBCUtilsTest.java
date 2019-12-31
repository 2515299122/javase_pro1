package testutils;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import javax.xml.transform.Templates;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JDBCUtilsTest {
    @Test
    public void testAll(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="select * from admin";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }
}
