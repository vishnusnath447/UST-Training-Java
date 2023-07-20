package in.stackroute.services;

import java.util.List;
import java.util.Optional;

public interface Services<T,K extends Number> {
    public T saveData(T t);
    public Optional<T> getDataById(K t);
    public List<T> getAllData();
    public T update(T t);
    public T delete(T t);
}