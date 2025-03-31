package com.example.chatserver.chat.domain;

import com.example.chatserver.common.domain.BaseTimeEntity;
import com.example.chatserver.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ChatMessage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // chatroom:message = 1:N
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="chat_room_id",nullable=false)
    private ChatRoom chatRoom;

    // member:message = 1:N
    // 한명의 회원은 여러 메시지 전송 가능
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id",nullable=false)
    private Member member;

    @Column(nullable=false, length=500)
    private String content;

    // 메시지 사용 시 readStatus도 삭제
    @OneToMany(mappedBy="chatMessage",cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ReadStatus> readStatuses = new ArrayList<>();

}
