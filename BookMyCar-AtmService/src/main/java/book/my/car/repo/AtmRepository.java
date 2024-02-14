package book.my.car.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import book.my.car.entity.AtmDetails;

import java.util.List;
import java.util.Optional;

public interface AtmRepository extends JpaRepository<AtmDetails, String> {

   List<AtmDetails> findByEmail(String email);

}
