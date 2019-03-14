package com.arouri.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nidhal on 13/03/2019.
 */
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String username;
    String email;
    String password;
    String gitlabPrivateToken;
    String avatarURL;
    @ManyToMany(fetch = FetchType.EAGER)
    List<AppRole> roles = new ArrayList<>();
}
