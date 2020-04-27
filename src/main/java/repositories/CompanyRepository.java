package repositories;

import models.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {

    void add(Company c);
    Optional<List<Company>> listAll ();
    Optional<Company> findCompanyByCompanyname(String name);

    static CompanyRepository build(Type type) {
        switch (type) {
            case FILE: return new FileCompanyRepository();
          //  case ARRAY:return new ArrayEventRepository();
        }

        throw new RuntimeException("No such type");
    }

    enum Type {
        FILE, ARRAY
    }
}
