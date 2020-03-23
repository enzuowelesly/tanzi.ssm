import com.tanzi.ssm.domain.Product;
import com.tanzi.ssm.service.IProductService;
import com.tanzi.ssm.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class mybatis {
@Autowired
private ProductServiceImpl  productService =new ProductServiceImpl();
@Test
    public void testquery() throws Exception {
    List<Product> lis=productService.findAll();
        System.out.println(lis);

    }
}
