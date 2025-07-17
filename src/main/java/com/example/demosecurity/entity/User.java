package com.example.demosecurity.entity;

import com.example.demosecurity.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // Trả về quyền được cấp cho người dùng.
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() { // Trả về mật khẩu được sử dụng để xác thực người dùng.
        return password;
    }

    @Override
    public String getUsername() { // Trả về tên người dùng được sử dụng để xác thực người dùng.
        return name;
    }

    @Override
    public boolean isAccountNonExpired() { // Cho biết tài khoản của người dùng đã hết hạn hay chưa.
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // Cho biết người dùng bị khóa hay mở khóa.
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // Cho biết thông tin đăng nhập (mật khẩu) của người dùng đã hết hạn hay chưa.
        return true;
    }

    @Override
    public boolean isEnabled() { // Cho biết người dùng được bật hay tắt.
        return true;
    }
}
