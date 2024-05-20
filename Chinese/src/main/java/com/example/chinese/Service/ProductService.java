package com.example.chinese.Service;

import com.example.chinese.Api.ApiException;
import com.example.chinese.Model.Product;
import com.example.chinese.Model.Supplier;
import com.example.chinese.Repository.ProductRepository;
import com.example.chinese.Repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        Supplier s = supplierRepository.findSupplierBySupplierId(product.getSupplierId());
        if (s == null) {
            throw new ApiException("  Supplier Id not found");
        }
        productRepository.save(product);
    }

    public void updateProduct(Integer id, Product product) {
        Product product1 = productRepository.findProductById(id);
        if (product1 == null) {
            throw new ApiException("id not found");
        }
        Supplier s = supplierRepository.findSupplierBySupplierId(product.getSupplierId());
        if (s == null) {
            throw new ApiException("  Supplier Id not found");
        }
        product1.setCategory(product.getCategory());
        product1.setDescription(product.getDescription());
        product1.setEvaluation(product.getEvaluation());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setSupplierId(product.getSupplierId());
        productRepository.save(product1);

    }

    public void deleteProduct(Integer id) {
        Product product1 = productRepository.findProductById(id);
        if (product1 == null) {
            throw new ApiException("id not found");
        }
        productRepository.delete(product1);
    }

    //---------------------------  end CRUD  ---------------------------------

    //------------------------------    1    ----------------------------------
    public void discount(Integer productId, Double discount) {
        Product product1 = productRepository.findProductById(productId);
        if (product1 == null) {
            throw new ApiException("id not found");
        }
        if (product1.getPrice() - discount > 0){
            product1.setPrice(product1.getPrice() - discount);
        productRepository.save(product1);
       }else  {
            throw new ApiException("The discount is greater than the value of the product ");
        }


    }

    //------------------------------    2    ----------------------------------

    public List<Product> bestSeller(Integer num) {
        List<Product> products = productRepository.searchTopBySales();
        List<Product> product1 = new ArrayList<>();

        if (products.size()>=num) {
            for (int i = 0; i < num; i++) {
                product1.add(products.get(i));
            }
        }
        return product1;
    }

    //------------------------------    3    ----------------------------------
    public List<Product> bestEvaluation(Integer num) {
        List<Product> products = productRepository.searchTopByEvaluation();
        List<Product> product1 = new ArrayList<>();

        if (products.size()>=num) {
            for (int i = 0; i < num; i++) {
                product1.add(products.get(i));
            }
        }
        return product1;
    }
}