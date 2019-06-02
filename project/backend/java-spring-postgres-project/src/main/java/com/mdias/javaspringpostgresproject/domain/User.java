package com.mdias.javaspringpostgresproject.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "`user`")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected Long id;

	@Column
	@CreationTimestamp
	protected LocalDateTime createdDateTime;

	@Column(nullable = false, length = 150)
	private String name;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<ProjectStarred> projectsStarred;
}