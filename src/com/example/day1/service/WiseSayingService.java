package com.example.day1.service;

import com.example.day1.entity.WiseSaying;
import com.example.day1.repository.WiseSayingRepository;

import java.util.List;
import java.util.Optional;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying add(String content, String author) {
        WiseSaying ws = new WiseSaying(0, content, author);
        wiseSayingRepository.add(ws);

        return ws;
    }

    public List<WiseSaying> getWiseSayingList() {
        return wiseSayingRepository.findAll();
    }

    public boolean removeById(int id) {
        return wiseSayingRepository.removeById(id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setSay(content);
        wiseSaying.setAuthor(author);

        wiseSayingRepository.modify(wiseSaying);
    }
}
