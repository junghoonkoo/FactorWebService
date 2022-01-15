package com.factos.domain.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
//lombok은 서비스 초기 구축 단계에서 테이블 설계의 변경이 빈번한데에 코드 변경량을 최소화시켜주어 좋음
import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor //기본 생성자 자동 추가
@Entity //테이블이 링크될 클래스임을 알림
@IdClass(F_Users.class)
public class F_Users implements Serializable {

    @Id //PK임을 알림
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성규칙 IDENTITY를 추가해줘야 auto_increment
    @Column(length = 50, nullable = false)//column을 나타냄(굳이 없어도 default임) 사용하는 이유는 그 외적 기본값 변경이 필요할 떄
    private String userId;
    //유저아이디

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10, nullable = false)
    private String userSeq;
    //유저 고유번호

    @Column(length = 50, nullable = false)
    private String userName;
    //유저이름

    @Column(length = 20, nullable = false)
    private String userPassword;
    //유저 비밀번호

    @Column(length = 50, nullable = false)
    private String userPhone;
    //유저 휴대폰 번호

    @Column(length = 50, nullable = false)
    private String userEmail;
    //유저 이메일

    @Column(length = 10, nullable = false)
    private String userMarketingAgree;
    //유저 마케팅 수신 동의

    @Column(length = 50, nullable = false)
    private String userNickname;
    //유저 닉네임

    @Column(length = 10, nullable = false)
    private String userStatus;
    //유저 유저 상태값

    @Column(length = 10, nullable = false)
    private String userAccess;
    //유저 권한 코드

    private String userJoinDate;
    //회원가입 날짜

    private String userSecessionDate;
    //이게 탈퇴 날짜인가?

    @Builder
    //해당 클래스의 빌더 패턴 클래스 생성
    //생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함

    public F_Users(String userId, String userName, String userEmail, String userAccess, String userPhone, String userJoinDate,
                   String userNickname, String userMarketingAgree, String userPassword, String userSeq, String userStatus, String userSecessionDate) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAccess = userAccess;
        this.userMarketingAgree = userMarketingAgree;
        this.userNickname = userNickname;
        this.userSecessionDate = userSecessionDate;
        this.userJoinDate = userJoinDate;
        this.userPassword = userPassword;
        this.userSeq = userSeq;
        this.userStatus = userStatus;
        this.userPhone = userPhone;

    }
}

//Entity 클래스에 setter 메소드의 생성을 최소화한다.
//대신 해당 필드 값 변경이 필요하면, 명확히 목적과 의도를 나타낼 수 있는 메소드를 추가하여 사용한다.

//setter가 없는 상황에서 DB에 값을 채워 넣는 방법은 두가지
//생성자를 통해 최종값을 채워 INSERT
//== this.a =a ;
//@Builder의 빌더 클래스를 통해 INSERT
// == .a(a)
// ==.build();