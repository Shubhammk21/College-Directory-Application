package com.CDA.CollegeDirectoryApplication.Modules;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {
    @Id
    private Long userId;
    private String photo;
    private Integer departmentId;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
