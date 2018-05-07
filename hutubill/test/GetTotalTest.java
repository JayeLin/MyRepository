import com.hutubill.dao.CategoryDAO;
import com.hutubill.dao.ConfigDAO;
import com.hutubill.dao.impl.CategoryDAOImpl;
import com.hutubill.dao.impl.ConfigDAOImpl;
import com.hutubill.entity.Category;
import com.hutubill.entity.Config;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class GetTotalTest {
    Connection conn = null;
    @Test
    public void testGetTotal() throws Exception {
//        CategoryDAO adao = new CategoryDAOImpl();
        ConfigDAO configDAO = new ConfigDAOImpl();
        Config config = new Config();
        config.setKey("abc");
        config.setValue("abc");
        config.getValue();
        System.out.println(configDAO.get(1));
    }

    @Test
    public void testGet() throws Exception {

    }
}
