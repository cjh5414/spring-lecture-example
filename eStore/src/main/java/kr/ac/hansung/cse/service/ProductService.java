package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.ProductDao;
import kr.ac.hansung.cse.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jihun on 2018. 11. 25..
 */

@Service
public class ProductService {
    private ProductDao productDao;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    public void addProduct(Product product) { productDao.addProduct(product); }

    public void deleteProductById(Product product) {
        productDao.deleteProductById(product);
    }

    public Product getProductById(int id) {
        return productDao.getproductById(id);
    }

    public void editProduct(Product product) {
        productDao.editProduct(product);
    }
}
