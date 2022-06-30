package com.vrapalis.www.backend.tutorials.security.simplewebapp.domain.authority;

import com.vrapalis.www.backend.tutorials.security.simplewebapp.domain.user.AppUserEntity;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "authority")
public class AuthorityEntity implements Serializable {

    @Id
    private Integer id;

    @NaturalId
    private String name;

    @ToString.Exclude
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
