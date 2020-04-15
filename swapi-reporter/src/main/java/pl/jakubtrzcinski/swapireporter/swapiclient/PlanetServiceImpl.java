package pl.jakubtrzcinski.swapireporter.swapiclient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Planet;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.SwapiPage;
import pl.jakubtrzcinski.swapireporter.util.URLUtil;

import java.net.URL;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class PlanetServiceImpl implements PlanetService {

    private final PlanetClient planetClient;

    @Override
    public Optional<Planet> findByName(String planetName) {

        SwapiPage<Planet> page = planetClient.getPage(1);

        while (true) {
            Optional<Planet> planet = page.getResults().stream().filter(e -> e.getName().equals(planetName)).findFirst();
            if (planet.isPresent()) {
                return planet;
            }
            Optional<URL> next = page.getNext();
            if(next.isEmpty()){
                break;
            }
            page = planetClient.getPage(URLUtil.getIntParam(next.get(), "page"));
        }

        return Optional.empty();
    }
}
