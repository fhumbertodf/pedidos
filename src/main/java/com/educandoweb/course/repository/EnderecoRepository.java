package com.educandoweb.course.repository;

import com.educandoweb.course.domain.Endereco;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Endereco entity.
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
