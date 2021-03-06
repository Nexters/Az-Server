package org.nexters.az.post.apis;

import org.junit.Test;
import org.nexters.az.common.CommonTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class GetPostsApiTest extends CommonTest {

    @Test
    public void testGetPostsAndCheckSuccessWhenGuest() throws Exception {
        //when
        MvcResult mvcResult = mockMvc.perform(
                get(POST_URL)
                    .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        //then
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    public void testGetPostsAndCheckSuccessWhenUser() throws Exception {
        //then
        String accessToken = createUser().getAccessToken().getToken();

        //when
        MvcResult mvcResult = mockMvc.perform(
                get(POST_URL)
                    .header("accessToken", accessToken)
                    .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        //then
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

}
