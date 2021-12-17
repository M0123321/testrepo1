package com.geekbrains.backend.test.imgur;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@DisplayName("Тесты функциональности Image")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ImgurApiImagesTest extends ImgurApiAbstractTest {

    private static String CURRENT_IMAGE_ID;

    @Test
    @Order(1)
    void validJpeg() {
        CURRENT_IMAGE_ID = given()
                .spec(requestSpecification)
                .multiPart("image", getFileResource("valid.jpg"))
                .formParam("name", "Valid JPEG")
                .formParam("title", "API test. Valid JPEG upload testing.")
                .log()
                .all()
                .expect()
                .body("data.type", is("image/jpeg"))
                .body("data.name", is("Valid JPEG"))
                .body("data.title", is("API test. Valid JPEG upload testing."))
                .log()
                .all()
                .when()
                .post("upload")
                .body()
                .jsonPath()
                .getString("data.id");
    }

    @Test
    @Order(2)
    void validPng() {
        CURRENT_IMAGE_ID = given()
                .spec(requestSpecification)
                .multiPart("image", getFileResource("valid.png"))
                .formParam("name", "Valid PNG")
                .formParam("title", "API test. Valid PNG upload testing.")
                .log()
                .all()
                .expect()
                .body("data.type", is("image/png"))
                .body("data.name", is("Valid PNG"))
                .body("data.title", is("API test. Valid PNG upload testing."))
                .log()
                .all()
                .when()
                .post("upload")
                .body()
                .jsonPath()
                .getString("data.id");
    }

    @Test
    @Order(3)
    void validGif() {
        CURRENT_IMAGE_ID = given()
                .spec(requestSpecification)
                .multiPart("image", getFileResource("valid.gif"))
                .formParam("name", "Valid GIF")
                .formParam("title", "API test. Valid GIF upload testing.")
                .log()
                .all()
                .expect()
                .body("data.type", is("image/gif"))
                .body("data.name", is("Valid GIF"))
                .body("data.title", is("API test. Valid GIF upload testing."))
                .log()
                .all()
                .when()
                .post("upload")
                .body()
                .jsonPath()
                .getString("data.id");
    }

    @Test
    @Order(4)
    void validTIFF() {
        CURRENT_IMAGE_ID = given()
                .spec(requestSpecification)
                .multiPart("image", getFileResource("valid.tif"))
                .formParam("name", "Valid TIFF")
                .formParam("title", "API test. Valid TIFF upload testing.")
                .log()
                .all()
                .expect()
                .body("data.type", is("image/tiff"))
                .body("data.name", is("Valid TIFF"))
                .body("data.title", is("API test. Valid TIFF upload testing."))
                .log()
                .all()
                .when()
                .post("upload")
                .body()
                .jsonPath()
                .getString("data.id");
    }

    @Test
    @Order(5)
    void invalidJPEG() {
        CURRENT_IMAGE_ID = given()
                .spec(requestSpecification)
                .multiPart("image", getFileResource("jpeg.png"))
                .formParam("name", "jpeg as png")
                .formParam("title", "API test. Jpeg renamed into .png file for test.")
                .log()
                .all()
                .expect()
                .body("data.type", is("image/jpeg"))
                .body("data.name", is("jpeg as png"))
                .body("data.title", is("API test. Jpeg renamed into .png file for test."))
                .log()
                .all()
                .when()
                .post("upload")
                .body()
                .jsonPath()
                .getString("data.id");
    }

    @Test
    @Order(6)
    void invalidPNG() {
        CURRENT_IMAGE_ID = given()
                .spec(requestSpecification)
                .multiPart("image", getFileResource("png.jpg"))
                .formParam("name", "png as jpeg")
                .formParam("title", "API test. PNG renamed into .jpg file for test.")
                .log()
                .all()
                .expect()
                .body("data.type", is("image/png"))
                .body("data.name", is("png as jpeg"))
                .body("data.title", is("API test. PNG renamed into .jpg file for test."))
                .log()
                .all()
                .when()
                .post("upload")
                .body()
                .jsonPath()
                .getString("data.id");
    }

    @Test
    @Order(7)
    void invalidGIF() {
        CURRENT_IMAGE_ID = given()
                .spec(requestSpecification)
                .multiPart("image", getFileResource("gif.tif"))
                .formParam("name", "gif as TIFF")
                .formParam("title", "API test. GIF renamed into .tif file for test.")
                .log()
                .all()
                .expect()
                .body("data.type", is("image/gif"))
                .body("data.name", is("gif as TIFF"))
                .body("data.title", is("API test. GIF renamed into .tif file for test."))
                .log()
                .all()
                .when()
                .post("upload")
                .body()
                .jsonPath()
                .getString("data.id");
    }

    @Test
    @Order(8)
    void invalidTIFF() {
        CURRENT_IMAGE_ID = given()
                .spec(requestSpecification)
                .multiPart("image", getFileResource("tiff.gif"))
                .formParam("name", "TIFF as GIF")
                .formParam("title", "API test. TIFF renamed into .gif file for test.")
                .log()
                .all()
                .expect()
                .body("data.type", is("image/png"))
                .body("data.name", is("TIFF as GIF"))
                .body("data.title", is("API test. TIFF renamed into .gif file for test."))
                .log()
                .all()
                .when()
                .post("upload")
                .body()
                .jsonPath()
                .getString("data.id");
    }

    @Test
    @Order(9)
    void BMPattempt() {
        CURRENT_IMAGE_ID = given()
                .spec(requestSpecification)
                .multiPart("image", getFileResource("bmp.jpg"))
                .formParam("name", "BMP as jpg")
                .formParam("title", "API test. BMP renamed into .jpg file for test.")
                .log()
                .all()
                .expect()
                .body("data.type", is("image/png"))
                .body("data.name", is("BMP as jpg"))
                .body("data.title", is("API test. BMP renamed into .jpg file for test."))
                .log()
                .all()
                .when()
                .post("upload")
                .body()
                .jsonPath()
                .getString("data.id");
    }

    @Test
    @Order(10)
    void PCXattempt() {
        CURRENT_IMAGE_ID = given()
                .spec(requestSpecification)
                .multiPart("image", getFileResource("pcx.png"))
                .formParam("name", "PCX as png")
                .formParam("title", "API test. PCX renamed into .png file for test.")
                .log()
                .all()
                .expect()
                .body("success", is(false))
                .log()
                .all()
                .when()
                .post("upload")
                .body()
                .jsonPath()
                .getString("data.id");
    }

}