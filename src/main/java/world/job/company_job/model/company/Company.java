package world.job.company_job.model.company;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @NotNull(message = "ID cannot be null")
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Name cannot be empty")
    @Size(max = 255, message = "Name must not exceed 255 characters")
    private String name;

    @Column(name = "imgUrl", nullable = false)
    @NotBlank(message = "Url of image cannot be empty")
    @Size(max = 255, message = "Url of image must not exceed 255 characters")
    private String imgUrl;

    @Column(name = "imgDescription", nullable = false)
    @NotBlank(message = "Description of image cannot be empty")
    @Size(max = 255, message = "Description of image not exceed 255 characters")
    private String imgDescription;

}
