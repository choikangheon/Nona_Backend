package letsnona.nonabackend.global.security.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import letsnona.nonabackend.domain.file.entity.MemberImg;
import letsnona.nonabackend.domain.file.entity.PostImg;
import letsnona.nonabackend.domain.review.enums.TradeState;
import letsnona.nonabackend.global.entity.BaseTimeEntity;
import letsnona.nonabackend.global.security.entity.enums.MemberState;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
//@EntityListeners(AuditingEntityListener.class) /* JPA에게 해당 Entity는 Auditiong 기능을 사용함을 알립니다. */
public class Member extends BaseTimeEntity {
    /*TODO - Setter 지워야함*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
   // @Column(unique = true)
    private String username;


    private String originalImgSrc;
    private String thumbImgSrc;
    private String originalName;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String nickName;
    private String email;
    private String zipCode;
    private String phoneNumber;
    private String gender;
    private LocalDate birthday;
    private int age;
    @Column(columnDefinition = "integer(20) default 0")
    private int point;

    @Enumerated(value = EnumType.STRING)
    private MemberState memberState;
    @Column(columnDefinition = "varchar(255) default 'ROLE_USER'")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String roles;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String providerId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String provider;


    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public void updateAge(int age) {
        this.age = age;
    }

    public void updatePoint(int point) {
        this.point = point;
    }


    public void updateMemberSate(MemberState memberState) {
        this.memberState = memberState;
    }

    public void decreasePoint(int fee) {
        this.point = this.point - fee;
    }

    public void increasePoint(int fee) {
        this.point = this.point + fee;
    }

    public void memberInfoUpdate(String username, String nickName, String password, String email, LocalDate birthday, String phoneNumber, String zipCode) {
        this.username = username;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
    }
}
