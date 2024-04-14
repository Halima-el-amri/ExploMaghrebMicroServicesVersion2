package com.fileRouge.Guide.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "guides")

public class Guide {

    @Id
    private String id;
    private String name;
    private String photo;
    private  String Age;
    private String email;
    private String phone;
    private String password;
    private String langue;
    private List<String> managedTourIds; // List of GuideTour ids managed by this guide


}
