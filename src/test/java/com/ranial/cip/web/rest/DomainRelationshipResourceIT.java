package com.ranial.cip.web.rest;

import com.ranial.cip.AbstractCassandraTest;
import com.ranial.cip.CogServiceIntegrationApp;
import com.ranial.cip.domain.DomainRelationship;
import com.ranial.cip.repository.DomainRelationshipRepository;
import com.ranial.cip.service.DomainRelationshipService;
import com.ranial.cip.service.dto.DomainRelationshipDTO;
import com.ranial.cip.service.mapper.DomainRelationshipMapper;
import com.ranial.cip.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;


import java.util.List;
import java.util.UUID;

import static com.ranial.cip.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@Link DomainRelationshipResource} REST controller.
 */
@SpringBootTest(classes = CogServiceIntegrationApp.class)
public class DomainRelationshipResourceIT extends AbstractCassandraTest {

    private static final String DEFAULT_PARENT_KEY_ENTITY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_KEY_ENTITY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PARENT_KEY_ATTRIBUTE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_KEY_ATTRIBUTE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CHIELD_ATTRIBUTE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CHIELD_ATTRIBUTE_NAME = "BBBBBBBBBB";

    @Autowired
    private DomainRelationshipRepository domainRelationshipRepository;

    @Autowired
    private DomainRelationshipMapper domainRelationshipMapper;

    @Autowired
    private DomainRelationshipService domainRelationshipService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private Validator validator;

    private MockMvc restDomainRelationshipMockMvc;

    private DomainRelationship domainRelationship;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final DomainRelationshipResource domainRelationshipResource = new DomainRelationshipResource(domainRelationshipService);
        this.restDomainRelationshipMockMvc = MockMvcBuilders.standaloneSetup(domainRelationshipResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DomainRelationship createEntity() {
        DomainRelationship domainRelationship = new DomainRelationship()
            .parentKeyEntityName(DEFAULT_PARENT_KEY_ENTITY_NAME)
            .parentKeyAttributeName(DEFAULT_PARENT_KEY_ATTRIBUTE_NAME)
            .chieldAttributeName(DEFAULT_CHIELD_ATTRIBUTE_NAME);
        return domainRelationship;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DomainRelationship createUpdatedEntity() {
        DomainRelationship domainRelationship = new DomainRelationship()
            .parentKeyEntityName(UPDATED_PARENT_KEY_ENTITY_NAME)
            .parentKeyAttributeName(UPDATED_PARENT_KEY_ATTRIBUTE_NAME)
            .chieldAttributeName(UPDATED_CHIELD_ATTRIBUTE_NAME);
        return domainRelationship;
    }

    @BeforeEach
    public void initTest() {
        domainRelationshipRepository.deleteAll();
        domainRelationship = createEntity();
    }

    @Test
    public void createDomainRelationship() throws Exception {
        int databaseSizeBeforeCreate = domainRelationshipRepository.findAll().size();

        // Create the DomainRelationship
        DomainRelationshipDTO domainRelationshipDTO = domainRelationshipMapper.toDto(domainRelationship);
        restDomainRelationshipMockMvc.perform(post("/api/domain-relationships")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(domainRelationshipDTO)))
            .andExpect(status().isCreated());

        // Validate the DomainRelationship in the database
        List<DomainRelationship> domainRelationshipList = domainRelationshipRepository.findAll();
        assertThat(domainRelationshipList).hasSize(databaseSizeBeforeCreate + 1);
        DomainRelationship testDomainRelationship = domainRelationshipList.get(domainRelationshipList.size() - 1);
        assertThat(testDomainRelationship.getParentKeyEntityName()).isEqualTo(DEFAULT_PARENT_KEY_ENTITY_NAME);
        assertThat(testDomainRelationship.getParentKeyAttributeName()).isEqualTo(DEFAULT_PARENT_KEY_ATTRIBUTE_NAME);
        assertThat(testDomainRelationship.getChieldAttributeName()).isEqualTo(DEFAULT_CHIELD_ATTRIBUTE_NAME);
    }

    @Test
    public void createDomainRelationshipWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = domainRelationshipRepository.findAll().size();

        // Create the DomainRelationship with an existing ID
        domainRelationship.setId(UUID.randomUUID());
        DomainRelationshipDTO domainRelationshipDTO = domainRelationshipMapper.toDto(domainRelationship);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDomainRelationshipMockMvc.perform(post("/api/domain-relationships")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(domainRelationshipDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DomainRelationship in the database
        List<DomainRelationship> domainRelationshipList = domainRelationshipRepository.findAll();
        assertThat(domainRelationshipList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllDomainRelationships() throws Exception {
        // Initialize the database
        domainRelationship.setId(UUID.randomUUID());
        domainRelationshipRepository.save(domainRelationship);

        // Get all the domainRelationshipList
        restDomainRelationshipMockMvc.perform(get("/api/domain-relationships"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(domainRelationship.getId().toString())))
            .andExpect(jsonPath("$.[*].parentKeyEntityName").value(hasItem(DEFAULT_PARENT_KEY_ENTITY_NAME.toString())))
            .andExpect(jsonPath("$.[*].parentKeyAttributeName").value(hasItem(DEFAULT_PARENT_KEY_ATTRIBUTE_NAME.toString())))
            .andExpect(jsonPath("$.[*].chieldAttributeName").value(hasItem(DEFAULT_CHIELD_ATTRIBUTE_NAME.toString())));
    }
    
    @Test
    public void getDomainRelationship() throws Exception {
        // Initialize the database
        domainRelationship.setId(UUID.randomUUID());
        domainRelationshipRepository.save(domainRelationship);

        // Get the domainRelationship
        restDomainRelationshipMockMvc.perform(get("/api/domain-relationships/{id}", domainRelationship.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(domainRelationship.getId().toString()))
            .andExpect(jsonPath("$.parentKeyEntityName").value(DEFAULT_PARENT_KEY_ENTITY_NAME.toString()))
            .andExpect(jsonPath("$.parentKeyAttributeName").value(DEFAULT_PARENT_KEY_ATTRIBUTE_NAME.toString()))
            .andExpect(jsonPath("$.chieldAttributeName").value(DEFAULT_CHIELD_ATTRIBUTE_NAME.toString()));
    }

    @Test
    public void getNonExistingDomainRelationship() throws Exception {
        // Get the domainRelationship
        restDomainRelationshipMockMvc.perform(get("/api/domain-relationships/{id}", UUID.randomUUID().toString()))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateDomainRelationship() throws Exception {
        // Initialize the database
        domainRelationship.setId(UUID.randomUUID());
        domainRelationshipRepository.save(domainRelationship);

        int databaseSizeBeforeUpdate = domainRelationshipRepository.findAll().size();

        // Update the domainRelationship
        DomainRelationship updatedDomainRelationship = domainRelationshipRepository.findById(domainRelationship.getId()).get();
        updatedDomainRelationship
            .parentKeyEntityName(UPDATED_PARENT_KEY_ENTITY_NAME)
            .parentKeyAttributeName(UPDATED_PARENT_KEY_ATTRIBUTE_NAME)
            .chieldAttributeName(UPDATED_CHIELD_ATTRIBUTE_NAME);
        DomainRelationshipDTO domainRelationshipDTO = domainRelationshipMapper.toDto(updatedDomainRelationship);

        restDomainRelationshipMockMvc.perform(put("/api/domain-relationships")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(domainRelationshipDTO)))
            .andExpect(status().isOk());

        // Validate the DomainRelationship in the database
        List<DomainRelationship> domainRelationshipList = domainRelationshipRepository.findAll();
        assertThat(domainRelationshipList).hasSize(databaseSizeBeforeUpdate);
        DomainRelationship testDomainRelationship = domainRelationshipList.get(domainRelationshipList.size() - 1);
        assertThat(testDomainRelationship.getParentKeyEntityName()).isEqualTo(UPDATED_PARENT_KEY_ENTITY_NAME);
        assertThat(testDomainRelationship.getParentKeyAttributeName()).isEqualTo(UPDATED_PARENT_KEY_ATTRIBUTE_NAME);
        assertThat(testDomainRelationship.getChieldAttributeName()).isEqualTo(UPDATED_CHIELD_ATTRIBUTE_NAME);
    }

    @Test
    public void updateNonExistingDomainRelationship() throws Exception {
        int databaseSizeBeforeUpdate = domainRelationshipRepository.findAll().size();

        // Create the DomainRelationship
        DomainRelationshipDTO domainRelationshipDTO = domainRelationshipMapper.toDto(domainRelationship);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDomainRelationshipMockMvc.perform(put("/api/domain-relationships")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(domainRelationshipDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DomainRelationship in the database
        List<DomainRelationship> domainRelationshipList = domainRelationshipRepository.findAll();
        assertThat(domainRelationshipList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteDomainRelationship() throws Exception {
        // Initialize the database
        domainRelationship.setId(UUID.randomUUID());
        domainRelationshipRepository.save(domainRelationship);

        int databaseSizeBeforeDelete = domainRelationshipRepository.findAll().size();

        // Delete the domainRelationship
        restDomainRelationshipMockMvc.perform(delete("/api/domain-relationships/{id}", domainRelationship.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database is empty
        List<DomainRelationship> domainRelationshipList = domainRelationshipRepository.findAll();
        assertThat(domainRelationshipList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DomainRelationship.class);
        DomainRelationship domainRelationship1 = new DomainRelationship();
        domainRelationship1.setId(UUID.randomUUID());
        DomainRelationship domainRelationship2 = new DomainRelationship();
        domainRelationship2.setId(domainRelationship1.getId());
        assertThat(domainRelationship1).isEqualTo(domainRelationship2);
        domainRelationship2.setId(UUID.randomUUID());
        assertThat(domainRelationship1).isNotEqualTo(domainRelationship2);
        domainRelationship1.setId(null);
        assertThat(domainRelationship1).isNotEqualTo(domainRelationship2);
    }

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DomainRelationshipDTO.class);
        DomainRelationshipDTO domainRelationshipDTO1 = new DomainRelationshipDTO();
        domainRelationshipDTO1.setId(UUID.randomUUID());
        DomainRelationshipDTO domainRelationshipDTO2 = new DomainRelationshipDTO();
        assertThat(domainRelationshipDTO1).isNotEqualTo(domainRelationshipDTO2);
        domainRelationshipDTO2.setId(domainRelationshipDTO1.getId());
        assertThat(domainRelationshipDTO1).isEqualTo(domainRelationshipDTO2);
        domainRelationshipDTO2.setId(UUID.randomUUID());
        assertThat(domainRelationshipDTO1).isNotEqualTo(domainRelationshipDTO2);
        domainRelationshipDTO1.setId(null);
        assertThat(domainRelationshipDTO1).isNotEqualTo(domainRelationshipDTO2);
    }
}
