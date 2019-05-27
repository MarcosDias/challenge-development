package com.mdias.javaspringpostgresproject.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mdias.javaspringpostgresproject.AbstractRestTest;
import com.mdias.javaspringpostgresproject.dto.ProjectGitHubDTO;
import com.mdias.javaspringpostgresproject.exception.UserNotFoundGitHubException;

public class LoadUserGithubServiceTest extends AbstractRestTest {

	@Autowired
	private LoadUserGithubService service;

	@Test
	public void loadProjectStars_test() throws Exception {
		List<ProjectGitHubDTO> projectStars = service.loadProjectStars(VALIDE_USER_GITHUB);

		assertThat(projectStars)
			.asList()
			.isNotEmpty()
			.allSatisfy(objProject -> {
				ProjectGitHubDTO project = (ProjectGitHubDTO) objProject;
				assertThat(project.getId()).isNotNull();
				assertThat(project.getName()).isNotNull();
				assertThat(project.getUrl()).isNotNull();
				assertThat(project.getDescription());
				assertThat(project.getLanguage());
			});
	}

	@Test(expected = UserNotFoundGitHubException.class)
	public void findProjectStars_test_error() throws Exception {
		service.loadProjectStars(INVALIDE_USER_GITHUB);
	}

}
