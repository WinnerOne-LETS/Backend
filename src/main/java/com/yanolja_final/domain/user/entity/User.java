package com.yanolja_final.domain.user.entity;

import com.yanolja_final.domain.order.entity.Order;
import com.yanolja_final.domain.poll.entity.PollAnswer;
import com.yanolja_final.domain.review.entity.Review;
import com.yanolja_final.domain.wish.entity.Wish;
import com.yanolja_final.global.common.BaseTimeEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phoneNumber;

    private String username;

    private String encryptedPassword;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private UserImage image;

    private boolean isTermsAgreed = false;

    @ManyToMany
    @JoinTable(
        name = "user_authority",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    private Set<Authority> authorities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Order> orders;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Review> reviews;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Wish> wishes;

    @OneToOne(mappedBy = "user")
    private PollAnswer pollAnswer;

    @Builder
    public  User(String email, String phoneNumber, String username,
        String encryptedPassword,boolean isTermsAgreed, Set<Authority> authorities) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.encryptedPassword = encryptedPassword;
        this.isTermsAgreed = isTermsAgreed;
        this.authorities = authorities;
    }

    public void updateCredentials(String username, String encryptedPassword) {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

    @Override
    public void restore() {
        super.restore();
    }

    @Override
    public void delete(LocalDateTime currentTime) {
        super.delete(currentTime);
    }
}
