package pl.jakubtrzcinski.swapireporter.swapiclient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.Person;
import pl.jakubtrzcinski.swapireporter.swapiclient.dto.SwapiPage;
import pl.jakubtrzcinski.swapireporter.util.URLUtil;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class PeopleServiceImpl implements PeopleService {
    private final PeopleClient peopleClient;
    @Override
    public List<Person> findAllByPhrase(String phrase) {
        List<Person> persons = new LinkedList<>();

        SwapiPage<Person> page = peopleClient.getPage(1);
        while (true) {
            persons.addAll(
                    page.getResults().stream().filter(e->e.getName().contains(phrase)).collect(Collectors.toList())
            );
            Optional<URL> next = page.getNext();
            if(next.isEmpty()){
                break;
            }
            page = peopleClient.getPage(URLUtil.getIntParam(next.get(), "page"));
        }
        return persons;
    }
}
