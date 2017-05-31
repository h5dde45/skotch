package ru.project.objects;

import org.springframework.stereotype.Component;
import ru.project.enums.SearchType;

import java.util.HashMap;
import java.util.Map;

@Component
public class Utils {

    private Map<String,SearchType> searchTypeMap=new HashMap<>();

    public Map<String, SearchType> getSearchTypeMap(){
        searchTypeMap.clear();
        searchTypeMap.put("По автору",SearchType.AUTHOR);
        searchTypeMap.put("По названию",SearchType.TITLE);
        return searchTypeMap;
    }

}
