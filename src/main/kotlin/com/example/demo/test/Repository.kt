package com.example.demo.test

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.stereotype.Repository

@NoRepositoryBean
interface AncestorDTORepository<T>: JpaRepository<T, Long> {

    @Query(
        """
            SELECT p FROM #{#entityName} p WHERE p.id IN(SELECT fk(a.ancestor) FROM #{#entityName}Ancestor a WHERE fk(a.node)=:id) OR p.id = :id
        """
    )
    fun findAllParentsByAncestors(id: Long): List<T>
}


@Repository
interface ServiceAncestorTrackingRepository : AncestorDTORepository<Service>
