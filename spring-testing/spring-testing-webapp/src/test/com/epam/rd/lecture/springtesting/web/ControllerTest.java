package com.epam.rd.lecture.springtesting.web;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@ContextConfiguration(value = {"classpath:core-context.xml", "classpath:web-context.xml"})
public class ControllerTest {
    public static final String PRODUCT_API_URL = "/product";

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public void returnsProducts() throws Exception {
        //GIVEN


        //WHEN
        MockHttpServletResponse response = mockMvc.perform(get(PRODUCT_API_URL))
                .andReturn()
                .getResponse();

        //THEN
        String content = response.getContentAsString();
        assertThat(content, containsString("prod1"));
        assertThat(content, containsString("42"));
    }


    @Test
    public void returnsProducts2() throws Exception {
        //GIVEN


        //WHEN
        MockHttpServletResponse response = mockMvc.perform(get(PRODUCT_API_URL))
                .andReturn()
                .getResponse();

        //THEN
        String content = response.getContentAsString();
        Assertions.assertThat(content)
                .contains("prod1", "42");
    }



    @Test
    public void returnsProducts3() throws Exception {
        //GIVEN


        //WHEN / THEN
         mockMvc.perform(get(PRODUCT_API_URL))
                 .andExpect(jsonPath("$", Matchers.hasSize(2)))
                 .andExpect(jsonPath("$[0].name").value("prod1"))
                 .andExpect(jsonPath("$..cost").value(contains(42, 42)))
;    }



}