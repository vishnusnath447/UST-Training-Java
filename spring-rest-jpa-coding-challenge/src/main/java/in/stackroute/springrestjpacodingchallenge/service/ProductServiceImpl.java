package in.stackroute.springrestjpacodingchallenge.service;

import in.stackroute.springrestjpacodingchallenge.domain.Product;
import in.stackroute.springrestjpacodingchallenge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(int pid) {
        return productRepository.findById(pid);
    }
}
