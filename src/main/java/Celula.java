import java.util.Objects;

public class Celula {
    private int number;
    private String word;

    public Celula( String word) {
        this.word = word;
        this.number=0;
    }

    public Celula(int number, String word) {
        this.number = number;
        this.word = word;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
