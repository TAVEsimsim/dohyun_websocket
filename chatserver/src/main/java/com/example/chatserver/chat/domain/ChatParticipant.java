package com.example.chatserver.chat.domain;

import com.example.chatserver.common.domain.BaseTimeEntity;
import com.example.chatserver.member.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ChatParticipant extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // chatroom:participant = 1:N
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="chat_room_id",nullable=false)
    private ChatRoom chatRoom;

    // member:participant = 1:N
    // 한명의 회원은 여러 채팅방에 참여 가능
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id",nullable=false)
    private Member member;


}
