package com.example.day1.service;

import com.example.day1.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingService {
    private final List<WiseSaying> wiseSayingList;
    private int lastId;

    public WiseSayingService() {
        this.wiseSayingList = new ArrayList<WiseSaying>();
        this.lastId = 0;
    }

    public WiseSaying addWiseSaying(String content, String author) {
        int id = ++lastId;
        WiseSaying ws = new WiseSaying(id, content, author);
        wiseSayingList.add(ws);

        return ws;
    }

    public List<WiseSaying> getWiseSayingList() {
        return wiseSayingList;
    }

    public boolean removeById(int id) {
        return wiseSayingList.removeIf(ws -> ws.getId() == id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayingList.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    public void modify(WiseSaying foundWiseSaying, String content, String author) {
        foundWiseSaying.setSay(content);
        foundWiseSaying.setAuthor(author);
    }
}
