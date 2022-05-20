package com.dayana.market.persistence;

import com.dayana.market.domain.Product;
import com.dayana.market.domain.repository.ProductRepository;
import com.dayana.market.persistence.crud.ProductoCrudRepository;
import com.dayana.market.persistence.entity.Producto;
import com.dayana.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

//Esta clase se encarga de interactuar con la base de datos. Tipo de componente.
@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    //Para usar el princio D de SOLID
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }


    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quentity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quentity,1);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
