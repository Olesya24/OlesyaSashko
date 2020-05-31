package hw_API.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TestData {

    RU_WRONG_WORD("мыш", "мышь"),
    RU_CORRECT_WORD("ключ", "ключ"),
    RU_WRONG_PHRASE("пракуратор Иудеи", "прокуратор"),
    RU_CORRECT_PHRASE("прокуратор Иудеи", "прокуратор Иудеи"),
    RU_PHRASE_WITH_REPEAT_WORD("привет привет девочка", "привет"),
    RU_WORD_IGNORE_CASE("оРЕНБУРГ", "Оренбург"),
    EN_WRONG_WORD("yyear", "year"),
    EN_CORRECT_WORD("mouse", "mouse"),
    EN_PHRASE_WITH_REPEAT_WORD("repeat repeat please", "repeat"),
    EN_WORD_IGNORE_DIGITS("me2", "me 2"),
    EN_WORD_IGNORE_URL("epam.com", "COM"),
    EN_WORD_IGNORE_EMAIL("admin@gmail.com", "COM"),
    EN_PHRASE_IGNORE_CASE("hELlo wOrLD", "hello world"),
    EN_CORRECT_PHRASE("This is correct answer", "This is correct answer");

    private String givenText;
    private String getterText;
}
