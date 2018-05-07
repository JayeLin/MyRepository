import com.hutubill.dao.ConfigDAO;
import com.hutubill.dao.impl.ConfigDAOImpl;
import com.hutubill.entity.Category;
import com.hutubill.entity.Config;
import com.hutubill.service.ConfigService;
import com.hutubill.service.impl.ConfigServiceImpl;
import com.hutubill.util.DBUtil;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class DBUtilTest {
    @Test
    public void testDBUtil() throws SQLException {
        Connection connection = DBUtil.getConnection();
        if (connection != null) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
    public boolean add(Config config) {
        String sql = "insert into config values(null, ?, ?)";
        String sql1 = "select * from config";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            PreparedStatement pre1 = conn.prepareStatement(sql1);
            pre.setString(1, config.key);
            pre.setString(2, config.value);
            pre.executeUpdate();

            ResultSet result = pre1.executeQuery();
            if (result.next()) {
                int id = result.getInt(1);
                config.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean add(Category category) {
        String sql = "insert into category values(null, ?)";
        String sql1 = "select * from category";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            PreparedStatement pre1 = conn.prepareStatement(sql1);
            pre.setString(1, category.name);
            pre.execute();

            ResultSet result = pre1.executeQuery();
            if (result.next()) {
                int id = result.getInt(1);
                category.id = id;
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    @Test
    public void testAdd() {
//        Config config = new Config();
//        config.setKey("aaa");
//        config.setValue("bbb");
//        Category category = new Category();
//        category.setName("餐饮");
//
//        Assert.assertEquals(add(category), true);

        ConfigDAO configDAO = new ConfigDAOImpl();
//        Config config = configDAO.get(1);
//        config.setKey("budget");
//        config.setValue("200");
//        configDAO.update(config);


        ConfigService configService = new ConfigServiceImpl();

        configService.update("budget","100");
        System.out.println(configDAO.getByKey("budget").value);
    }

}
