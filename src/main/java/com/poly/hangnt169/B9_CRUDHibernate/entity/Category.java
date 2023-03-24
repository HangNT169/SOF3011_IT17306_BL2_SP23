package com.poly.hangnt169.B9_CRUDHibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hangnt169
 */
@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Category {
    // Java 3: JDBC thuan
    // Java 4: Hibernate
    // Java 5 >: JPA
    // Hibernate : Là cách truy vấn trên thực thể (entity): HQL
    // ORM (Object Relationship Mapping) :
    // varchar (nvarchar) <=> String
    // int <=> Integer
    // bigint <=> Long
    // Mapping quan hệ giữa các bảng : ManyToOne , OneToMany, OneToOne, ManyToMany
    // Thực thể <=> Table : 3 loai :
    // Khoa Chinh :
    // Cot binh thuong
    // Khoa ngoai

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

}
