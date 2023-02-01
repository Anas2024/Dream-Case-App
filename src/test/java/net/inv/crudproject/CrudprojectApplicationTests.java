package net.inv.crudproject;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.inv.crudproject.data.entities.Case;
import net.inv.crudproject.data.repositories.CaseRepository;
import net.inv.crudproject.service.CaseService;


@SpringBootTest
@AutoConfigureMockMvc
class CrudprojectApplicationTests {


	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CaseService caseService;
	@MockBean
	private CaseRepository caseRepository;
	@Test
	public void testGetCaseById() throws Exception {
		 Case testCase = new Case();
		    testCase.setCaseId(1L);
		    testCase.setCreationDate(new Date());
		    testCase.setLastUpdateDate(new Date());
		    testCase.setTitle("Test Case");
		    testCase.setDescription("Test Description");
		    
		    given(caseService.getCaseById(1L)).willReturn(testCase);
		    
		    mockMvc.perform(get("/cases/1"))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.caseId", is(1)))
		        .andExpect(jsonPath("$.title", is("Test Case")))
		        .andExpect(jsonPath("$.description", is("Test Description")));
	}



	@Test
	public void testSaveCase() throws Exception{
		 Case testCase = new Case();
		    testCase.setCaseId(1L);
		    testCase.setCreationDate(new Date());
		    testCase.setLastUpdateDate(new Date());
		    testCase.setTitle("Test Case");
		    testCase.setDescription("Test Description");
		    
		    given(caseService.saveCase(testCase)).willReturn(testCase);
		    
		    mockMvc.perform(post("/cases/")
		        .contentType(MediaType.APPLICATION_JSON)
		        .content(toJson(testCase)))
		        .andExpect(status().isOk());
		  
	}

	@Test
	public void testUpdateCase() throws Exception{
		 Case testCase = new Case();
		    testCase.setCaseId(1L);
		    testCase.setCreationDate(new Date());
		    testCase.setLastUpdateDate(new Date());
		    testCase.setTitle("Test Case");
		    testCase.setDescription("Test Description");
		    
		    given(caseService.updateCase(testCase.getCaseId(), testCase.getTitle(), testCase.getDescription())).willReturn(testCase);
		    
		    mockMvc.perform(put("/cases/1")
		        .contentType(MediaType.APPLICATION_JSON)
		        .content(toJson(testCase)))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.caseId", is(1)))
		        .andExpect(jsonPath("$.title", is("Test Case")))
		        .andExpect(jsonPath("$.description", is("Test Description")));
	}

	private String toJson(Case testCase) throws Exception{
		  ObjectMapper mapper = new ObjectMapper();
	      String json = mapper.writeValueAsString(testCase);
	      return json;
	}


	@Test
	public void testDeleteCase() throws Exception{
		Case newcase = new Case();
		newcase.setTitle("Case 1");
		newcase.setDescription("This is a sample case");
		newcase.setCreationDate(new Date());
		newcase.setLastUpdateDate(new Date());

		caseService.saveCase(newcase);

		mockMvc.perform(delete("/cases/" + newcase.getCaseId()))
		.andExpect(status().isOk());

		assertThat(caseRepository.existsById(newcase.getCaseId()), is(false));
	}


}
