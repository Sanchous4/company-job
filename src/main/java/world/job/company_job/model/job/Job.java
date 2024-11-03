package world.job.company_job.model.job;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import world.job.company_job.model.company.Company;


@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @NotNull(message = "ID cannot be null")
    private Long id;

    @Column(name = "company_id", insertable = false, updatable = false)
    private Long companyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false, foreignKey = @ForeignKey(name = "fk_jobs_companies"))
    @NotNull(message = "Company cannot be null")
    private Company company;

    @Column(name = "title", nullable = false)
    @NotBlank(message = "Title cannot be empty")
    @Size(max = 255, message = "Title must not exceed 255 characters")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "JOB_STATUS")
    @NotNull(message = "Status cannot be null")
    private JobStatus status;
}
