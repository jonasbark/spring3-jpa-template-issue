package com.example.demo.test

import jakarta.persistence.*

@Entity(name = "Service")
data class Service(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    @SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence")
    var id: Long? = null
)

@Entity(name = "ServiceAncestor")
data class ServiceAncestor(
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    @SequenceGenerator(name = "primary_sequence", sequenceName = "primary_sequence")
    @Id
    var id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    val ancestor: Service? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    val node: Service? = null
)


