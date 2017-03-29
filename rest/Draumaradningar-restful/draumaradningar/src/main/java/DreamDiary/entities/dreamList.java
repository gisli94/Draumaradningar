package DreamDiary.entities;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.lang.reflect.Array;


@JsonIgnoreProperties(ignoreUnknown = true)
public class dreamList {

    private List<Dream> dreams;

    public dreamList(){
        dreams = new ArrayList<Dream>();
    }
    public dreamList(ArrayList<Dream> dreams){
        this.dreams = dreams;

    }
    public List<Dream> getDreams(){
        return this.dreams;
    }

    public void setDreams(List<Dream> dreams){
        this.dreams = dreams;
    }

    public void addDream(Dream dream){
        this.dreams.add(dream);
    }

}
