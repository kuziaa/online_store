//package com.antonkhmarun.onlinestore.online_store.dao.tmp;
//
//import com.antonkhmarun.onlinestore.online_store.entity.Product;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import java.util.List;
//
//@Repository
//public class ProductDAOImpl implements ProductDAO {
//
//    @Autowired
//    private EntityManager entityManager;
//
//    @Override
//    public List<Product> findAll() {
//        Query query = entityManager.createQuery("from Product");
//        List<Product> products = query.getResultList();
//        return products;
//    }
//
//    @Override
//    public Product findById(int id) {
//        Product product = entityManager.find(Product.class, id);
//        return product;
//    }
//
//    @Override
//    public Product findByName(String name) {
////        Query query = entityManager.createQuery("from Product where name:=name");
////        query.setParameter("name", name);
////        Product product = query.getParameterValue(Product p);
//        Product product = entityManager.find(Product.class, name);
//        return product;
//    }
//
//    @Override
//    public Product save(Product product) {
//        return null;
//    }
//
//    @Override
//    public Product deleteById(int id) {
//        return null;
//    }
//}
