package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicLimits{
	private Integer maxActiveTestRunsPerProject;
	private Integer maxFileUploadMb;
	private Integer maxProjectsPerUser;
	private Integer maxMembersPerProject;
}