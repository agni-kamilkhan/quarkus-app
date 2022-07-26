package com.onblocktrust.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BT_PRODUCT")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Product extends AbstractModel {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    @Lob
    private String desc;

    @Column(name = "price")
    private double price;

    @Column(name = "image_id")
    private String imageId;

    @Column(name = "status")
    private String status;

    @Column(name = "cat_id")
    private Long catId;

    //    @Transient
    @Column(name = "cat_name")
    private String catName;

    //    @Transient
    @Column(name = "creator_name")
    private String creatorName;

    // common fields
    @Column(name = "create_time", nullable = false)
    protected Date createTime;

    @Column(name = "update_time", nullable = false)
    protected Date updateTime;

    @Column(name = "create_by", nullable = false)
    protected String createBy;

    @Column(name = "update_by", nullable = false)
    protected String updateBy;

    // persistence operations
    public void preUpdate(String updateBy, Date now) {
        this.updateTime = now;
        if (updateBy != null)
            this.updateBy = updateBy;
    }

    public void prePersist(String createUpdateBy, Date now) {
        this.createTime = now;
        this.updateTime = now;
        if (createUpdateBy != null) {
            this.createBy = createUpdateBy;
            this.updateBy = createUpdateBy;
        }
    }
}
