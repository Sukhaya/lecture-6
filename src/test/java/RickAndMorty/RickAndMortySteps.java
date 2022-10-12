package RickAndMorty;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RickAndMortySteps {
    private static final String BASE_URI = "https://rickandmortyapi.com/api";

    @Given("Получаем информацию по персонажу")
    public void getRick() {
        List<Character> characters = given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .when()
                .get("/character")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList("results", Character.class);

        Optional<Character> optionalMortySmith = characters.stream()
                .filter(user -> user.name.matches("Morty Smith"))
                .findFirst();
        assertTrue(optionalMortySmith.isPresent(), "Не нашли юзера Morty Smith");
        System.out.println(optionalMortySmith.get());
    }

    @When("^Получаем последний эпизод с Риком$")
    public void getRickLastEpisode() {
        List<Character> characters = given()
                .baseUri(BASE_URI)

                .contentType(ContentType.JSON)
                .when()
                .get("/character")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList("results", Character.class);

        Optional<Character> optionalMortySmith = characters.stream()
                .filter(user -> user.name.matches("Morty Smith"))
                .findFirst();
        assertTrue(optionalMortySmith.isPresent(), "Не нашли юзера Morty Smith");
        Character mortySmith = optionalMortySmith.get();
        assertFalse(mortySmith.episode.isEmpty(), "У Рика Морти нет эпизодов");
        String lastEpisodeOfMortySmith = mortySmith.episode.get(mortySmith.episode.size() - 1);
        System.out.println(lastEpisodeOfMortySmith);
    }

    @Then("^Получаем последнего персонажа из последнего эпизода с Риком$")
    public void getLastCharacterFromLastEpisodeOfRickMorty() {
        List<Character> characters = given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .when()
                .get("/character")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList("results", Character.class);

        Optional<Character> optionalMortySmith = characters.stream()
                .filter(user -> user.name.matches("Morty Smith"))
                .findFirst();
        assertTrue(optionalMortySmith.isPresent(), "Не нашли юзера Morty Smith");
        Character mortySmith = optionalMortySmith.get();
        assertFalse(mortySmith.episode.isEmpty(), "У Рика Морти нет эпизодов");
        String lastEpisodeOfMortySmith = mortySmith.episode.get(mortySmith.episode.size() - 1);

        Episode lastEpisode = given()
                .contentType(ContentType.JSON)
                .when()
                .get(lastEpisodeOfMortySmith)
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getObject(".", Episode.class);

        assertFalse(lastEpisode.characters.isEmpty(), "Нет персонажей в эпизоде");
        System.out.println(lastEpisode.characters.get(lastEpisode.characters.size() - 1));
    }

    @And("^Получаем локацию и расу последнего персонажа из последнего эпизода с Риком и сравниваем$")
    public void getLocationAndRaceOfLastCharacterFromLastEpisodeOfRickMorty() {
        List<Character> characters = given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .when()
                .get("/character")
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getList("results", Character.class);


        Optional<Character> optionalMortySmith = characters.stream()
                .filter(user -> user.name.matches("Morty Smith"))
                .findFirst();
        assertTrue(optionalMortySmith.isPresent(), "Не нашли юзера Morty Smith");
        Character mortySmith = optionalMortySmith.get();
        assertFalse(mortySmith.episode.isEmpty(), "У Рика Морти нет эпизодов");
        String lastEpisodeOfMortySmith = mortySmith.episode.get(mortySmith.episode.size() - 1);

        Episode lastEpisode = given()
                .contentType(ContentType.JSON)
                .when()
                .get(lastEpisodeOfMortySmith)
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getObject(".", Episode.class);

        assertFalse(lastEpisode.characters.isEmpty(), "Нет персонажей в эпизоде");
        String lastCharacterId = lastEpisode.characters.get(lastEpisode.characters.size() - 1);

        Character lastCharacter = given()
                .contentType(ContentType.JSON)
                .when()
                .get(lastCharacterId)
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getObject(".", Character.class);

        assertFalse(lastCharacter.location.name.isEmpty(), "Нет данных о местоположении");
        assertFalse(lastCharacter.species.isEmpty(), "Нет данных о расе");

        System.out.println("Местоположение: " + lastCharacter.location.name + " Раса: " + lastCharacter.species);
//    }
//
//    @And("^проверяем совпадение локации$")
//    public void locationAssert() {
        assertEquals(mortySmith.location.name, lastCharacter.location.name, "Локация не совпадает");
//    }
//    @And("^проверяем совпадение расы$")
        assertEquals(mortySmith.species, lastCharacter.species, "Расса не совпадает");
    }
}


