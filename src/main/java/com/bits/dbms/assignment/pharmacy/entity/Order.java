package com.bits.dbms.assignment.pharmacy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "ph_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer order_id;
    private LocalDateTime order_date;
    private String order_status;
    private Integer store_id;
    private String supplier_id;
    private String created_by;
    @CreationTimestamp
    private LocalDateTime created_on;
    private String modified_by;
    @UpdateTimestamp
    private LocalDateTime modified_on;
}