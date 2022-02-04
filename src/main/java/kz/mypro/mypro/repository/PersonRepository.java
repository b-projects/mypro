package kz.mypro.mypro.repository;

import kz.mypro.mypro.entity.QueryMsg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <QueryMsg, Integer> {

}
