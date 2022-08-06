package com.example.coindesk;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CoindeskApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getCoinDeskApi() throws Exception{
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

		RequestBuilder requestBuilder =
				MockMvcRequestBuilders
						.get("/coin-desk-api")
						.headers(httpHeaders);

		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk());
	}

	@Test
	public void insertCoinName() throws Exception{
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

		JSONObject request = new JSONObject()
				.put("coinNameEN", "USD")
				.put("coinNameTC", "美元");

		RequestBuilder requestBuilder =
				MockMvcRequestBuilders
						.post("/coin-names")
						.headers(httpHeaders)
						.content(request.toString());

		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk());
	}

	@Test
	public void getCoinName() throws Exception{
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

		RequestBuilder requestBuilder =
				MockMvcRequestBuilders
						.get("/coin-names")
						.headers(httpHeaders);

		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk());
	}

	@Test
	public void updateCoinName() throws Exception{
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

		JSONObject request = new JSONObject()
				.put("coinNameEN", "USD")
				.put("coinNameTC", "美圓");

		RequestBuilder requestBuilder =
				MockMvcRequestBuilders
						.put("/coin-names")
						.headers(httpHeaders)
						.content(request.toString());

		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk());
	}

	@Test
	public void getCoinDeskInfo() throws Exception{
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

		RequestBuilder requestBuilder =
				MockMvcRequestBuilders
						.get("/coin-desk-info")
						.headers(httpHeaders);

		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk());
	}

	@Test
	public void deleteCoinName() throws Exception{
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

		RequestBuilder requestBuilder =
				MockMvcRequestBuilders
						.delete("/coin-names/USD")
						.headers(httpHeaders);

		mockMvc.perform(requestBuilder)
				.andExpect(status().isOk());
	}
}
