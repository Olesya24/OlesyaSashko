package hw_API.functional_level;

import hw_API.service.SpellerAssertions;
import hw_API.dataProvider.SpellerDataProvider;
import hw_API.dto.SpellerDto;
import hw_API.service.YandexSpellerService;
import org.testng.annotations.Test;

public class YandexSpellerCheckTexts {
    @Test(dataProviderClass = SpellerDataProvider.class, dataProvider = "correctTexts")
    public void checkCorrectTextsTest(String firstText, String secondTest) {
        SpellerDto[][] speller = new YandexSpellerService().getCheckTexts(new String[]{firstText, secondTest});
        new SpellerAssertions(speller).assertTextsEmptyResponse();
    }

    @Test(dataProviderClass = SpellerDataProvider.class, dataProvider = "incorrectTexts")
    public void checkIncorrectTextsTest(String firstText, String secondTest) {
        SpellerDto[][] speller = new YandexSpellerService().getCheckTexts(new String[]{firstText, secondTest});
        new SpellerAssertions(speller).assertTextsNotEmptyResponse();
    }
}
