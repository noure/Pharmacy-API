package ma.nour.api.controller;

import java.nio.charset.Charset;

import ma.nour.api.Application;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 
 * @author noureddine
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
public class TestingApiPharmacies {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
			MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(this.context).build();
	}

	/**
	 * testing API method
	 * 
	 * @throws Exception
	 */
	@Test
	public void WhenGetPharmaciesThenJSonStack() throws Exception {
		this.mockMvc.perform(get("/api/pharmacies")).andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8));
	}

	/**
	 * testing API method
	 * 
	 * @throws Exception
	 */

	public void WhenGetPharmaciesGardeThenJSonStack() throws Exception {
		this.mockMvc.perform(get("/api/pharmaciesgarde"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8));
	}

	/**
	 * testing API method
	 * 
	 * @throws Exception
	 */
	public void WhenGetPharmacyThenJSonElement() throws Exception {
		this.mockMvc.perform(get("/api/pharmacies/1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON_UTF8));
	}

	@After
	public void downUp() {
		this.mockMvc = null;
	}
}
