package com.example.mission_leesooho.boundedContext.instaMember.entity;

import com.example.mission_leesooho.boundedContext.base.BaseTimeEntity;
import com.example.mission_leesooho.boundedContext.likeablePerson.entity.LikeablePerson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class InstaMember extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String gender;

    @OneToMany(mappedBy = "fromInstaMember", cascade = CascadeType.REMOVE) //likeableperson
    @Builder.Default
    private List<LikeablePerson> flikeablePeople = new ArrayList<>();

    @OneToMany(mappedBy = "toInstaMember", cascade = CascadeType.REMOVE) //likeableperson
    @Builder.Default
    private List<LikeablePerson> tlikeablePeople = new ArrayList<>();



    public void SelectGender(String gender) {
        this.gender = gender;
    }

    public void addfLikePeople(LikeablePerson likeablePerson) {
        this.flikeablePeople.add(likeablePerson);
    }

    public void deletefLikePeople(LikeablePerson likeablePerson) {
        this.flikeablePeople.remove(likeablePerson);
    }

    public void addtLikePeople(LikeablePerson likeablePerson) {
        this.tlikeablePeople.add(likeablePerson);
    }

    public void deletetLikePeople(LikeablePerson likeablePerson) {
        this.tlikeablePeople.remove(likeablePerson);
    }



}
