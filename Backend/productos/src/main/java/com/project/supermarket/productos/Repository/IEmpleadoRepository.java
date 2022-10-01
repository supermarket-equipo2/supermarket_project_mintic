package com.project.supermarket.productos.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.project.supermarket.productos.Entity.Empleado;

public interface IEmpleadoRepository extends PagingAndSortingRepository<Empleado, Long> {

}
