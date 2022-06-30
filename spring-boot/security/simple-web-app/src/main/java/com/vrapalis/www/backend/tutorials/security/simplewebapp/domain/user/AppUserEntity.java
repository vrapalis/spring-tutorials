package com.vrapalis.www.backend.tutorials.security.simplewebapp.domain.user;

import com.vrapalis.www.backend.tutorials.security.simplewebapp.domain.authority.AuthorityEntity;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
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
@Table(name = "app_user")
public class AppUserEntity implements Serializable {

    @Id
    private Integer id;

    @NaturalId
    private String email;

    private String password;
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "app_user_has_authority", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<AuthorityEntity> authorities = new HashSet<>();

    private void addAuthority(AuthorityEntity authorityEntity) {
        authorities.add(authorityEntity);
        authorityEntity.getUsers().add(this);
    }

    private void removeAuthority(AuthorityEntity authorityEntity) {
        authorities.remove(authorityEntity);
        authorityEntity.getUsers().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUserEntity)) return false;
        AppUserEntity that = (AppUserEntity) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
