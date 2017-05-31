package ru.project.objects;

import org.springframework.stereotype.Component;
import ru.project.enums.SearchType;

import java.util.HashMap;
import java.util.Map;

@Component
public class Utils {

    private Map<String,SearchType> searchTypeMap=new HashMap<>();
    private SearchType selectedSearchType=SearchType.TITLE;

    public Map<String, SearchType> getSearchTypeMap(){
        searchTypeMap.clear();
        searchTypeMap.put("По автору",SearchType.AUTHOR);
        searchTypeMap.put("По названию",SearchType.TITLE);
        return searchTypeMap;
    }

    public SearchType getSelectedSearchType() {
        return selectedSearchType;
    }

    public void setSelectedSearchType(SearchType selectedSearchType) {
        this.selectedSearchType = selectedSearchType;
    }
}
