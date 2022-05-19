package model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "words")
public class Words {


    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "word")
    private List<String> words;

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public String getWordByIndex(int index) {
        return words.get(index);
    }

    public int getSize() {
        return words.size();
    }

}
