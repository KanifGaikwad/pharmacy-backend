package com.bits.dbms.assignment.pharmacy.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;
    private String product_name;
    private Integer category_id;
    private Integer supplier_id;
    private Integer expiry_duration;
    private Integer threshold_qty;
    private Boolean is_discountable;
    private String created_by;
    @CreationTimestamp
    private Date created_on;
    private String modified_by;
    @UpdateTimestamp
    private Date modified_on;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "product_offers",
            joinColumns = {@JoinColumn(name = "product_product_id", referencedColumnName = "product_id",
                    nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "offer_offer_id", referencedColumnName = "offer_id",
                    nullable = false, updatable = false)})
    private Set<Offer> offers;
}