import com.tanzi.ssm.dao.IProductDao;
import com.tanzi.ssm.domain.Product;
import com.tanzi.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class mybatistest {
    @Autowired
    private static IProductService iProductService;
    @Autowired
    private IProductDao iProductDao;

    public static void main(String[] args) throws Exception {
        List<Product> li= iProductService.findAll();
        System.out.println(li);
    }
}

