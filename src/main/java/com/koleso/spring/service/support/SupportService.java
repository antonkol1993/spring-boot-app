package com.koleso.spring.service.support;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupportService<T> {

    public List<Long> readerIdsFromClient(HttpServletRequest request) throws IOException {
    StringBuilder body = new StringBuilder();
    String line;
        while ((line = request.getReader().readLine()) != null) {
        body.append(line);
    }
    String postBody = body.toString();
    String[] parts = postBody.split("[^0-9]");
    List<Long> playersIdsToTeam = new ArrayList<>();
        for (String part : parts) {
        if(!part.isEmpty()) {
            playersIdsToTeam.add(Long.valueOf(part));
        }
    }
        return playersIdsToTeam;
    }


}
