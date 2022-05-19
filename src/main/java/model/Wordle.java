package model;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import controller.WordleController;

import java.io.*;
import java.net.URL;
import java.util.Random;

public class Wordle {

    private String word;

    private Words words = new Words();

    private Random random = new Random();

    public Wordle()  {

        URL url = WordleController.class.getClassLoader().getResource("words.xml");
        XmlMapper mapper = new XmlMapper();
        String xml = null;


        try {
            xml = inputStreamToString(new FileInputStream(new File(url.getFile())));
            words = mapper.readValue(xml, Words.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.word = words.getWordByIndex(random.nextInt(words.getSize())).toUpperCase();
        System.out.println(word);
    }

    public Wordle(String s) {
        this.word = s.substring(0,5).toUpperCase();
    }

    public String getWord() {
        return word;
    }

    public boolean isExactMatch(String s) {
        return word.matches(s);
    }


    public boolean isCharacterMatching(int index, char cha) {
        Boolean isMatching = false;
        if (cha == word.charAt(index)) {
            isMatching = true;
        }
        return isMatching;
    }

    public boolean isContainsCharacter(char cha) {
        return word.contains(String.valueOf(cha));
    }

    private String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

}
