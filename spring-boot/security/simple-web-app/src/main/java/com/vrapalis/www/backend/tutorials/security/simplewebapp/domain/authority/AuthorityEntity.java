package com.vrapalis.www.backend.tutorials.security.simplewebapp.domain.authority;

import com.vrapalis.www.backend.tutorials.security.simplewebapp.domain.user.AppUserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authority")
public class AuthorityEntity implements Serializable {

    @Id
    private Integer id;

    @NaturalId
    private String name;

    @ToString.Exclude
    @Builder.Default
    @ManyToMany(mappedBy = "authorities")
    private Set<AppUserEntity> users = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthorityEntity)) return false;
        AuthorityEntity that = (AuthorityEntity) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
