package com.etensionChrome.etensionChrome.Controller;

import com.etensionChrome.etensionChrome.DTO.messageFrontDTO;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SSemitterManager {
    private static final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    public static void addEmitter(SseEmitter emitter){
        emitters.add(emitter);
    }
    public static void removeEmitter(SseEmitter emitter){
        emitters.remove(emitter);
    }

    public static void sendMessageToAll(messageFrontDTO messageFrontDTO){
        for (SseEmitter emitter : emitters) {
            try {
                emitter.send(messageFrontDTO);
            }catch (Exception e) {
                emitters.remove(emitter);
            }
        }
    }

}
