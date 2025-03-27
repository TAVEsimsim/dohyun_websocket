//package com.example.chatserver.chat.config;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.*;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//
////connect로 웹소켓 연결 요청이 들어왔을 때 이를 처리할 클래스
//@Component
//public class SimpleWebSocketHandler extends TextWebSocketHandler {
//
//        //연결된 세션 관리 : 스레드 safe한 set 사용
//        private final Set<WebSocketSession> sessions= ConcurrentHashMap.newKeySet();
//        @Override
//        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//            sessions.add(session);
//            System.out.println("Connected : " + session.getId());
//        }
//
//        @Override
//        //사용자에게 메시지 보냄
//        protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//            String payload = message.getPayload();
//            System.out.println("received Message : " + payload);
//            for(WebSocketSession s : sessions){
//                if (s.isOpen()) {
//                    s.sendMessage(new TextMessage(payload));
//                }
//            }
//        }
//
//        //연결이 끊기면 제외
//        @Override
//        public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//            sessions.remove(session);
//            System.out.println("Disconnected !!");
//        }
//    }


