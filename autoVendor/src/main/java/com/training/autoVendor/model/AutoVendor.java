package com.training.autoVendor.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="auto_vendor_info")
public class AutoVendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    @NonNull
    private Long autoId;

    private String autoName;
    private String autoModel;
    private String autoFuel;

    @CreationTimestamp
    @Column(updatable = false)
    @Schema(hidden = true)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Schema(hidden = true)
    private LocalDateTime updatedAt;

}
