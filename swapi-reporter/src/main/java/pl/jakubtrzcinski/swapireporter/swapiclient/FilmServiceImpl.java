package pl.jakubtrzcinski.swapireporter.swapiclient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Film;
import pl.jakubtrzcinski.swapireporter.util.URLUtil;

import java.net.URL;

@Service
@RequiredArgsConstructor
class FilmServiceImpl implements FilmService {

    private final FilmClient client;

    @Override
    public Film getOne(URL url) {
        return client.getOne(URLUtil.getId(url));
    }
}
