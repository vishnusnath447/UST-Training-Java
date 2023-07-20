package in.stackroute.springrestjpacodingchallenge.service;

import in.stackroute.springrestjpacodingchallenge.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();

    Optional<Product> getProductById(int pid);
}
