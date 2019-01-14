import java.util.Objects;

public class Celula {
    private int number;
    private String word;

    Celula(String word) {
        this.word = word;
        this.number = 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Celula celula = (Celula) o;
        return number == celula.number &&
                Objects.equals(word, celula.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, word);
    }

    @Override
    public String toString() {
        return "Celula{" +
                "number=" + number +
                ", word='" + word + '\'' +
                '}';
    }

    int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    String getWord() {
        return word;
    }

}
