package in.stackroute.ust.service;

import in.stackroute.ust.domain.User;

import java.util.List;

public interface ServiceInterface {
    List<User> getAll();
    User getById(Long k);
    User saveData(User t);
    User update(User t);
    void deleteData(Long k);
}
