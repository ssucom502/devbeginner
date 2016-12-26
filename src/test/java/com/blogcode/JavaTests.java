package com.blogcode;

import org.json.JSONObject;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by jojoldu@gmail.com on 2016-12-26.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

public class JavaTests {

    @Test
    public void test_Optional계층구조() {
        Map<String, Object> details = new LinkedHashMap<>();
        Map<String, Object> picture = new LinkedHashMap<>();
        Map<String, String> data = new LinkedHashMap<>();

        data.put("name", "초보개발자모임");
        data.put("url", "https://www.facebook.com/devbeginner/");
        picture.put("data", data);
        details.put("picture", picture);

        JSONObject jsonObject = new JSONObject(details);
        assertThat(jsonObject.getJSONObject("picture").getJSONObject("data").get("url"), is("https://www.facebook.com/devbeginner/"));
        assertThat(getUrl(jsonObject), is("https://www.facebook.com/devbeginner/"));

        picture.put("data", null);
        details.put("picture", picture);
        assertThat(getUrl(new JSONObject(details)), is(""));
    }

    private String getUrl(JSONObject jsonObject) {
        return Optional.ofNullable(jsonObject)
                .map(j -> j.getJSONObject("picture"))
                .map(p -> p.getJSONObject("data"))
                .map(d -> d.get("url").toString())
                .orElse("");
    }
}